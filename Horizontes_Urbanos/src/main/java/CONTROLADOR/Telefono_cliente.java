
package CONTROLADOR;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que determina la entidad Telefono Cliente
 * 
 * @author Santiago
 */
@Entity
@Table(name = "Telefono_cliente")
public class Telefono_cliente {
     
    @Id
    private int Id;
    private Integer Telefono;
    
    @ManyToOne
    @JoinColumn(name = "Cedula_cliente", referencedColumnName = "Cedula")
    private Cliente cliente;
}
