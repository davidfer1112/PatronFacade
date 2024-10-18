package org.example.facturador;


import org.example.utilidades.Cliente;
import org.example.utilidades.DatosBDSimulada;


public class SistemaFacturacion {

    public double ConsultaSaldoCliente(Long clienteId) {
        Cliente cliente = DatosBDSimulada.BuscarClienteId(clienteId);
        return cliente.getBalance();
    }

    public double pago(SolicitudPagoFactura pagoFactura) {
        Cliente customer = DatosBDSimulada.BuscarClienteId(pagoFactura.getClienteId());
        customer.setBalance(customer.getBalance() - pagoFactura.getPago());
        System.out.println("Pago aplicado al cliente '"+customer.getNombre() +"', "
                + "el nuevo saldo es '"+customer.getBalance()+"'");
        return customer.getBalance();//new Balance.
    }
}

