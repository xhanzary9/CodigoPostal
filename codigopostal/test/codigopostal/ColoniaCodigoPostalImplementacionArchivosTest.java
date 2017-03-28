/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigopostal;

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
    }

    private void testColoniaMexico() {
        System.out.println("Empezando test mexico colonia");
        pais = "Mexico";
        cp = "01111";
        codigo = fabrica.creaCodigoPostal(pais, cp);

        coloniaCp = new ColoniaCodigoPostalImplementacionArchivos();
        colonia = coloniaCp.colonia(codigo);
        assertNotNull("Código debería ser distinto de null", codigo);
        assertNotNull("Colonia no debería ser null", colonia);
        assertTrue("Esta colonia no debería estar registrada", colonia.contains("Colonia no registrada"));

        pais = "Mexico";
        cp = "55717";
        codigo = fabrica.creaCodigoPostal(pais, cp);
        colonia = coloniaCp.colonia(codigo);
     
        assertTrue("Esta colonia debería estar registrada", colonia.contains("Coacalco de BerriozabalBosques"));
    }

}
