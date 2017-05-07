/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration_test;

import codigopostal.Contolador.FabricaCodigosPostales;
import codigopostal.Contolador.ColoniaCodigoPostalImplementacionArchivos;
import codigopostal.Modelo.CodigoPostal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ken
 */
public class ColoniaCodigoPostalImplementacionArchivosTest {

    ColoniaCodigoPostalImplementacionArchivos coloniaCp = new ColoniaCodigoPostalImplementacionArchivos();
    FabricaCodigosPostales fabrica = new FabricaCodigosPostales();

    String pais;
    String cp;
    String colonia;
    CodigoPostal codigo;

    /**
     * Test of colonia method, of class
     * ColoniaCodigoPostalImplementacionArchivos.
     */
    @Test
    public void testColonia() {
        testColoniaMexico();
        testColoniaJapon();
        testColoniaChina();
        testColoniaEU();
        testColoniaCanada();
    }

    private void testColoniaMexico() {
        pais = "Mexico";
        cp = "01111";
        codigo = fabrica.creaCodigoPostal(pais, cp);

        coloniaCp = new ColoniaCodigoPostalImplementacionArchivos();
        colonia = coloniaCp.colonia(codigo).getNombre();
        assertNotNull("Código debería ser distinto de null", codigo);
        assertNotNull("Colonia no debería ser null", colonia);
        assertTrue("Esta colonia no debería estar registrada", colonia.contains("Colonia no registrada"));

        cp = "55717";
        codigo = fabrica.creaCodigoPostal(pais, cp);
        colonia = coloniaCp.colonia(codigo).getNombre();
        assertTrue("Esta colonia debería estar registrada", colonia.contains("Coacalco de BerriozabalBosques"));
    }

    private void testColoniaJapon() {
        pais = "Japon";
        cp = "260-0008";
        codigo = fabrica.creaCodigoPostal(pais, cp);

        coloniaCp = new ColoniaCodigoPostalImplementacionArchivos();
        colonia = coloniaCp.colonia(codigo).getNombre();
        assertNotNull("Código debería ser distinto de null", codigo);
    
        assertNotNull("Colonia no debería ser null", colonia);
        assertTrue("Esta colonia no debería estar registrada", colonia.contains("Colonia no registrada"));

        cp = "260-0006";
        codigo = fabrica.creaCodigoPostal(pais, cp);
        colonia = coloniaCp.colonia(codigo).getNombre();
        assertTrue("Esta colonia debería estar registrada", colonia.contains("Dojo Kita"));
    }

    private void testColoniaChina() {
        pais = "China";
        cp = "100350";
        codigo = fabrica.creaCodigoPostal(pais, cp);

        coloniaCp = new ColoniaCodigoPostalImplementacionArchivos();
        colonia = coloniaCp.colonia(codigo).getNombre();
        assertNotNull("Código debería ser distinto de null", codigo);
        assertNotNull("Colonia no debería ser null", colonia);
        assertTrue("Esta colonia no debería estar registrada", colonia.contains("Colonia no registrada"));

        cp = "100050";
        codigo = fabrica.creaCodigoPostal(pais, cp);
        colonia = coloniaCp.colonia(codigo).getNombre();
        assertTrue("Esta colonia debería estar registrada", colonia.contains("Xuanwu"));
    }

    private void testColoniaEU() {
        pais = "Estados Unidos";
        cp = "24201";
        codigo = fabrica.creaCodigoPostal(pais, cp);

        coloniaCp = new ColoniaCodigoPostalImplementacionArchivos();
        colonia = coloniaCp.colonia(codigo).getNombre();
        assertNotNull("Código debería ser distinto de null", codigo);
        assertNotNull("Colonia no debería ser null", colonia);
        assertTrue("Esta colonia no debería estar registrada", colonia.contains("Colonia no registrada"));

        cp = "24205";
        codigo = fabrica.creaCodigoPostal(pais, cp);
        colonia = coloniaCp.colonia(codigo).getNombre();
        assertTrue("Esta colonia debería estar registrada", colonia.contains("Bristol Merchandise"));
    }

    private void testColoniaCanada() {
        pais = "Canada";
        cp = "N0H 1K3";
        codigo = fabrica.creaCodigoPostal(pais, cp);

        coloniaCp = new ColoniaCodigoPostalImplementacionArchivos();
        colonia = coloniaCp.colonia(codigo).getNombre();
        assertNotNull("Código debería ser distinto de null", codigo);
        assertNotNull("Colonia no debería ser null", colonia);
        assertTrue("Esta colonia no debería estar registrada", colonia.contains("Colonia no registrada"));

        cp = "N0H 1K0";
        codigo = fabrica.creaCodigoPostal(pais, cp);
        colonia = coloniaCp.colonia(codigo).getNombre();
        assertTrue("Esta colonia debería estar registrada", colonia.contains("DesboroPO Boxes"));
    }
    
    

}
