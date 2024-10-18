
package CONTROLADOR;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Santiago
 */
@Entity
@Table(name = "VENTA")
public class Venta {
    
    @Id
    private int Id_venta;
    
    /**
     * Falta poner llaves foraneas
     */
}
