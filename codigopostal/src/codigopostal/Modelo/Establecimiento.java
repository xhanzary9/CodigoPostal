
package codigopostal.Modelo;

import java.util.List;

public abstract class Establecimiento {

    private String nombre;
    private String direccion;
    private List<Servicio> serviciosOfrece;
    private String telefono;
    private Colonia colonia;
    private String horarioServicio;
    private List<Cita> citas;

    public Establecimiento() {
    }

    
    public Establecimiento(String nombre, List<Servicio> serviciosOfrece, Colonia colonia, String horarioServicio) {
        this.nombre = nombre;
        this.serviciosOfrece = serviciosOfrece;
        this.colonia = colonia;
        this.horarioServicio = horarioServicio;
    }

    public Establecimiento(String nombre, String direccion, List<Servicio> serviciosOfrece, String telefono, Colonia colonia, String horarioServicio) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.serviciosOfrece = serviciosOfrece;
        this.telefono = telefono;
        this.colonia = colonia;
        this.horarioServicio = horarioServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Servicio> getServiciosOfrece() {
        return serviciosOfrece;
    }

    public void setServiciosOfrece(List<Servicio> serviciosOfrece) {
        this.serviciosOfrece = serviciosOfrece;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Colonia getColonia() {
        return colonia;
    }

    public void setColonia(Colonia colonia) {
        this.colonia = colonia;
    }

    public String getHorarioServicio() {
        return horarioServicio;
    }

    public void setHorarioServicio(String horarioServicio) {
        this.horarioServicio = horarioServicio;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }
    public String toString(){
        System.out.println(getNombre());
        for (Servicio servicio : getServiciosOfrece()) {
            System.out.println(servicio.getNombreServicio());
            
        }
        return "";
    }
        
}
