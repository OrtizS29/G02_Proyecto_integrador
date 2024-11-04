
package CONTROLADOR;

import Modelo.entities.Usuario;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.persistir.IPersistencia;

/**
 *
 * @author Santiago
 */
public class GestionarUsuario {
    
    private IPersistencia<Usuario> persisUsuario;

    public GestionarUsuario(I_PersistenciaFactory fa) {
        persisUsuario = fa.crearPersistirUsuario();
    }

    public void guardar(Usuario usu) throws Exception {
        persisUsuario.crear(usu);
    }
    
    
}
