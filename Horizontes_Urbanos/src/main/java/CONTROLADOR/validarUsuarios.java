
package CONTROLADOR;

import Modelo.entities.Usuario;
import Modelo.persistir.PersistirUsuario;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class validarUsuarios {
    
    PersistirUsuario persisUsu;

    public validarUsuarios() {
        persisUsu = new PersistirUsuario();
    }
    
    /**
     * 
     * @param usuario
     * @param contrasena
     * @return 
     */
    public Usuario validarUsuario(String usuario, String contrasena) {
        
        Usuario usu = null;
        List<Usuario> listaUsuarios = persisUsu.traerUsuarios();
        
        for(Usuario usua:listaUsuarios){
            if(usua.getUsuario().equals(usuario)){
                if(usua.getContraseña().equals(contrasena)){
                    //El usuario y contraseña coinciden
                    usu=usua;
                    return usu;
                }
                else{
                    //la contraseña no coincide
                    usu = null;
                    return usu;
                }
            }
            else{
                usu=null; //No coincide el usuario;
            }
        }
        
        return usu;
        
    }
    
    
}
