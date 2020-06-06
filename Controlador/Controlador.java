package Controlador;

import Modelo.ConexionBDD;
import Modelo.Enum_OBDD;
import Modelo.GestionBDD;
import Vista.DialogAniadir;
import Vista.DialogBorrar;
import Vista.DialogModif;
import Vista.Listado;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jose Manuel Lopez Sanchez
 */
public class Controlador implements ActionListener {

    private Vista v;
    private Listado l;
    private ConexionBDD con;

    public Controlador(Vista v) {
        try {
            // CONEXION BDD
            Properties prop = new Properties();
            InputStream is = new FileInputStream("src/Modelo/property.txt");
            prop.load(is);

            String driver = prop.getProperty("valor.driver");
            String servidor = prop.getProperty("valor.servidor");
            String user = prop.getProperty("valor.user");
            String pass = prop.getProperty("valor.pass");
            this.con = new ConexionBDD(driver);
            this.con.setConexion(servidor, user, pass);

            // COMPROBAR CONEXION EXITOSA
            comprConexion(2000);

            // AJUSTES VENTANA
            this.v = v;
            this.v.seleccionarEventos(this);

        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Comprueba la conexión de la BDD y si no existe cierra la aplicación con
     * un error.
     *
     * @param timeout Tiempo de espera hasta indicar que la conexión se ha
     * perdido.
     */
    private void comprConexion(int timeout) {
        try {
            if (!this.con.comprobarConexion(timeout)) {
                // A PASADO EL TIEMPO DE ESPERA
                JOptionPane.showConfirmDialog(
                        this.v,
                        "La conexión se ha perdido, se va a salir de la aplicación.",
                        "Conexión Perdida",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException npe) {
            // LA CONEXION NO SE HA DADO Y DEVUELVE NULL
            JOptionPane.showConfirmDialog(
                    this.v,
                    "La conexión no ha sido posible, se va a salir de la aplicación.",
                    "Conexión Perdida",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    /**
     * Consulta la base de datos (todos los elementos de una tabla) pasada por
     * parámetros.
     *
     * @param nombre Nombre de la tabla
     * @return LinkedList con vectores de Strings con los datos de cada elemento
     * de la tabla.
     */
    private LinkedList<String[]> consultaBDD(String nombre) {
        LinkedList<String[]> listaDatos = new LinkedList<String[]>();

        // CONSULTA
        this.con.setSQL("SELECT * FROM ".concat(nombre)); // HACER CONSULTA
        this.con.ejecutarConsulta();
        try {
            // CURSOR Y METADATOS DE CURSOR
            ResultSet rs = this.con.getCursor();
            ResultSetMetaData rsmd = rs.getMetaData();

            // SACAR DATOS DE CURSOR Y GUARDAR EN VECTOR
            while (rs.next()) {
                String[] fila = new String[rsmd.getColumnCount()];
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = rs.getNString(i + 1);
                }
                // GUARDAR VECTOR EN LISTA
                listaDatos.add(fila);
            }
            this.con.cerrarCursor();
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDatos;
    }

    /**
     * Imprimir la tabla seleccionada con los valores indicados.
     *
     * @param tabla JTable que se desea imprimir.
     * @param cabecera Mensaje que aparecerá arriba de la impresión.
     * @param pie Mensaje que aparecerá debajo de la impresión.
     * @param mostrarDialog Indicar si aparece un dialogo para configurar la
     * impresión.
     */
    public void imprimirTabla(JTable tabla, String cabecera, String pie, boolean mostrarDialog) {
        boolean ajustado = true;
        boolean interactivo = true;
        // TIPO DE IMPRESION
        JTable.PrintMode mode = ajustado ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
        try {
            // IMPRIMIR TABLA            
            boolean completo = tabla.print(mode,
                    new MessageFormat(cabecera),
                    new MessageFormat(pie),
                    mostrarDialog,
                    null,
                    interactivo);
            if (completo) {
                // SE IMPRIME CORRECTAMENTE
                JOptionPane.showMessageDialog(tabla,
                        "Impresión completa",
                        "Resultado de la impresión",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                // SE CANCELÓ LA IMPRESIÓN
                JOptionPane.showMessageDialog(tabla,
                        "Impresión cancelada",
                        "Resultado de la impresión",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (PrinterException pe) {
            // ERROR EN LA OPERACIÓN
            JOptionPane.showMessageDialog(tabla,
                    "Fallo de impresión: " + pe.getMessage(),
                    "Resultado de la impresión",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // DESCUBRIR ORIGEN DE EVENTO Y TIPO DE EVENTO.
        JButton boton = (JButton) ae.getSource();
        Object ob = SwingUtilities.getRoot(boton);
        String evento = ae.getActionCommand();

        // ¿VISTA O LISTADO?
        if (ob instanceof Vista) {
            switch (evento) {
                case "SALIR":
                    this.v.salir();
                    break;
                default:
                    /*
                     * CONSULTA DE BDD similar a "consultaBDD" pero obteniendo
                     * tambien las columnas que almaceno en su Enumerado.
                     */
                    String[] columnas = null;
                    LinkedList<String[]> listaDatos = new LinkedList<String[]>();
                    // CONSULTA
                    this.con.setSQL("SELECT * FROM ".concat(evento)); // HACER CONSULTA
                    this.con.ejecutarConsulta();
                    try {
                        ResultSet rs = this.con.getCursor();
                        Enum_OBDD datoBuscado = Enum_OBDD.asignar(evento);
                        columnas = datoBuscado.getColumnas();

                        while (rs.next()) {
                            String[] fila = new String[columnas.length];
                            for (int i = 0; i < fila.length; i++) {
                                fila[i] = rs.getNString(i + 1);
                            }
                            listaDatos.add(fila);
                        }
                        this.con.cerrarCursor();
                    } catch (SQLException ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    /*
                     * PARA MOSTRAR LISTADO, NECESITO EL EVENTO, LAS COLUMNAS QUE
                     * DEBE PINTAR Y LOS DATOS QUE SE MUESTRAN DE CADA FILA.
                     */
                    this.l = new Listado(evento, columnas, listaDatos);
                    this.l.selecccionarEventos(this); // CONTROLAR LOS EVENTOS DE LISTADO.
                    this.v.listadosActivos(false);
            }
        } else if (ob instanceof Listado) {
            // IDENTIFICAR LISTADO Y DECLARAR UTILES.
            Listado listado = (Listado) SwingUtilities.getRoot(boton);
            Object obj;
            String[] datos;
            // USAR ENUMERADO PARA CREAR OBJETOS DEPENDIENDO TIPO Y USAR.
            switch (evento) {
                case "Aniadir":
                    // CREAR DIALOGO PARA AÑADIR ELEMENTOS.
                    DialogAniadir da = new DialogAniadir(listado, listado.columnas, listado.nombre);
                    da.setVisible(true); // APARECE DIALOG AÑADIR.
                    try {
                        // CREAR OBJETO CON DATOS INTRODUCIDOS.
                        obj = da.getDatos();
                        // INSERTAR EN BDD.
                        GestionBDD.insert(obj, con);
                        // ACTUALIZAR TABLA.
                        listado.actualizarTabla(consultaBDD(listado.nombre));
                    } catch (NullPointerException npe) {
                        // SI NO SE RELLENAN DATOS, EVITAR NULLPOINTER.
                    }
                    break;
                case "Borrar":
                    // OBTENER DATOS DE LA FILA SELECCIONADA.
                    datos = listado.filaSeleccionada();
                    // CREAR DIALOGO PARA BORRAR ELEMENTOS (SE MUESTRAN LOS DATOS A BORRAR).
                    DialogBorrar dborrar = new DialogBorrar(listado, listado.columnas, datos);
                    dborrar.setVisible(true); // APARECE DIALOG BORRAR.
                    try {
                        // CREAR OBJETO CON DATOS A BORRAR.
                        obj = dborrar.getDatos(listado.nombre);
                        // BORRAR DE BDD.
                        GestionBDD.remove(obj, con);
                        // ACTUALIZAR TABLA.
                        listado.actualizarTabla(consultaBDD(listado.nombre));
                    } catch (NullPointerException npe) {
                        // SI NO SE CONFIRMAN DATOS, EVITAR NULLPOINTER.
                    }
                    break;
                case "Cerrar":
                    // METODO PARA SALIR DE LISTADO.
                    this.l.salir();
                    this.v.listadosActivos(true);
                    break;
                case "Modif":
                    // OBTENER DATOS DE LA FILA SELECCIONADA.
                    datos = listado.filaSeleccionada();
                    // CREAR DIALOGO PARA MODIFICAR ELEMENTOS.
                    DialogModif dm = new DialogModif(listado, listado.columnas, listado.nombre, datos);
                    dm.setVisible(true); // APARECE DIALOG MODIFICAR.
                    try {
                        // CREAR OBJETO CON DATOS A MODIFICAR.
                        obj = dm.getDatos(listado.nombre);
                        // MODIFICAR DATOS DE BDD.
                        GestionBDD.modify(obj, con);
                        // ACTUALIZAR TABLA.
                        listado.actualizarTabla(consultaBDD(listado.nombre));
                    } catch (NullPointerException npe) {
                        // SI NO SE CONFIRMAN DATOS, EVITAR NULLPOINTER.
                    }
                    break;
                case "Print":
                    // LLAMAR A METODO QUE CONFIGURA Y REALIZA LA IMPRESION
                    imprimirTabla(this.l.getTabla(),
                            "Impresión de: " + listado.nombre,
                            "Realizado por José Manuel López Sánchez",
                            true);
            }
        }
    }
}
