package org.example.utilidades;


import java.util.HashMap;

public class SistemaFidelizacion {
    private static final HashMap<Long, Integer> PuntosClientes = new HashMap<>();
    private static final int PUNTOS_POR_100_PESOS = 10;
    private static final int PUNTOS_POR_USD = 10; // 10 puntos equivalen a 1 USD

    public static void agregarPuntos(Long clienteId, double montoPagado) {
        int puntosGanados = (int) (montoPagado / 100) * PUNTOS_POR_100_PESOS;
        PuntosClientes.put(clienteId, PuntosClientes.getOrDefault(clienteId, 0) + puntosGanados);
        System.out.println("Cliente con ID " + clienteId + " ha ganado " + puntosGanados + " puntos.");
    }

    public static boolean puedePagarConPuntos(Long clienteId, double montoCompra) {
        int puntosCliente = PuntosClientes.getOrDefault(clienteId, 0);
        double montoEnPuntos = puntosCliente / PUNTOS_POR_USD;
        return montoEnPuntos >= montoCompra;
    }

    public static void usarPuntos(Long clienteId, double montoCompra) {
        int puntosCliente = PuntosClientes.getOrDefault(clienteId, 0);
        int puntosAUsar = (int) (montoCompra * PUNTOS_POR_USD);
        PuntosClientes.put(clienteId, puntosCliente - puntosAUsar);
        System.out.println("Se han usado " + puntosAUsar + " puntos para cubrir una compra de " + montoCompra + " USD.");
    }
}

