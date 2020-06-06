
package Objetos_BDD;

/**
 *
 * @author Jose Manuel Lopez Sanchez
 */
public class Fitosanitario {
    
    private short id_fito;
    private String nombre;
    private String proveedor;
    private short cantidad_almacen;
    private float precio;

    public Fitosanitario(short id_fito, String nombre, String proveedor, 
            short cantidad_almacen, float precio) {
        this.id_fito = id_fito;
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.cantidad_almacen = cantidad_almacen;
        this.precio = precio;
    }

    public short getId_fito() {
        return id_fito;
    }

    public void setId_fito(short id_fito) {
        this.id_fito = id_fito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public short getCantidad_almacen() {
        return cantidad_almacen;
    }

    public void setCantidad_almacen(short cantidad_almacen) {
        this.cantidad_almacen = cantidad_almacen;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
