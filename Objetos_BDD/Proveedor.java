
package Objetos_BDD;

/**
 *
 * @author Jose Manuel Lopez Sanchez
 */
public class Proveedor {
    
    private String cif;
    private String nombre;
    private String telefono;
    private String fax;
    private String poblacion;
    private String provincia;

    public Proveedor(String cif, String nombre, String telefono, 
            String fax, String poblacion, String provincia) {
        this.cif = cif;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fax = fax;
        this.poblacion = poblacion;
        this.provincia = provincia;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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
}
