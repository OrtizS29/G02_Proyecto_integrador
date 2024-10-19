
package CONTROLADOR;

import java.util.ArrayList;
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
@Table(name = "CLIENTE")
public class Cliente {
    
    @Id
    private int Cedula;
    private String Nombre;
    private String Direccion;
    private Integer subsidio_ministerio;
    private Integer Sisben;
    
    @OneToMany
    private ArrayList<Telefono_cliente> listaTelefonosClientes;
    
    @OneToMany
    private ArrayList<Correo_cliente> listaCorreoClientes;
    
    
    /**
     * Falta poner llaves foraneas
     */
}
