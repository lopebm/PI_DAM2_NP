
package Objetos_BDD;

import java.util.Date;

/**
 *
 * @author Jose Manuel Lopez Sanchez
 */
public class Empleado {
    
    private String dni;
    private String nombre;
    private String apellidos;
    private String poblacion;
    private String provincia;
    private String telefono;
    private Date fecha_nac;
    private short especialidad;

    public Empleado(String dni, String nombre, String apellidos, 
            String poblacion, String provincia, String telefono, 
            Date fecha_nac, short especialidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.telefono = telefono;
        this.fecha_nac = fecha_nac;
        this.especialidad = especialidad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public short getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(short especialidad) {
        this.especialidad = especialidad;
    }
}
