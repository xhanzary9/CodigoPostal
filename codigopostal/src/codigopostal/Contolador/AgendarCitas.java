
package codigopostal.Contolador;

import codigopostal.Excepciones.EstablecimientoCerradoExcepcion;
import codigopostal.Modelo.Establecimiento;
import codigopostal.Modelo.Servicio;
import java.util.Date;

public interface AgendarCitas {
    /**
     * * Metodo que se encarga de agendar una cita en un establecimiento especificado
     * @param establecimiento Establecimiento en el que se busca hacer una cita  
     * @param horario Horario en el que se trata de agregar una cita
     * @throws EstablecimientoCerradoExcepcion  Excepcion que se arroja cuando el local no esta disponible en determinado horario.
     */
    public void AgendarCita(Establecimiento establecimiento,Servicio servicio,Date horario) throws EstablecimientoCerradoExcepcion ;
    
}
