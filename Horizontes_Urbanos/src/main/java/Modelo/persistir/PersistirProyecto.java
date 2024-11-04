
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
    public Proyecto obtener(int id){
        return proyectoJpa.findProyecto(id);
    }

    @Override
    public void editar(Proyecto entidad) throws Exception {
        proyectoJpa.editarNombreYProyecto(entidad);
    }

    @Override
    public void eliminar(int id) throws Exception {
        proyectoJpa.destroy(id);
    }

    public int contarNTorres(String nombre_proyecto) {
        List<Object[]> Qresultado = proyectoJpa.contarNTorres();
        
        for (Object[] objects : Qresultado) {
            
            String nombreP = (String) objects[0];
            Long CanTorres = (Long) objects[1];
            
            if (nombreP.equals(nombre_proyecto)) {
                return CanTorres.intValue();
            }
        }
        return 0;
    }
}
