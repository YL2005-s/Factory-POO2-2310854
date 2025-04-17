package futuro.whatsapp;

import core.Notificacion;

public class WhatsAppNotificacion implements Notificacion {
    private final String numero;
    private final String mensaje;

    public WhatsAppNotificacion(String numero, String mensaje) {
        this.numero = numero;
        this.mensaje = mensaje;
    }

    @Override
    public void enviar() {
        System.out.println("Enviando WhatsApp a " + numero + ": " + mensaje);
    }
}
