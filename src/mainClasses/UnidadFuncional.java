package mainClasses;

import commonClasses.Inquilino;
import commonClasses.PagoRealizado;
import commonClasses.Propietario;
import commonClasses.TipoUF;
import mainClasses.estrategias.EstrategiaDeLiquidacion;

import java.util.List;

public class UnidadFuncional {
    private int nro_uf;
    private Double mts_cuadrados;
    private Double porcentaje_expensas; // 0,1 10% - 0,25 25% - 0,3 30%
    private Propietario propietario;
    private Inquilino inquilino;
    private TipoUF tipo_uf;
    private List<PagoRealizado> pagosRealizados;
    private Double saldoDeudor;
    // agregar saldoDeudor.
    //TODO Chequear metodo
    public void calcularExpensas(EstrategiaDeLiquidacion criterio, Double importeTotalConsorcio){

        //TODO Chequear deuda expensas anteriores para sumarlo al importeUF al final
        Double deudaUF = this.obtenerDeudaExpensas();

        Double importeUF = (importeTotalConsorcio * this.porcentaje_expensas) + deudaUF;

        System.out.println(this.nro_uf + "    | " + this.propietario.getApellido() + ", " + this.propietario.getNombre() + "      |  " + this.porcentaje_expensas + "%  |  $" + deudaUF + " |  $" + importeUF);
    }

    public Double obtenerDeudaExpensas(){
        return 4200.00;
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
}
