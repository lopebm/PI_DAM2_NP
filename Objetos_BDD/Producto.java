
package Objetos_BDD;

/**
 *
 * @author Jose Manuel Lopez Sanchez
 */
public class Producto {
    
    private short id_producto;
    private String nombre;
    private float precio_actual;
    private String per_inicio_siembra;
    private String per_fin_siembra;
    private String tipo;

    public Producto(short id_producto, String nombre, float precio_actual, 
            String per_inicio_siembra, String per_fin_siembra, String tipo) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio_actual = precio_actual;
        this.per_inicio_siembra = per_inicio_siembra;
        this.per_fin_siembra = per_fin_siembra;
        this.tipo = tipo;
    }

    public short getId_producto() {
        return id_producto;
    }

    public void setId_producto(short id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio_actual() {
        return precio_actual;
    }

    public void setPrecio_actual(float precio_actual) {
        this.precio_actual = precio_actual;
    }

    public String getPer_inicio_siembra() {
        return per_inicio_siembra;
    }

    public void setPer_inicio_siembra(String per_inicio_siembra) {
        this.per_inicio_siembra = per_inicio_siembra;
    }

    public String getPer_fin_siembra() {
        return per_fin_siembra;
    }

    public void setPer_fin_siembra(String per_fin_siembra) {
        this.per_fin_siembra = per_fin_siembra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
