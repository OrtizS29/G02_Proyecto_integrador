
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
    private int Cedula;
    private String Nombre;
    private String Direccion;
    private Integer subsidio_ministerio;
    private Integer Sisben;
    /**
     * Falta poner llaves foraneas
     */
}
