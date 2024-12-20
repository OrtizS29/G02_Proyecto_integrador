
package Modelo.persistir;

import Modelo.entities.Proyecto;
import Modelo.jpa_controllers.ProyectoJpaController;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class PersistirProyecto implements IPersistenciaProyecto {
    
    private ProyectoJpaController proyectoJpa;

    public PersistirProyecto() {
        proyectoJpa = new ProyectoJpaController();
    }

    @Override
    public void crear(Proyecto entidad) throws Exception {
        proyectoJpa.create(entidad);
    }

    @Override
    public Proyecto obtener(Long id){
        return proyectoJpa.findProyecto(id);
    }

    @Override
    public void editar(Proyecto entidad) throws Exception {
        proyectoJpa.editarNombreYProyecto(entidad);
    }

    @Override
    public void eliminar(Long id) throws Exception {
        proyectoJpa.destroy(id);
    }

    public int contarNTorres(String nombre_proyecto) {
        return proyectoJpa.contarNTorres(nombre_proyecto);
    } 

    @Override
    public List<Proyecto> traerEntidades() {
        List<Proyecto> listaProyectos = proyectoJpa.findProyectoEntities();
        return listaProyectos;
    }
}
