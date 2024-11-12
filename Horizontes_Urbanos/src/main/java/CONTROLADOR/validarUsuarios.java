
package CONTROLADOR;

import Modelo.entities.Usuario;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.persistir.IPersistenciaUsuario;
import Modelo.persistir.PersistirUsuario;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class validarUsuarios {
    
    IPersistenciaUsuario persisUsu;

    public validarUsuarios(I_PersistenciaFactory fa) {
        persisUsu = fa.crearPersistirUsuario();
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
        List<Usuario> listaUsuarios = persisUsu.traerEntidades();
        
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
