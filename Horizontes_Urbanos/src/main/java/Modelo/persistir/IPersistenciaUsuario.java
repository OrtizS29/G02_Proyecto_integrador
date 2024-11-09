
package Modelo.persistir;

import Modelo.entities.Usuario;

/**
 *
 * @author Santiago
 */
public interface IPersistenciaUsuario extends IPersistencia<Usuario>{
    
    public Usuario obtenerAsesorCed(Long id);
}
