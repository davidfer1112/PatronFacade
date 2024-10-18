package org.example.financiera;


import java.util.UUID;
import org.example.implementacion.ErrorGeneralPago;
import org.example.utilidades.DatosBDSimulada;


public class SistemaBancario {
    public String Transferencia(SolicitudTransferencia request) throws ErrorGeneralPago {
        String NumeroPrefijoTarjeta = request.getNumeroTarjeta().substring(0, 3);
        if (!DatosBDSimulada.ValidarTarjeta(NumeroPrefijoTarjeta)) {
            throw new ErrorGeneralPago("Tarjeta Invalida.");
        }
        String TarjetaEmpresa = DatosBDSimulada.ObtenerEmpresaTarjeta(NumeroPrefijoTarjeta);
        if ("NEQUI".equals(TarjetaEmpresa) && request.getNumeroTarjeta().length() != 15) {
            throw new ErrorGeneralPago("Numero Tarjeta Invalido");
        } else if (("VISA".equals(TarjetaEmpresa) || "MASTERCARD".equals(TarjetaEmpresa))
                && request.getNumeroTarjeta().length() != 16) {
            throw new ErrorGeneralPago("Número Tarjeta Invalido");
        }
        String number = request.getNumeroTarjeta();
        String NumeroSufijoTarjeta = number.substring(number.length()-4, number.length());
        System.out.println("Se ha hecho un cargo al cliente '"
                + request.getNombreTarjeta() + "' \n"
                + "\tPor un monto de: '" + request.getMonto() + "' a la tarjeta "
                + "terminada en '"+NumeroSufijoTarjeta+"'.\n");

        return UUID.randomUUID().toString();
    }
}

