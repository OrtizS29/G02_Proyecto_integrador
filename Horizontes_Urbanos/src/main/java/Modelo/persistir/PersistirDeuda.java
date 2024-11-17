
package Modelo.persistir;

import Modelo.entities.Deuda;
import Modelo.jpa_controllers.DeudaJpaController;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class PersistirDeuda implements IPersistencia<Deuda> {

    private DeudaJpaController deudaJpa;

    public PersistirDeuda() {
        deudaJpa = new DeudaJpaController();
    }

    @Override
    public void crear(Deuda entidad) throws Exception {
        deudaJpa.create(entidad);
    }

    @Override
    public Deuda obtener(Long id) {
        return deudaJpa.findDeuda(id);
    }

    @Override
    public void editar(Deuda entidad) throws Exception {
        deudaJpa.edit(entidad);
    }

    @Override
    public void eliminar(Long id) throws Exception {
        deudaJpa.destroy(id);
    }

    @Override
    public List<Deuda> traerEntidades() {
        List<Deuda> listaDeudas = deudaJpa.findDeudaEntities();
        return listaDeudas;
    }
    
    
    
}
