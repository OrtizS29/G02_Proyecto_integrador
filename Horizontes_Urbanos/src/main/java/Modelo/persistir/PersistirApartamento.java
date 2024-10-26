
package Modelo.persistir;

import Modelo.entities.Apartamento;
import Modelo.jpa_controllers.ApartamentoJpaController;

/**
 *
 * @author Santiago
 */
public class PersistirApartamento implements IPersistencia<Apartamento> {
    
    private ApartamentoJpaController proyectoJpa;

    public PersistirApartamento() {
        proyectoJpa = new ApartamentoJpaController();
    }

    @Override
    public void crear(Apartamento entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Apartamento obtener(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar(Apartamento entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
