
package CONTROLADOR.gestionar;

import Modelo.entities.Apartamento;
import Modelo.entities.Cliente;
import Modelo.entities.Venta;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.persistir.IPersistencia;
import Modelo.persistir.IPersistenciaVenta;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class GestionarVenta {
    
    private IPersistenciaVenta persisVenta;
    private IPersistencia<Cliente> persisCliente;

    public GestionarVenta(I_PersistenciaFactory fa) {
        persisVenta = fa.crearPersistirVenta();
        persisCliente = fa.crearPersistirCliente();
    }

    public Venta guardar(Venta venta) throws Exception {
        persisVenta.crear(venta);
        return venta;
    }
    
    public Venta buscarPorId(Long id) {
        Venta venta = null;
        venta = persisVenta.obtener(id);
        return venta;
    }
    
    public void editar(Venta venta) throws Exception {
        persisVenta.editar(venta);
    }
    
    public void borrar(int id){
    
    }
    
    public List<Venta> traerVentas() {
        List<Venta> listaVentas = persisVenta.traerEntidades();
        return listaVentas;
    }
    
    public List<Apartamento> obtenerAptosNoVendidos(){
        List<Apartamento> listaApartamentosNoVendidos = persisVenta.obtenerAptosNoVendidos();
        return listaApartamentosNoVendidos;
    }
    

    public List<Venta> obtenerVentaCliente(Long ced) {
        Cliente cliente = persisCliente.obtener(ced);
        return cliente.getListaVentas();
    }
                    
}
