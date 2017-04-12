
package codigopostal.Contolador;

import codigopostal.Modelo.Cita;
import java.io.IOException;

public interface ManejaCitas {
    public void GuardarCita(Cita cita)throws IOException;
    public boolean disponible(Cita cita);
    
}
