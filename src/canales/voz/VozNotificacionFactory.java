package canales.voz;

import core.NotificacionFactory;
import core.Notificacion;

public class VozNotificacionFactory implements NotificacionFactory {

    public Notificacion crearNotificacion(String destinatario, String mensaje) {
        return new VozNotificacion(destinatario, mensaje);
    }
}
