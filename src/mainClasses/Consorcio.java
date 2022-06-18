package mainClasses;

import commonClasses.CuentaBancaria;

import java.util.List;

public class Consorcio {
    private Administrador administrador;
    private CuentaBancaria cuenta_bancaria;
    private String domicilio;
    private List<UnidadFuncional> unidades_funcionales;

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    //TODO Chequear metodo
    // Recorrer  List<UnidadFuncional> e invocar el metodo calcularExpensas de c/u de ellas
    //public void calcularExpensas(Administrador responsable, Criterio: criterio);

    //TODO Chequear metodo
    //public void enviarNotificaciones(Expensa expensa, Notificacion notificacion);

}
