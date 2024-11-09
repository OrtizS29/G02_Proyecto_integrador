
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
        ventaJpa.create(entidad);
    }

    @Override
    public Venta obtener(Long id) {
        return ventaJpa.findVenta(id);
    }

    @Override
    public void editar(Venta entidad) throws Exception {
        ventaJpa.edit(entidad);
    }

    @Override
    public void eliminar(Long id) throws Exception {
        ventaJpa.destroy(id);
    }
    
}
