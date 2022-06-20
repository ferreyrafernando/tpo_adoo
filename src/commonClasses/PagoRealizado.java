package commonClasses;

import java.util.Date;

public class PagoRealizado {
    private Date fecha;
    private Double importe;

    public PagoRealizado(Date fecha, Double importe) {
        this.fecha = fecha;
        this.importe = importe;
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
}
