
package Modelo;

import Modelo.Proyecto;
import Modelo.Apartamento;
import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Santiago
 */
@Entity
@Table(name = "TORRE")
public class Torre {
    
    @Id
    private int Id_torre;
    private String Nombre_torre;
    private int Numero_apartamento;
    
    @OneToMany
    private LinkedList<Apartamento> listaApartamentos;
    
    @ManyToOne
    @JoinColumn(name = "Id_torre", referencedColumnName = "Id_torre")
    private Proyecto proyecto;
    
    /**
     * Falta poner llaves foraneas
     */
}
