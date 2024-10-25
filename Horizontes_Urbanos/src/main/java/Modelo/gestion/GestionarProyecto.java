
package Modelo.gestion;

import Modelo.IPersistencia;
import Modelo.entities.Proyecto;
import Modelo.jpa_controllers.ProyectoJpaController;

/**
 *
 * @author Santiago
 */
public class GestionarProyecto implements IPersistencia<Proyecto> {
    
    private ProyectoJpaController proyectoJpa;

    public GestionarProyecto() {
        proyectoJpa = new ProyectoJpaController();
    }

    @Override
    public void crear(Proyecto entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Proyecto obtener(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar(Proyecto entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
