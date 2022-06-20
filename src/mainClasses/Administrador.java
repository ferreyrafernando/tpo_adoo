package mainClasses;

import mainClasses.estrategias.EstrategiaLiquidacion;

public class Administrador {
    static Administrador instancia = null;

    private Administrador() {};

    public static Administrador getInstance() {
        if(instancia == null) {
            instancia = new Administrador();
        }
        return instancia;
    }

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
