
package Modelo.gestion;

import Modelo.IPersistencia;
import Modelo.entities.Pago;
import Modelo.jpa_controllers.PagoJpaController;

/**
 *
 * @author Santiago
 */
public class GestionarPago implements IPersistencia<Pago> {
    
    private PagoJpaController pagoJpa;

    public GestionarPago() {
        pagoJpa = new PagoJpaController();
    }

    @Override
    public void crear(Pago entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pago obtener(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar(Pago entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
