
package Modelo.persistir;

import Modelo.entities.Administrador;
import Modelo.exceptions.PreexistingEntityException;
import Modelo.jpa_controllers.AdministradorJpaController;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class PersistirAdministrador implements IPersistencia<Administrador>{

    private AdministradorJpaController adminJpa;
    
    public PersistirAdministrador() {
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
    public Administrador obtener(Long cedula) {
        return adminJpa.findAdministrador(cedula);
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
    public void eliminar(Long id) throws Exception {
        adminJpa.destroy(id);
    }

    @Override
    public List<Administrador> traerEntidades() {
        List<Administrador> listaAdministradores = adminJpa.findAdministradorEntities();
        return listaAdministradores;
    }
}
