package Modelo;

import Objetos_BDD.*;
import java.sql.Date;

/**
 *
 * @author Jose Manuel Lopez Sanchez
 */
public enum Enum_OBDD {

    APERO, EMPLEADO, FAENA, FITOSANITARIO, HERRAMIENTA, PARTE, PRODUCTO,
    PROPIETARIO, PROVEEDOR, TERRENO, TIPO_HERRAMIENTA, VEHICULO;

    /**
     * Crear enumerado concreto usando su posición.
     *
     * @param i Posición de enumerado a crear.
     * @return Enumerado concreto.
     */
    public static Enum_OBDD asignar(int i) {

        Enum_OBDD enumerado = null;
        switch (i) {
            case 0:
                enumerado = Enum_OBDD.APERO;
                break;
            case 1:
                enumerado = Enum_OBDD.EMPLEADO;
                break;
            case 2:
                enumerado = Enum_OBDD.FAENA;
                break;
            case 3:
                enumerado = Enum_OBDD.FITOSANITARIO;
                break;
            case 4:
                enumerado = Enum_OBDD.HERRAMIENTA;
                break;
            case 5:
                enumerado = Enum_OBDD.PARTE;
                break;
            case 6:
                enumerado = Enum_OBDD.PRODUCTO;
                break;
            case 7:
                enumerado = Enum_OBDD.PROPIETARIO;
                break;
            case 8:
                enumerado = Enum_OBDD.PROVEEDOR;
                break;
            case 9:
                enumerado = Enum_OBDD.TERRENO;
                break;
            case 10:
                enumerado = Enum_OBDD.TIPO_HERRAMIENTA;
                break;
            case 11:
                enumerado = Enum_OBDD.VEHICULO;
        }
        return enumerado;
    }

    /**
     * Crear enumerado concreto usando su nombre.
     *
     * @param nombre Nombre de enumerado a crear.
     * @return Enumerado concreto.
     */
    public static Enum_OBDD asignar(String nombre) {

        Enum_OBDD enumerado = null;
        switch (nombre) {
            case "APEROS":
                enumerado = Enum_OBDD.APERO;
                break;
            case "EMPLEADOS":
                enumerado = Enum_OBDD.EMPLEADO;
                break;
            case "FAENAS":
                enumerado = Enum_OBDD.FAENA;
                break;
            case "FITOSANITARIOS":
                enumerado = Enum_OBDD.FITOSANITARIO;
                break;
            case "HERRAMIENTAS":
                enumerado = Enum_OBDD.HERRAMIENTA;
                break;
            case "PARTES":
                enumerado = Enum_OBDD.PARTE;
                break;
            case "PRODUCTOS":
                enumerado = Enum_OBDD.PRODUCTO;
                break;
            case "PROPIETARIOS":
                enumerado = Enum_OBDD.PROPIETARIO;
                break;
            case "PROVEEDORES":
                enumerado = Enum_OBDD.PROVEEDOR;
                break;
            case "TERRENOS":
                enumerado = Enum_OBDD.TERRENO;
                break;
            case "TIPO_HERRAMIENTA":
                enumerado = Enum_OBDD.TIPO_HERRAMIENTA;
                break;
            case "VEHICULOS":
                enumerado = Enum_OBDD.VEHICULO;
        }
        return enumerado;
    }

