package Vista;

import Controlador.Controlador;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Jose Manuel Lopez Sanchez
 */
public class Listado extends JFrame {

    public String nombre;
    public String[] columnas;
    private JPanel pPrincipal, pTabla, pBotones;
    private JTable tabla;
    private JTableHeader cabeceraTabla;
    private ModeloTabla modelo;
    private JScrollPane despTabla;
    private JButton butAniadir, butBorrar, butModif, butCerrar, butPrint;

    public Listado(String nombre, String[] columnas, LinkedList<String[]> datosCursor) {
        // CONOCER NOMBRE DE LA TABLA MOSTRADA Y SUS COLUMNAS.
        this.nombre = nombre;
        this.columnas = columnas;
        inicializar(columnas, datosCursor);
        posicionar();
        confVentana();
    }

    /**
     * Inicialización de todos los elementos.
     */
    private void inicializar(String[] columnas, LinkedList<String[]> datosCursor) {

        // JPANELS
        this.pPrincipal = new JPanel(new BorderLayout());
        this.pTabla = new JPanel(new BorderLayout());
        this.pBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // JTABLE, MODELO
        this.tabla = new JTable();
        // Solo una selección posible.
        this.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.modelo = new ModeloTabla();

        // -- Columnas de la tabla
        this.modelo.setColumnIdentifiers(columnas);

        // -- Redimencionar
        this.tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        this.tabla.setFillsViewportHeight(true);

        // -- Setear modelo a tabla
        this.tabla.setModel(this.modelo);

        // DESPLAZ Y HEADER
        this.despTabla = new JScrollPane(this.tabla);
        this.cabeceraTabla = tabla.getTableHeader();
        this.tabla.setPreferredScrollableViewportSize(tabla.getPreferredSize());

        // -- Desplazamiento vertical y horizontal
        this.despTabla.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.despTabla.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // -- Desplazamiento en panel
        this.pPrincipal.add(this.despTabla, BorderLayout.CENTER);

        // BOTONES
        this.butAniadir = new JButton("Añadir");
        this.butBorrar = new JButton("Eliminar");
        this.butBorrar.setEnabled(false);
        this.butModif = new JButton("Modificar");
        this.butModif.setEnabled(false);
        this.butCerrar = new JButton("Cerrar");
        this.butPrint = new JButton("Imprimir");

        // EVENTO ACTIVAR BOTONES (Solo se puede Modificar o Borrar con fila Seleccionada).
        this.tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                Listado listado = (Listado) SwingUtilities.getRoot(tabla);
                listado.butModif.setEnabled(true);
                listado.butBorrar.setEnabled(true);
            }
        });

        // RELLENAR TABLA
        actualizarTabla(datosCursor);

        // DAR UN TAMAÑO DE COLUMNA PREDETERMINADO.
        for (int i = 0; i < columnas.length; i++) {
            tabla.getColumn(columnas[i]).setPreferredWidth(150);
        }
    }

    /**
     * Configurar todos los elementos.
     */
    public void posicionar() {

        // POS TABLA
        this.pTabla.add(this.cabeceraTabla, BorderLayout.NORTH);
        this.pTabla.add(this.tabla, BorderLayout.CENTER);
        this.pPrincipal.add(this.pTabla, BorderLayout.CENTER);

        // POS BOTONES
        this.pBotones.add(this.butPrint);
        this.pBotones.add(this.butAniadir);
        this.pBotones.add(this.butBorrar);
        this.pBotones.add(this.butModif);
        this.pBotones.add(this.butCerrar);
        this.pPrincipal.add(this.pBotones, BorderLayout.SOUTH);

        // Firma
        this.pPrincipal.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Jose Manuel Lopez Sanchez"));
        
        // POS VENTANA
        this.add(this.pPrincipal);
    }

    /**
     * Configuración final de la ventana.
     */
    private void confVentana() {
        this.setTitle("Listado ".concat(this.nombre));
        this.setIconImage(new ImageIcon("src/imagenes/icono2.png").getImage());
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        this.setSize(width / 2, height / 2);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    /**
     * Actualiza la tabla con los datos pasados por parámetros.
     *
     * @param datosCursor
     */
    public void actualizarTabla(LinkedList<String[]> datosCursor) {

        int cantFilas = this.modelo.getRowCount();
        for (int i = 0; i < cantFilas; i++) {
            this.modelo.removeRow(0);
        }

        for (int i = 0; i < datosCursor.size(); i++) {
            this.modelo.addRow(datosCursor.get(i));
        }
        this.tabla.repaint();
        this.pack();
    }

    /**
     * Devuelve un Vector de Strings con los datos de la fila seleccionada en
     * ese momento. Si no se selecciona ninguna devuelve null.
     *
     * @return Vector de Strings con datos de fila seleccionada.
     */
    public String[] filaSeleccionada() {

        int totalCol = this.tabla.getColumnCount();
        String[] datosFila = new String[totalCol];
        int filaSelect = this.tabla.getSelectedRow();

        if (filaSelect != -1) {
            for (int i = 0; i < datosFila.length; i++) {
                datosFila[i] = String.valueOf(this.tabla.getValueAt(filaSelect, i));
            }
        } else {
            datosFila = null;
        }

        return datosFila;
    }
    
    /**
     * Accesso a tabla privada desde método.
     * @return JTable de la tabla usada en este momento.
     */
    public JTable getTabla() {
        return this.tabla;
    }

    /**
     * Controla eventos de la Listado dándoles un nombre y dándole el control al
     * Controlador.
     *
     * @param c Controlador.
     */
    public void selecccionarEventos(Controlador c) {
        this.butAniadir.setActionCommand("Aniadir");
        this.butAniadir.addActionListener(c);

        this.butBorrar.setActionCommand("Borrar");
        this.butBorrar.addActionListener(c);

        this.butCerrar.setActionCommand("Cerrar");
        this.butCerrar.addActionListener(c);

        this.butModif.setActionCommand("Modif");
        this.butModif.addActionListener(c);

        this.butPrint.setActionCommand("Print");
        this.butPrint.addActionListener(c);
    }

    /**
     * Método para salir de Listado.
     */
    public void salir() {
        this.dispose();
    }
}
