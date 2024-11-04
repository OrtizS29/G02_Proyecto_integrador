
package Modelo.persistir;

import Modelo.entities.Telefono_asesor;
import Modelo.jpa_controllers.Telefono_asesorJpaController;

/**
 *
 * @author Santiago
 */
public class PersistirTelefono_asesor implements IPersistencia<Telefono_asesor> {
    
    private Telefono_asesorJpaController telAseJpa;

    public PersistirTelefono_asesor() {
        telAseJpa = new Telefono_asesorJpaController();
    }

    @Override
    public void crear(Telefono_asesor entidad) throws Exception {
        telAseJpa.create(entidad);
    }

    @Override
    public Telefono_asesor obtener(int id) {
        return telAseJpa.findTelefono_asesor(id);
    }

    @Override
    public void editar(Telefono_asesor entidad) throws Exception {
        telAseJpa.edit(entidad);
    }

    @Override
    public void eliminar(int id) throws Exception {
        telAseJpa.destroy(id);
    }
    
    
    
}
