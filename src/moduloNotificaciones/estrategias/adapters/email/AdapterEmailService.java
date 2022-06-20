package moduloNotificaciones.estrategias.adapters.email;

import moduloNotificaciones.Notificacion;

public class AdapterEmailService implements AdapterNotificadorEmail {
    public void enviarEmail(Notificacion notificacion) {
        System.out.println("Enviando Email a " +
                notificacion.getEmailDestinatario() + ". " +
                notificacion.getMensaje()
        );
    }
}
