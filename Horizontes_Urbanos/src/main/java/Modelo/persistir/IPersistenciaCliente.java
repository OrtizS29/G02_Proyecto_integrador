
package Modelo.persistir;

import Modelo.entities.Cliente;
import java.util.List;

/**
 *
 * @author CLAUDIA
 */
public interface IPersistenciaCliente extends IPersistencia<Cliente>{
    
    public List<Cliente> traerClientes();
}
