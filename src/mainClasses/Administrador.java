package mainClasses;

import java.util.Date;

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
    private String user;
    private String pass;

    public Administrador(String nombre, String apellido, String usuario, String pass) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.user = usuario;
        this.pass = pass;
    }



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


    public void login() throws InterruptedException {
        System.out.println("Autenticando Usuario " + this.getUser() +"...");
        Thread.sleep(2500);
        System.out.println("Autenticado Correctamente!");
    }



    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
