package futuro.sirena;

import core.Notificacion;

public class SirenaNotificacion implements Notificacion {
    private final String ubicacion;
    private final String mensaje;

    public SirenaNotificacion(String ubicacion, String mensaje) {
        this.ubicacion = ubicacion;
        this.mensaje = mensaje;
    }

    @Override
    public void enviar() {
        System.out.println("Activando sirena en " + ubicacion + " con alerta: " + mensaje);
    }
}
