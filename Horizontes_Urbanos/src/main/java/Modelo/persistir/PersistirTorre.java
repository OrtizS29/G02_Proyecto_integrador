
package Modelo.persistir;

import Modelo.entities.Torre;
import Modelo.jpa_controllers.TorreJpaController;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class PersistirTorre implements IPersistenciaTorre {
    
    private TorreJpaController torreJpa;

    public PersistirTorre() {
        torreJpa = new TorreJpaController();
    }

    @Override
    public void crear(Torre entidad) throws Exception {
        torreJpa.create(entidad);
    }

    @Override
    public Torre obtener(int id) {
        return torreJpa.findTorre(id);
    }

    @Override
    public void editar(Torre entidad) throws Exception {
        torreJpa.editarNumeroYNumeroT(entidad);
    }

    @Override
    public void eliminar(int id) throws Exception {
        torreJpa.destroy(id);
    }
    /**
    public void editarNumeroYNumeroT(Torre torre) throws Exception {
        torreJpa.editarNumeroYNumeroT(torre);
    }*/

    public int contarNAptos(int numero_torre) {
        List<Object[]> Qresultado = torreJpa.contarNAptos();
        
        for (Object[] objects : Qresultado) {
           
            Number numeroT = (Number) objects[0];
            Number canApto = (Number) objects[1];
            
            if (numeroT.intValue() == numero_torre) {
                return canApto.intValue();
            }
        }
        return 0;
        
    }
    
}
