
package Modelo.persistir;

import Modelo.entities.Cliente;
import Modelo.jpa_controllers.ClienteJpaController;

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
    public Cliente obtener(int id){
        return clienteJpa.findCliente(id);
    }

    @Override
    public void editar(Cliente entidad) throws Exception {
        clienteJpa.edit(entidad);
    }

    @Override
    public void eliminar(int id) throws Exception {
        clienteJpa.destroy(id);
    }
    
}
