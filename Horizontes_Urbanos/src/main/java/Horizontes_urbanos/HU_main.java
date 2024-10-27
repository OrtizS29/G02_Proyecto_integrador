package Horizontes_urbanos;



import Modelo.ConexionORACLE;
import VISTA.Login;

/**
 *
 * @author SAlA-9
 */
public class HU_main {

    public static void main(String[] args) {
        /**
         * Se
         */
        ConexionORACLE conn = new ConexionORACLE();
        
        Login log = new Login();
        log.setVisible(true);
        log.setLocationRelativeTo(null);
        
    }
}
