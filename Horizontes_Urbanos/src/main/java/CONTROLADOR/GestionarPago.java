
package CONTROLADOR;

import Modelo.entities.Pago;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.persistir.IPersistencia;

/**
 *
 * @author Santiago
 */
public class GestionarPago {
    
    private IPersistencia<Pago> persisPago;

    public GestionarPago(I_PersistenciaFactory fa) {
        persisPago = fa.crearPersistirPago();
    }
    
    
}
