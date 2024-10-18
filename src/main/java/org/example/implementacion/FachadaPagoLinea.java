package org.example.implementacion;


import java.util.HashMap;
import org.example.financiera.SistemaBancario;
import org.example.financiera.SolicitudTransferencia;
import org.example.facturador.SistemaFacturacion;
import org.example.facturador.SolicitudPagoFactura;
import org.example.crm.SistemaCRM;
import org.example.correo.SistemaCorreo;
import org.example.utilidades.DatosBDSimulada;
import org.example.utilidades.Cliente;
import org.example.utilidades.SistemaFidelizacion;


public class FachadaPagoLinea implements InterfaceFacadePago {

    private static final SistemaCRM crmSistema = new SistemaCRM();
    private static final SistemaFacturacion facturaSistema = new SistemaFacturacion();
    private static final SistemaBancario financieraSistema = new SistemaBancario();
    private static final SistemaCorreo correoSistema = new SistemaCorreo();

    @Override
    public RespuestaPago pago(SolicitudPago request)
            throws ErrorGeneralPago {
        Cliente customer = crmSistema.BuscarCliente(request.getClienteId());

        // Validar existencia y estado del cliente
        if(customer == null){
            throw new ErrorGeneralPago("Id de Cliente no existe '"
                    + request.getClienteId() + "' no existe.");
        } else if("Inactivo".equals(customer.getEstado())) {
            throw new ErrorGeneralPago("El cliente '"
                    + request.getClienteId() + "' está inactivo.");
        }

        // Validar si el cliente puede pagar con puntos
        if (SistemaFidelizacion.puedePagarConPuntos(request.getClienteId(), request.getMonto())) {
            SistemaFidelizacion.usarPuntos(request.getClienteId(), request.getMonto());
            System.out.println("La compra ha sido pagada con puntos.");
            return new RespuestaPago("PAGO_CON_PUNTOS", customer.getBalance(), customer.getEstado());
        }

        // Si no se puede pagar con puntos, proceder con el pago normal
        else if(request.getMonto() > facturaSistema.ConsultaSaldoCliente(customer.getId())) {
            throw new ErrorGeneralPago("Estas tratando de hacer un pago mayor que el saldo del cliente");
        }

        // Cargo a la tarjeta
        SolicitudTransferencia transfer = new SolicitudTransferencia(
                request.getMonto(), request.getNumeroTarjeta(),
                request.getNombreTarjeta(), request.getFechaExpiracionTarjeta(),
                request.getNumeroTarjeta());
        String payReference = financieraSistema.Transferencia(transfer);

        // Impacto de la transacción
        SolicitudPagoFactura solicitudPago = new SolicitudPagoFactura(
                request.getClienteId(), request.getMonto());
        double newBalance = facturaSistema.pago(solicitudPago);

        // Reaccionar si el saldo es inferior a 51 dólares
        String newStatus = customer.getEstado();
        if (newBalance <= 50) {
            DatosBDSimulada.CambiarEstadoCliente(request.getClienteId(), "Activo");
            newStatus = "Activo";
        }

        // Agregar puntos por la compra
        SistemaFidelizacion.agregarPuntos(request.getClienteId(), request.getMonto());

        // Enviar confirmación de pago por email
        HashMap<String, String> params = new HashMap<>();
        params.put("$nombre", customer.getNombre());
        params.put("$Monto", request.getMonto() + "");
        params.put("$NuevoSaldo", newBalance + "");
        String number = request.getNumeroTarjeta();
        String subfix = number.substring(number.length() - 4);
        params.put("$NumeroTarjeta", subfix);
        params.put("$Referencia", payReference);
        params.put("$NuevoEstado", newStatus);
        correoSistema.EnviarCorreo(params);

        return new RespuestaPago(payReference, newBalance, newStatus);
    }



}


