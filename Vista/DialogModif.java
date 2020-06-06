package Vista;

import Modelo.Enum_OBDD;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jose Manuel Lopez Sanchez
 */
public class DialogModif extends JDialog {

    private boolean cancelado = true;
    private String[] datosRecogidos;
    private String nombre;
    private ArrayList<JLabel> listaLabel = new ArrayList<JLabel>();
    private ArrayList<JTextField> listaText = new ArrayList<JTextField>();
    private ArrayList<JPanel> listaPanel = new ArrayList<JPanel>();
    private JPanel pCentral, pSur;
    private JLabel labInfo;
    private JButton butAceptar, butCerrar;

    public DialogModif(Frame padre, String[] columnas, String nombre, String[] datos) {
        super(padre, true);

        // Titulo
        this.setTitle("Modificar datos");
        this.nombre = nombre;

        // Crear labels, textfields y paneles para cada elemento de la tabla
        for (int i = 0; i < columnas.length; i++) {
            this.listaLabel.add(new JLabel(columnas[i]));
            this.listaText.add(new JTextField(30));
            this.listaText.get(i).setText(datos[i]);
            // EVITAR QUE SE PUEDA EDITAR LOS ID PARA MODIFICAR.
            if (columnas[i].startsWith("ID")) {
                this.listaText.get(i).setEditable(false);
            }
            this.listaPanel.add(new JPanel());
            this.listaPanel.get(i).setLayout(
                    new BoxLayout(this.listaPanel.get(i), BoxLayout.Y_AXIS));
            this.listaPanel.get(i).add(this.listaLabel.get(i));
            this.listaPanel.get(i).add(this.listaText.get(i));
        }

        // Crear botones
        this.butAceptar = new JButton("Modificar");
        this.butAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cancelado = false;
                // ACCESO AL DIALOG PARA DEJAR DE HACER VISIBLE.
                JButton boton = (JButton) ae.getSource();
                DialogModif dm = (DialogModif) SwingUtilities.getRoot(boton);
                // COMPROBAR DATOS CORRECTOS
                boolean tiposCorrectos = true;
                Enum_OBDD enumerador = Enum_OBDD.asignar(dm.nombre);
                Object[] tipos = enumerador.getTiposDatos();
                try {
                    for (int i = 0; i < tipos.length; i++) {
                        tipos[i].getClass().cast(dm.listaText.get(i).getText());
                    }
                } catch (ClassCastException cce) {
                    tiposCorrectos = false;
                }
                if (tiposCorrectos) {
                    dm.setVisible(false);
                } else {
                    dm.labInfo.setText("Datos incorrectos");
                }
            }
        });
        this.butCerrar = new JButton("Cerrar");
        this.butCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cancelado = true;
                // ACCESO AL DIALOG PARA DEJAR DE HACER VISIBLE.
                JButton boton = (JButton) ae.getSource();
                DialogModif dm = (DialogModif) SwingUtilities.getRoot(boton);
                dm.setVisible(false);
            }
        });
        this.labInfo = new JLabel("", JLabel.CENTER);
        this.labInfo.setForeground(Color.RED);
        this.pSur = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        this.pSur.add(this.labInfo);
        this.pSur.add(this.butAceptar);
        this.pSur.add(this.butCerrar);

        // Posicionar
        this.pCentral = new JPanel();
        this.pCentral.setLayout(new BoxLayout(this.pCentral, BoxLayout.Y_AXIS));
        for (int i = 0; i < this.listaPanel.size(); i++) {
            this.pCentral.add(this.listaPanel.get(i));
        }

        // Poner en Dialog
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(this.pCentral, BorderLayout.CENTER);
        getContentPane().add(this.pSur, BorderLayout.SOUTH);
        this.setLocationRelativeTo(padre);
        this.setIconImage(new ImageIcon("src/imagenes/icono2.png").getImage());
        this.setResizable(false);
        this.pack();
    }

    /**
     * Obtiene los datos insertados por el usuario.
     * @param nombre Nombre de la tabla/objeto donde se modificarán estos datos.
     * @return Un Object del objeto que contiene los datos o null si fué cancelado.
     */
    public Object getDatos(String nombre) throws NullPointerException {

        if (cancelado) {
            this.datosRecogidos = null;
        } else {
            this.datosRecogidos = new String[this.listaText.size()];
            for (int i = 0; i < this.datosRecogidos.length; i++) {
                if (!this.listaText.get(i).getText().equalsIgnoreCase("") 
                        & !this.listaText.get(i).getText().equalsIgnoreCase("null")) {
                    this.datosRecogidos[i] = this.listaText.get(i).getText();
                } else {
                    this.datosRecogidos[i] = "0";
                }
            }
        }
        Enum_OBDD objeto = Enum_OBDD.asignar(nombre);

        return objeto.devolverObj(datosRecogidos);
    }
}
