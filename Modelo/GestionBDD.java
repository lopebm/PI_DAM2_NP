
package Modelo;

import Objetos_BDD.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jose Manuel Lopez Sanchez
 */
public abstract class GestionBDD {
    
    /**
     * Inserta en la BDD el objeto pasado por parametros usando la conexión.
     * @param obj Objeto a insertar en BDD.
     * @param con Conexión activa con la BDD.
     * @return Bolean que indica si pudo insertar.
     */
    public static boolean insert(Object obj, ConexionBDD con) {
        
        boolean correcto = true;
        
        if (obj instanceof Apero) {
            Apero ident = (Apero) obj;
            String consulta = "INSERT INTO APEROS VALUES (ID_APERO, 'MARCA', 'MODELO', "
                    + "'PROPIETARIO', 'EN_USO', CONSUMO)";
            consulta = consulta.replaceFirst("ID_APERO", String.valueOf(ident.getId_apero()));
            consulta = consulta.replaceFirst("MARCA", ident.getMarca());
            consulta = consulta.replaceFirst("MODELO", ident.getModelo());
            consulta = consulta.replaceFirst("PROPIETARIO", ident.getPropietario());
            consulta = consulta.replaceFirst("EN_USO", String.valueOf(ident.getEn_uso()));
            consulta = consulta.replaceFirst("CONSUMO", String.valueOf(ident.getConsumo()));
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Empleado) {
            Empleado ident = (Empleado) obj;
            String consulta = "INSERT INTO EMPLEADOS VALUES ('DNI', 'NOMBRE', 'APELLIDOS', "
                    + "'POBLACION', 'PROVINCIA', 'TELEFONO', 'FECHA_NAC', ESPECIALIDAD)";
            consulta = consulta.replaceFirst("DNI", ident.getDni());
            consulta = consulta.replaceFirst("NOMBRE", ident.getNombre());
            consulta = consulta.replaceFirst("APELLIDOS", ident.getApellidos());
            consulta = consulta.replaceFirst("POBLACION", ident.getPoblacion());
            consulta = consulta.replaceFirst("PROVINCIA", ident.getProvincia());
            consulta = consulta.replaceFirst("TELEFONO", ident.getTelefono());
            consulta = consulta.replaceFirst("FECHA_NAC", adaptarFecha(ident.getFecha_nac()));
            consulta = consulta.replaceFirst("ESPECIALIDAD", 
                    ((String.valueOf(ident.getEspecialidad()).equalsIgnoreCase("0") 
                    | String.valueOf(ident.getEspecialidad()).equalsIgnoreCase("null")) 
                    ? "NULL" : String.valueOf(ident.getEspecialidad())));
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Faena) {
            Faena ident = (Faena) obj;
            String consulta = "INSERT INTO FAENAS VALUES (ID_FAENA, 'NOMBRE')";
            consulta = consulta.replaceFirst("ID_FAENA", String.valueOf(ident.getId_faena()));
            consulta = consulta.replaceFirst("NOMBRE", ident.getNombre());
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Fitosanitario) {
            Fitosanitario ident = (Fitosanitario) obj;
            String consulta = "INSERT INTO FITOSANITARIOS VALUES (ID_FITO, 'NOMBRE', "
                    + "'PROVEEDOR', CANTIDAD_ALMACEN, PRECIO)";
            consulta = consulta.replaceFirst("ID_FITO", String.valueOf(ident.getId_fito()));
            consulta = consulta.replaceFirst("NOMBRE", ident.getNombre());
            consulta = consulta.replaceFirst("PROVEEDOR", ident.getProveedor());
            consulta = consulta.replaceFirst("CANTIDAD_ALMACEN", String.valueOf(ident.getCantidad_almacen()));
            consulta = consulta.replaceFirst("PRECIO", String.valueOf(ident.getPrecio()));
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Herramienta) {
            Herramienta ident = (Herramienta) obj;
            String consulta = "INSERT INTO HERRAMIENTAS VALUES (ID_HERRAM, 'MARCA', "
                    + "'MODELO', TIPO, 'PROPIETARIO', CONSUMO, ES_USO, CANT_TOTAL)";
            consulta = consulta.replaceFirst("ID_HERRAM", String.valueOf(ident.getId_herram()));
            consulta = consulta.replaceFirst("MARCA", ident.getMarca());
            consulta = consulta.replaceFirst("MODELO", ident.getModelo());
            consulta = consulta.replaceFirst("TIPO", String.valueOf(ident.getTipo()));
            consulta = consulta.replaceFirst("PROPIETARIO", ident.getPropietario());
            consulta = consulta.replaceFirst("CONSUMO", String.valueOf(ident.getConsumo()));
            consulta = consulta.replaceFirst("ES_USO", String.valueOf(ident.getEn_uso()));
            consulta = consulta.replaceFirst("CANT_TOTAL", String.valueOf(ident.getCant_total()));
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Parte) {
            Parte ident = (Parte) obj;
            String consulta = "INSERT INTO PARTES VALUES (ID_PARTE, 'FECHA', PEONADA, "
                    + "'EMPLEADO', TERRENO, FAENA, 'VEHICULO', APERO, FITOSANITARIO, "
                    + "CANT_FITOSANITARIO, HERRAMIENTA)";
            consulta = consulta.replaceFirst("ID_PARTE", String.valueOf(ident.getId_parte()));
            consulta = consulta.replaceFirst("FECHA", adaptarFecha(ident.getFecha()));
            consulta = consulta.replaceFirst("PEONADA", String.valueOf(ident.getPeonada()));
            consulta = consulta.replaceFirst("EMPLEADO", ident.getEmpleado());
            consulta = consulta.replaceFirst("TERRENO", String.valueOf(ident.getTerreno()));
            consulta = consulta.replaceFirst("FAENA", String.valueOf(ident.getFaena()));
            consulta = consulta.replaceFirst("'VEHICULO'", 
                    ((String.valueOf(ident.getVehiculo()).equalsIgnoreCase("0") 
                    | String.valueOf(ident.getVehiculo()).equalsIgnoreCase("null")) 
                    ? "NULL" : String.valueOf(ident.getVehiculo())));
            consulta = consulta.replaceFirst("APERO", 
                    ((String.valueOf(ident.getApero()).equalsIgnoreCase("0") 
                    | String.valueOf(ident.getApero()).equalsIgnoreCase("null")) 
                    ? "NULL" : String.valueOf(ident.getApero())));
            consulta = consulta.replaceFirst("FITOSANITARIO", 
                    ((String.valueOf(ident.getFitosanitario()).equalsIgnoreCase("0") 
                    | String.valueOf(ident.getFitosanitario()).equalsIgnoreCase("null")) 
                    ? "NULL" : String.valueOf(ident.getFitosanitario())));
            consulta = consulta.replaceFirst("CANT_FITOSANITARIO", 
                    ((String.valueOf(ident.getCant_fitosanitario()).equalsIgnoreCase("0") 
                    | String.valueOf(ident.getCant_fitosanitario()).equalsIgnoreCase("null")) 
                    ? "NULL" : String.valueOf(ident.getCant_fitosanitario())));
            consulta = consulta.replaceFirst("HERRAMIENTA", 
                    ((String.valueOf(ident.getHerramienta()).equalsIgnoreCase("0") 
                    | String.valueOf(ident.getHerramienta()).equalsIgnoreCase("null")) 
                    ? "NULL" : String.valueOf(ident.getHerramienta())));
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Producto) {
            Producto ident = (Producto) obj;
            String consulta = "INSERT INTO PRODUCTOS VALUES (ID_PRODUCTO, 'NOMBRE', "
                    + "PRECIO_ACTUAL, 'PER_INICIO_SIEMBRA', 'PER_FIN_SIEMBRA', 'TIPO')";
            consulta = consulta.replaceFirst("ID_PRODUCTO", String.valueOf(ident.getId_producto()));
            consulta = consulta.replaceFirst("NOMBRE", ident.getNombre());
            consulta = consulta.replaceFirst("PRECIO_ACTUAL", String.valueOf(ident.getPrecio_actual()));
            consulta = consulta.replaceFirst("PER_INICIO_SIEMBRA", ident.getPer_inicio_siembra());
            consulta = consulta.replaceFirst("PER_FIN_SIEMBRA", ident.getPer_fin_siembra());
            consulta = consulta.replaceFirst("TIPO", ident.getTipo());
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Propietario) {
            Propietario ident = (Propietario) obj;
            String consulta = "INSERT INTO PROPIETARIOS VALUES ('DNI', 'NOMBRE', 'APELLIDOS', "
                    + "'POBLACION', 'PROVINCIA', 'TELEFONO', 'FECHA_NAC')";
            consulta = consulta.replaceFirst("DNI", ident.getDni());
            consulta = consulta.replaceFirst("NOMBRE", ident.getNombre());
            consulta = consulta.replaceFirst("APELLIDOS", ident.getApellidos());
            consulta = consulta.replaceFirst("POBLACION", ident.getPoblacion());
            consulta = consulta.replaceFirst("PROVINCIA", ident.getProvincia());
            consulta = consulta.replaceFirst("TELEFONO", ident.getTelefono());
            consulta = consulta.replaceFirst("FECHA_NAC", adaptarFecha(ident.getFecha_nac()));
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Proveedor) {
            Proveedor ident = (Proveedor) obj;
            String consulta = "INSERT INTO PROVEEDORES VALUES ('CIF', 'NOMBRE', 'TELEFONO', "
                    + "'FAX', 'POBLACION', 'PROVINCIA')";
            consulta = consulta.replaceFirst("CIF", ident.getCif());
            consulta = consulta.replaceFirst("NOMBRE", ident.getNombre());
            consulta = consulta.replaceFirst("TELEFONO", ident.getTelefono());
            consulta = consulta.replaceFirst("FAX", ident.getFax());
            consulta = consulta.replaceFirst("POBLACION", ident.getPoblacion());
            consulta = consulta.replaceFirst("PROVINCIA", ident.getProvincia());
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Terreno) {
            Terreno ident = (Terreno) obj;
            String consulta = "INSERT INTO TERRENOS VALUES (ID_TERRENO, 'NOMBRE', EXTENSION, "
                    + "USO_TERRENO, 'ACCESIBILIDAD', 'PROPIETARIO')";
            consulta = consulta.replaceFirst("ID_TERRENO", String.valueOf(ident.getId_terreno()));
            consulta = consulta.replaceFirst("NOMBRE", ident.getNombre());
            consulta = consulta.replaceFirst("EXTENSION", String.valueOf(ident.getExtension()));
            consulta = consulta.replaceFirst("USO_TERRENO", 
                    ((String.valueOf(ident.getUso_terreno()).equalsIgnoreCase("0") 
                    | String.valueOf(ident.getUso_terreno()).equalsIgnoreCase("null")) 
                    ? "NULL" : String.valueOf(ident.getUso_terreno())));
            consulta = consulta.replaceFirst("ACCESIBILIDAD", ident.getAccesibilidad());
            consulta = consulta.replaceFirst("PROPIETARIO", ident.getPropietario());
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Tipo_herramienta) {
            Tipo_herramienta ident = (Tipo_herramienta) obj;
            String consulta = "INSERT INTO TIPO_HERRAMIENTA VALUES (ID_TIPO, 'NOMBRE_TIPO')";
            consulta = consulta.replaceFirst("ID_TIPO", String.valueOf(ident.getId_tipo()));
            consulta = consulta.replaceFirst("NOMBRE_TIPO", ident.getNombre_tipo());
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Vehiculo) {
            Vehiculo ident = (Vehiculo) obj;
            String consulta = "INSERT INTO VEHICULO VALUES ('MATRICULA', 'MARCA', 'MODELO', "
                    + "'PROPIETARIO', 'EN_USO', CONSUMO)";
            consulta = consulta.replaceFirst("MATRICULA", ident.getMatricula());
            consulta = consulta.replaceFirst("MARCA", ident.getMarca());
            consulta = consulta.replaceFirst("MODELO", ident.getModelo());
            consulta = consulta.replaceFirst("PROPIETARIO", ident.getPropietario());
            consulta = consulta.replaceFirst("EN_USO", String.valueOf(ident.getEn_uso()));
            consulta = consulta.replaceFirst("CONSUMO", String.valueOf(ident.getConsumo()));
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        }
        return correcto;
    }
    
