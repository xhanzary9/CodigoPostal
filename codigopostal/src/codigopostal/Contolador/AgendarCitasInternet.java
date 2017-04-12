package codigopostal.Contolador;

import codigopostal.Excepciones.EstablecimientoCerradoExcepcion;
import codigopostal.Modelo.Cita;
import codigopostal.Modelo.CitaNormal;
import codigopostal.Modelo.CodigoPostal;
import codigopostal.Modelo.Colonia;
import codigopostal.Modelo.Establecimiento;
import codigopostal.Modelo.Servicio;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgendarCitasInternet implements AgendarCitas {

    @Override
    public void AgendarCita(Establecimiento establecimiento,Servicio servicio, Date horario) throws EstablecimientoCerradoExcepcion {
        Date hora = elegirHorario(establecimiento, horario);
        Cita cita = new CitaNormal(establecimiento, hora, servicio);
        ManejaCitas manejador = new ManejaCitasInternet();
        if(manejador.disponible(cita)){
            guardarCita(cita);
        }else{
            
        }
    }
    /**
     * 
     * @param establecimiento
     * @param horario
     * @return
     * @throws EstablecimientoCerradoExcepcion 
     */
    private Date elegirHorario(Establecimiento establecimiento, Date horario) throws EstablecimientoCerradoExcepcion {
        if (diaHabil(establecimiento.getHorarioServicio(), horario)) {
            throw new EstablecimientoCerradoExcepcion("Establecimiento no disponible en el dia selecionado"
                    + "\n el horario del establecimiento " + establecimiento.getNombre() + " es " + establecimiento.getHorarioServicio());
        }
        if (!horasHabiles(establecimiento.getHorarioServicio(), horario)) {
            throw new EstablecimientoCerradoExcepcion("Establecimiento no disponible en el dia selecionado"
                    + "\n el horario del establecimiento " + establecimiento.getNombre() + "es " + establecimiento.getHorarioServicio());
        }
        return horario;
    }
    /**
     * 
     * @param horario
     * @param dias
     * @return 
     */
    private boolean diaHabil(String horario, Date dias) {
        Calendar c = Calendar.getInstance();
        c.setTime(dias);
        int dia = c.get(Calendar.DAY_OF_WEEK);
        int[] arregloDias = diasHabiles(horario);
        if (arregloDias[dia] == 1) {
            return true;
        }
        return false;
    }
    /**
     * 
     * @param horario
     * @return 
     */
    private int[] diasHabiles(String horario) {
        int[] arregloDias = new int[7];
        for (StringTokenizer stringTokenizer = new StringTokenizer(horario, ","); stringTokenizer.hasMoreTokens();) {
            String token = stringTokenizer.nextToken();
            token = token.trim().toLowerCase();
            switch (token) {
                case "lunes":
                    arregloDias[1] = 1;
                case "martes":
                    arregloDias[2] = 1;
                case "miercoles":
                    arregloDias[3] = 1;
                case "jueves":
                    arregloDias[4] = 1;
                case "viernes":
                    arregloDias[5] = 1;
                case "sabado":
                    arregloDias[6] = 1;
                case "domingo":
                    arregloDias[0] = 1;
            }
        }
        return arregloDias;
    }
    /**
     * 
     * @param horarioServicio
     * @param horario
     * @return 
     */
    private boolean horasHabiles(String horarioServicio, Date horario) {
        horarioServicio = horarioDelDiaEscogido(horario, horarioServicio);
        String horaApertura = horarioServicio.substring(0, horarioServicio.indexOf(","));
        String horaCierre = horarioServicio.substring(horarioServicio.indexOf(",") + 1);
        Calendar c = Calendar.getInstance();
        c.setTime(horario);
        int hora = c.get(Calendar.HOUR_OF_DAY);
        int minutos = c.get(Calendar.MINUTE);
        int hApertura = Integer.parseInt(horaApertura.substring(0,horaApertura.indexOf(":")));
        int mApertura = Integer.parseInt(horaApertura.substring(horaApertura.indexOf(":")+1));
        int hCierre = Integer.parseInt(horaCierre.substring(0,horaCierre.indexOf(":")));
        int mCierre = Integer.parseInt(horaCierre.substring(horaCierre.indexOf(":")+1));
        int minutosHora = (hora*60) + minutos;
        int abrir = (hApertura*60) +mApertura; 
        int cierre = (hCierre*60) + mCierre;
        if(abrir < minutosHora && minutosHora < cierre){
            return true;
        }
        return false;
    }
    /**
     * 
     * @param horario
     * @param horarioServicio
     * @return 
     */
    private String horarioDelDiaEscogido(Date horario, String horarioServicio) {
        Calendar c = Calendar.getInstance();
        c.setTime(horario);
        int dia = c.get(Calendar.DAY_OF_WEEK) - 1;
        String diaSemana = "";
        switch (dia) {
            case 1:
                diaSemana = "lunes";
                break;
            case 2:
                diaSemana = "martes";
                break;
            case 3:
                diaSemana = "miercoles";
                break;
            case 4:
                diaSemana = "jueves";
                break;
            case 5:
                diaSemana = "viernes";
                break;
            case 6:
                diaSemana = "sabado";
                break;
            case 0:
                diaSemana = "domingo";
                break;
        }
        String horariosDelDia = horarioServicio.substring(horarioServicio.indexOf(diaSemana));
        if (horariosDelDia.indexOf(",") > 0) {
            horariosDelDia = horariosDelDia.substring(0, horariosDelDia.indexOf(","));
        } else {
            horariosDelDia = horariosDelDia.substring(0);
        }
        String horaApertura = horariosDelDia.substring(horariosDelDia.indexOf("de ") + 3, horariosDelDia.indexOf(" a"));
        String horaCierre = horariosDelDia.substring(horariosDelDia.indexOf(" a ") + 3).trim();
        return horaApertura + "," + horaCierre;

    }
    /**
     * 
     * @param cita 
     */
    private void guardarCita(Cita cita) {
        ManejaCitas citas = new ManejaCitasInternet();
        try {
            citas.GuardarCita(cita);
        } catch (IOException ex) {
            Logger.getLogger(AgendarCitasInternet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * MEtodo main que sirve para ejemplificar la funcion del sistema
     * @param args 
     */
    public static void main(String[] args) {
        AgendarCitasInternet i = new AgendarCitasInternet();
        DesplegarEstablecimientoArchivoTexto est = new DesplegarEstablecimientoArchivoTexto();
        FabricaCodigosPostales fabrica = new FabricaCodigosPostales();
        CodigoPostal codigo = fabrica.creaCodigoPostal("Mexico", "55717");
        ColoniaCodigoPostal obtenerColonia = new ColoniaCodigoPostalImplementacionArchivos();
        Colonia coloniaTemp = obtenerColonia.colonia(codigo);
        List<Establecimiento> estb = est.establecimientoEnColonia(coloniaTemp);
        Calendar c = Calendar.getInstance();
        Date now = c.getTime();
        i.AgendarCita(estb.get(0),estb.get(0).getServiciosOfrece().get(0), now);       
    }
}
