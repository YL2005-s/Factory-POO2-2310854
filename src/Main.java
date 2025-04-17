import core.Notificador;

public class Main {
    public static void main(String[] args) {
        Notificador notificador = new Notificador();

        notificador.enviarNotificacion("EMAIL", "cliente@correo.com", "¡Hola por email!");
        notificador.enviarNotificacion("PUSH", "AEBE52E7-03EE-455A-B3C4-E57283966239", "¡Hola por Push(?)!");
        notificador.enviarNotificacion("SMS", "987654321", "¡Hola por SMS!");
        notificador.enviarNotificacion("VOZ", "987654321", "Este es un mensaje de voz muy largo que debe dividirse si supera los 500 caracteres. Puedes imaginar que continúa así hasta que supera el límite definido...");
    }
}