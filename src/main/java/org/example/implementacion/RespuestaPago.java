package org.example.implementacion;


public class RespuestaPago {
    private String NumeroConfirmacionPago;
    private double NuevoSaldo;
    private String EstadoCliente;

    public RespuestaPago(String NumeroConfirmacionPago, double NuevoSaldo, String EstadoCliente) {
        this.NumeroConfirmacionPago = NumeroConfirmacionPago;
        this.NuevoSaldo = NuevoSaldo;
        this.EstadoCliente = EstadoCliente;
    }

    public String getNumeroConfirmacionPago() {
        return NumeroConfirmacionPago;
    }

    public void setNumeroConfirmacionPago(String NumeroConfirmacionPago) {
        this.NumeroConfirmacionPago = NumeroConfirmacionPago;
    }

    public double getNuevoSaldo() {
        return NuevoSaldo;
    }

    public void setNuevoSaldo(double NuevoSaldo) {
        this.NuevoSaldo = NuevoSaldo;
    }

    public String getEstadoCliente() {
        return EstadoCliente;
    }

    public void setEstadoCliente(String EstadoCliente) {
        this.EstadoCliente = EstadoCliente;
    }


}
