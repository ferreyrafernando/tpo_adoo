package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import commonClasses.*;
import mainClasses.Administrador;
import mainClasses.Consorcio;
import mainClasses.Expensa;
import mainClasses.UnidadFuncional;
import mainClasses.estrategias.EstrategiaDeLiquidacion;
import mainClasses.estrategias.PagoCompletoFondoDeReserva;
import mainClasses.estrategias.PagoCompletoFuturosFondosDeReserva;
import mainClasses.estrategias.PagoCompletoGasto;
import moduloNotificaciones.estrategias.Estrategia;

public class Main {

    public static void main(String[] args) {

        Administrador administrador=new Administrador("Juan","Perez", "jperez", "1234");
        try {
            administrador.login();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Consorcio consorcio = new Consorcio();
        consorcio.setAdministrador(administrador);
        EstrategiaDeLiquidacion pagoCompletoGastoLiquidacion = new PagoCompletoGasto(); //Divide los gastos totales y los restante lo divide por UF
        EstrategiaDeLiquidacion pagoCompletoFondoReserva = new PagoCompletoFondoDeReserva(); //Utiliza y saldo y los restante lo divide por UF
        EstrategiaDeLiquidacion pagoCompletoFuturoFondoReserva = new PagoCompletoFuturosFondosDeReserva(); //Agrega un porcentaje a los gastos para el fondo y lo divide por UF
        consorcio.setEstrategiaDeLiquidacion(pagoCompletoGastoLiquidacion);
        consorcio.setNombre("Consorcio UADE");

        CuentaBancaria cuentaBancaria = new CuentaBancaria("Galicia", "1214", "1342142353456436436", "FUTBOL.MATE.PAJARO");
        consorcio.setCuenta_bancaria(cuentaBancaria);
        consorcio.setUnidades_funcionales(getUnidadesFuncionales(consorcio));

        Expensa expensa = new Expensa(new Date(2022,6,1), TipoExpensa.ORDINARIA, new ArrayList<Gasto>(), consorcio.getEstrategiaLiquidacion(), consorcio);

        consorcio.cargarGasto(new Date(2022,6,5), 150000.00, "SERVICIOS", expensa);
        consorcio.cargarGasto(new Date(2022,6,7), 7500.00, "MANTENIMIENTO", expensa);
        consorcio.cargarGasto(new Date(2022,6,10), 25000.00, "SEGUROS", expensa);
        consorcio.addExpensa(expensa);

        expensa = new Expensa(new Date(2022,6,1), TipoExpensa.EXTRAORDINARIA, new ArrayList<Gasto>(), consorcio.getEstrategiaLiquidacion(), consorcio);
        consorcio.cargarGasto(new Date(2022,6,8), 50000.00, "MANTENIMIENTO", expensa);
        consorcio.addExpensa(expensa);

        consorcio.calcularExpensas();
    }

    private static List<UnidadFuncional> getUnidadesFuncionales(Consorcio consorcio){
        List<UnidadFuncional> unidadesFunc = new ArrayList<UnidadFuncional>();

        Propietario prop = new Propietario();
        UnidadFuncional uf = new UnidadFuncional(prop, consorcio);
        Inquilino inq = new Inquilino();

        prop.setApellido("Ferreyra");
        prop.setNombre("Fernando");
        inq = new Inquilino();
        inq.setNombre("Dario");
        inq.setApellido("Hernandez");
        inq.setEmail("hernandezd@gmail.com");
        inq.setNumero("1122332211");
        uf.setInquilino(inq);
        uf.setEstrategiaDeNotificacion(Estrategia.SMS);
        uf.setNro_uf(1);
        uf.setTipo_uf(TipoUF.DEPARTAMENTO);
        uf.setPropietario(prop);
        uf.setMts_cuadrados(52.5);
        uf.setPorcentaje_expensas(0.025);
        unidadesFunc.add(uf);

        prop = new Propietario();
        uf = new UnidadFuncional(prop, consorcio);
        prop.setApellido("Meza");
        prop.setNombre("Mauricio");
        inq = new Inquilino();
        inq.setNombre("Lucas");
        inq.setApellido("Rodriguez");
        inq.setEmail("lucasr@gmail.com");
        uf.setInquilino(inq);
        inq.setNumero("1154332872");
        uf.setEstrategiaDeNotificacion(Estrategia.SMS);
        uf.setNro_uf(2);
        uf.setTipo_uf(TipoUF.DEPARTAMENTO);
        uf.setPropietario(prop);
        uf.setMts_cuadrados(83.4);
        uf.setPorcentaje_expensas(0.035);
        unidadesFunc.add(uf);

        prop = new Propietario();
        uf = new UnidadFuncional(prop, consorcio);

        prop.setApellido("Pelech");
        prop.setNombre("Federico");
        inq = new Inquilino();
        inq.setNombre("Carlos");
        inq.setApellido("Lopez");
        inq.setEmail("carloslopez@gmail.com");
        uf.setInquilino(inq);
        uf.setEstrategiaDeNotificacion(Estrategia.EMAIL);
        uf.setNro_uf(3);
        uf.setTipo_uf(TipoUF.COCHERA);
        uf.setPropietario(prop);
        uf.setMts_cuadrados(4.8);
        uf.setPorcentaje_expensas(0.001);
        unidadesFunc.add(uf);

        prop = new Propietario();
        uf = new UnidadFuncional(prop, consorcio);

        prop.setApellido("Stricagnoli");
        prop.setNombre("Matias");
        inq = new Inquilino();
        inq.setNombre("Matias");
        inq.setApellido("Stricagnoli");
        inq.setNumero("1128725433");
        inq.setEmail("mstricagnoli@uade.edu.ar");
        uf.setInquilino(inq);
        uf.setEstrategiaDeNotificacion(Estrategia.WHATSAPP);
        uf.setNro_uf(4);
        uf.setTipo_uf(TipoUF.DEPARTAMENTO);
        uf.setPropietario(prop);
        uf.setMts_cuadrados(83.4);
        uf.setPorcentaje_expensas(0.035);
        unidadesFunc.add(uf);

        return unidadesFunc;
    }

}
