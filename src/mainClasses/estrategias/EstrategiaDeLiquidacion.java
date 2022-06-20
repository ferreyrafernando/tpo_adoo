package mainClasses.estrategias;

import commonClasses.CuentaBancaria;
import commonClasses.Gasto;
import mainClasses.Administrador;
import mainClasses.Consorcio;
import mainClasses.Expensa;

public abstract class EstrategiaDeLiquidacion {

    public abstract Double calcularExpensas(Consorcio consorcio);

    public Double obtencionSaldos(Consorcio consorcio) {
        System.out.println("Obteniendo saldos");
        return consorcio.getCuenta_bancaria().getSaldo();
    }

    public Double calculoGastos(Consorcio consorcio) {
        System.out.println("Calculando gastos");
        Double gastoTotal = 0.0;
        for(Expensa expensa : consorcio.getExpensas()) {
            for(Gasto gasto : expensa.getGastos()) {
                gastoTotal += gasto.getImporte();
            }
        }
        return gastoTotal;
    }

    public abstract void divisionExpensas(Double gastos);
}
