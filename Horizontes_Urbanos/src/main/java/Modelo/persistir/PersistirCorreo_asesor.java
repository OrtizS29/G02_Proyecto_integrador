
package Modelo.persistir;

import Modelo.entities.Correo_asesor;
import Modelo.jpa_controllers.Correo_asesorJpaController;

/**
 *
 * @author Santiago
 */
public class PersistirCorreo_asesor implements IPersistencia<Correo_asesor> {
    
    private Correo_asesorJpaController correoAseJpa; 

    public PersistirCorreo_asesor() {
        correoAseJpa =  new Correo_asesorJpaController();
    }

    @Override
    public void crear(Correo_asesor entidad) throws Exception {
        correoAseJpa.create(entidad);
    }

    @Override
    public Correo_asesor obtener(int id) {
        return correoAseJpa.findCorreo_asesor(id);
    }

    @Override
    public void editar(Correo_asesor entidad) throws Exception {
        correoAseJpa.edit(entidad);
    }

    @Override
    public void eliminar(int id) throws Exception {
        correoAseJpa.destroy(id);
    }
   
   
    
}
