
package CONTROLADOR;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Santiago
 */
@Entity
@Table(name = "PROYECTO")
public class Proyecto {
    
    @Id
    private int Id_proyecto;
    
    /**
     * Falta poner llaves foraneas
     */
}
