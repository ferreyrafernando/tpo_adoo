package mainClasses;

import mainClasses.estrategias.EstrategiaLiquidacion;

public class Administrador {
    private String nombre;
    private String apellido;
    private EstrategiaLiquidacion estrategiaLiquidacion;

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
}
