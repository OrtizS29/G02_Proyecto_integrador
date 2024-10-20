
package CONTROLADOR;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que determina la entidad Telefono Administrador
 * 
 * @author Santiago
 */
@Entity
@Table(name = "TELEFONO_ADMINISTRADOR") 
public class Telefono_administrador {
    
    @Id 
    private int Id;
    private Integer Telefono;
    
    @ManyToOne
    @JoinColumn(name = "Cedula_administrador", referencedColumnName = "Cedula")
    private Cliente cliente;
    
}
