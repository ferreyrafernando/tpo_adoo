package moduloNotificaciones.estrategias.adapters.whatsapp;

import moduloNotificaciones.Notificacion;

public class AdapterWhatsAppService implements AdapterNotificadorWhatsApp {
    public void enviarWhatsApp(Notificacion notificacion) {
        System.out.println("Enviando WhatsApp a " +
                notificacion.getNroCompletoDestinatario() + ". " +
                notificacion.getMensaje()
        );
    }
}
