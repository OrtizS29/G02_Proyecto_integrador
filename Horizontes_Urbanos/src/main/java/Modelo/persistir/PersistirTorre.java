
package Modelo.persistir;

import Modelo.entities.Torre;
import Modelo.jpa_controllers.TorreJpaController;

/**
 *
 * @author Santiago
 */
public class PersistirTorre implements IPersistencia<Torre> {
    
    private TorreJpaController torreJpa;

    public PersistirTorre() {
        torreJpa = new TorreJpaController();
    }

    @Override
    public void crear(Torre entidad) throws Exception {
        torreJpa.create(entidad);
    }

    @Override
    public Torre obtener(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar(Torre entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
