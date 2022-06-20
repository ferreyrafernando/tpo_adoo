package commonClasses;

import mainClasses.Expensa;

import java.util.Date;

public class GastoRecurrente extends Gasto {
    private Integer periodoDias;

    public GastoRecurrente(Date fecha, Double importe, TipoGasto tipoGasto, Expensa expensa) {
        super(fecha, importe, tipoGasto, expensa);
    }

    /*
    periodoDias
    7 - Semanal
    15 - Quincenal
    30 - Mensual
    365 - Anual
     */
}
