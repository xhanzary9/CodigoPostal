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
public class CodigoPostalValidadorTest {

    private String pais;
    private String cp;
    private FabricaCodigosPostales fabrica = new FabricaCodigosPostales();
    private Validar validar = new CodigoPostalValidador();
    private CodigoPostal codigo;

    public CodigoPostalValidadorTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    /**
     * Test of valida method, of class CodigoPostalValidador.
     */
    @Test
    public void testValida() {

        CodigoPostalValidador instance = new CodigoPostalValidador();

        try {
            instance.valida(null);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }

        testForMexico();
        testForEu();
        testFChina();
        testForJapon();

        //boolean result = instance.valida(codigoPostal);
        //assertEquals(expResult, result);
    }

    /**
     * Test of caracterValido method, of class CodigoPostalValidador.
     */
    @Test
    public void testCaracterValido() {
        CodigoPostalValidador instance = new CodigoPostalValidador();
        assertTrue("CaracterValido con codigo 5 y ER #", instance.caracterValido('5', '#'));
        assertFalse("CaracterValido con codigo G y ER #", instance.caracterValido('G', '#'));
        assertTrue("CaracterValido con codigo G y ER $", instance.caracterValido('G', '$'));
        assertFalse("CaracterValido con codigo % y ER $", instance.caracterValido('%', '$'));
    }

    private void testForJapon() {

        pais = "Japon";
        cp = "36507";
        codigo = fabrica.creaCodigoPostal(pais, cp);
        assertEquals(false, validar.valida(codigo));

        pais = "Japon";
        cp = "3650-7243";
        codigo = fabrica.creaCodigoPostal(pais, cp);
        assertEquals("Esto es falso", false, validar.valida(codigo));
    }

    private void testFChina() {

        pais = "China";
        cp = "36507";
        codigo = fabrica.creaCodigoPostal(pais, cp);
        assertEquals(false, validar.valida(codigo));

        pais = "China";
        cp = "3650723";
        codigo = fabrica.creaCodigoPostal(pais, cp);
        assertEquals(false, validar.valida(codigo));
    }

    private void testForEu() {
        pais = "Estados unidos";
        cp = "36507";
        codigo = fabrica.creaCodigoPostal(pais, cp);
        assertEquals(true, validar.valida(codigo));

        pais = "Estados unidos";
        cp = "3650723";
        codigo = fabrica.creaCodigoPostal(pais, cp);
        assertEquals(false, validar.valida(codigo));
    }

    private void testForMexico() {

        pais = "Mexico";
        cp = "01111";
        codigo = fabrica.creaCodigoPostal(pais, cp);
        assertEquals(true, validar.valida(codigo));

        cp = "011111";
        codigo = fabrica.creaCodigoPostal(pais, cp);
        assertEquals(false, validar.valida(codigo));
    }

}
