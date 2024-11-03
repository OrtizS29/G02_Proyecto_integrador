package Horizontes_urbanos;



import Modelo.ConexionORACLE;
import VISTA.Login;

/**
 *
 * @author Santiago
 */
public class HU_main {

    public static void main(String[] args) {

        ConexionORACLE conn = new ConexionORACLE();
        
        Login log = new Login();
        log.setVisible(true);
        log.setLocationRelativeTo(null);
        
    }
}
