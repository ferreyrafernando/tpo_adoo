package mainClasses.estrategias;

public class PagoCompletoFuturosFondosDeReserva extends EstrategiaDeLiquidacion {

    private final String NOMBRE_CRITERIO = "Pago completo y generar futuros fondos de reserva";
    private Double pocentaje_recargo = 0.08;

    public Double getPocentaje_recargo() {
        return pocentaje_recargo;
    }

    @Override
    public Double divisionExpensas(Double saldo, Double gastos) {
        System.out.println("Dividiendo expensas para " + NOMBRE_CRITERIO);
        System.out.println("Gasto Actual " + gastos.floatValue());
        Double gastoFinal = gastos + (gastos * getPocentaje_recargo());
        System.out.println("Gasto con Futuro Fondo de Reserva " + gastoFinal.floatValue());

        return gastoFinal;
    }
}
