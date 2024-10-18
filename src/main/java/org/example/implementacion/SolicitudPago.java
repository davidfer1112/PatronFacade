package org.example.implementacion;


public class SolicitudPago {
    private Long ClienteId;
    private double Monto;
    private String NumeroTarjeta;
    private String NombreTarjeta;
    private String FechaExpiracionTarjeta;
    private String NumeroSeguridadTarjeta;

    public SolicitudPago() {
    }

    public Long getClienteId() {
        return ClienteId;
    }

    public void setClienteId(Long ClienteId) {
        this.ClienteId = ClienteId;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double Monto) {
        this.Monto = Monto;
    }

    public String getNumeroTarjeta() {
        return NumeroTarjeta;
    }

    public void setNumeroTarjeta(String NumeroTarjeta) {
        this.NumeroTarjeta = NumeroTarjeta;
    }

    public String getNombreTarjeta() {
        return NombreTarjeta;
    }

    public void setNombreTarjeta(String NombreTarjeta) {
        this.NombreTarjeta = NombreTarjeta;
    }

    public String getFechaExpiracionTarjeta() {
        return FechaExpiracionTarjeta;
    }

    public void setFechaExpiracionTarjeta(String FechaExpiracionTarjeta) {
        this.FechaExpiracionTarjeta = FechaExpiracionTarjeta;
    }

    public String getNumeroSeguridadTarjeta() {
        return NumeroSeguridadTarjeta;
    }

    public void setNumeroSeguridadTarjeta(String NumeroSeguridadTarjeta) {
        this.NumeroSeguridadTarjeta = NumeroSeguridadTarjeta;
    }



}
