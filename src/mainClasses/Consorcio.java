package mainClasses;

import com.company.UsuarioNotificacionMock;
import commonClasses.CuentaBancaria;
import mainClasses.estrategias.EstrategiaDeLiquidacion;

import java.util.List;

public class Consorcio {
    private String nombre;
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
    public void calcularExpensas(Administrador responsable, EstrategiaDeLiquidacion criterio){
        System.out.println("Calculando Expensas");
        System.out.println("---------------------------------------------------------");
        System.out.println("Consorcio: "+ this.getNombre() + " Administrador Resp.: " + responsable.getNombre());
        System.out.println("---------------------------------------------------------");
        System.out.println("U.F. |  Propietario           |  Porc. (%)  |  Saldo  |  Total");

        for(UnidadFuncional uf: this.unidades_funcionales ) {
            uf.calcularExpensas(criterio, 100000.00);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CuentaBancaria getCuenta_bancaria() {
        return cuenta_bancaria;
    }

    public void setCuenta_bancaria(CuentaBancaria cuenta_bancaria) {
        this.cuenta_bancaria = cuenta_bancaria;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public List<UnidadFuncional> getUnidades_funcionales() {
        return unidades_funcionales;
    }

    public void setUnidades_funcionales(List<UnidadFuncional> unidades_funcionales) {
        this.unidades_funcionales = unidades_funcionales;
    }

    //TODO Chequear metodo
    //public void enviarNotificaciones(Expensa expensa, Notificacion notificacion);

}
