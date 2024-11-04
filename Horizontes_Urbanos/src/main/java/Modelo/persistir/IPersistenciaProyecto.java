
package Modelo.persistir;

import Modelo.entities.Proyecto;

/**
 *
 * @author Santiago
 */
public interface IPersistenciaProyecto extends IPersistencia<Proyecto>{

    int contarNTorres(String nombre_proyecto);

}
