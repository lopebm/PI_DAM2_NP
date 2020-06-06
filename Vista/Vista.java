package Vista;

import Controlador.Controlador;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jose Manuel Lopez Sanchez
 */
public class Vista extends JFrame {

    // DECLARADO PARA VENTANA PRINCIPAL
    private JPanel pPrincipal, pCentral;
    private JLabel labImg;
    private ImageIcon img;
    private GridBagConstraints gbc;
    private Insets ins;
    
    // DECLARADO PARA OPCIONES
    private JPanel pEmpleados, pFaenas, pTerrenos, pProductos, pVehiculos, 
            pPropietarios, pAperos, pProveedores, pFitos, pHerramientas, 
            pTipo_Herram, pPartes, pSalir;
    private JLabel labEmpleados, labFaenas, labTerrenos, labProductos, 
            labVehiculos, labPropietarios, labAperos, labProveedores, labFitos, 
            labHerramientas, labTipo_Herram, labPartes;
    private JButton butEmpleados, butFaenas, butTerrenos, butProductos,
            butVehiculos, butPropietarios, butAperos, butProveedores, butFitos, 
            butHerramientas, butTipo_Herram, butPartes, butSalir;
    
    public Vista() {
        inicializar();
        posicionar();
        confVentana();
    }
    
    /**
     * Inicialización de todos los elementos.
     */
    private void inicializar() {

        // JPANELS (OPCIONES)
        this.pPrincipal = new JPanel();
        this.pCentral = new JPanel();
        this.pEmpleados = new JPanel();
        this.pFaenas = new JPanel();
        this.pTerrenos = new JPanel();
        this.pProductos = new JPanel();
        this.pVehiculos = new JPanel();
        this.pPropietarios = new JPanel();
        this.pAperos = new JPanel();
        this.pProveedores = new JPanel();
        this.pFitos = new JPanel();
        this.pHerramientas = new JPanel();
        this.pTipo_Herram = new JPanel();
        this.pPartes = new JPanel();
        this.pSalir = new JPanel();
        
        // IMAGEN
        this.img = new ImageIcon("src/imagenes/agrodata.png");
        this.labImg = new JLabel(this.img);
        
        // JLABELS (OPCIONES)
        this.labEmpleados = new JLabel("Empleados");
        this.labFaenas = new JLabel("Faenas");
        this.labTerrenos = new JLabel("Terrenos");
        this.labProductos = new JLabel("Productos");
        this.labVehiculos = new JLabel("Vehiculos");
        this.labPropietarios = new JLabel("Propietarios");
        this.labAperos = new JLabel("Aperos");
        this.labProveedores = new JLabel("Proveedores");
        this.labFitos = new JLabel("Fitosanitarios");
        this.labHerramientas = new JLabel("Herramientas");
        this.labTipo_Herram = new JLabel("Tipos Herram.");
        this.labPartes = new JLabel("Partes");
        
        // JBUTTONS (OPCIONES)
        this.butEmpleados = new JButton("Ver listado");
        this.butFaenas = new JButton("Ver listado");
        this.butTerrenos = new JButton("Ver listado");
        this.butProductos = new JButton("Ver listado");
        this.butVehiculos = new JButton("Ver listado");
        this.butPropietarios = new JButton("Ver listado");
        this.butAperos = new JButton("Ver listado");
        this.butProveedores = new JButton("Ver listado");
        this.butFitos = new JButton("Ver listado");
        this.butHerramientas = new JButton("Ver listado");
        this.butTipo_Herram = new JButton("Ver listado");
        this.butPartes = new JButton("Ver listado");
        this.butSalir = new JButton("SALIR");
        
        // GRIDBAGCONSTRAINT E INSETS
        this.gbc = new GridBagConstraints();
        this.ins = new Insets(0, 0, 50, 0);
    }
    
