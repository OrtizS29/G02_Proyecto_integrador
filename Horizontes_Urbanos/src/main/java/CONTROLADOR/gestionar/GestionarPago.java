
package CONTROLADOR.gestionar;

import Modelo.entities.Cliente;
import Modelo.entities.Pago;
import Modelo.entities.Venta;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.persistir.IPersistencia;
import Modelo.persistir.IPersistenciaVenta;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class GestionarPago {
    
    private IPersistencia<Pago> persisPago;
    private IPersistencia<Cliente> persisCliente;
    private IPersistenciaVenta persisVenta;

    public GestionarPago(I_PersistenciaFactory fa) {
        persisPago = fa.crearPersistirPago();
        persisCliente = fa.crearPersistirCliente();
        persisVenta = fa.crearPersistirVenta();
    }
    
    public Pago guardar(Pago pago) throws Exception {
        persisPago.crear(pago);
        return pago;
    }
    
    public List<Pago> traerClientePago(Long ced){
        Cliente cliente = persisCliente.obtener(ced);
        return cliente.getListaPagos();
    }
    
    public List<Pago> traerVentaPago(Long id){
        Venta venta = persisVenta.obtener(id);
        return venta.getListaPagos();
    }
}
