
package Modelo.gestion;

import Modelo.IPersistencia;
import Modelo.entities.Telefono_asesor;
import Modelo.jpa_controllers.Telefono_asesorJpaController;

/**
 *
 * @author Santiago
 */
public class GestionarTelefono_asesor implements IPersistencia<Telefono_asesor> {
    
    private Telefono_asesorJpaController telAseJpa;

    public GestionarTelefono_asesor() {
        telAseJpa = new Telefono_asesorJpaController();
    }

    @Override
    public void crear(Telefono_asesor entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Telefono_asesor obtener(int id) throws Exception {
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
