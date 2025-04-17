package canales.voz;

import core.Notificacion;
import utils.TextoAVozUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class VozNotificacion implements Notificacion {
    private static final int MAX_LONGITUD_TEXTO = 500;
    private static final int MAX_INTENTOS = 3;
    private static final int DURACION_POR_CARACTER_MS = 50;

    private final String telefono;
    private final String mensaje;

    public VozNotificacion(String telefono, String mensaje) {
        this.telefono = telefono;
        this.mensaje = mensaje;
    }

    @Override
    public void enviar() {
        List<String> partes = (mensaje.length() > MAX_LONGITUD_TEXTO) ? dividirMensaje(mensaje) : Collections.singletonList(mensaje);
        long inicio = System.currentTimeMillis();
        boolean entregado = false;
        int intento = 0;

        while (intento < MAX_INTENTOS && !entregado) {
            intento++;
            entregado = simularRespuesta();

            if (entregado) {
                System.out.println("Enviando mensaje de voz a " + telefono + ":");

                int total = partes.size();
                for (int i = 0; i < total; i++) {
                    String parte = partes.get(i);
                    System.out.print("[Audio] Parte [" + (i + 1) + "/" + total + "]: ");
                    System.out.flush();
                    String audio = TextoAVozUtil.convertir(parte);
                    reproducirAudio(audio);
                }
            }
        }

        long fin = System.currentTimeMillis();
        long total = (fin - inicio) / 1000;

        if (entregado) {
            System.out.println("\n--- Estadísticas de la llamada de voz ---");
            System.out.println("✔ Llamada completada");
            System.out.println("Intentos necesarios: " + intento);
            System.out.println("Duración total: " + total + "s");
        } else {
            System.out.println("No se logro enviar un mensaje de voz a " + telefono + " tras " + MAX_INTENTOS  + " intentos.");
        }
    }

    private boolean simularRespuesta() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    private void reproducirAudio(String texto) {
        for (char c : texto.toCharArray()) {
            System.out.print(c);
            System.out.flush();
            try {
                Thread.sleep(DURACION_POR_CARACTER_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    private List<String> dividirMensaje(String mensaje) {
        List<String> partes = new ArrayList<>();
        int inicio = 0;

        while (inicio < mensaje.length()) {
            int fin = Math.min(inicio + MAX_LONGITUD_TEXTO, mensaje.length());
            partes.add(mensaje.substring(inicio, fin));
            inicio = fin;
        }

        return partes;
    }

}
