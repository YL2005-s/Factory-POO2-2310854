package core;

public interface NotificacionFactory {
    Notificacion crearNotificacion(String destinatario, String mensaje);
}
