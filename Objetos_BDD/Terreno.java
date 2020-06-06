
package Objetos_BDD;

/**
 *
 * @author Jose Manuel Lopez Sanchez
 */
public class Terreno {
    
    private short id_terreno;
    private String nombre;
    private float extension;
    private short uso_terreno;
    private String accesibilidad;
    private String propietario;

    public Terreno(short id_terreno, String nombre, float extension, 
            short uso_terreno, String accesibilidad, String propietario) {
        this.id_terreno = id_terreno;
        this.nombre = nombre;
        this.extension = extension;
        this.uso_terreno = uso_terreno;
        this.accesibilidad = accesibilidad;
        this.propietario = propietario;
    }

    public short getId_terreno() {
        return id_terreno;
    }

    public void setId_terreno(short id_terreno) {
        this.id_terreno = id_terreno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getExtension() {
        return extension;
    }

    public void setExtension(float extension) {
        this.extension = extension;
    }

    public short getUso_terreno() {
        return uso_terreno;
    }

    public void setUso_terreno(short uso_terreno) {
        this.uso_terreno = uso_terreno;
    }

    public String getAccesibilidad() {
        return accesibilidad;
    }

    public void setAccesibilidad(String accesibilidad) {
        this.accesibilidad = accesibilidad;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}
