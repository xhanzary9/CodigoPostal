package codigopostal.Contolador;

import codigopostal.Modelo.Dentista;
import codigopostal.Modelo.Establecimiento;
import codigopostal.Modelo.Restaurante;

public class FabricaEstableciminetos {
    /**
     * Clase que crea una instancia de una clase que hereda a Establecimiento
     * @param nombreEstablecimiento Linea de la base de datos que contiene el nombre del establecimiento
     * @return clase que hereda a la clase establecimiento 
     */
    public Establecimiento creaEstablecimiento(String nombreEstablecimiento) {
        if (nombreEstablecimiento.contains("Clinica Odontologia")) {
            return new Dentista();
        }
        if (nombreEstablecimiento.contains("Restaurante")) {

            return new Restaurante();
        }
        return null;

    }
}
