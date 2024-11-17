
package Modelo.persistir;

import Modelo.entities.Apartamento;
import Modelo.entities.Pago;
import Modelo.entities.Venta;
import Modelo.jpa_controllers.VentaJpaController;
import Modelo.jpa_controllers.exceptions.IllegalOrphanException;
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
        
        Venta ventaExistente = ventaJpa.findVenta(entidad.getId_venta());
        if (ventaExistente != null) {
            // Validar que los pagos actuales no queden huérfanos
            for (Pago pago : ventaExistente.getListaPagos()) {
                entidad.getListaPagos().add(pago);
                if (!entidad.getListaPagos().contains(pago)) {
                    
                    System.out.println("Hay un error");
                    return;
                }
            }
        }
        
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

    @Override
    public List<Venta> traerEntidades() {
        List<Venta> listaVentas = ventaJpa.findVentaEntities();
        return listaVentas;
    }

    @Override
    public int contarNPagos(Long id_venta) {
        return ventaJpa.contarNPagos(id_venta);
    }

    @Override
    public List<Apartamento> obtenerAptosVendidos(Long id_venta, Long ced_cliente) {
        List<Apartamento> listaApartamentosVendidos = ventaJpa.obtenerAptosVendidos(id_venta,ced_cliente);
        return listaApartamentosVendidos;
    }
}