    /**
     * Modifica en la BDD el objeto pasado por parametros usando la conexión.
     * @param obj Objeto a modificar en BDD.
     * @param con Conexión activa con la BDD.
     * @return Bolean que indica si pudo modificar.
     */
    public static boolean modify(Object obj, ConexionBDD con) {
        
        boolean correcto = true;
        
        if (obj instanceof Apero) {
            Apero ident = (Apero) obj;
            String consulta = "UPDATE APEROS "
                    + "SET MARCA = 'VALOR', "
                    + "MODELO = 'VALOR', "
                    + "PROPIETARIO = 'VALOR', "
                    + "EN_USO = 'VALOR', "
                    + "CONSUMO = VALOR "
                    + "WHERE ID_APERO = " + ident.getId_apero();
            consulta = consulta.replaceFirst("VALOR", ident.getMarca());
            consulta = consulta.replaceFirst("VALOR", ident.getModelo());
            consulta = consulta.replaceFirst("VALOR", ident.getPropietario());
            consulta = consulta.replaceFirst("VALOR", String.valueOf(ident.getEn_uso()));
            consulta = consulta.replaceFirst("VALOR", String.valueOf(ident.getConsumo()));
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Empleado) {
            Empleado ident = (Empleado) obj;
            String consulta = "UPDATE EMPLEADOS "
                    + "SET NOMBRE = 'VALOR', "
                    + "APELLIDOS = 'VALOR', "
                    + "POBLACION = 'VALOR', "
                    + "PROVINCIA = 'VALOR', "
                    + "TELEFONO = 'VALOR', "
                    + "FECHA_NAC = 'VALOR', "
                    + "ESPECIALIDAD = VALOR "
                    + "WHERE DNI = '" + ident.getDni() + "'";
            consulta = consulta.replaceFirst("VALOR", ident.getNombre());
            consulta = consulta.replaceFirst("VALOR", ident.getApellidos());
            consulta = consulta.replaceFirst("VALOR", ident.getPoblacion());
            consulta = consulta.replaceFirst("VALOR", ident.getProvincia());
            consulta = consulta.replaceFirst("VALOR", ident.getTelefono());
            consulta = consulta.replaceFirst("VALOR", adaptarFecha(ident.getFecha_nac()));
            consulta = consulta.replaceFirst("VALOR", 
                    ((String.valueOf(ident.getEspecialidad()).equalsIgnoreCase("0") 
                    | String.valueOf(ident.getEspecialidad()).equalsIgnoreCase("null")) 
                    ? "NULL" : String.valueOf(ident.getEspecialidad())));
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Faena) {
            Faena ident = (Faena) obj;
            String consulta = "UPDATE FAENAS "
                    + "SET NOMBRE = 'VALOR' "
                    + "WHERE ID_FAENA = " + ident.getId_faena();
            consulta = consulta.replaceFirst("VALOR", ident.getNombre());
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Fitosanitario) {
            Fitosanitario ident = (Fitosanitario) obj;
            String consulta = "UPDATE FITOSANITARIOS "
                    + "SET NOMBRE = 'VALOR', "
                    + "PROVEEDOR = 'VALOR', "
                    + "CANTIDAD_ALMACEN = VALOR, "
                    + "PRECIO = VALOR "
                    + "WHERE ID_FITO = " + ident.getId_fito();
            consulta = consulta.replaceFirst("VALOR", ident.getNombre());
            consulta = consulta.replaceFirst("VALOR", ident.getProveedor());
            consulta = consulta.replaceFirst("VALOR", String.valueOf(ident.getCantidad_almacen()));
            consulta = consulta.replaceFirst("VALOR", String.valueOf(ident.getPrecio()));
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Herramienta) {
            Herramienta ident = (Herramienta) obj;
            String consulta = "UPDATE HERRAMIENTAS "
                    + "SET MARCA = 'VALOR', "
                    + "MODELO = 'VALOR', "
                    + "TIPO = VALOR, "
                    + "PROPIETARIO = 'VALOR', "
                    + "CONSUMO = VALOR, "
                    + "ES_USO = VALOR, "
                    + "CANT_TOTAL = VALOR "
                    + "WHERE ID_HERRAM = " + ident.getId_herram();
            consulta = consulta.replaceFirst("VALOR", ident.getMarca());
            consulta = consulta.replaceFirst("VALOR", ident.getModelo());
            consulta = consulta.replaceFirst("VALOR", String.valueOf(ident.getTipo()));
            consulta = consulta.replaceFirst("VALOR", ident.getPropietario());
            consulta = consulta.replaceFirst("VALOR", String.valueOf(ident.getConsumo()));
            consulta = consulta.replaceFirst("VALOR", String.valueOf(ident.getEn_uso()));
            consulta = consulta.replaceFirst("VALOR", String.valueOf(ident.getCant_total()));
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Parte) {
            Parte ident = (Parte) obj;
            String consulta = "UPDATE PARTES "
                    + "SET FECHA = 'VALOR', "
                    + "PEONADA = VALOR, "
                    + "EMPLEADO = 'VALOR', "
                    + "TERRENO = VALOR, "
                    + "FAENA = VALOR, "
                    + "VEHICULO = 'VALOR', "
                    + "APERO = VALOR, "
                    + "FITOSANITARIO = VALOR, "
                    + "CANT_FITOSANITARIO = VALOR, "
                    + "HERRAMIENTA = VALOR "
                    + "WHERE ID_PARTE = " + ident.getId_parte();
            consulta = consulta.replaceFirst("VALOR", adaptarFecha(ident.getFecha()));
            consulta = consulta.replaceFirst("VALOR", String.valueOf(ident.getPeonada()));
            consulta = consulta.replaceFirst("VALOR", ident.getEmpleado());
            consulta = consulta.replaceFirst("VALOR", String.valueOf(ident.getTerreno()));
            consulta = consulta.replaceFirst("VALOR", String.valueOf(ident.getFaena()));
            consulta = consulta.replaceFirst("'VALOR'", 
                    ((String.valueOf(ident.getVehiculo()).equalsIgnoreCase("0") 
                    | String.valueOf(ident.getVehiculo()).equalsIgnoreCase("null")) 
                    ? "NULL" : "'" + String.valueOf(ident.getVehiculo())) + "'");
            consulta = consulta.replaceFirst("VALOR", 
                    ((String.valueOf(ident.getApero()).equalsIgnoreCase("0") 
                    | String.valueOf(ident.getApero()).equalsIgnoreCase("null")) 
                    ? "NULL" : String.valueOf(ident.getApero())));
            consulta = consulta.replaceFirst("VALOR", 
                    ((String.valueOf(ident.getFitosanitario()).equalsIgnoreCase("0") 
                    | String.valueOf(ident.getFitosanitario()).equalsIgnoreCase("null")) 
                    ? "NULL" : String.valueOf(ident.getFitosanitario())));
            consulta = consulta.replaceFirst("VALOR", 
                    ((String.valueOf(ident.getCant_fitosanitario()).equalsIgnoreCase("0") 
                    | String.valueOf(ident.getCant_fitosanitario()).equalsIgnoreCase("null")) 
                    ? "NULL" : String.valueOf(ident.getCant_fitosanitario())));
            consulta = consulta.replaceFirst("VALOR", 
                    ((String.valueOf(ident.getHerramienta()).equalsIgnoreCase("0") 
                    | String.valueOf(ident.getHerramienta()).equalsIgnoreCase("null")) 
                    ? "NULL" : String.valueOf(ident.getHerramienta())));
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Producto) {
            Producto ident = (Producto) obj;
            String consulta = "UPDATE PRODUCTOS "
                    + "SET NOMBRE = 'VALOR', "
                    + "PRECIO_ACTUAL = VALOR, "
                    + "PER_INICIO_SIEMBRA = 'VALOR', "
                    + "PER_FIN_SIEMBRA = 'VALOR', "
                    + "TIPO = 'VALOR' "
                    + "WHERE ID_PRODUCTO = " + ident.getId_producto();
            consulta = consulta.replaceFirst("VALOR", ident.getNombre());
            consulta = consulta.replaceFirst("VALOR", String.valueOf(ident.getPrecio_actual()));
            consulta = consulta.replaceFirst("VALOR", ident.getPer_inicio_siembra());
            consulta = consulta.replaceFirst("VALOR", ident.getPer_fin_siembra());
            consulta = consulta.replaceFirst("VALOR", ident.getTipo());
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Propietario) {
            Propietario ident = (Propietario) obj;
            String consulta = "UPDATE PROPIETARIOS "
                    + "SET NOMBRE = 'VALOR', "
                    + "APELLIDOS = 'VALOR', "
                    + "POBLACION = 'VALOR', "
                    + "PROVINCIA = 'VALOR', "
                    + "TELEFONO = 'VALOR', "
                    + "FECHA_NAC = 'VALOR' "
                    + "WHERE DNI = '" + ident.getDni() + "'";
            consulta = consulta.replaceFirst("VALOR", ident.getNombre());
            consulta = consulta.replaceFirst("VALOR", ident.getApellidos());
            consulta = consulta.replaceFirst("VALOR", ident.getPoblacion());
            consulta = consulta.replaceFirst("VALOR", ident.getProvincia());
            consulta = consulta.replaceFirst("VALOR", ident.getTelefono());
            consulta = consulta.replaceFirst("VALOR", adaptarFecha(ident.getFecha_nac()));
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Proveedor) {
            Proveedor ident = (Proveedor) obj;
            String consulta = "UPDATE PROVEEDORES "
                    + "SET NOMBRE = 'VALOR', "
                    + "TELEFONO = 'VALOR', "
                    + "FAX = 'VALOR', "
                    + "POBLACION = 'VALOR', "
                    + "PROVINCIA = 'VALOR' "
                    + "WHERE CIF = '" + ident.getCif() + "'";
            consulta = consulta.replaceFirst("VALOR", ident.getNombre());
            consulta = consulta.replaceFirst("VALOR", ident.getTelefono());
            consulta = consulta.replaceFirst("VALOR", ident.getFax());
            consulta = consulta.replaceFirst("VALOR", ident.getPoblacion());
            consulta = consulta.replaceFirst("VALOR", ident.getProvincia());
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Terreno) {
            Terreno ident = (Terreno) obj;
            String consulta = "UPDATE TERRENOS "
                    + "SET NOMBRE = 'VALOR', "
                    + "EXTENSION = VALOR, "
                    + "USO_TERRENO = VALOR, "
                    + "ACCESIBILIDAD = 'VALOR', "
                    + "PROPIETARIO = 'VALOR' "
                    + "WHERE ID_TERRENO = " + ident.getId_terreno();
            consulta = consulta.replaceFirst("VALOR", ident.getNombre());
            consulta = consulta.replaceFirst("VALOR", String.valueOf(ident.getExtension()));
            consulta = consulta.replaceFirst("VALOR", 
                    ((String.valueOf(ident.getUso_terreno()).equalsIgnoreCase("0") 
                    | String.valueOf(ident.getUso_terreno()).equalsIgnoreCase("null")) 
                    ? "NULL" : String.valueOf(ident.getUso_terreno())));
            consulta = consulta.replaceFirst("VALOR", ident.getAccesibilidad());
            consulta = consulta.replaceFirst("VALOR", ident.getPropietario());
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Tipo_herramienta) {
            Tipo_herramienta ident = (Tipo_herramienta) obj;
            String consulta = "UPDATE TIPO_HERRAMIENTA "
                    + "SET NOMBRE_TIPO = 'VALOR' "
                    + "WHERE ID_TIPO = " + ident.getId_tipo();
            consulta = consulta.replaceFirst("VALOR", ident.getNombre_tipo());
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Vehiculo) {
            Vehiculo ident = (Vehiculo) obj;
            String consulta = "UPDATE VEHICULOS "
                    + "SET MARCA = 'VALOR', "
                    + "MODELO = 'VALOR', "
                    + "PROPIETARIO = 'VALOR', "
                    + "EN_USO = 'VALOR', "
                    + "CONSUMO = VALOR "
                    + "WHERE MATRICULA = '" + ident.getMatricula() + "'";
            consulta = consulta.replaceFirst("VALOR", ident.getMarca());
            consulta = consulta.replaceFirst("VALOR", ident.getModelo());
            consulta = consulta.replaceFirst("VALOR", ident.getPropietario());
            consulta = consulta.replaceFirst("VALOR", String.valueOf(ident.getEn_uso()));
            consulta = consulta.replaceFirst("VALOR", String.valueOf(ident.getConsumo()));
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        }
        return correcto;
    }
    
