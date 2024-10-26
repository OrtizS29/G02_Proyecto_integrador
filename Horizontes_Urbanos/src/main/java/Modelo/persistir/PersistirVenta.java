
package Modelo.persistir;

import Modelo.entities.Venta;
import Modelo.jpa_controllers.VentaJpaController;

/**
 *
 * @author Santiago
 */
public class PersistirVenta implements IPersistencia<Venta> {
    
    private VentaJpaController ventaJpa;

    public PersistirVenta() {
        ventaJpa = new VentaJpaController();
    }

    @Override
    public void crear(Venta entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Venta obtener(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar(Venta entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
