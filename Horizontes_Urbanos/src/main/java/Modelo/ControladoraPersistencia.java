
package Modelo;

import Modelo.jpa_controllers.AdministradorJpaController;
import Modelo.entities.Administrador;
import Modelo.exceptions.PreexistingEntityException;

/**
 *
 * @author Santiago
 */
public class ControladoraPersistencia{
    
    AdministradorJpaController adminJpa = new AdministradorJpaController();
    
    public void crearAdministrador(Administrador administrador) throws Exception {
       
        //crear en la BD el Administrado
        try {
           adminJpa.create(administrador); 
        } catch (PreexistingEntityException e) {
            System.out.println("El administrador ya existe" + e.getMessage());
        }
        
    }
}
