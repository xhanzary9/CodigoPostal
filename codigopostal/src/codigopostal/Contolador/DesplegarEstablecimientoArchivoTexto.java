package codigopostal.Contolador;

import codigopostal.Excepciones.ColoniaNoRegistradaExcepcion;
import codigopostal.Modelo.Restaurante;
import codigopostal.Excepciones.EstablecimientosNoEncontradosExcepcion;
import codigopostal.Modelo.CodigoPostal;
import codigopostal.Modelo.Colonia;
import codigopostal.Modelo.Dentista;
import codigopostal.Modelo.Establecimiento;
import codigopostal.Modelo.Servicio;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DesplegarEstablecimientoArchivoTexto implements DeplegarEstablecimientos {

    @Override
    public List<Establecimiento> establecimientoEnColonia(Colonia colonia) throws EstablecimientosNoEncontradosExcepcion {
        try {
            return obtenerEstablecimientos(colonia, colonia.getPais());
        } catch (IOException ex) {
            throw new EstablecimientosNoEncontradosExcepcion("No hay establecimietnos registrados en esta Colonia");
        }catch (NullPointerException e){
            throw new ColoniaNoRegistradaExcepcion("Colonia no  registrada");
        }

    }
    /**
     * Metodo auxiliar que obtiene todos los establecimientos por colonia
     * @param colonia Colonia que se desean buscar los establecimentos 
     * @param pais Pais al que pretenece la colonia
     * @return lista con todos los establecimientos de la colonia solicitada
     * @throws IOException 
     */
    private List<Establecimiento> obtenerEstablecimientos(Colonia colonia, String pais) throws IOException {
        String nombreArchivo = "./BaseDatos/Establecimientos/Establecimientos.txt";
        File archivo = new File(nombreArchivo);
        FileReader lectorArchivo = new FileReader(archivo);
        BufferedReader lector = new BufferedReader(lectorArchivo);
        String linea;
        List<Establecimiento> establecimientos = new ArrayList<>();
        Establecimiento establecimiento = null;
        while ((linea = lector.readLine()) != null) {
            
            if (linea.contains("nombre")) {
                FabricaEstableciminetos est = new FabricaEstableciminetos();
                establecimiento = est.creaEstablecimiento(linea);
                establecimiento.setNombre(linea.substring(linea.indexOf(":") + 1));
                List<Servicio> serviciosOfrece = serviciosEstablecimiento(establecimiento);
                establecimiento.setServiciosOfrece(serviciosOfrece);
            }
            if (linea.contains("direccion")) {
                establecimiento.setDireccion(linea.substring(linea.indexOf(":") + 1));
            }
            if (linea.contains("telefono")) {
                establecimiento.setTelefono(linea.substring(linea.indexOf(":") + 1));
            }
            if (linea.contains("colonia")) {
                FabricaCodigosPostales fabrica = new FabricaCodigosPostales();
                CodigoPostal codigo = fabrica.creaCodigoPostal(pais, (linea.substring(linea.indexOf(":") + 1).trim()));
                ColoniaCodigoPostal obtenerColonia = new ColoniaCodigoPostalImplementacionArchivos();
                Colonia coloniaTemp = obtenerColonia.colonia(codigo);
                establecimiento.setColonia(coloniaTemp);
            }
            if (linea.contains("horarioServicio")) {
                establecimiento.setHorarioServicio(linea.substring(linea.indexOf(":") + 1));
                if (establecimiento.getColonia().getNombre().equals(colonia.getNombre())) {
                    establecimientos.add(establecimiento);
                }
            }
        }
        return establecimientos;
    }
    /**
     * MEtodo que obtiene todos los servicios que ofrece un establecimiento 
     * @param establecimiento Establecimiento  en cuetion
     * @return lista de servicios que ofrece el establecimiento
     * @throws IOException 
     */

    private List<Servicio> serviciosEstablecimiento(Establecimiento establecimiento) throws IOException {
        String nombreArchivo = "./BaseDatos/Establecimientos/Servicios.txt";
        File archivo = new File(nombreArchivo);
        FileReader lectorArchivo = new FileReader(archivo);
        BufferedReader lector = new BufferedReader(lectorArchivo);
        String linea;
        List<Servicio> servicios = new ArrayList<>();
        Servicio servicio = new Servicio();
        while ((linea = lector.readLine()) != null) {
            
            if (linea.contains("nombreServicio")) {
                servicio.setNombreServicio(linea.substring(linea.indexOf(":") + 1));
            }
            if (linea.contains("costo")) {
                servicio.setCosto(Double.parseDouble(linea.substring(linea.indexOf(":") + 1).trim()));
            }
            if (linea.contains("establecimiento")) {
                String nombre = (linea.substring(linea.indexOf(":") + 1)).trim();
                servicio.setEstablecimiento(nombre);
                String nombreEstablecimiento = establecimiento.getNombre().trim();
                
                if(nombre.equalsIgnoreCase(nombreEstablecimiento)){
                    servicios.add(servicio);
                }
                servicio = new Servicio();
            }            
        }
        return servicios;
    }

    public static void main(String[] args) {
        DesplegarEstablecimientoArchivoTexto est = new DesplegarEstablecimientoArchivoTexto();
        FabricaCodigosPostales fabrica = new FabricaCodigosPostales();
        CodigoPostal codigo = fabrica.creaCodigoPostal("Mexico", "55717");
        ColoniaCodigoPostal obtenerColonia = new ColoniaCodigoPostalImplementacionArchivos();
        Colonia coloniaTemp = obtenerColonia.colonia(codigo);
        List<Establecimiento> estb = est.establecimientoEnColonia(coloniaTemp);
        for (Establecimiento establecimiento : estb) {
            System.out.println(establecimiento);
        }
    }

}
