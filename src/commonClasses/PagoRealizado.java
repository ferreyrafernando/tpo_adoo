package commonClasses;

import java.util.Date;
import mainClasses.Expensa;

public class PagoRealizado {
    private Date fecha;
    private Double importe;
    private Expensa expensa;

    PagoRealizado(Date fecha, Double importe, Expensa expensa) {
        this.fecha = fecha;
        this.importe = importe;
        this.expensa = expensa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Expensa getExpensa() {
        return expensa;
    }

    public void setExpensa(Expensa expensa) {
        this.expensa = expensa;
    }
}
