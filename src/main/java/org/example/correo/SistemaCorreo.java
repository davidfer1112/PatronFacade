package org.example.correo;


import java.util.Map;


public class SistemaCorreo {

    public void EnviarCorreo(Map<String, String> values) {
        String templete = "\n**************************************\n"
                + "|To: $nombre\n"
                + "|from: Facade_System\n"
                + "|\n"
                + "|Gracias por usar nuestros servicios online\n"
                + "|para realizar sus pagos.\n"
                + "|\n"
                + "|Hace un momento hemos recibido un pago:\n"
                + "|\n"
                + "|Monto del pago: $Monto.\n"
                + "|Nuevo saldo: $NuevoSaldo.\n"
                + "|Numeros finales de la tarjeta: $NumeroTarjeta\n"
                + "|Referencia de pago: $Referencia\n"
                + "|Nuevo estado: $NuevoEstado\n"
                + "|\n"
                + "|Gracias por preferirnos.\n"
                + "|\n"
                + "|Por favor no contestar este correo, \n"
                + "|hace parte de un proceso automàtico"
                + "\n**************************************";

        for(String str : values.keySet()){
            templete = templete.replace(str, values.get(str));
        }

        System.out.println(templete);
    }
}
