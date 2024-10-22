
package CONTROLADOR;

import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * Clase que determina la entidad Administrador
 *
 * @author Santiago
 */
@Entity
@Table(name = "Administrador") 
public class Administrador {
    
    @Id
    private int Cedula;
    private String Nombre;
    private String Direccion;
    
    @OneToMany
    private LinkedList<Apartamento> listaApartamentos;
    
    @OneToMany
    private LinkedList<Telefono_administrador> listaTelefonosAdministrador;
    
    @OneToMany
    private LinkedList<Correo_administrador> listaCorreosAdministrador;
    /**
     * Falta poner llaves foraneas
     */
}
