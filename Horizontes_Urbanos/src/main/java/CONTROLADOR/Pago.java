
package CONTROLADOR;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Santiago
 */
@Entity
@Table(name = "PAGO")
public class Pago {
    
    @Id
    private int id_pago;
    
    /**
     * Falta poner llaves foraneas
     */
}
