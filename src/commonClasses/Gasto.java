package commonClasses;

import java.util.Date;
import mainClasses.Expensa;

public class Gasto {
    private Double importe;
    private Date fecha;
    private Expensa expensa;

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    //TODO Chequear metodo
    //public void cargarGasto();
}
