
package Modelo.persistir;

import Modelo.entities.Torre;
import Modelo.jpa_controllers.TorreJpaController;

/**
 *
 * @author Santiago
 */
public class PersistirTorre implements IPersistencia<Torre> {
    
    private TorreJpaController torreJpa;

    public PersistirTorre() {
        torreJpa = new TorreJpaController();
    }

    @Override
    public void crear(Torre entidad) throws Exception {
        torreJpa.create(entidad);
    }

    @Override
    public Torre obtener(int id) {
        return torreJpa.findTorre(id);
    }

    @Override
    public void editar(Torre entidad) throws Exception {
        torreJpa.edit(entidad);
    }

    @Override
    public void eliminar(int id) throws Exception {
        torreJpa.destroy(id);
    }
    
    public void editarNumeroYNumeroT(Torre torre) throws Exception {
        torreJpa.editarNumeroYNumeroT(torre);
    }
    
}
