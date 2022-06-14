package mainClasses;

import commonClasses.Gasto;
import commonClasses.TipoExpensa;
import mainClasses.estrategias.EstrategiaDeLiquidacion;

import java.util.Date;
import java.util.List;

public class Expensa {
    private Date fecha;
    private TipoExpensa tipo_expensa;
    private List<Gasto> gastos;
    private EstrategiaDeLiquidacion estrategia;

    public void cambiarEstrategiaDeLiquidacion(EstrategiaDeLiquidacion estrategia) {
        this.estrategia = estrategia;
    }

    public void cargarGasto(Gasto gasto){
        System.out.println("Cargando Gasto");
    }


}
