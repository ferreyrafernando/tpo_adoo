package mainClasses.estrategias;

import mainClasses.Consorcio;

public class PagoCompletoFuturosFondosDeReserva extends EstrategiaDeLiquidacion {

    private final String NOMBRE_CRITERIO = "Pago completo y generar futuros fondos de reserva";

    @Override
    public Double calcularExpensas(Consorcio consorcio) {
        System.out.println("El Administrador " + consorcio.getAdministrador().getNombre() + " " + consorcio.getAdministrador().getApellido() + " inició el calculo de expensas");
        System.out.println("Calculando expensas segun el criterio de " + NOMBRE_CRITERIO);
        Double saldo = super.obtencionSaldos(consorcio);
        Double gastos = super.calculoGastos(consorcio);
        divisionExpensas(gastos);
        return gastos;
    }

    @Override
    public void divisionExpensas(Double gastos) {
        System.out.println("Dividiendo expensas para " + NOMBRE_CRITERIO);
    }
}
