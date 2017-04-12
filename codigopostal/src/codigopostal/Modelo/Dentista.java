package codigopostal.Modelo;

import java.util.List;

public class Dentista extends Establecimiento{
    
    public Dentista(String nombre, List<Servicio> serviciosOfrece, Colonia colonia, String horarioServicio) {
        super("Clinica odontologica "+nombre, serviciosOfrece, colonia, horarioServicio);
    }

    public Dentista() {
      
    }
    
    
}
