
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Telefono_asesor obtener(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar(Telefono_asesor entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
