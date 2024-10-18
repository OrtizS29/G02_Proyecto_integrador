
package CONTROLADOR;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Santiago
 */
@Entity
@Table(name = "TORRE")
public class Torre {
    
    @Id
    private int Id_torre;
    
    /**
     * Falta poner llaves foraneas
     */
}
