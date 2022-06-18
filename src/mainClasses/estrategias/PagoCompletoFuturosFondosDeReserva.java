package mainClasses.estrategias;

import commonClasses.Gasto;
import mainClasses.Administrador;

public class PagoCompletoFuturosFondosDeReserva extends EstrategiaDeLiquidacion {

    private final String NOMBRE_CRITERIO = "Pago completo y generar futuros fondos de reserva";

    @Override
    void calcularExpensas(Administrador responsable, Gasto deudaPrevia) {
        System.out.println("El Administrador " + responsable.getNombre() + " " + responsable.getApellido() + " inició el calculo de expensas");
        System.out.println("El gasto adeudado es de " + deudaPrevia.getImporte());
        System.out.println("Calculando expensas segun el criterio de " + NOMBRE_CRITERIO);
    }

    @Override
    void divisionExpensas() {
        System.out.println("Dividiendo expensas para " + NOMBRE_CRITERIO);
    }
}
