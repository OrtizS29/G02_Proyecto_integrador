
package Modelo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="seq_idProyecto")
    @SequenceGenerator(name = "seq_idProyecto", sequenceName = "seq_idProyecto", allocationSize = 1)
    private Long id_proyecto;
    private String nombre_proyecto;
    
    @OneToMany(mappedBy = "proyecto",cascade = CascadeType.ALL, orphanRemoval = true) 
    private ArrayList<Torre> listaTorres;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "Cedula_administrador", referencedColumnName = "Cedula")
    private Administrador administrador;

    public Proyecto() {
    }

    public Proyecto(Long id_proyecto, String nombre_proyecto, ArrayList<Torre> listaTorres, Administrador administrador) {
        this.id_proyecto = id_proyecto;
        this.nombre_proyecto = nombre_proyecto;
        this.listaTorres = listaTorres;
        this.administrador = administrador;
    }

    public Long getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(Long id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }

    public ArrayList<Torre> getListaTorres() {
        return listaTorres;
    }

    public void setListaTorres(ArrayList<Torre> listaTorres) {
        this.listaTorres = listaTorres;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }    
}
