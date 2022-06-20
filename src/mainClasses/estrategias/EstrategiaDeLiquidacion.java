package mainClasses.estrategias;

import commonClasses.Gasto;
import mainClasses.Administrador;

public abstract class EstrategiaDeLiquidacion {

    // TODO el administrador se saco de la estrategia ya que el administrador contiene la estrategia
    // TODO en el diagrama se le pasa el criterio a la clase pero en realidad la clase misma ya es el criterio
    // TODO deuda previa seria de tipo Gasto?
    abstract void calcularExpensas(Administrador responsable, Gasto deudaPrevia);

    void obtencionSaldos() {
        System.out.println("Obteniendo saldos");
    }

    void calculoGastos(Gasto gastoAnterior) {
        System.out.println("Calculando gastos");
    }

    abstract void divisionExpensas();

}
