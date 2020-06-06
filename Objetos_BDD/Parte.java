
package Objetos_BDD;

import java.util.Date;

/**
 *
 * @author Jose Manuel Lopez Sanchez
 */
public class Parte {
    
    private long id_parte;
    private Date fecha;
    private float peonada;
    private String empleado;
    private short terreno;
    private short faena;
    private String vehiculo;
    private short apero;
    private short fitosanitario;
    private byte cant_fitosanitario;
    private short herramienta;

    public Parte(long id_parte, Date fecha, float peonada, String empleado, 
            short terreno, short faena, String vehiculo, short apero, 
            short fitosanitario, byte cant_fitosanitario, short herramienta) {
        this.id_parte = id_parte;
        this.fecha = fecha;
        this.peonada = peonada;
        this.empleado = empleado;
        this.terreno = terreno;
        this.faena = faena;
        this.vehiculo = vehiculo;
        this.apero = apero;
        this.fitosanitario = fitosanitario;
        this.cant_fitosanitario = cant_fitosanitario;
        this.herramienta = herramienta;
    }

    public long getId_parte() {
        return id_parte;
    }

    public void setId_parte(long id_parte) {
        this.id_parte = id_parte;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getPeonada() {
        return peonada;
    }

    public void setPeonada(float peonada) {
        this.peonada = peonada;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public short getTerreno() {
        return terreno;
    }

    public void setTerreno(short terreno) {
        this.terreno = terreno;
    }

    public short getFaena() {
        return faena;
    }

    public void setFaena(short faena) {
        this.faena = faena;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public short getApero() {
        return apero;
    }

    public void setApero(short apero) {
        this.apero = apero;
    }

    public short getFitosanitario() {
        return fitosanitario;
    }

    public void setFitosanitario(short fitosanitario) {
        this.fitosanitario = fitosanitario;
    }

    public byte getCant_fitosanitario() {
        return cant_fitosanitario;
    }

    public void setCant_fitosanitario(byte cant_fitosanitario) {
        this.cant_fitosanitario = cant_fitosanitario;
    }

    public short getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(short herramienta) {
        this.herramienta = herramienta;
    }
}
