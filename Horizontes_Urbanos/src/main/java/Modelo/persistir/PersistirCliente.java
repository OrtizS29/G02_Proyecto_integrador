
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente obtener(int id){
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar(Cliente entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
