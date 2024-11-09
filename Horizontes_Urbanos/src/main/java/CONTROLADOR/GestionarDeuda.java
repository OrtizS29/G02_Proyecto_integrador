
package CONTROLADOR;

import Modelo.entities.Deuda;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.persistir.IPersistencia;

/**
 *
 * @author Santiago
 */
public class GestionarDeuda {
    
    private IPersistencia<Deuda> persisDeuda;

    public GestionarDeuda(I_PersistenciaFactory fa) {
        persisDeuda = fa.crearPersistirDeuda();
    }
    
    
    
}
