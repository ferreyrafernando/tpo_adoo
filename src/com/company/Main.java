package com.company;

import java.util.ArrayList;
import java.util.List;

import moduloNotificaciones.Notificacion;
import moduloNotificaciones.Notificador;
import moduloNotificaciones.estrategias.Estrategia;
import moduloNotificaciones.estrategias.EstrategiaDeNotificacion;
import moduloNotificaciones.estrategias.NotificacionPorEmail;
import moduloNotificaciones.estrategias.NotificacionPorSMS;
import moduloNotificaciones.estrategias.NotificacionPorWhatsApp;
import moduloNotificaciones.estrategias.adapters.email.AdapterEmailService;
import moduloNotificaciones.estrategias.adapters.sms.AdapterSMSService;
import moduloNotificaciones.estrategias.adapters.whatsapp.AdapterWhatsAppService;

public class Main {

    public static void main(String[] args) {
        Notificador notificador = new Notificador();
        EstrategiaDeNotificacion notificadorSMS = new NotificacionPorSMS(new AdapterSMSService());
        EstrategiaDeNotificacion notificadorWhatsApp = new NotificacionPorWhatsApp(new AdapterWhatsAppService());
        EstrategiaDeNotificacion notificadorEmail = new NotificacionPorEmail(new AdapterEmailService());

        for(UsuarioNotificacionMock usuarioMock : usuariosMock()) {
            Notificacion notificacion = new Notificacion();
            notificacion.setEmailDestinatario(usuarioMock.getEmailDestinatario());
            notificacion.setEmailRemitente(usuarioMock.getEmailRemitente());
            notificacion.setMensaje(usuarioMock.getMensaje());
            notificacion.setNroCompletoDestinatario(usuarioMock.getNroCompletoDestinatario());
            notificacion.setNroCompletoRemitente(usuarioMock.getEmailRemitente());

            switch(usuarioMock.getEstrategiaElegida()) {
                case SMS: notificador.cambiarEstrategiaDeNotificacion(notificadorSMS); break;
                case WHATSAPP: notificador.cambiarEstrategiaDeNotificacion(notificadorWhatsApp); break;
                case EMAIL: notificador.cambiarEstrategiaDeNotificacion(notificadorEmail); break;
            }

            notificador.enviar(notificacion);
        }
    }

    private static List<UsuarioNotificacionMock> usuariosMock(){
        List<UsuarioNotificacionMock> usuariosMock =
                new ArrayList<UsuarioNotificacionMock>();

        UsuarioNotificacionMock usuarioMock =
                new UsuarioNotificacionMock("prueba1@test.com",
                        "remitente1@test.com",
                        "Tu paquete esta en camino",
                        "+541154874514",
                        "+51454745754",
                        Estrategia.EMAIL);
        usuariosMock.add(usuarioMock);

        usuarioMock =
                new UsuarioNotificacionMock("prueba2@test.com",
                        "remitente2@test.com",
                        "Tu pedido ha sido rechazado",
                        "+54645646546",
                        "+8985252",
                        Estrategia.WHATSAPP);
        usuariosMock.add(usuarioMock);

        usuarioMock =
                new UsuarioNotificacionMock("prueba3@test.com",
                        "remitente3@test.com",
                        "El vendedor esta preparando el pedido",
                        "+541154874514",
                        "+51454745754",
                        Estrategia.SMS);
        usuariosMock.add(usuarioMock);

        return usuariosMock;
    }

}