    /**
     * Crea un objeto (como Object) que representa un elemento de una tabla de
     * la BDD, se le pasan los datos que debe tener este para crearlo relleno.
     *
     * @param d Datos que debe contener el objeto en un vector de Strings.
     * @return Objeto creado como Object.
     */
    public Object devolverObj(String[] d) throws NullPointerException {

        Object obj = null;

        switch (this.ordinal()) {
            case 0:
                obj = new Apero(Short.parseShort(d[0]), d[1], d[2],
                        d[3], d[4].charAt(0), Float.parseFloat(d[5]));
                break;
            case 1:
                obj = new Empleado(d[0], d[1], d[2], d[3], d[4], d[5],
                        Date.valueOf(d[6]), Short.parseShort(d[7]));
                break;
            case 2:
                obj = new Faena(Short.parseShort(d[0]), d[1]);
                break;
            case 3:
                obj = new Fitosanitario(Short.parseShort(d[0]), d[1], d[2],
                        Short.parseShort(d[3]), Float.parseFloat(d[4]));
                break;
            case 4:
                obj = new Herramienta(Short.parseShort(d[0]), d[1], d[2],
                        Short.parseShort(d[3]), d[4], Float.parseFloat(d[5]),
                        Short.parseShort(d[6]), Short.parseShort(d[7]));
                break;
            case 5:
                obj = new Parte(Long.parseLong(d[0]), Date.valueOf(d[1]),
                        Float.parseFloat(d[2]), d[3], Short.parseShort(d[4]),
                        Short.parseShort(d[5]), d[6], Short.parseShort(d[7]),
                        Short.parseShort(d[8]), Byte.parseByte(d[9]),
                        Short.parseShort(d[10]));
                break;
            case 6:
                obj = new Producto(Short.parseShort(d[0]), d[1],
                        Float.parseFloat(d[2]), d[3], d[4], d[5]);
                break;
            case 7:
                obj = new Propietario(d[0], d[1], d[2], d[3], d[4], d[5],
                        Date.valueOf(d[6]));
                break;
            case 8:
                obj = new Proveedor(d[0], d[1], d[2], d[3], d[4], d[5]);
                break;
            case 9:
                obj = new Terreno(Short.parseShort(d[0]), d[1],
                        Float.parseFloat(d[2]), Short.parseShort(d[3]),
                        d[4], d[5]);
                break;
            case 10:
                obj = new Tipo_herramienta(Short.parseShort(d[0]), d[1]);
                break;
            case 11:
                obj = new Vehiculo(d[0], d[1], d[2], d[3], d[4].charAt(0),
                        Float.parseFloat(d[5]));
        }
        return obj;
    }

    /**
     * Devuelve el nombre que deben tener los atributos el objeto que representa
     * el enumerado.
     *
     * @return Vector de Strings con nombres de cada columna.
     */
    public String[] getColumnas() {

        String[] columnas = null;

        switch (this.ordinal()) {
            case 0:
                columnas = new String[6];
                columnas[0] = "ID";
                columnas[1] = "MARCA";
                columnas[2] = "MODELO";
                columnas[3] = "PROPIETARIO";
                columnas[4] = "EN USO";
                columnas[5] = "CONSUMO";
                break;
            case 1:
                columnas = new String[8];
                columnas[0] = "DNI";
                columnas[1] = "NOMBRE";
                columnas[2] = "APELLIDOS";
                columnas[3] = "POBLACIÓN";
                columnas[4] = "PROVINCIA";
                columnas[5] = "TELÉFONO";
                columnas[6] = "FECHA NACIMIENTO";
                columnas[7] = "ESPECIALIDAD";
                break;
            case 2:
                columnas = new String[2];
                columnas[0] = "ID";
                columnas[1] = "FAENA";
                break;
            case 3:
                columnas = new String[5];
                columnas[0] = "ID";
                columnas[1] = "NOMBRE";
                columnas[2] = "PROVEEDOR";
                columnas[3] = "EN ALMACEN";
                columnas[4] = "PRECIO";
                break;
            case 4:
                columnas = new String[8];
                columnas[0] = "ID";
                columnas[1] = "MARCA";
                columnas[2] = "MODELO";
                columnas[3] = "TIPO";
                columnas[4] = "PROPIETARIO";
                columnas[5] = "CONSUMO";
                columnas[6] = "EN USO";
                columnas[7] = "TOTAL HERRAM.";
                break;
            case 5:
                columnas = new String[11];
                columnas[0] = "ID";
                columnas[1] = "FECHA";
                columnas[2] = "PEONADA";
                columnas[3] = "EMPLEADO";
                columnas[4] = "TERRENO";
                columnas[5] = "FAENA";
                columnas[6] = "VEHICULO";
                columnas[7] = "APERO";
                columnas[8] = "FITOSANITARIO";
                columnas[9] = "CANT. FITOSAN.";
                columnas[10] = "HERRAMIENTA";
                break;
            case 6:
                columnas = new String[6];
                columnas[0] = "ID";
                columnas[1] = "NOMBRE";
                columnas[2] = "PRECIO ACT.";
                columnas[3] = "PERIODO INICIO SIEMBRA";
                columnas[4] = "PERIODO FIN SIEMBRA";
                columnas[5] = "TIPO";
                break;
            case 7:
                columnas = new String[7];
                columnas[0] = "DNI";
                columnas[1] = "NOMBRE";
                columnas[2] = "APELLIDOS";
                columnas[3] = "POBLACIÓN";
                columnas[4] = "PROVINCIA";
                columnas[5] = "TELÉFONO";
                columnas[6] = "FECHA NACIMIENTO";
                break;
            case 8:
                columnas = new String[6];
                columnas[0] = "CIF";
                columnas[1] = "NOMBRE";
                columnas[2] = "TELÉFONO";
                columnas[3] = "FAX";
                columnas[4] = "POBLACIÓN";
                columnas[5] = "PROVINCIA";
                break;
            case 9:
                columnas = new String[6];
                columnas[0] = "ID";
                columnas[1] = "NOMBRE";
                columnas[2] = "EXTENSIÓN";
                columnas[3] = "USO DE TERRENO";
                columnas[4] = "ACCESIBILIDAD";
                columnas[5] = "PROPIETARIO";
                break;
            case 10:
                columnas = new String[2];
                columnas[0] = "ID";
                columnas[1] = "NOMBRE";
                break;
            case 11:
                columnas = new String[6];
                columnas[0] = "MATRÍCULA";
                columnas[1] = "MARCA";
                columnas[2] = "MODELO";
                columnas[3] = "PROPIETARIO";
                columnas[4] = "EN USO";
                columnas[5] = "CONSUMO";
        }
        return columnas;
    }
    
