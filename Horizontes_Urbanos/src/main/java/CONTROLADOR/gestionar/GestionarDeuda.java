
package CONTROLADOR.gestionar;

import Modelo.entities.Deuda;
import Modelo.entities.Venta;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.persistir.IPersistencia;
import Modelo.persistir.IPersistenciaVenta;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class GestionarDeuda {
    
    private IPersistencia<Deuda> persisDeuda;
    private IPersistenciaVenta persisVenta;

    public GestionarDeuda(I_PersistenciaFactory fa) {
        persisDeuda = fa.crearPersistirDeuda();
        persisVenta = fa.crearPersistirVenta();
    }

    public Deuda guardar(Deuda deuda) throws Exception {
        persisDeuda.crear(deuda);
        return deuda;
    }

    public List<Deuda> traerVentaDeuda(Long id) {
        Venta venta = persisVenta.obtener(id);
        return venta.getListaDeuda();
    }
    
    
    
}
