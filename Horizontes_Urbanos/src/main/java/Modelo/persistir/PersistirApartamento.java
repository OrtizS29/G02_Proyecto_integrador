
package Modelo.persistir;

import Modelo.entities.Apartamento;
import Modelo.jpa_controllers.ApartamentoJpaController;

/**
 *
 * @author Santiago
 */
public class PersistirApartamento implements IPersistencia<Apartamento> {
    
    private ApartamentoJpaController aptoJpa;

    public PersistirApartamento() {
        aptoJpa = new ApartamentoJpaController();
    }

    @Override
    public void crear(Apartamento entidad) throws Exception {
        aptoJpa.create(entidad);
    }

    @Override
    public Apartamento obtener(int id) {
        return aptoJpa.findApartamento(id);
    }

    @Override
    public void editar(Apartamento entidad) throws Exception {
        aptoJpa.edit(entidad);
    }

    @Override
    public void eliminar(int id) throws Exception {
        aptoJpa.destroy(id);
    }
    
}
