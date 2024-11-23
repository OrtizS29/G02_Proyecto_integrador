
package Modelo.persistir;

import Modelo.entities.Pago;
import Modelo.entities.Venta;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.jpa_controllers.PagoJpaController;
import Modelo.jpa_controllers.VentaJpaController;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class PersistirPago implements IPersistencia<Pago> {
    
    private PagoJpaController pagoJpa;

    public PersistirPago() {
        pagoJpa = new PagoJpaController();
    }

    @Override
    public void crear(Pago entidad) throws Exception {
        pagoJpa.create(entidad);
    }

    @Override
    public Pago obtener(Long id){
        return pagoJpa.findPago(id);
    }

    @Override
    public void editar(Pago entidad) throws Exception {
        if (entidad.getVenta() == null) {
            throw new IllegalArgumentException("El pago debe estar asociado a una venta.");
        }
        
        pagoJpa.edit(entidad);
    }

    @Override
    public void eliminar(Long id) throws Exception {
        pagoJpa.destroy(id);
    }

    @Override
    public List<Pago> traerEntidades() {
        List<Pago> listaPagos = pagoJpa.findPagoEntities();
        return listaPagos;
    }
}
