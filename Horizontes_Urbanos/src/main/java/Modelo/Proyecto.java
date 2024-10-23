
package Modelo;

import Modelo.Administrador;
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
    private int id_proyecto;
    private String nombre_proyecto; 
    private int numero_torres;
    
    @OneToMany 
    private LinkedList<Torre> listaTorres;
    
    @ManyToOne
    @JoinColumn(name = "Cedula_administrador", referencedColumnName = "Cedula")
    private Administrador administrador;
    
}
