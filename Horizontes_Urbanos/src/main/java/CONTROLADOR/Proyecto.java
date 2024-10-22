
package CONTROLADOR;

import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que determina la entidad Proyecto
 * 
 * @author Santiago
 */
@Entity
@Table(name = "Proyecto")
public class Proyecto {
    
    @Id
    private int Id_proyecto;
    private String Nombre_proyecto; 
    private int Numero_torres;
    
    @OneToMany
    private LinkedList<Torre> listaTorres;
    
    @ManyToOne
    @JoinColumn(name = "Cedula_administrador", referencedColumnName = "Cedula")
    private Administrador administrador;
    
}
