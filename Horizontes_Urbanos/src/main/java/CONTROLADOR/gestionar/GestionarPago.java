
package CONTROLADOR.gestionar;

import Modelo.entities.Cliente;
import Modelo.entities.Pago;
import Modelo.entities.Venta;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.persistir.IPersistencia;
import Modelo.persistir.IPersistenciaVenta;
import java.math.BigDecimal;
import java.sql.Date;
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
    
    public Pago buscarPorId(Long id_pago) {
        Pago pago = null;
        pago = persisPago.obtener(id_pago);
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

    public void editar(Pago pago, Date fecha, BigDecimal valor_pago) throws Exception {
        
        pago.setFecha(fecha);
        pago.setValor_pago(valor_pago);
        persisPago.editar(pago);
    }

    public boolean borrar(Long id_pago, Venta ventaSeleccionada) throws Exception {
        
        if (ventaSeleccionada.getListaApartamentos().size()==1) {
            return false;
        }
        else {
            Pago pago = persisPago.obtener(id_pago);
            persisPago.eliminar(id_pago);
            Venta ventaR = persisVenta.obtener(ventaSeleccionada.getId_venta());
            
            if (!ventaR.getListaPagos().contains(pago)) {
                //se actualiza la lista de apartamentos
                ventaSeleccionada.setListaApartamentos(ventaR.getListaApartamentos());
                return true;
            } 
            else {
                // Si algo salio mal sale esta excepcion
                throw new Exception("El apartamento no se eliminó correctamente de la torre.");
            } 
        }
    }

    
}
