package mainClasses;

import commonClasses.Gasto;
import commonClasses.TipoGasto;
import mainClasses.estrategias.EstrategiaDeLiquidacion;

import java.util.Date;

public class Administrador {
    private String nombre;
    private String apellido;

    public Administrador(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    private EstrategiaDeLiquidacion estrategiaDeLiquidacion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public EstrategiaDeLiquidacion getEstrategiaLiquidacion() {
        return estrategiaDeLiquidacion;
    }

    public void setEstrategiaDeLiquidacion(EstrategiaDeLiquidacion estrategiaDeLiquidacion) {
        this.estrategiaDeLiquidacion = estrategiaDeLiquidacion;
    }

    public void cargarGasto(Date fecha, Double importe, TipoGasto tipoGasto, Expensa expensa) {
        Gasto gasto = new Gasto(fecha, importe, tipoGasto, expensa);

    }
}
