package org.example.utilidades;


public class Tarjeta {
    private String prefijo;
    private String empresa;
    private String tipotarjeta;//{Credito - Debito}

    public Tarjeta(String prefijo, String empresa, String tipotarjeta) {
        this.prefijo = prefijo;
        this.empresa = empresa;
        this.tipotarjeta = tipotarjeta;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTipotarjeta() {
        return tipotarjeta;
    }

    public void setTipotarjeta(String tipotarjeta) {
        this.tipotarjeta = tipotarjeta;
    }



}
