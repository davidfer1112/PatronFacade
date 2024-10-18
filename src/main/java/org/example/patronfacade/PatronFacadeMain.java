package org.example.patronfacade;


import org.example.implementacion.InterfaceFacadePago;
import org.example.implementacion.FachadaPagoLinea;
import org.example.implementacion.SolicitudPago;

public class PatronFacadeMain {


    public static void main(String[] args) {
        SolicitudPago request = new SolicitudPago();
        request.setMonto(499); // Monto de la compra
        request.setFechaExpiracionTarjeta("10/2025");
        request.setNombreTarjeta("Mo Salah");
        request.setNumeroTarjeta("1234567890123456");
        request.setNumeroSeguridadTarjeta("345");
        request.setClienteId(1L);

        try {
            InterfaceFacadePago paymentFacade = new FachadaPagoLinea();
            paymentFacade.pago(request);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
