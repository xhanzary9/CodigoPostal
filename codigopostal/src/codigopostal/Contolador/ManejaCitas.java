
package codigopostal.Contolador;

import codigopostal.Modelo.Cita;
import java.io.IOException;

public interface ManejaCitas {
    /**
     * Metodo que se encarga de guardar una cita
     * @param cita
     * @throws IOException 
     */
    public void GuardarCita(Cita cita)throws IOException;
    /**
     * Metodo que recibe una solicitud de cita y regresa un valor booleano 
     * que expresa la disponibilidad de la cita en dicho dia,hora y establecimiento
     * @param cita una solicitud de cita que cumpla con los requisitos previos de cada establecimiento
     * @return true si es posible establecer una cita en esa hora y dia especificados, false en otro caso
     */
    public boolean disponible(Cita cita);
    
}
