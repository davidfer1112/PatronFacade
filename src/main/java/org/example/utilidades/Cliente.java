package org.example.utilidades;



public class Cliente {
    private Long id;
    private String nombre;
    private double balance;
    private String estado;

    public Cliente() {
    }

    public Cliente(Long id, String nombre, double balance, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.balance = balance;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", "
                + "\nbalance=" + balance + ", estado=" + estado + '}';
    }


}
