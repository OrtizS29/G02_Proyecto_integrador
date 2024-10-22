
package CONTROLADOR;

import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que determina la entidad Cliente
 * 
 * @author Santiago
 */
@Entity
@Table(name = "Cliente")
public class Cliente {
    
    @Id
    private int Cedula;
    private String Nombre;
    private String Direccion;
    private Integer subsidio_ministerio;
    private Integer Sisben;
    
    @OneToMany
    private LinkedList<Telefono_cliente> listaTelefonosCliente;
    
    @OneToMany
    private LinkedList<Correo_cliente> listaCorreosCliente;
    
    
    /**
     * Falta poner llaves foraneas
     */
}
