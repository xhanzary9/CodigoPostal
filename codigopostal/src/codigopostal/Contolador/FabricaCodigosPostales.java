package codigopostal.Contolador;

import codigopostal.Modelo.CodigoPostalChina;
import codigopostal.Modelo.CodigoPostalCanada;
import codigopostal.Modelo.CodigoPostalJapon;
import codigopostal.Modelo.CodigoPostalEstadosUnidos;
import codigopostal.Modelo.CodigoPostal;
import codigopostal.Modelo.CodigoPostalMexico;


public class FabricaCodigosPostales {
    /**
     * Fabrica que se encarga de crear las clases codigo postal correspondientes para cada entidad.
     * @param nombreEntidad Nombre de la entidad que el usuario quiere verificar el codigo postal.
     * @param codigopostal codigo postal que desea verificar el usuario.
     * @return una instacia de una clase que herede la clase abstracta CodigoPostal ya inicializada.
     */
    public CodigoPostal creaCodigoPostal(String nombreEntidad, String codigopostal){
        nombreEntidad = nombreEntidad.trim();
        if(nombreEntidad.equalsIgnoreCase("Mexico")){
            return new CodigoPostalMexico(codigopostal);
        }
        if(nombreEntidad.equalsIgnoreCase("Estados unidos")){
            return new CodigoPostalEstadosUnidos(codigopostal);
        }
        if(nombreEntidad.equalsIgnoreCase("Japon")){
            return new CodigoPostalJapon(codigopostal);
        }
        if(nombreEntidad.equalsIgnoreCase("Canada")){
            return new CodigoPostalCanada(codigopostal);
        }
        if(nombreEntidad.equalsIgnoreCase("China")){
            return new CodigoPostalChina(codigopostal);
        }
        return null;
    }
}
