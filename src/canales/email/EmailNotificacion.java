package canales.email;

import core.Notificacion;

public class EmailNotificacion implements Notificacion {
    private final String email;
    private final String mensaje;

    public EmailNotificacion(String email, String mensaje) {
        this.email = email;
        this.mensaje = mensaje;
    }

    @Override
    public void enviar() {
        System.out.println("Enviando email a " + email + ": " + mensaje);
    }
}
