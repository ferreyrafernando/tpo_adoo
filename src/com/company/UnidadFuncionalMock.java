package com.company;

import commonClasses.Propietario;
import commonClasses.TipoUF;
import mainClasses.UnidadFuncional;

public class UnidadFuncionalMock {
    private Propietario prop;
    private UnidadFuncional uf;

    public UnidadFuncionalMock(String apeProp, String nomPropr, Integer nro_uf, Double mts_cuad, Double porc_exp, TipoUF tipo_uf) {
        super();

        this.prop.setApellido(apeProp);
        this.prop.setNombre(nomPropr);

        this.uf.setNro_uf(nro_uf);
        this.uf.setTipo_uf(tipo_uf);
        this.uf.setPropietario(prop);
        this.uf.setMts_cuadrados(mts_cuad);
        this.uf.setPorcentaje_expensas(porc_exp);

    }

}
