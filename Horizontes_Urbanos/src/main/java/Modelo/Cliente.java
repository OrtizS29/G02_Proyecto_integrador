
package Modelo;

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
    private int cedula;
    private String nombre;
    private String direccion;
    private Integer subsidio_ministerio;
    private Integer sisben;
    
    @OneToMany(mappedBy = "cliente")
    private LinkedList<Telefono_cliente> listaTelefonosCliente;
    
    @OneToMany(mappedBy = "cliente")
    private LinkedList<Correo_cliente> listaCorreosCliente;
    
    
    /**
     * Falta poner llaves foraneas
     */
}
