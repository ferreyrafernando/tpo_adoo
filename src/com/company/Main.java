package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import commonClasses.*;
import mainClasses.Administrador;
import mainClasses.Consorcio;
import mainClasses.Expensa;
import mainClasses.UnidadFuncional;
import mainClasses.estrategias.EstrategiaDeLiquidacion;
import mainClasses.estrategias.PagoCompletoGasto;
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

        Administrador administrador=new Administrador("Juan","Perez");
        EstrategiaDeLiquidacion pagoCompletoGastoLiquidacion = new PagoCompletoGasto(); //Puede ser esta u otra
        administrador.setEstrategiaDeLiquidacion(pagoCompletoGastoLiquidacion);

        Consorcio consorcio = new Consorcio(); // Generar y usar Mock para datos del consorocio, algunos deptos, cocheras, etc
        consorcio.setAdministrador(administrador);
        consorcio.setNombre("Consorcio UADE");



        consorcio.setUnidades_funcionales(unidadesFuncMock());



        Expensa expensa = new Expensa(new Date(2022,6,1), TipoExpensa.ORDINARIA, new ArrayList<Gasto>(), administrador.getEstrategiaLiquidacion());

        administrador.cargarGasto(new Date(2022,6,5), 150000.00, TipoGasto.SERVICIOS, expensa); // Generar y usar Mock para datos GASTOS
        administrador.cargarGasto(new Date(2022,6,7), 7500.00, TipoGasto.MANTENIMIENTO, expensa);
        administrador.cargarGasto(new Date(2022,6,10), 25000.00, TipoGasto.SEGUROS, expensa);


        consorcio.calcularExpensas(administrador, administrador.getEstrategiaLiquidacion());







/*


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
        */

    }

    private static List<UnidadFuncional> unidadesFuncMock() {
        List<UnidadFuncional> unidadesFuncMock = new ArrayList<UnidadFuncionalMock>();

        UnidadFuncionalMock uf_mock = new UnidadFuncionalMock("Ferreyra",
                    "Fernando",
                    1,
                    52.5,
                    0.25,
                    TipoUF.DEPARTAMENTO);
        unidadesFuncMock.add(uf_mock);

        uf_mock = new UnidadFuncionalMock("Meza",
                "Mauricio",
                2,
                83.4,
                0.35,
                TipoUF.DEPARTAMENTO);
        unidadesFuncMock.add(uf_mock);

        uf_mock = new UnidadFuncionalMock("Pelech",
                "Federico",
                3,
                5.1,
                0.1,
                TipoUF.COCHERA);
        unidadesFuncMock.add(uf_mock);

        return unidadesFuncMock;
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
