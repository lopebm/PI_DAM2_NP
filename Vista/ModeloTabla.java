
package Vista;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Manuel Lopez Sanchez
 */
public class ModeloTabla extends DefaultTableModel {
    
    /**
     * Evitar que puedan editar la tabla directamente.
     */
   @Override
   public boolean isCellEditable (int row, int column) {
       return false;
   }
}
