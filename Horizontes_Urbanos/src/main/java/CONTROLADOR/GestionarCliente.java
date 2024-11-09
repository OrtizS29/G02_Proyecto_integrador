
package CONTROLADOR;

import Modelo.entities.Cliente;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.persistir.IPersistencia;

/**
 *
 * @author Santiago
 */
public class GestionarCliente {
    
    private IPersistencia<Cliente> persisCliente;

    public GestionarCliente(I_PersistenciaFactory fa) {
        persisCliente = fa.crearPersistirCliente();
    }
    
    
}
