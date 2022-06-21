package mainClasses;

import commonClasses.CuentaBancaria;
import commonClasses.Gasto;
import mainClasses.estrategias.EstrategiaDeLiquidacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Consorcio {
    private String nombre;
    private Administrador administrador;
    private CuentaBancaria cuenta_bancaria;
    private String domicilio;
    private List<UnidadFuncional> unidades_funcionales;
    private List<Expensa> expensas = new ArrayList<Expensa>();

    private EstrategiaDeLiquidacion estrategiaDeLiquidacion;

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public void imprimirTablaSalida() {
        System.out.println("Liquidando Expensas por UF del Consorcio");
        System.out.println("---------------------------------------------------------");
        System.out.println("Consorcio: "+ this.getNombre() + " Administrador Resp.: " + getAdministrador().getNombre() + " " + getAdministrador().getApellido());
        System.out.println("---------------------------------------------------------");
        System.out.println("U.F. |  Propietario           |  Porc. (%)  |  Saldo  |  Total");
    }

    public void calcularExpensas() {
        double saldoTotalConsorcio = getEstrategiaLiquidacion().obtencionSaldos(this);
        double gastoTotalConsorcio = getEstrategiaLiquidacion().calculoGastos(getExpensas());
        double importeTotalConsorcio = getEstrategiaLiquidacion().divisionExpensas(saldoTotalConsorcio, gastoTotalConsorcio);

        imprimirTablaSalida();

        for(UnidadFuncional uf : getUnidades_funcionales()) {
            Double deudaUF = uf.obtenerDeudaExpensas();
            Double importeUF = (importeTotalConsorcio * uf.getPorcentaje_expensas()) + deudaUF;
            uf.setSaldoDeudor(importeUF);

            System.out.println(uf.getNro_uf() + "    | " + uf.getPropietario().getApellido() + ", " + uf.getPropietario().getNombre() + "      |  " + uf.getPorcentaje_expensas() + "%  |  $" + deudaUF + " |  $" + importeUF.floatValue());
            uf.enviarNotificacion(importeUF);
        }
    }

    public void addExpensa(Expensa expensa) {
        this.expensas.add(expensa);
    }

    public void setEstrategiaDeLiquidacion(EstrategiaDeLiquidacion estrategiaDeLiquidacion) {
        this.estrategiaDeLiquidacion = estrategiaDeLiquidacion;
    }

    public void cargarGasto(Date fecha, Double importe, String tipoGasto, Expensa expensa) {
        Gasto gasto = new Gasto(fecha, importe, tipoGasto, expensa);
    }
    public EstrategiaDeLiquidacion getEstrategiaLiquidacion() {
        return estrategiaDeLiquidacion;
    }

    public void cargarPago(Double importePagado, int nroUf, Date fecha) {
        for(UnidadFuncional uf : getUnidades_funcionales()) {
            if(uf.getNro_uf() == nroUf) {
                uf.agregarNuevoPago(importePagado, fecha);
            }
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


}
