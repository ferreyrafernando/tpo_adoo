package mainClasses.estrategias;

import commonClasses.Gasto;
import mainClasses.Administrador;

import java.math.BigDecimal;

public abstract class EstrategiaDeLiquidacion {

    abstract void calcularExpensas(Administrador responsable, BigDecimal deudaPrevia);

    void obtencionSaldos() {
        System.out.println("Obteniendo saldos");
    }

    void calculoGastos(Gasto gastoAnterior) {
        System.out.println("Calculando gastos");
    }

    abstract void divisionExpensas();

}
