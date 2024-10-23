
package Modelo;

import Modelo.exceptions.PreexistingEntityException;

/**
 *
 * @author Santiago
 */
public class ControladoraPersistencia{
    
    AdministradorJpaController adminJpa = new AdministradorJpaController();
    
    public void crearAdministrador(Administrador administrador) throws Exception {
       
        //crear en la BD el Administrador
        try {
           adminJpa.create(administrador); 
        } catch (PreexistingEntityException e) {
            System.out.println("El administrador ya existe" + e.getMessage());
        }
        
    }
}
