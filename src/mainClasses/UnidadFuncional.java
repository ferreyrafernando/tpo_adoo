package mainClasses;

import commonClasses.Inquilino;
import commonClasses.PagoRealizado;
import commonClasses.Propietario;
import commonClasses.TipoUF;

import java.util.List;

public class UnidadFuncional {
    private Double mts_cuadrados;
    private Double porcentaje_expensas;
    private Propietario propietario;
    private Inquilino inquilino;
    private TipoUF tipo_uf;
    private List<PagoRealizado> pagosRealizados;

    public void calcularExpensas(Administrador responsable, Criterio criterio) {

    }
}