    /**
     * Configurar todos los elementos.
     */
    public void posicionar() {
        
        // PANEL EMPLEADOS
        this.pEmpleados.setLayout(new BoxLayout(this.pEmpleados, 
                BoxLayout.Y_AXIS));
        this.pEmpleados.add(this.labEmpleados);
        this.pEmpleados.add(this.butEmpleados);
        
        // PANEL FAENAS
        this.pFaenas.setLayout(new BoxLayout(this.pFaenas, 
                BoxLayout.Y_AXIS));
        this.pFaenas.add(this.labFaenas);
        this.pFaenas.add(this.butFaenas);
        
        // PANEL TERRENOS
        this.pTerrenos.setLayout(new BoxLayout(this.pTerrenos, 
                BoxLayout.Y_AXIS));
        this.pTerrenos.add(this.labTerrenos);
        this.pTerrenos.add(this.butTerrenos);
        
        // PANEL PRODUCTOS
        this.pProductos.setLayout(new BoxLayout(this.pProductos, 
                BoxLayout.Y_AXIS));
        this.pProductos.add(this.labProductos);
        this.pProductos.add(this.butProductos);
        
        // PANEL VEHICULOS
        this.pVehiculos.setLayout(new BoxLayout(this.pVehiculos, 
                BoxLayout.Y_AXIS));
        this.pVehiculos.add(this.labVehiculos);
        this.pVehiculos.add(this.butVehiculos);
        
        // PANEL PROPIETARIOS
        this.pPropietarios.setLayout(new BoxLayout(this.pPropietarios, 
                BoxLayout.Y_AXIS));
        this.pPropietarios.add(this.labPropietarios);
        this.pPropietarios.add(this.butPropietarios);
        
        // PANEL APEROS
        this.pAperos.setLayout(new BoxLayout(this.pAperos, 
                BoxLayout.Y_AXIS));
        this.pAperos.add(this.labAperos);
        this.pAperos.add(this.butAperos);
        
        // PANEL PROVEEDORES
        this.pProveedores.setLayout(new BoxLayout(this.pProveedores, 
                BoxLayout.Y_AXIS));
        this.pProveedores.add(this.labProveedores);
        this.pProveedores.add(this.butProveedores);
        
        // PANEL FITOS
        this.pFitos.setLayout(new BoxLayout(this.pFitos, 
                BoxLayout.Y_AXIS));
        this.pFitos.add(this.labFitos);
        this.pFitos.add(this.butFitos);
        
        // PANEL HERRAMIENTAS
        this.pHerramientas.setLayout(new BoxLayout(this.pHerramientas, 
                BoxLayout.Y_AXIS));
        this.pHerramientas.add(this.labHerramientas);
        this.pHerramientas.add(this.butHerramientas);
        
        // PANEL TIPOS HERRAM.
        this.pTipo_Herram.setLayout(new BoxLayout(this.pTipo_Herram, 
                BoxLayout.Y_AXIS));
        this.pTipo_Herram.add(this.labTipo_Herram);
        this.pTipo_Herram.add(this.butTipo_Herram);
        
        // PANEL PARTES
        this.pPartes.setLayout(new BoxLayout(this.pPartes, 
                BoxLayout.Y_AXIS));
        this.pPartes.add(this.labPartes);
        this.pPartes.add(this.butPartes);
        
        // PANEL CENTRAL
        this.pCentral.setLayout(new GridBagLayout());
        
        // -- POSICIONAR -- //
        
        // POSICION EMPLEADOS
        this.gbc.gridx = 0; // COLUMNA
        this.gbc.gridy = 0; // FILA
        this.gbc.gridwidth = 1; // COLUMNAS OCUPA
        this.gbc.gridheight = 1; // FILAS OCUPA
        this.gbc.weightx = 1;
        this.gbc.weighty = 0;
        this.gbc.insets = ins;
        this.pCentral.add(this.pEmpleados, this.gbc);
        
        // POSICION FAENAS
        this.gbc.gridx = 2; // COLUMNA
        this.gbc.gridy = 0; // FILA
        this.pCentral.add(this.pFaenas, this.gbc);
        
        // POSICION TERRENOS
        this.gbc.gridx = 4; // COLUMNA
        this.gbc.gridy = 0; // FILA
        this.pCentral.add(this.pTerrenos, this.gbc);
        
        // POSICION PRODUCTOS
        this.gbc.gridx = 6; // COLUMNA
        this.gbc.gridy = 0; // FILA
        this.pCentral.add(this.pProductos, this.gbc);
        
        // POSICION VEHICULOS
        this.gbc.gridx = 8; // COLUMNA
        this.gbc.gridy = 0; // FILA
        this.pCentral.add(this.pVehiculos, this.gbc);
        
        // POSICION PROPIETARIOS
        this.gbc.gridx = 10; // COLUMNA
        this.gbc.gridy = 0; // FILA
        this.pCentral.add(this.pPropietarios, this.gbc);
        
        // POSICION APEROS
        this.gbc.gridx = 0; // COLUMNA
        this.gbc.gridy = 2; // FILA
        this.gbc.insets = new Insets(0,0,0,0);
        this.pCentral.add(this.pAperos, this.gbc);
        
        // POSICION PROVEEDORES
        this.gbc.gridx = 2; // COLUMNA
        this.gbc.gridy = 2; // FILA
        this.pCentral.add(this.pProveedores, this.gbc);
        
        // POSICION FITOS
        this.gbc.gridx = 4; // COLUMNA
        this.gbc.gridy = 2; // FILA
        this.pCentral.add(this.pFitos, this.gbc);
        
        // POSICION HERRAMIENTAS
        this.gbc.gridx = 6; // COLUMNA
        this.gbc.gridy = 2; // FILA
        this.pCentral.add(this.pHerramientas, this.gbc);
        
        // POSICION TIPO HERRAM.
        this.gbc.gridx = 8; // COLUMNA
        this.gbc.gridy = 2; // FILA
        this.pCentral.add(this.pTipo_Herram, this.gbc);
        
        // POSICION PARTES
        this.gbc.gridx = 10; // COLUMNA
        this.gbc.gridy = 2; // FILA
        this.pCentral.add(this.pPartes, this.gbc);
        
        // PANEL PRINCIPAL Y BOTON SALIR
        this.pPrincipal.setLayout(new BorderLayout());
        // Firma
        this.pPrincipal.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Jose Manuel Lopez Sanchez"));
        
        this.pSalir.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.pSalir.add(this.butSalir);
        this.pPrincipal.add(this.labImg, BorderLayout.NORTH);
        this.pPrincipal.add(this.pSalir, BorderLayout.SOUTH);
        this.pPrincipal.add(this.pCentral, BorderLayout.CENTER);

        // VENTANA
        this.add(this.pPrincipal);
    }
    
