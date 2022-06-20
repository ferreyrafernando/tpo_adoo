package mainClasses;

import commonClasses.CuentaBancaria;
import moduloNotificaciones.Notificacion;
import moduloNotificaciones.Notificador;

import java.util.List;

enum Criterio {
    PagoCompletoGastos,
    PagoCompletoFondoDeReserva,
    PagoCompletoFuturosFondoDeReserva
}

public class Consorcio {
    private Administrador administrador;
    private CuentaBancaria cuenta_bancaria;
    private String domicilio;
    private List<UnidadFuncional> unidades_funcionales;
    // Esto no va
    private Criterio criterio = Criterio.PagoCompletoFondoDeReserva;

    public void calcularExpensas(Administrador responsable, Criterio criterio) {
        for(UnidadFuncional unidadFuncional : unidades_funcionales) {
            unidadFuncional.calcularExpensas(administrador, criterio);
        }
    }

    //TODO Chequear metodo - Nose bien que hacer con la expensa acá.
    public void enviarNotificacion(Expensa expensa, Notificacion notificacion)  {
        Notificador.enviar(notificacion);
    }

}
