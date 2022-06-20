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
import mainClasses.estrategias.PagoCompletoGasto;
import moduloNotificaciones.Notificacion;
import moduloNotificaciones.Notificador;
import moduloNotificaciones.estrategias.Estrategia;
import moduloNotificaciones.estrategias.EstrategiaDeNotificacion;
import moduloNotificaciones.estrategias.NotificacionPorEmail;
import moduloNotificaciones.estrategias.NotificacionPorSMS;
import moduloNotificaciones.estrategias.NotificacionPorWhatsApp;
import moduloNotificaciones.estrategias.adapters.email.AdapterEmailService;
import moduloNotificaciones.estrategias.adapters.sms.AdapterSMSService;
import moduloNotificaciones.estrategias.adapters.whatsapp.AdapterWhatsAppService;

public class Main {

    public static void main(String[] args) {

        Administrador administrador=new Administrador("Juan","Perez");
        EstrategiaDeLiquidacion pagoCompletoGastoLiquidacion = new PagoCompletoGasto(); //Puede ser esta u otra
        administrador.setEstrategiaDeLiquidacion(pagoCompletoGastoLiquidacion);

        Consorcio consorcio = new Consorcio(); // Generar y usar Mock para datos del consorocio, algunos deptos, cocheras, etc
        consorcio.setAdministrador(administrador);
        consorcio.setNombre("Consorcio UADE");

        CuentaBancaria cuentaBancaria = new CuentaBancaria("Galicia", "1214", "1342142353456436436", "FUTBOL.MATE.PAJARO");
        consorcio.setCuenta_bancaria(cuentaBancaria);
        consorcio.setUnidades_funcionales(getUnidadesFuncionales(consorcio));

        Expensa expensa = new Expensa(new Date(2022,6,1), TipoExpensa.ORDINARIA, new ArrayList<Gasto>(), administrador.getEstrategiaLiquidacion(), consorcio);

        administrador.cargarGasto(new Date(2022,6,5), 150000.00, TipoGasto.SERVICIOS, expensa); // Generar y usar Mock para datos GASTOS
        administrador.cargarGasto(new Date(2022,6,7), 7500.00, TipoGasto.MANTENIMIENTO, expensa);
        administrador.cargarGasto(new Date(2022,6,10), 25000.00, TipoGasto.SEGUROS, expensa);

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

        return unidadesFunc;
    }

}
