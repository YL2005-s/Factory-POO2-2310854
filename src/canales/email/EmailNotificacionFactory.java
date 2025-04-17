package canales.email;

import core.Notificacion;
import core.NotificacionFactory;

public class EmailNotificacionFactory implements NotificacionFactory {

    public Notificacion crearNotificacion(String destinatario, String mensaje) {
        return new EmailNotificacion(destinatario, mensaje);
    }
}
