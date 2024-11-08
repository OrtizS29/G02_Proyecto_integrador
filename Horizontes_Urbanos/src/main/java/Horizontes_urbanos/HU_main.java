package Horizontes_urbanos;



import Modelo.ConexionORACLE;
import VISTA.Login;

/**
 *
 * @author Santiago
 */
public class HU_main {

    public static void main(String[] args) {

        String usu = "Constructora";
        String contra = "constructora688";
        ConexionORACLE conn = new ConexionORACLE(usu,contra);
        
        Login log = new Login();
        log.setVisible(true);
        log.setLocationRelativeTo(null);
        
    }
}
