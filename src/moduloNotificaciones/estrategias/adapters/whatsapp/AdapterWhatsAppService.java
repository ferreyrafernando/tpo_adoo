package moduloNotificaciones.estrategias.adapters.whatsapp;

import moduloNotificaciones.Notificacion;

public class AdapterWhatsAppService implements AdapterNotificadorWhatsApp {
    /**
     * TODO Se debería llamar a la o las clases correspondientes que se
     * quieren adaptar
     */
    public void enviarWhatsApp(Notificacion notificacion) {
        System.out.println("Enviando WhatsApp a " +
                notificacion.getNroCompletoDestinatario() + " por Twilio: " +
                "'" + notificacion.getMensaje() + "'"
        );
    }
}
