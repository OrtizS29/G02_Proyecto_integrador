
package CONTROLADOR;

import Modelo.entities.Asesor;
import Modelo.entities.Usuario;

/**
 *
 * @author Santiago
 */
public class SessionManager {
    
    private static Usuario usuarioActual;
    
    public static void setUsuarioActual(Usuario usuario) {
        usuarioActual = usuario;
    }

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static Asesor getAsesorActual() {
        return usuarioActual != null ? usuarioActual.getAsesor() : null;
    }
}
