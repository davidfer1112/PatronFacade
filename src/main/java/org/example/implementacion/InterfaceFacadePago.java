package org.example.implementacion;


public interface InterfaceFacadePago {
    public RespuestaPago pago(SolicitudPago solicitudPago)throws ErrorGeneralPago;
}
