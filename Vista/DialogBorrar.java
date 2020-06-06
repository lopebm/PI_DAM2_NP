
package Vista;

import Modelo.Enum_OBDD;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
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
public class DialogBorrar extends JDialog {
    
    private boolean cancelado = true;
    private String[] datosRecogidos;
    private ArrayList<JLabel> listaLabel = new ArrayList<JLabel>();
    private ArrayList<JTextField> listaText = new ArrayList<JTextField>();
    private ArrayList<JPanel> listaPanel = new ArrayList<JPanel>();
    private JPanel pCentral, pSur;
    private JButton butBorrar, butCerrar;
    private JLabel confirmacion;
    
    public DialogBorrar(Frame padre, String[] columnas, String[] datos) {
        super(padre, true);

        // Titulo
        this.setTitle("Borrar datos");

        // Crear labels, textfields y paneles para cada elemento de la tabla
        for (int i = 0; i < columnas.length; i++) {
            this.listaLabel.add(new JLabel(columnas[i]));
            this.listaText.add(new JTextField(30));
            this.listaText.get(i).setText(datos[i]);
            // IMPEDIR QUE SE EDITEN LOS DATOS MOSTRADOS PARA BORRAR.
            this.listaText.get(i).setEditable(false);
            this.listaPanel.add(new JPanel());
            this.listaPanel.get(i).setLayout(
                    new BoxLayout(this.listaPanel.get(i), BoxLayout.Y_AXIS));
            this.listaPanel.get(i).add(this.listaLabel.get(i));
            this.listaPanel.get(i).add(this.listaText.get(i));
        }

        // Crear botones
        this.butBorrar = new JButton("BORRAR");
        this.butBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cancelado = false;
                // ACCESO AL DIALOG PARA DEJAR DE HACER VISIBLE.
                JButton boton = (JButton) ae.getSource();
                DialogBorrar dborrar = (DialogBorrar) SwingUtilities.getRoot(boton);
                dborrar.setVisible(false);
            }
        });
        this.butCerrar = new JButton("Cerrar");
        this.butCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cancelado = true;
                // ACCESO AL DIALOG PARA DEJAR DE HACER VISIBLE.
                JButton boton = (JButton) ae.getSource();
                DialogBorrar dborrar = (DialogBorrar) SwingUtilities.getRoot(boton);
                dborrar.setVisible(false);
            }
        });
        this.pSur = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        this.confirmacion = new JLabel("¿ESTÁ SEGURO?");
        this.confirmacion.setFont(new Font("Monospaced", Font.BOLD, 18));
        this.pSur.add(this.confirmacion);
        this.pSur.add(this.butBorrar);
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
     * @param nombre Nombre de la tabla/objeto de donde serán borrados los datos.
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
