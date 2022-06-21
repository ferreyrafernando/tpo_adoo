package mainClasses.estrategias;

import commonClasses.Gasto;
import mainClasses.Consorcio;
import mainClasses.Expensa;

import java.util.List;

public abstract class EstrategiaDeLiquidacion {

    public Double obtencionSaldos(Consorcio consorcio) {
        System.out.println("Obteniendo saldos");
        return consorcio.getCuenta_bancaria().getSaldo();
    }

    public Double calculoGastos(List<Expensa> expensas) {
        System.out.println("Calculando gastos");
        Double gastoTotal = 0.0;
        for(Expensa expensa : expensas) {
            for(Gasto gasto : expensa.getGastos()) {
                gastoTotal += gasto.getImporte();
            }
        }
        return gastoTotal;
    }

    public abstract Double divisionExpensas(Double saldo, Double gastos);
}
