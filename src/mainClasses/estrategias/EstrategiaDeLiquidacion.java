package mainClasses.estrategias;

import mainClasses.Administrador;

public abstract class EstrategiaDeLiquidacion {
    private Administrador responsable;

    abstract void calcularExpensas();
    abstract void divisionExpensas();
    abstract void obtencionSaldos();
    abstract void calculoGastos();
}
