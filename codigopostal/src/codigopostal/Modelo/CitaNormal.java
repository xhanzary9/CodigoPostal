package codigopostal.Modelo;

import java.util.Date;

public class CitaNormal extends Cita{
    
    public CitaNormal(Establecimiento establecimiento, Date horario, Servicio servicio) {
        super(establecimiento, horario, servicio);
    }

    public CitaNormal() {
        super();
    }
    
}
