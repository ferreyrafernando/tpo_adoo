package mainClasses.estrategias;

import commonClasses.Gasto;
import mainClasses.Administrador;
import mainClasses.Consorcio;

import java.math.BigDecimal;

public class PagoCompletoGasto extends EstrategiaDeLiquidacion {

    private final String NOMBRE_CRITERIO = "Pago completo de gastos";


    @Override
    public Double divisionExpensas(Double saldo, Double gastos) {

        System.out.println("Dividiendo expensas para " + NOMBRE_CRITERIO);
        System.out.println("Gasto Actual " + gastos.floatValue());
        System.out.println("Gasto Pago Completo " + gastos.floatValue());

        return gastos;
    }
}
