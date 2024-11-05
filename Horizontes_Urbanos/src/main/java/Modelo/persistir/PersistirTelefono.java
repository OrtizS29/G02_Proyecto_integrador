
package Modelo.persistir;

import Modelo.entities.Telefono;
import Modelo.jpa_controllers.TelefonoJpaController;

/**
 *
 * @author Santiago
 */
public class PersistirTelefono implements IPersistencia<Telefono> {
    
    private TelefonoJpaController telAseJpa;

    public PersistirTelefono() {
        telAseJpa = new TelefonoJpaController();
    }

    @Override
    public void crear(Telefono entidad) throws Exception {
        telAseJpa.create(entidad);
    }

    @Override
    public Telefono obtener(int id) {
        return telAseJpa.findTelefono(id);
    }

    @Override
    public void editar(Telefono entidad) throws Exception {
        telAseJpa.edit(entidad);
    }

    @Override
    public void eliminar(int id) throws Exception {
        telAseJpa.destroy(id);
    }
    
    
    
}
