
package CONTROLADOR.gestionar;

import Modelo.entities.Venta;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.persistir.IPersistencia;
import java.sql.Date;

/**
 *
 * @author Santiago
 */
public class GestionarVenta {
    
    private IPersistencia<Venta> persisVenta;

    public GestionarVenta(I_PersistenciaFactory fa) {
        persisVenta = fa.crearPersistirVenta();
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
    
    public void editar(Venta venta, Date fecha,int numero_coutas) throws Exception {
        
        venta.setFecha(fecha);
        venta.setNumero_coutas(numero_coutas);
        persisVenta.editar(venta);
    }
    
    public void borrar(int id){
    
    }
    
    
}
