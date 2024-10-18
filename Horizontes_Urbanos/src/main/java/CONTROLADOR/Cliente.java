
package CONTROLADOR;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Santiago
 * 
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente {
    
    @Id
    private int cedula;
    
    /**
     * Falta poner llaves foraneas
     */
}
