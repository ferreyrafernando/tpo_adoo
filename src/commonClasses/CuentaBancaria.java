package commonClasses;
import moduloBanco.*;

public class CuentaBancaria {
    private ServicioBancario servicioBancario;

    CuentaBancaria(String banco, String nro_cuenta, String cbu, String alias, Double saldo) {
        ServicioBancario servicioExterno = new ServicioBancario(banco, nro_cuenta, cbu, alias, saldo);
        this.servicioBancario = servicioExterno;
    }
    public String getBanco() {
        return servicioBancario.getBanco();
    }

    public void setBanco(String banco) {
        servicioBancario.setBanco(banco);
    }

    public String getNro_cuenta() {
        return servicioBancario.getNro_cuenta();
    }

    public void setNro_cuenta(String nro_cuenta) {
        servicioBancario.setNro_cuenta(nro_cuenta);
    }

    public String getCbu() {
        return servicioBancario.getCbu();
    }

    public void setCbu(String cbu) {
        servicioBancario.setCbu(cbu);
    }

    public String getAlias() {
        return servicioBancario.getAlias();
    }

    public void setAlias(String alias) {
        servicioBancario.setAlias(alias);
    }

    public Double getSaldo() {
        return servicioBancario.getSaldo();
    }

    public void setSaldo(Double saldo) {
       servicioBancario.setSaldo(saldo);
    }
}
