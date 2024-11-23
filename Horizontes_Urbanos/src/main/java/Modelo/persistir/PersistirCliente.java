
package Modelo.persistir;

import Modelo.entities.Cliente;
import Modelo.jpa_controllers.ClienteJpaController;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class PersistirCliente implements IPersistencia<Cliente> {

    private ClienteJpaController clienteJpa;

    public PersistirCliente() {
        clienteJpa = new ClienteJpaController();
    }
    
    @Override
    public void crear(Cliente entidad) throws Exception {
        clienteJpa.create(entidad);
    }

    @Override
    public Cliente obtener(Long id){
        return clienteJpa.findCliente(id);
    }

    @Override
    public void editar(Cliente entidad) throws Exception {
        
        clienteJpa.editarCliente(entidad);
    }

    @Override
    public void eliminar(Long id) throws Exception {
        clienteJpa.destroy(id);
    }

    @Override
    public List<Cliente> traerEntidades() {
        List<Cliente> listaClientes = clienteJpa.findClienteEntities();
        return listaClientes;
    }
    
}
