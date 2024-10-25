
package Modelo.gestion;

import Modelo.IPersistencia;
import Modelo.entities.Cliente;
import Modelo.jpa_controllers.ClienteJpaController;

/**
 *
 * @author Santiago
 */
public class GestionarCliente implements IPersistencia<Cliente> {

    private ClienteJpaController clienteJpa;

    public GestionarCliente() {
        clienteJpa = new ClienteJpaController();
    }
    
    @Override
    public void crear(Cliente entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente obtener(int id) throws Exception {
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
