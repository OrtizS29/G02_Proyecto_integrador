
package Modelo.persistir;

import Modelo.entities.Asesor;
import Modelo.jpa_controllers.AsesorJpaController;

import java.util.List;

/**
 *
 * @author Santiago
 */
public class PersistirAsesor implements IPersistencia<Asesor> {

    private AsesorJpaController asesorJpa;
    
    public PersistirAsesor() {
        asesorJpa = new AsesorJpaController();
    }

    @Override
    public void crear(Asesor entidad) throws Exception {
        asesorJpa.create(entidad);
    }

    @Override
    public Asesor obtener(Long id){
        return asesorJpa.findAsesor(id);
    }

    @Override
    public void editar(Asesor entidad) throws Exception {
        asesorJpa.edit(entidad);
    }

    @Override
    public void eliminar(Long id) throws Exception {
        asesorJpa.destroy(id);
    }
  
    @Override
    public List<Asesor> traerEntidades() {
        List<Asesor> listaAsesores = asesorJpa.findAsesorEntities();
        return listaAsesores;
    }
}
