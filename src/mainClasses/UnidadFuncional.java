package mainClasses;

import commonClasses.Inquilino;
import commonClasses.PagoRealizado;
import commonClasses.Propietario;
import commonClasses.TipoUF;
import moduloNotificaciones.Notificacion;
import moduloNotificaciones.Notificador;
import moduloNotificaciones.estrategias.*;
import moduloNotificaciones.estrategias.adapters.email.AdapterEmailService;
import moduloNotificaciones.estrategias.adapters.sms.AdapterSMSService;
import moduloNotificaciones.estrategias.adapters.whatsapp.AdapterWhatsAppService;

import java.util.Date;
import java.util.List;

public class UnidadFuncional {
    private int nro_uf;
    private Double mts_cuadrados;
    private Double porcentaje_expensas; // 0,1 10% - 0,25 25% - 0,3 30%
    private Propietario propietario;
    private Inquilino inquilino;
    private TipoUF tipo_uf;
    private List<PagoRealizado> pagosRealizados;
    private Double saldoDeudor = 0.0;
    private Estrategia estrategiaDeNotificacion;
    private Notificador notificador = new Notificador();
    private Consorcio consorcio;

    public UnidadFuncional(Propietario propietario, Consorcio consorcio) {
        this.propietario = propietario;
        this.consorcio = consorcio;
    }

    public Double obtenerDeudaExpensas() {
        return saldoDeudor;
    }

    public int getNro_uf() {
        return nro_uf;
    }

    public void setNro_uf(int nro_uf) {
        this.nro_uf = nro_uf;
    }

    public Double getMts_cuadrados() {
        return mts_cuadrados;
    }

    public void setMts_cuadrados(Double mts_cuadrados) {
        this.mts_cuadrados = mts_cuadrados;
    }

    public Double getPorcentaje_expensas() {
        return porcentaje_expensas;
    }

    public void setPorcentaje_expensas(Double porcentaje_expensas) {
        this.porcentaje_expensas = porcentaje_expensas;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public TipoUF getTipo_uf() {
        return tipo_uf;
    }

    public void setTipo_uf(TipoUF tipo_uf) {
        this.tipo_uf = tipo_uf;
    }

    public List<PagoRealizado> getPagosRealizados() {
        return pagosRealizados;
    }

    public void setPagosRealizados(List<PagoRealizado> pagosRealizados) {
        this.pagosRealizados = pagosRealizados;
    }

    public void agregarNuevoPago(Double importe, Date fecha) {
        PagoRealizado nuevoPago = new PagoRealizado(fecha, importe);
        pagosRealizados.add(nuevoPago);
        saldoDeudor = saldoDeudor - importe;
    }

    public void enviarNotificacion(Double importeAPagar)  {
        Notificacion nuevaNotificacion = new Notificacion();
        EstrategiaDeNotificacion notificadorSMS = new NotificacionPorSMS(new AdapterSMSService());
        EstrategiaDeNotificacion notificadorWhatsApp = new NotificacionPorWhatsApp(new AdapterWhatsAppService());
        EstrategiaDeNotificacion notificadorEmail = new NotificacionPorEmail(new AdapterEmailService());

        nuevaNotificacion.setEmailDestinatario(getInquilino().getEmail());
        nuevaNotificacion.setNroCompletoDestinatario(getInquilino().getNumero());
        nuevaNotificacion.setMensaje("Se genero una nueva expensa para la unidad funcional " + getNro_uf() + ". El importe a pagar es: $" + importeAPagar.floatValue());

        switch(getEstrategiaDeNotificacion()) {
            case SMS: notificador.cambiarEstrategiaDeNotificacion(notificadorSMS); break;
            case WHATSAPP: notificador.cambiarEstrategiaDeNotificacion(notificadorWhatsApp); break;
            case EMAIL: notificador.cambiarEstrategiaDeNotificacion(notificadorEmail); break;
        }
        notificador.enviar(nuevaNotificacion);
    }

    public Estrategia getEstrategiaDeNotificacion() {
        return estrategiaDeNotificacion;
    }

    public void setEstrategiaDeNotificacion(Estrategia estrategiaDeNotificacion) {
        this.estrategiaDeNotificacion = estrategiaDeNotificacion;
    }

    public Double getSaldoDeudor() {
        return saldoDeudor;
    }

    public void setSaldoDeudor(Double saldoDeudor) {
        this.saldoDeudor = saldoDeudor;
    }
}
