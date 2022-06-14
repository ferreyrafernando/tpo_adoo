package moduloNotificaciones;
import moduloNotificaciones.estrategias.EstrategiaDeNotificacion;

public class Notificador {
    private EstrategiaDeNotificacion estrategia;

    public void enviar(Notificacion notificacion) {
        this.estrategia.enviar(notificacion);
    }

    public void cambiarEstrategiaDeNotificacion(EstrategiaDeNotificacion estrategia) {
        this.estrategia = estrategia;
    }
}
