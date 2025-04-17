package canales.sms;

import core.Notificacion;

public class SMSNotificacion implements Notificacion {
    private final String telefono;
    private final String mensaje;

    public SMSNotificacion(String telefono, String mensaje) {
        this.telefono = telefono;
        this.mensaje = mensaje;
    }

    @Override
    public void enviar() {
        System.out.println("Enviando SMS a " + telefono + ": " + mensaje);
    }
}