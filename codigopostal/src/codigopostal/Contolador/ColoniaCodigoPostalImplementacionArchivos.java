package codigopostal.Contolador;

import codigopostal.Modelo.Colonia;
import codigopostal.Modelo.CodigoPostalChina;
import codigopostal.Modelo.CodigoPostalCanada;
import codigopostal.Modelo.CodigoPostalJapon;
import codigopostal.Modelo.CodigoPostalEstadosUnidos;
import codigopostal.Modelo.CodigoPostal;
import codigopostal.Modelo.CodigoPostalMexico;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase encargada de regresar la colonia a la que pertenece el codigo postal
 * Implementacion de la clase por archivos de texto
 *
 * @author Branch Code
 * @version 2.1
 */
public class ColoniaCodigoPostalImplementacionArchivos implements ColoniaCodigoPostal {

    @Override
    public Colonia colonia(CodigoPostal codigoPostal) {
        String pais = "";
        try {
            if (codigoPostal instanceof CodigoPostalMexico) {
                pais = "Mexico";
                return obtenerColoniaDadoPais(pais, codigoPostal);
            }
            if (codigoPostal instanceof CodigoPostalEstadosUnidos) {
                pais = "Estados Unidos";
                return obtenerColoniaDadoPais(pais, codigoPostal);
            }
            if (codigoPostal instanceof CodigoPostalCanada) {
                pais = "Canada";
                return obtenerColoniaDadoPais(pais, codigoPostal);
            }
            if (codigoPostal instanceof CodigoPostalChina) {
                pais = "China";
                return obtenerColoniaDadoPais(pais, codigoPostal);
            }
            if (codigoPostal instanceof CodigoPostalJapon) {
                pais = "Japon";
                return obtenerColoniaDadoPais(pais, codigoPostal);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return null;
    }

    /**
     * Metodo auxiliar que sirve para poder regresar el nombre de la colonia que
     * tiene dicho codigo postal
     *
     * @param pais Candena que representa el pais del codigo ya validado.
     * @param codigoPostal Objeto de la calse codigo postal.
     * @return Cadena con el nombre de la colonia a la que pertenece el codigo
     * postal.
     * @throws IOException
     */
    private Colonia obtenerColoniaDadoPais(String pais, CodigoPostal codigoPostal) throws IOException {
        //  String nombreArchivo = "C:\\Users\\Renoir\\Documents\\NetBeansProjects\\test\\src\\colonias\\codigoPostalColonias" + pais + ".txt";
        String nombreArchivo = "./BaseDatos/colonias/codigoPostalColonias" + pais + ".txt";
        File archivo = new File(nombreArchivo);
        //File archivo = new File(getClass().getResource("../colonias/" + pais + ".txt").getFile());
        FileReader lectorArchivo = new FileReader(archivo);
        BufferedReader lector = new BufferedReader(lectorArchivo);
        String linea;
        while ((linea = lector.readLine()) != null) {
            if (linea.contains(codigoPostal.getCodigoPostal())) {
                Colonia colonia = new Colonia(linea.substring(codigoPostal.getCodigoPostal().length() + 1),codigoPostal);
                colonia.setPais(pais);
                return colonia;
            }
        }
        return null;
    }
}
