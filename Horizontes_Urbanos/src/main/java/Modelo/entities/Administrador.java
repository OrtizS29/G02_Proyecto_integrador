
package Modelo.entities;

import java.io.Serializable;
import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * Clase que determina la entidad Administrado
 *
 * @author Santiago
 */
@Entity
@Table(name = "Administrador") 
public class Administrador implements Serializable {
    
    @Id
    private int cedula;
    private String nombre;
    private String direccion;
    
    @OneToMany(mappedBy="administrador")
    private LinkedList<Proyecto> listaProyectos;

    public Administrador() {
    }

    public Administrador(int cedula, String nombre, String direccion, LinkedList<Proyecto> listaProyectos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaProyectos = listaProyectos;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LinkedList<Proyecto> getListaProyectos() {
        return listaProyectos;
    }

    public void setListaProyectos(LinkedList<Proyecto> listaProyectos) {
        this.listaProyectos = listaProyectos;
    }

    

    
    
    
}
