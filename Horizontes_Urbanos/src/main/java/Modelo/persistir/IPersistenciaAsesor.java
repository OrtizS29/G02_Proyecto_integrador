
package Modelo.persistir;
import Modelo.entities.Asesor;
import java.util.List;

/*
/**
 *
 * @author Santiago
 */
public interface IPersistenciaAsesor extends IPersistencia<Asesor> {
    
    public List<Asesor> traerAsesores();
}