    /**
     * Configuración final de la ventana.
     */
    private void confVentana() {
        this.setTitle("Listados Agrarios");
        this.setIconImage(new ImageIcon("src/imagenes/icono2.png").getImage());
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        this.setSize(width / 2, height / 2);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    /**
     * Controla eventos de la Vista dándoles un nombre y dándole el control al
     * Controlador.
     * @param c Controlador.
     */
    public void seleccionarEventos(Controlador c) {
        
        this.butAperos.setActionCommand("APEROS");
        this.butAperos.addActionListener(c);
        
        this.butEmpleados.setActionCommand("EMPLEADOS");
        this.butEmpleados.addActionListener(c);
        
        this.butFaenas.setActionCommand("FAENAS");
        this.butFaenas.addActionListener(c);
        
        this.butFitos.setActionCommand("FITOSANITARIOS");
        this.butFitos.addActionListener(c);
        
        this.butHerramientas.setActionCommand("HERRAMIENTAS");
        this.butHerramientas.addActionListener(c);
        
        this.butPartes.setActionCommand("PARTES");
        this.butPartes.addActionListener(c);
        
        this.butProductos.setActionCommand("PRODUCTOS");
        this.butProductos.addActionListener(c);
        
        this.butPropietarios.setActionCommand("PROPIETARIOS");
        this.butPropietarios.addActionListener(c);
        
        this.butProveedores.setActionCommand("PROVEEDORES");
        this.butProveedores.addActionListener(c);
        
        this.butSalir.setActionCommand("SALIR");
        this.butSalir.addActionListener(c);
        
        this.butTerrenos.setActionCommand("TERRENOS");
        this.butTerrenos.addActionListener(c);
        
        this.butTipo_Herram.setActionCommand("TIPO_HERRAMIENTA");
        this.butTipo_Herram.addActionListener(c);
        
        this.butVehiculos.setActionCommand("VEHICULOS");
        this.butVehiculos.addActionListener(c);
        
    }
    
    /**
     * Controla los botones de los listados para que solo pueda abrirse 1 a la
     * vez.
     * @param bool Habilitados o no.
     */
    public void listadosActivos(boolean bool) {
        this.butAperos.setEnabled(bool);
        this.butEmpleados.setEnabled(bool);
        this.butFaenas.setEnabled(bool);
        this.butFitos.setEnabled(bool);
        this.butHerramientas.setEnabled(bool);
        this.butPartes.setEnabled(bool);
        this.butProductos.setEnabled(bool);
        this.butPropietarios.setEnabled(bool);
        this.butProveedores.setEnabled(bool);
        this.butTerrenos.setEnabled(bool);
        this.butTipo_Herram.setEnabled(bool);
        this.butVehiculos.setEnabled(bool);
    }
    
    /**
     * Muestra un cuadro de dialogo para indicar si desea salir o no de la
     * aplicación.
     * @return boolean que indica si se aceptó.
     */
    public boolean salir() {

        boolean seSale = false;
        int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Estás seguro de que quieres cerrar la aplicación?",
                "Salir de Aplicación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
            seSale = true;
        }
        return seSale;
    }
}
