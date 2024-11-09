
package CONTROLADOR;

import Modelo.entities.Cliente;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.persistir.IPersistenciaCliente;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class GestionarCliente {
    
    private IPersistenciaCliente persisCliente;

    public GestionarCliente(I_PersistenciaFactory fa) {
        persisCliente = fa.crearPersistirCliente();
    }

    public Cliente guardar(Cliente cliente) throws Exception {
        persisCliente.crear(cliente);
        return cliente;
    }

    public List<Cliente> traerClientes() {
        List<Cliente> listaClientes = persisCliente.traerClientes();
        return listaClientes;
    }
    
    
}
