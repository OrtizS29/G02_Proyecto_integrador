
package CONTROLADOR;

import Modelo.entities.Usuario;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.persistir.IPersistencia;
import Modelo.persistir.IPersistenciaUsuario;

/**
 *
 * @author Santiago
 */
public class GestionarUsuario {
    
    //private IPersistencia<Usuario> persisUsuario;
    private IPersistenciaUsuario persisUsuario;

    public GestionarUsuario(I_PersistenciaFactory fa) {
        persisUsuario = fa.crearPersistirUsuario();
    }

    public void guardar(Usuario usu) throws Exception {
        persisUsuario.crear(usu);
    }
    
    public void editar(Usuario usu,String usuario,String contraseña) throws Exception{
        
        usu.setUsuario(usuario);
        usu.setContraseña(contraseña);
        persisUsuario.editar(usu);
    }
    
    public Usuario obtenerAsesorCed(Long id){
        return persisUsuario.obtenerAsesorCed(id);
    }
}
