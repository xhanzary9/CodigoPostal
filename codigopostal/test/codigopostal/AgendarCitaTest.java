/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigopostal;

import codigopostal.Contolador.AgendarCitasInternet;
import codigopostal.Contolador.ColoniaCodigoPostalImplementacionArchivos;
import codigopostal.Contolador.DesplegarEstablecimientoArchivoTexto;
import codigopostal.Contolador.FabricaCodigosPostales;
import codigopostal.Contolador.FabricaEstableciminetos;
import codigopostal.Excepciones.EstablecimientoCerradoExcepcion;
import codigopostal.Modelo.CodigoPostal;
import codigopostal.Modelo.CodigoPostalMexico;
import codigopostal.Modelo.Colonia;
import codigopostal.Modelo.Establecimiento;
import codigopostal.Modelo.Servicio;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Renoir
 */
public class AgendarCitaTest {
    
    public AgendarCitaTest() {
    }
    
    @Test
    public void testAgendarCitaValida() {
        FabricaCodigosPostales fabrica = new FabricaCodigosPostales();
        CodigoPostal codigo = fabrica.creaCodigoPostal("Mexico", "09200");
        ColoniaCodigoPostalImplementacionArchivos coloniaCp = new ColoniaCodigoPostalImplementacionArchivos();
        Colonia colonia = coloniaCp.colonia(codigo);
        
        DesplegarEstablecimientoArchivoTexto desp = new DesplegarEstablecimientoArchivoTexto();
        List<Establecimiento> establecimientos = desp.establecimientoEnColonia(colonia);
        AgendarCitasInternet agendar = new AgendarCitasInternet();
        Establecimiento est = establecimientos.get(0);
        Date date = new Date();
        try {
            agendar.AgendarCita(est, est.getServiciosOfrece().get(0), date);
        } catch (EstablecimientoCerradoExcepcion e) {
            assert(false);
        }
    }
    
    @Test
    public void testAgendarCitaInvalida() {
        FabricaCodigosPostales fabrica = new FabricaCodigosPostales();
        CodigoPostal codigo = fabrica.creaCodigoPostal("Mexico", "09200");
        ColoniaCodigoPostalImplementacionArchivos coloniaCp = new ColoniaCodigoPostalImplementacionArchivos();
        Colonia colonia = coloniaCp.colonia(codigo);
        
        DesplegarEstablecimientoArchivoTexto desp = new DesplegarEstablecimientoArchivoTexto();
        List<Establecimiento> establecimientos = desp.establecimientoEnColonia(colonia);
        AgendarCitasInternet agendar = new AgendarCitasInternet();
        Establecimiento est = establecimientos.get(0);
        Date date = new Date(1995, 3, 4);
        try {
            agendar.AgendarCita(est, est.getServiciosOfrece().get(0), date);
        } catch (EstablecimientoCerradoExcepcion e) {
            assert(true);
        }
    }
}
