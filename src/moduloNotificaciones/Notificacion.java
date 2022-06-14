package moduloNotificaciones;

public class Notificacion {
    private String mensaje;
    private String emailDestinatario;
    private String emailRemitente;
    private String nroTelDestinatario;
    private String nroTelRemitente;

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
        return nroTelDestinatario;
    }
    public void setNroCompletoDestinatario(String nroCompletoDestinatario) {
        this.nroTelDestinatario = nroCompletoDestinatario;
    }
    public String getNroCompletoRemitente() {
        return nroTelRemitente;
    }
    public void setNroCompletoRemitente(String nroCompletoRemitente) {
        this.nroTelRemitente = nroCompletoRemitente;
    }
}
