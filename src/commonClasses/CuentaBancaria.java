package commonClasses;

public class CuentaBancaria {

    private String banco;
    private String nro_cuenta;
    private String cbu;
    private String alias;
    private Double saldo;

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNro_cuenta() {
        return nro_cuenta;
    }

    public void setNro_cuenta(String nro_cuenta) {
        this.nro_cuenta = nro_cuenta;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
