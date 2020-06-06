
package Objetos_BDD;

/**
 *
 * @author Jose Manuel Lopez Sanchez
 */
public class Faena {
    
    private short id_faena;
    private String nombre;

    public Faena(short id_faena, String nombre) {
        this.id_faena = id_faena;
        this.nombre = nombre;
    }

    public short getId_faena() {
        return id_faena;
    }

    public void setId_faena(short id_faena) {
        this.id_faena = id_faena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