    /**
     * Borra de la BDD el objeto pasado por parametros usando la conexión.
     * @param obj Objeto a borrar en BDD.
     * @param con Conexión activa con la BDD.
     * @return Bolean que indica si pudo borrar.
     */
    public static boolean remove(Object obj, ConexionBDD con) {
        
        boolean correcto = true;
        
        if (obj instanceof Apero) {
            Apero ident = (Apero) obj;
            String consulta = "DELETE FROM APEROS "
                    + "WHERE ID_APERO = " + ident.getId_apero();
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Empleado) {
            Empleado ident = (Empleado) obj;
            String consulta = "DELETE FROM EMPLEADOS "
                    + "WHERE DNI = '" + ident.getDni() + "'";
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Faena) {
            Faena ident = (Faena) obj;
            String consulta = "DELETE FROM FAENAS "
                    + "WHERE ID_FAENA = " + ident.getId_faena();
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Fitosanitario) {
            Fitosanitario ident = (Fitosanitario) obj;
            String consulta = "DELETE FROM FITOSANITARIOS "
                    + "WHERE ID_FITO = " + ident.getId_fito();
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Herramienta) {
            Herramienta ident = (Herramienta) obj;
            String consulta = "DELETE FROM HERRAMIENTAS "
                    + "WHERE ID_HERRAM = " + ident.getId_herram();
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Parte) {
            Parte ident = (Parte) obj;
            String consulta = "DELETE FROM PARTES "
                    + "WHERE ID_PARTE = " + ident.getId_parte();
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Producto) {
            Producto ident = (Producto) obj;
            String consulta = "DELETE FROM PRODUCTOS "
                    + "WHERE ID_PRODUCTO = " + ident.getId_producto();
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Propietario) {
            Propietario ident = (Propietario) obj;
            String consulta = "DELETE FROM PROPIETARIOS "
                    + "WHERE DNI = '" + ident.getDni() + "'";
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Proveedor) {
            Proveedor ident = (Proveedor) obj;
            String consulta = "DELETE FROM PROVEEDORES "
                    + "WHERE CIF = '" + ident.getCif() + "'";
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Terreno) {
            Terreno ident = (Terreno) obj;
            String consulta = "DELETE FROM TERRENOS "
                    + "WHERE ID_TERRENO = " + ident.getId_terreno();
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Tipo_herramienta) {
            Tipo_herramienta ident = (Tipo_herramienta) obj;
            String consulta = "DELETE FROM TIPO_HERRAMIENTA "
                    + "WHERE ID_TIPO = " + ident.getId_tipo();
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        } else if (obj instanceof Vehiculo) {
            Vehiculo ident = (Vehiculo) obj;
            String consulta = "DELETE FROM VEHICULOS "
                    + "WHERE MATRICULA = '" + ident.getMatricula() + "'";
            con.setSQL(consulta);
            correcto = con.ejecutarSentencia();
            
        }
        return correcto;
    }
    
    /**
     * Devuelve un String con la fecha indicada en el Objeto Date pasado por
     * parametros con el formato adecuado para la BDD.
     * @param fecha
     * @return 
     */
    private static String adaptarFecha(Date fecha) {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha = formato.format(fecha);

        return strFecha;
    }
}