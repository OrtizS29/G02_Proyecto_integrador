
package Modelo.persistir;

import Modelo.entities.Torre;
import Modelo.jpa_controllers.TorreJpaController;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class PersistirTorre implements IPersistenciaTorre {
    
    private TorreJpaController torreJpa;

    public PersistirTorre() {
        torreJpa = new TorreJpaController();
    }

    @Override
    public void crear(Torre entidad) throws Exception {
        torreJpa.create(entidad);
    }

    @Override
    public Torre obtener(Long id) {
        return torreJpa.findTorre(id);
    }

    @Override
    public void editar(Torre entidad) throws Exception {
        torreJpa.editarNumeroYNumeroT(entidad);
    }

    @Override
    public void eliminar(Long id) throws Exception {
        torreJpa.destroy(id);
    }
    /**
    public void editarNumeroYNumeroT(Torre torre) throws Exception {
        torreJpa.editarNumeroYNumeroT(torre);
    }*/

    public int contarNAptos(int numero_torre,Long id_proyecto) {
        return torreJpa.contarNAptos(numero_torre,id_proyecto);
    }

    @Override
    public List<Torre> traerEntidades() {
        List<Torre> listaTorres = torreJpa.findTorreEntities();
        return listaTorres;
    }
    
}
