package codigopostal.Modelo;

import java.util.Date;

public class CitaNormal extends Cita{
    /**
     * Instancia de la clase Cita que modela una cita normal, los precios son los mismo.
     */
    public CitaNormal(Establecimiento establecimiento, Date horario, Servicio servicio) {
        super(establecimiento, horario, servicio);
    }

    public CitaNormal() {
        super();
    }
    
}
