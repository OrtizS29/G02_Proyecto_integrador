
package CONTROLADOR;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private String Nombre_proyecto;
    private int Numero_torres;
    
    @ManyToOne
    @JoinColumn(name = "Cedula_administrador", referencedColumnName = "Cedula")
    private Administrador administrador;
    /**
     * Falta poner llaves foraneas
     */
}