    /**
     * Devuelve los tipos de datos usados por cada elemento de cada objeto en
     * un vector de Objetos.
     * @return vector de Objetos
     */
    public Object[] getTiposDatos() {
        
        Object[] tipos = null;

        switch (this.ordinal()) {
            case 0:
                // APERO
                tipos = new Object[6];
                tipos[0] = new Short("0");
                tipos[1] = new String("");
                tipos[2] = new String("");
                tipos[3] = new String("");
                tipos[4] = new Character('a');
                tipos[5] = new Float("0");
                break;
            case 1:
                // EMPLEADO
                tipos = new Object[8];
                tipos[0] = new String("");
                tipos[1] = new String("");
                tipos[2] = new String("");
                tipos[3] = new String("");
                tipos[4] = new String("");
                tipos[5] = new String("");
                tipos[6] = new Date((long)1);
                tipos[7] = new Short("0");
                break;
            case 2:
                // FAENA
                tipos = new Object[2];
                tipos[0] = new Short("0");
                tipos[1] = new String("");
                break;
            case 3:
                // FITOSANITARIO
                tipos = new Object[5];
                tipos[0] = new Short("0");
                tipos[1] = new String("");
                tipos[2] = new String("");
                tipos[3] = new Short("0");
                tipos[4] = new Float("0");
                break;
            case 4:
                // HERRAMIENTA
                tipos = new Object[8];
                tipos[0] = new Short("0");
                tipos[1] = new String("");
                tipos[2] = new String("");
                tipos[3] = new Short("0");
                tipos[4] = new String("");
                tipos[5] = new Float("0");
                tipos[6] = new Short("0");
                tipos[7] = new Short("0");
                break;
            case 5:
                // PARTE
                tipos = new Object[11];
                tipos[0] = new Long("0");
                tipos[1] = new Date((long)1);
                tipos[2] = new Float("0");
                tipos[3] = new String("");
                tipos[4] = new Short("0");
                tipos[5] = new Short("0");
                tipos[6] = new Short("0");
                tipos[7] = new Short("0");
                tipos[8] = new Short("0");
                tipos[9] = new Byte("0");
                tipos[10] = new Short("0");
                break;
            case 6:
                // PRODUCTO
                tipos = new Object[6];
                tipos[0] = new Short("0");
                tipos[1] = new String("");
                tipos[2] = new Float("0");
                tipos[3] = new String("");
                tipos[4] = new String("");
                tipos[5] = new String("");
                break;
            case 7:
                // PROPIETARIO
                tipos = new Object[7];
                tipos[0] = new String("");
                tipos[1] = new String("");
                tipos[2] = new String("");
                tipos[3] = new String("");
                tipos[4] = new String("");
                tipos[5] = new String("");
                tipos[6] = new Date((long)1);
                break;
            case 8:
                // PROVEEDOR
                tipos = new Object[6];
                tipos[0] = new String("");
                tipos[1] = new String("");
                tipos[2] = new String("");
                tipos[3] = new String("");
                tipos[4] = new String("");
                tipos[5] = new String("");
                break;
            case 9:
                // TERRENO
                tipos = new Object[6];
                tipos[0] = new Short("0");
                tipos[1] = new String("");
                tipos[2] = new Float("0");
                tipos[3] = new Short("0");
                tipos[4] = new String("");
                tipos[5] = new String("");
                break;
            case 10:
                // TIPO HERRAM
                tipos = new Object[2];
                tipos[0] = new Short("0");
                tipos[1] = new String("");
                break;
            case 11:
                // VEHICULO
                tipos = new Object[6];
                tipos[0] = new String("");
                tipos[1] = new String("");
                tipos[2] = new String("");
                tipos[3] = new String("");
                tipos[4] = new Character('a');
                tipos[5] = new Float("0");
        }
        return tipos;
    }
}