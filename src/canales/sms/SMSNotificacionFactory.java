package canales.sms;

import core.Notificacion;
import core.NotificacionFactory;

public class SMSNotificacionFactory implements NotificacionFactory {

    public Notificacion crearNotificacion(String destinatario, String mensaje) {
        return new SMSNotificacion(destinatario, mensaje);
    }
}
