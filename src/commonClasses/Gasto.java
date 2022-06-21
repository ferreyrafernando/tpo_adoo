package commonClasses;

import java.util.Date;
import mainClasses.Expensa;

public class Gasto {
    private Date fecha;
    private Double importe;
    private String tipoGasto;
    private Expensa expensa;

    public Gasto(Date fecha, Double importe, String tipoGasto, Expensa expensa){
        this.fecha = fecha;
        this.importe = importe;
        this.tipoGasto = tipoGasto;

        expensa.cargarGasto(this);
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoGasto() {
        return tipoGasto;
    }

    public void setTipoGasto(String tipoGasto) {
        this.tipoGasto = tipoGasto;
    }

    public Expensa getExpensa() {
        return expensa;
    }

    public void setExpensa(Expensa expensa) {
        this.expensa = expensa;
    }

}
