package org.example.utilidades;


import java.util.HashMap;

public class DatosBDSimulada {
    private static final HashMap<Long, Cliente> Cliente_MAP = new HashMap<>();
    private static final HashMap<String, Tarjeta> Tarjeta_BINS = new HashMap<>();

    static {
        Cliente_MAP.put(1L, new Cliente(1L, "Mo Salah", 500, "Descontinuado"));
        Cliente_MAP.put(2L, new Cliente(2L, "Luis Diaz", 300, "Descontinuado"));
        Cliente_MAP.put(3L, new Cliente(3L, "Sadio Mane", 100, "Activo"));
        Cliente_MAP.put(4L, new Cliente(4L, "Alisson Becker", 100, "Inactivo"));

        Tarjeta_BINS.put("123", new Tarjeta("123", "VISA", "Credit"));
        Tarjeta_BINS.put("234", new Tarjeta("234", "MASTERCARD", "Debit"));
        Tarjeta_BINS.put("345", new Tarjeta("345", "NEQUI", "Credit"));
    }

    public static Cliente BuscarClienteId(Long id) {
        return Cliente_MAP.get(id);
    }

    public static void CambiarEstadoCliente(Long id, String nuevoestado) {
        Cliente clientereferencia = BuscarClienteId(id);
        clientereferencia.setEstado(nuevoestado);
        System.out.println("Cambio de estado del cliente '" + clientereferencia.getNombre()
                + "' : " + nuevoestado);
    }


    public static boolean ValidarTarjeta(String prefijotarjeta) {
        if (Tarjeta_BINS.containsKey(prefijotarjeta)) {
            String company = Tarjeta_BINS.get(prefijotarjeta).getEmpresa();
            System.out.println("Tarjeta Válida > '" + prefijotarjeta + "', "
                    + company + "\n");
            return true;
        } else {
            System.out.println("Tarjeta Invalida >\n");
            return false;
        }
    }

    public static String ObtenerEmpresaTarjeta(String prefijotarjeta) {
        if (Tarjeta_BINS.containsKey(prefijotarjeta)) {
            return Tarjeta_BINS.get(prefijotarjeta).getEmpresa();
        }
        throw new RuntimeException("La Tarjeta no Existe");
    }
}
