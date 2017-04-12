package codigopostal.Contolador;

import codigopostal.Modelo.Cita;
import codigopostal.Modelo.CitaNormal;
import codigopostal.Modelo.Dentista;
import codigopostal.Modelo.Establecimiento;
import codigopostal.Modelo.Restaurante;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejaCitasInternet implements ManejaCitas {

    @Override
    public void GuardarCita(Cita cita) throws IOException {
        String nombreArchivo = "./BaseDatos/citas/Citas.txt";
        File archivo = new File(nombreArchivo);
        FileWriter escritorArchivo = new FileWriter(archivo, true);
        String identificador = "\nCita id : " + cita.getId() + "{\n";
        escritorArchivo.write(identificador);
        String establecimiento = "Establecimiento : " + cita.getEstablecimiento().getNombre() + "\n";
        escritorArchivo.write(establecimiento);
        Calendar c = Calendar.getInstance();
        c.setTime(cita.getHorario());
        DateFormat hourFormat = new SimpleDateFormat("HH:mm");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String fecha = "Fecha : " + dateFormat.format(cita.getHorario()) + "\nHora : " + hourFormat.format(cita.getHorario()) + "\n";
        escritorArchivo.write(fecha);
        String servicio = "Servicio : " + cita.getServicio().getNombreServicio() + "\n}";
        escritorArchivo.write(servicio);
        escritorArchivo.close();

    }

    @Override
    public boolean disponible(Cita cita) {
        FileReader lectorArchivo = null;
        try {
            String nombreArchivo = "./BaseDatos/citas/Citas.txt";
            File archivo = new File(nombreArchivo);
            lectorArchivo = new FileReader(archivo);
            BufferedReader lector = new BufferedReader(lectorArchivo);
            String linea;
            Cita citatemporal = new CitaNormal();
            boolean mismoEstablecimiento = false;
            boolean mismaHora = false;
            boolean mismoDia = false;
            while ((linea = lector.readLine()) != null) {
                if (linea.contains("Establecimiento")) {
                    String nombre = linea.substring(linea.indexOf(":") + 1);
                    if (cita.getEstablecimiento().getNombre().trim().equalsIgnoreCase(nombre.trim())) {
                        System.out.println("pasa");
                        mismoEstablecimiento = true;
                    }
                }
                if (linea.contains("Fecha")) {
                    String fecha = linea.substring(linea.indexOf(":") + 1).trim();
                    Date horario = cita.getHorario();
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String fechaCita = dateFormat.format(horario);
                    if (fecha.equals(fechaCita)) {
                        mismoDia = true;
                    }
                }
                if (linea.contains("Hora")) {
                    String hora = linea.substring(linea.indexOf(":") + 1).trim();
                    Date horario = cita.getHorario();
                    DateFormat hourFormat = new SimpleDateFormat("HH:mm");
                    String horaCita = hourFormat.format(horario);
                    if (hora.equals(horaCita)) {
                        mismaHora = true;
                        if (mismaHora && mismoDia && mismoEstablecimiento) {
                            return false;
                        }
                    }
                }

            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ManejaCitasInternet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                lectorArchivo.close();
            } catch (IOException ex) {
                Logger.getLogger(ManejaCitasInternet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public Cita buscarCita(int identificador) throws IOException {
        String nombreArchivo = "./BaseDatos/citas/Citas.txt";
        File archivo = new File(nombreArchivo);
        FileReader lectorArchivo = new FileReader(archivo);
        BufferedReader lector = new BufferedReader(lectorArchivo);
        String linea;
        Cita cita = new CitaNormal();
        while ((linea = lector.readLine()) != null) {
            if (linea.contains(Integer.toString(identificador))) {
                cita.setId(identificador);
            }
            if (linea.contains("Establecimiento")) {
                Establecimiento est;
                String nombre = linea.substring(linea.indexOf(":") + 1);
                if (nombre.contains("Clinica Odontologia")) {
                    est = new Dentista();
                    est.setNombre(nombre);
                } else {
                    est = new Restaurante();
                    est.setNombre(nombre);
                }

                cita.setEstablecimiento(est);
            }
        }
        return cita;
    }
    
}
