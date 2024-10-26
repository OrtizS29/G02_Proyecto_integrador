
package Modelo.persistir;

import Modelo.entities.Correo_cliente;
import Modelo.jpa_controllers.Correo_clienteJpaController;

/**
 *
 * @author Santiago
 */
public class PersistirCorreo_cliente implements IPersistencia<Correo_cliente> {
    
    private Correo_clienteJpaController correoCliJpa; 

    public PersistirCorreo_cliente() {
        correoCliJpa =  new Correo_clienteJpaController();
    }

    @Override
    public void crear(Correo_cliente entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Correo_cliente obtener(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar(Correo_cliente entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
