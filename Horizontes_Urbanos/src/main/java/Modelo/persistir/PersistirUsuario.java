
package Modelo.persistir;

import Modelo.entities.Usuario;
import Modelo.exceptions.PreexistingEntityException;
import Modelo.jpa_controllers.UsuarioJpaController;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class PersistirUsuario implements IPersistenciaUsuario {
    
    private UsuarioJpaController usuarioJpa;

    public PersistirUsuario() {
        usuarioJpa = new UsuarioJpaController();
    }

    @Override
    public void crear(Usuario entidad) throws Exception {
        usuarioJpa.create(entidad); 
    }

    @Override
    public Usuario obtener(Long id) {
        return usuarioJpa.findUsuario(id);
    }

    @Override
    public void editar(Usuario entidad) throws Exception {
        usuarioJpa.edit(entidad);
    }

    @Override
    public void eliminar(Long id) throws Exception {
        usuarioJpa.destroy(id);
    }
    
    public Usuario obtenerAsesorCed(Long id){
        return usuarioJpa.obtenerPorCedulaAsesor(id);
    }

    @Override
    public List<Usuario> traerEntidades() {
        List<Usuario> listaUsuario = usuarioJpa.findUsuarioEntities();
        return listaUsuario;  
    }
}
