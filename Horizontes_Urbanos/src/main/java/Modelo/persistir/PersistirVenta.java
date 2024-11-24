
package Modelo.persistir;

import Modelo.entities.Apartamento;
import Modelo.entities.Pago;
import Modelo.entities.Venta;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.jpa_controllers.VentaJpaController;
import Modelo.jpa_controllers.exceptions.IllegalOrphanException;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class PersistirVenta implements IPersistenciaVenta {
    
    private VentaJpaController ventaJpa;
    private IPersistencia<Pago> persisPago;

    public PersistirVenta(I_PersistenciaFactory fa) {
        ventaJpa = new VentaJpaController();
        persisPago = fa.crearPersistirPago();
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
        
        ventaJpa.editarVentaC(entidad);
        
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
    public int contarNDeudas(Long id_venta) {
        return ventaJpa.contarNDeudas(id_venta);
    }

    @Override
    public List<Apartamento> obtenerAptosVendidos(Long id_venta, Long ced_cliente) {
        List<Apartamento> listaApartamentosVendidos = ventaJpa.obtenerAptosVendidos(id_venta,ced_cliente);
        return listaApartamentosVendidos;
    }
}
