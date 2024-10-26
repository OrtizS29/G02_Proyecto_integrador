
package Modelo.persistir;

import Modelo.entities.Telefono_cliente;
import Modelo.jpa_controllers.Telefono_clienteJpaController;

/**
 *
 * @author Santiago
 */
public class PersistirTelefono_cliente implements IPersistencia<Telefono_cliente> {
    
    private Telefono_clienteJpaController telCliJpa;

    public PersistirTelefono_cliente() {
        telCliJpa = new Telefono_clienteJpaController();
    }

    @Override
    public void crear(Telefono_cliente entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Telefono_cliente obtener(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar(Telefono_cliente entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
