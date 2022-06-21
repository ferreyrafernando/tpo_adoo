package commonClasses;

import java.util.Date;

public class FacadeSaldoBancario {
    private Double saldo = 3500000.00; // A modo de ejemplo para que devuelva el saldo el Facade

    public double obtenerSaldoCompleto(Date fecha, String CBU, String Alias, String token_seguridad){
        //@TODO este método implementaria el llamado al módulo de obtencio de saldo completo

        return this.saldo;
    }
}
