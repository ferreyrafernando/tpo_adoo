package com.company;

import moduloNotificaciones.estrategias.Estrategia;

public class UsuarioNotificacionMock {
    private String emailDestinatario;
    private String emailRemitente;
    private String mensaje;
    private String nroCompletoDestinatario;
    private String nroCompletoRemitente;
    private Estrategia estrategiaElegida;

    public UsuarioNotificacionMock(String emailDestinatario, String emailRemitente, String mensaje,
                                   String nroCompletoDestinatario, String nroCompletoRemitente, Estrategia estrategiaElegida) {
        super();
        this.emailDestinatario = emailDestinatario;
        this.emailRemitente = emailRemitente;
        this.mensaje = mensaje;
        this.nroCompletoDestinatario = nroCompletoDestinatario;
        this.nroCompletoRemitente = nroCompletoRemitente;
        this.estrategiaElegida = estrategiaElegida;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getEmailRemitente() {
        return emailRemitente;
    }

    public void setEmailRemitente(String emailRemitente) {
        this.emailRemitente = emailRemitente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNroCompletoDestinatario() {
        return nroCompletoDestinatario;
    }

    public void setNroCompletoDestinatario(String nroCompletoDestinatario) {
        this.nroCompletoDestinatario = nroCompletoDestinatario;
    }

    public String getNroCompletoRemitente() {
        return nroCompletoRemitente;
    }

    public void setNroCompletoRemitente(String nroCompletoRemitente) {
        this.nroCompletoRemitente = nroCompletoRemitente;
    }

    public Estrategia getEstrategiaElegida() {
        return estrategiaElegida;
    }

}
