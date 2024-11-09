
package Modelo.persistir;

import Modelo.entities.Deuda;
import Modelo.jpa_controllers.DeudaJpaController;

/**
 *
 * @author Santiago
 */
public class PersistirDeuda implements IPersistencia<Deuda> {

    private DeudaJpaController deudaJpa;
    
    @Override
    public void crear(Deuda entidad) throws Exception {
        deudaJpa.create(entidad);
    }

    @Override
    public Deuda obtener(int id) {
        return deudaJpa.findDeuda(id);
    }

    @Override
    public void editar(Deuda entidad) throws Exception {
        deudaJpa.edit(entidad);
    }

    @Override
    public void eliminar(int id) throws Exception {
        deudaJpa.destroy(id);
    }
    
    
    
}
