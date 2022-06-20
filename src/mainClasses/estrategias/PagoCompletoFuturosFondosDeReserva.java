package mainClasses.estrategias;

import commonClasses.Gasto;
import mainClasses.Administrador;

import java.math.BigDecimal;

public class PagoCompletoFuturosFondosDeReserva extends EstrategiaDeLiquidacion {

    private final String NOMBRE_CRITERIO = "Pago completo y generar futuros fondos de reserva";

    @Override
    void calcularExpensas(Administrador responsable, BigDecimal deudaPrevia) {
        System.out.println("El Administrador " + responsable.getNombre() + " " + responsable.getApellido() + " inició el calculo de expensas");
        System.out.println("El gasto adeudado es de " + deudaPrevia);
        System.out.println("Calculando expensas segun el criterio de " + NOMBRE_CRITERIO);
    }

    @Override
    void divisionExpensas() {
        System.out.println("Dividiendo expensas para " + NOMBRE_CRITERIO);
    }
}
