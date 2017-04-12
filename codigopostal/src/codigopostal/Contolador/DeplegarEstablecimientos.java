
package codigopostal.Contolador;

import codigopostal.Excepciones.EstablecimientosNoEncontradosExcepcion;
import codigopostal.Modelo.Colonia;
import codigopostal.Modelo.Establecimiento;
import java.util.List;

public interface DeplegarEstablecimientos {
    /**
     * Metodo que regresa todos los establecimientos de una colonia
     * @param colonia
     * @return Lista con todos los establecimientos
     * @throws EstablecimientosNoEncontradosExcepcion es lanzada cuando una colonia no tiene Establecimietos propios 
     */
    public List<Establecimiento> establecimientoEnColonia(Colonia colonia) throws EstablecimientosNoEncontradosExcepcion;
}
