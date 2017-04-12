package codigopostal.Modelo;

import java.util.Calendar;
import java.util.Date;

public abstract class Cita {
    private int id;
    private Establecimiento establecimiento;
    private Date horario;
    private Servicio servicio;

    public Cita() {
    }
    
    public Cita(Establecimiento establecimiento, Date horario, Servicio servicio) {
        id = calculaId(establecimiento,servicio,horario);
        this.establecimiento = establecimiento;
        this.horario = horario;
        this.servicio = servicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    private int calculaId(Establecimiento establecimiento, Servicio servicio,Date horario) {
        int identificador = (establecimiento.getNombre().hashCode() % 97)*10;
        identificador += ((servicio.getNombreServicio().hashCode()% 97));
        Calendar c = Calendar.getInstance();
        identificador += c.get(Calendar.MINUTE);
        return identificador;
    }
    
    
}
