
package Modelo.persistir;

import Modelo.entities.Torre;

/**
 *
 * @author Santiago
 */
public interface IPersistenciaTorre extends IPersistencia<Torre> {
    
    int contarNAptos(int numero_torre);
}
