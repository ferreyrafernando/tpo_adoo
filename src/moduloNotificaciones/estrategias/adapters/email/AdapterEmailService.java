package moduloNotificaciones.estrategias.adapters.email;

import moduloNotificaciones.Notificacion;

public class AdapterEmailService implements AdapterNotificadorEmail {

    /**
     * TODO Se debería llamas a la o las clases correspondientes que se
     * quieren adaptar
     */
    public void enviarEmail(Notificacion notificacion) {
        System.out.println("Enviando Email a " +
                notificacion.getNroCompletoDestinatario() + " por Twilio: " +
                "'" + notificacion.getMensaje() + "'"
        );

    }
}
