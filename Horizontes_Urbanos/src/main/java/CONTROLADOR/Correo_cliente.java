
package CONTROLADOR;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que determina la entidad Correo Cliente
 * 
 * @author Santiago
 */
@Entity
@Table(name = "Correo_cliente")
public class Correo_cliente {
    
    @Id
    private int Id;
    private String Correo;
    
    @ManyToOne
    @JoinColumn(name = "Cedula_cliente", referencedColumnName = "Cedula")
    private Cliente cliente;
}
