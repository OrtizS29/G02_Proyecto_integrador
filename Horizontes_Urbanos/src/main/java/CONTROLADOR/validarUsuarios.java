
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
     * Metodo para el login que valida que la contraseña y usuario sean correctas segun se el caso
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
