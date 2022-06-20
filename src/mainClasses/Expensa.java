package mainClasses;

import commonClasses.Gasto;
import commonClasses.TipoExpensa;
import commonClasses.TipoGasto;
import mainClasses.estrategias.EstrategiaDeLiquidacion;

import java.util.Date;
import java.util.List;

public class Expensa {
    private Date fecha;
    private TipoExpensa tipo_expensa;
    private List<Gasto> gastos;
    private EstrategiaDeLiquidacion estrategia;
    private Consorcio consorcio;

    public void cambiarEstrategiaDeLiquidacion(EstrategiaDeLiquidacion estrategia) {
        this.estrategia = estrategia;
    }

    public void cargarGasto(Gasto gasto){
        System.out.println("Cargando Gasto: " + gasto.getTipoGasto());
        this.gastos.add(gasto);
    }

    public Expensa(Date fecha, TipoExpensa tipoExpensa, List<Gasto> listGastos, EstrategiaDeLiquidacion criterio, Consorcio consorcio){
        this.fecha = fecha;
        this.tipo_expensa = tipoExpensa;
        this.gastos = listGastos;
        this.estrategia = criterio;
        this.consorcio = consorcio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TipoExpensa getTipo_expensa() {
        return tipo_expensa;
    }

    public void setTipo_expensa(TipoExpensa tipo_expensa) {
        this.tipo_expensa = tipo_expensa;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public EstrategiaDeLiquidacion getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(EstrategiaDeLiquidacion estrategia) {
        this.estrategia = estrategia;
    }
}
