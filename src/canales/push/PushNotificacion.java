package canales.push;

import core.Notificacion;

public class PushNotificacion implements Notificacion {
    private final String dispositivoId;
    private final String mensaje;

    public PushNotificacion(String dispositivoId, String mensaje) {
        this.dispositivoId = dispositivoId;
        this.mensaje = mensaje;
    }

    @Override
    public void enviar() {
        System.out.println("Enviando notificación push a " + dispositivoId + ": " + mensaje);
    }
}
