
package Modelo.persistir;

import Modelo.entities.Correo;
import Modelo.jpa_controllers.CorreoJpaController;

/**
 *
 * @author Santiago
 */
public class PersistirCorreo implements IPersistencia<Correo> {
    
    private CorreoJpaController correoAseJpa; 

    public PersistirCorreo() {
        correoAseJpa =  new CorreoJpaController();
    }

    @Override
    public void crear(Correo entidad) throws Exception {
        correoAseJpa.create(entidad);
    }

    @Override
    public Correo obtener(int id) {
        return correoAseJpa.findCorreo(id);
    }

    @Override
    public void editar(Correo entidad) throws Exception {
        correoAseJpa.edit(entidad);
    }

    @Override
    public void eliminar(int id) throws Exception {
        correoAseJpa.destroy(id);
    }
   
   
    
}
