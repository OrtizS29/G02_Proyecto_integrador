
package CONTROLADOR;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * author Santiago
 * Clase que representa la entidad Asesor
 */
@Entity
@Table(name = "ASESOR")
public class Asesor {
    
    @Id
    private int Cedula;
    private String Nombre;
    private String Direccion;
    /**
     * Falta poner llaves foraneas
     */
}
