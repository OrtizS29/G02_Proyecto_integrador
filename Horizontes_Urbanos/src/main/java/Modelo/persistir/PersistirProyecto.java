
package Modelo.persistir;

import Modelo.entities.Proyecto;
import Modelo.jpa_controllers.ProyectoJpaController;

/**
 *
 * @author Santiago
 */
public class PersistirProyecto implements IPersistencia<Proyecto> {
    
    private ProyectoJpaController proyectoJpa;

    public PersistirProyecto() {
        proyectoJpa = new ProyectoJpaController();
    }

    @Override
    public void crear(Proyecto entidad) throws Exception {
        proyectoJpa.create(entidad);
    }

    @Override
    public Proyecto obtener(int id){
        return proyectoJpa.findProyecto(id);
    }

    @Override
    public void editar(Proyecto entidad) throws Exception {
        proyectoJpa.edit(entidad);
    }

    @Override
    public void eliminar(int id) throws Exception {
        proyectoJpa.destroy(id);
    }
    
    public void editarNombreYProyecto(Proyecto proyecto) throws Exception {
        proyectoJpa.editarNombreYProyecto(proyecto);
    }
}
