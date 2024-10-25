
package Modelo.persistir;

import Modelo.IPersistencia;
import Modelo.entities.Usuario;
import Modelo.jpa_controllers.UsuarioJpaController;

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario obtener(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar(Usuario entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
