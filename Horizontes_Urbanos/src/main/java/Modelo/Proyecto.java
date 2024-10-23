
package Modelo;

import Modelo.Administrador;
import java.io.Serializable;
import java.util.LinkedList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que determina la entidad Proyecto
 * 
 * @author Santiago
 */
@Entity
@Table(name = "Proyecto")
public class Proyecto implements Serializable {
    
    @Id
    private int id_proyecto;
    private String nombre_proyecto; 
    private int numero_torres;
    
    @OneToMany(mappedBy = "proyecto",cascade = CascadeType.ALL) 
    private LinkedList<Torre> listaTorres;
    
    @ManyToOne
    @JoinColumn(name = "Cedula_administrador", referencedColumnName = "Cedula")
    private Administrador administrador;

    public Proyecto() {
    }

    public Proyecto(int id_proyecto, String nombre_proyecto, int numero_torres, LinkedList<Torre> listaTorres, Administrador administrador) {
        this.id_proyecto = id_proyecto;
        this.nombre_proyecto = nombre_proyecto;
        this.numero_torres = numero_torres;
        this.listaTorres = listaTorres;
        this.administrador = administrador;
    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }

    public int getNumero_torres() {
        return numero_torres;
    }

    public void setNumero_torres(int numero_torres) {
        this.numero_torres = numero_torres;
    }

    public LinkedList<Torre> getListaTorres() {
        return listaTorres;
    }

    public void setListaTorres(LinkedList<Torre> listaTorres) {
        this.listaTorres = listaTorres;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    
    
    
}
