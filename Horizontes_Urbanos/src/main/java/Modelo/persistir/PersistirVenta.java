
package Modelo.persistir;

import Modelo.entities.Apartamento;
import Modelo.entities.Venta;
import Modelo.jpa_controllers.VentaJpaController;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class PersistirVenta implements IPersistenciaVenta {
    
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
    
    public List<Apartamento> obtenerAptosNoVendidos(){
        List<Apartamento> listaApartamentosNoVendidos = ventaJpa.obtenerAptosNoVendidos();
        return listaApartamentosNoVendidos;
    }
}
