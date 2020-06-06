package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose Manuel Lopez Sanchez
 */
public class ConexionBDD {
    
    Connection con;
    String consulta;
    ResultSet cursor;
    
    public ConexionBDD(String driver) {
        try {
            Class.forName(driver).newInstance();
        } catch (ClassNotFoundException | InstantiationException 
                | IllegalAccessException ex) {
            Logger.getLogger(ConexionBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Conecta con la bdd indicada en los parámetros.
     * @param servidor Socket del servidor.
     * @param nombre Nombre de usuario a conectar a la bdd.
     * @param pass Contraseña de usuario a conectar a bdd.
     * @return boolean que indica si conexión exitosa.
     */
    public boolean setConexion(String servidor, String nombre, String pass) {
        boolean conexionHecha;
        try {
            this.con = DriverManager.getConnection(servidor, nombre, pass);
            conexionHecha = true;
        } catch (SQLException ex) {
            conexionHecha = false;
        }
        return conexionHecha;
    }
    
    /**
     * Guardar consulta/sentencia SQL.
     * @param strSQL Consulta/Sentencia.
     */
    public void setSQL(String strSQL) {
        this.consulta = strSQL;
    }
    
    /**
     * Ejecuta sentencia guardada con el metodo "setSQL".
     * @return boolean que comprueba si sentencia ha sido exitosa.
     */
    public boolean ejecutarSentencia() {
        boolean consultaHecha = true;
        try {
            Statement sta = con.createStatement();
            sta.execute(this.consulta);
            sta.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            consultaHecha = false;
        }
        return consultaHecha;
    }
    
    /**
     * Ejecuta consulta "Actualizable".
     * @return boolean que comprueba si consulta ha sido exitosa.
     */
    public boolean ejecutarConsultaAct() {
        boolean consultaHecha = true;
        try {
            Statement sta = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
            this.cursor = sta.executeQuery(this.consulta);
        } catch (SQLException ex) {
            consultaHecha = false;
        }
        return consultaHecha;
    }
    
    /**
     * Ejecuta consulta.
     * @return boolean que comprueba si consulta ha sido exitosa.
     */
    public boolean ejecutarConsulta() {
        boolean consultaHecha = true;
        try {
            Statement sta = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_READ_ONLY);
            this.cursor = sta.executeQuery(this.consulta);
        } catch (SQLException ex) {
            ex.printStackTrace();
            consultaHecha = false;
        }
        return consultaHecha;
    }
    
    /**
     * Obtiene cursor recuperado de consulta ejecutada anteriormente.
     * @return Cursor.
     */
    public ResultSet getCursor() {
        return this.cursor;
    }
    
    /**
     * Cierra el cursor utilizado.
     * @return boolean si ha sido cerrado con exito.
     */
    public boolean cerrarCursor() {
        boolean cerrado;
        try {
            this.cursor.close();
            cerrado = true;
        } catch (SQLException ex) {
            cerrado = false;
        }
        return cerrado;
    }
    
    /**
     * Cierra conexión a BDD.
     * @return boolean que indica si ha sido una desconexión exitosa.
     */
    public boolean cerrarConexion() {
        boolean cerrado;
        try {
            this.con.close();
            cerrado = true;
        } catch (SQLException ex) {
            cerrado = false;
        }
        return cerrado;
    }
    
    /**
     * Comprueba si la conexión sigue activa y válida.
     * @param timeout Tiempo de espera hasta considerar que la conexión está
     * perdida.
     * @return boolean que indica que la conexión está OK.
     * @throws SQLException Error de SQL.
     */
    public boolean comprobarConexion(int timeout) throws SQLException {
        return this.con.isValid(timeout);
    }
}
