package org.example.crm;


import org.example.utilidades.Cliente;
import org.example.utilidades.DatosBDSimulada;



public class SistemaCRM {

    public Cliente BuscarCliente(Long clienteId){
        return DatosBDSimulada.BuscarClienteId(clienteId);
    }
}
