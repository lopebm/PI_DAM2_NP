
import Controlador.Controlador;
import Vista.Vista;

/**
 *
 * @author Jose Manuel Lopez Sanchez
 */
public class Aplicacion {
    public static void main(String[] args) {
        
        Vista v = new Vista();
        Controlador c = new Controlador(v);
        
    }
}
