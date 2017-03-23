import java.io.IOException;

/** 
 * Clase encargada de regresar la colonia a la que pertenece el codigo postal
 * @author Branch Code
 * @version 2.1
 */
public interface ColoniaCodigoPostal {
    /**
     * Metodo que regresa el nombre de la colonia a la que pertenece el codigo postal 
     * @param codigoPostal Objeto de la clase codigo postal 
     * @return Cadena que representa el nombre de la colonia que pertenece el codigo postal introducido por el usuario
     */
    public String colonia(CodigoPostal codigoPostal) ;
    
}
