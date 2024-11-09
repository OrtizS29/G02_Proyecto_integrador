
package Modelo.entities;

import java.io.Serializable;
import java.util.ArrayList;
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
    private Long cedula;
    private String nombre;
    private String direccion;
    
    @OneToMany(mappedBy="administrador")
    private ArrayList<Proyecto> listaProyectos;

    public Administrador() {
    }

    public Administrador(Long cedula, String nombre, String direccion, ArrayList<Proyecto> listaProyectos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaProyectos = listaProyectos;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
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

    public ArrayList<Proyecto> getListaProyectos() {
        return listaProyectos;
    }

    public void setListaProyectos(ArrayList<Proyecto> listaProyectos) {
        this.listaProyectos = listaProyectos;
    }
}
