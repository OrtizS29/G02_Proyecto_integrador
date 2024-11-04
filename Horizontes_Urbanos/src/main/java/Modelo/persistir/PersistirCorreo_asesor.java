
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Correo_asesor obtener(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar(Correo_asesor entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
   
    
}
