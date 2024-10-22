
package CONTROLADOR;

import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * author Santiago
 * Clase que representa la entidad Asesor
 */
@Entity
@Table(name = "Asesor")
public class Asesor {
    
    @Id
    private int Cedula;
    private String Nombre;
    private String Direccion;
    
    @OneToMany
    private LinkedList<Telefono_asesor> listaTelefonosCliente;
    
    @OneToMany
    private LinkedList<Correo_asesor> listaCorreoCliente;
    /**
     * Falta poner llaves foraneas
     */
}
