package futuro.whatsapp;

import core.Notificacion;
import core.NotificacionFactory;

public class WhatsAppNotificacionFactory implements NotificacionFactory {

    public Notificacion crearNotificacion(String destinatario, String mensaje) {
        return new WhatsAppNotificacion(destinatario, mensaje);
    }
}
