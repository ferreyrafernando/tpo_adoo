package mainClasses.estrategias;

import commonClasses.Gasto;
import mainClasses.Administrador;
import mainClasses.Consorcio;

import java.math.BigDecimal;

public class PagoCompletoFondoDeReserva extends EstrategiaDeLiquidacion{

    private final String NOMBRE_CRITERIO = "Pago completo con fondos de reserva";

    @Override
    public Double divisionExpensas(Double saldo, Double gastos) {

        System.out.println("Dividiendo expensas para " + NOMBRE_CRITERIO);
        System.out.println("Gasto Actual " + gastos.floatValue());
        Double gastoFinal = (gastos - saldo) < 0 ? 0 : gastos - saldo ;
        System.out.println("Gasto Pendiente del Fondo de Reserva " + gastoFinal.floatValue());

        return gastoFinal;
    }
}
