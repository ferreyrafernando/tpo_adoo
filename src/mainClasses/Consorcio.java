package mainClasses;

import commonClasses.CuentaBancaria;
import mainClasses.estrategias.EstrategiaDeLiquidacion;

import java.util.ArrayList;
import java.util.List;

public class Consorcio {
    private String nombre;
    private Administrador administrador;
    private CuentaBancaria cuenta_bancaria;
    private String domicilio;
    private List<UnidadFuncional> unidades_funcionales;
    private List<Expensa> expensas = new ArrayList<Expensa>();

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public void calcularExpensas() {
        EstrategiaDeLiquidacion criterio = getAdministrador().getEstrategiaLiquidacion();
        Double importeConsorcio = criterio.calcularExpensas(this);
        System.out.println("Calculando Expensas");
        System.out.println("---------------------------------------------------------");
        System.out.println("Consorcio: "+ this.getNombre() + " Administrador Resp.: " + getAdministrador().getNombre());
        System.out.println("---------------------------------------------------------");
        System.out.println("U.F. |  Propietario           |  Porc. (%)  |  Saldo  |  Total");
        for(UnidadFuncional uf: this.unidades_funcionales ) {
            uf.calcularExpensas(criterio, importeConsorcio);
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

    public List<Expensa> getExpensas() {
        return expensas;
    }

    public void addExpensa(Expensa expensa) {
        this.expensas.add(expensa);
    }
}
