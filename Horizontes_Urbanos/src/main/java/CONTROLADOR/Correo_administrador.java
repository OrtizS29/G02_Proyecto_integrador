
package CONTROLADOR;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**  
 * Clase que determina la entidad Correo Administrador
 * 
 * @author Santiago
 */
@Entity
@Table(name = "Correo_administrador")
public class Correo_administrador {
    
    @Id
    private int Id;
    private String Correo;
    
    @ManyToOne
    @JoinColumn(name = "Cedula_administrador", referencedColumnName = "Cedula")
    private Cliente cliente;
}
