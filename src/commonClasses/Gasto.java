package commonClasses;

import java.security.PrivateKey;
import java.util.Date;
import mainClasses.Expensa;

public class Gasto {
    private Date fecha;
    private Double importe;
    private TipoGasto tipoGasto;
    private Expensa expensa;

    public Gasto(Date fecha, Double importe, TipoGasto tipoGasto, Expensa expensa){
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

    public TipoGasto getTipoGasto() {
        return tipoGasto;
    }

    public void setTipoGasto(TipoGasto tipoGasto) {
        this.tipoGasto = tipoGasto;
    }

    public Expensa getExpensa() {
        return expensa;
    }

    public void setExpensa(Expensa expensa) {
        this.expensa = expensa;
    }

    //TODO Chequear metodo
    //public void cargarGasto();
}
