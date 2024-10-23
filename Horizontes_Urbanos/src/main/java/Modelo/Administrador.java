
package Modelo;

import java.io.Serializable;
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
public class Administrador implements Serializable {
    
    @Id
    private int cedula;
    private String nombre;
    private String direccion;
    
    @OneToMany(mappedBy="administrador")
    private LinkedList<Apartamento> listaApartamentos;

    public Administrador() {
    }

    public Administrador(int cedula, String nombre, String direccion, LinkedList<Apartamento> listaApartamentos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaApartamentos = listaApartamentos;
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

    public LinkedList<Apartamento> getListaApartamentos() {
        return listaApartamentos;
    }

    public void setListaApartamentos(LinkedList<Apartamento> listaApartamentos) {
        this.listaApartamentos = listaApartamentos;
    }

    
    
    
    
    
}
