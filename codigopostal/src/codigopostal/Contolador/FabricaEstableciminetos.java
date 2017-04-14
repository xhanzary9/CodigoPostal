package codigopostal.Contolador;

import codigopostal.Modelo.Dentista;
import codigopostal.Modelo.Establecimiento;
import codigopostal.Modelo.Restaurante;

public class FabricaEstableciminetos {

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
