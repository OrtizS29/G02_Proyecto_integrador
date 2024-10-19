
package CONTROLADOR;

import java.util.ArrayList;
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
@Table(name = "ADMINISTRADOR") 
public class Administrador {
    
    @Id
    private int Cedula;
    /**
     * 
     */
    private String Nombre;
    private String Direccion;
    
    @OneToMany
    private ArrayList<Apartamento> listaApartamentos;
    /**
     * Falta poner llaves foraneas
     */
}
