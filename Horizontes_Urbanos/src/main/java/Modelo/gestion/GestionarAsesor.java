
package Modelo.gestion;

import Modelo.IPersistencia;
import Modelo.entities.Asesor;
import Modelo.jpa_controllers.AsesorJpaController;

/**
 *
 * @author Santiago
 */
public class GestionarAsesor implements IPersistencia<Asesor> {

    private AsesorJpaController asesorJpa;
    
    public GestionarAsesor() {
        asesorJpa = new AsesorJpaController();
    }

    @Override
    public void crear(Asesor entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Asesor obtener(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar(Asesor entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
