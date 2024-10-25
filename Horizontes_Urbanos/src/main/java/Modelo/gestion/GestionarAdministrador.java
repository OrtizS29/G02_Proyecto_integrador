
package Modelo.gestion;

import Modelo.IPersistencia;
import Modelo.entities.Administrador;
import Modelo.exceptions.PreexistingEntityException;
import Modelo.jpa_controllers.AdministradorJpaController;

/**
 *
 * @author Santiago
 */
public class GestionarAdministrador implements IPersistencia<Administrador>{

    private AdministradorJpaController adminJpa;
    
    public GestionarAdministrador() {
        adminJpa = new AdministradorJpaController();
    }
    
    /**
     * 
     * @param entidad
     * @throws Exception 
     */
    @Override
    public void crear(Administrador entidad) throws Exception {
        try {
           adminJpa.create(entidad); 
        } catch (PreexistingEntityException e) {
            System.out.println("El administrador ya existe" + e.getMessage());
        }
    }

    /**
     * 
     * @param id
     * @return
     * @throws Exception 
     */
    @Override
    public Administrador obtener(int id) throws Exception {
        return adminJpa.findAdministrador(id);
    }

    /**
     * 
     * @param entidad
     * @throws Exception 
     */
    @Override
    public void editar(Administrador entidad) throws Exception {
        adminJpa.edit(entidad);
    }

    /**
     * 
     * @param id
     * @throws Exception 
     */
    @Override
    public void eliminar(int id) throws Exception {
        adminJpa.destroy(id);
    }
    
}
