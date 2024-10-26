
package Modelo.persistir;

import Modelo.entities.Usuario;
import Modelo.exceptions.PreexistingEntityException;
import Modelo.jpa_controllers.UsuarioJpaController;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class PersistirUsuario implements IPersistencia<Usuario> {
    
    private UsuarioJpaController usuarioJpa;

    public PersistirUsuario() {
        usuarioJpa = new UsuarioJpaController();
    }

    @Override
    public void crear(Usuario entidad) throws Exception {
        usuarioJpa.create(entidad); 
    }

    @Override
    public Usuario obtener(int id) throws Exception {
        return usuarioJpa.findUsuario(id);
    }

    @Override
    public void editar(Usuario entidad) throws Exception {
        usuarioJpa.edit(entidad);
    }

    @Override
    public void eliminar(int id) throws Exception {
        usuarioJpa.destroy(id);
    }
    
    public List<Usuario> traerUsuarios() {
       
        List<Usuario> listaUsuario = usuarioJpa.findUsuarioEntities();
        return listaUsuario;  
    }
}
