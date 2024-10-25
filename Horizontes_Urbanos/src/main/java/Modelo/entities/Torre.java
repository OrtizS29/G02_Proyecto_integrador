
package Modelo.entities;

import Modelo.entities.Proyecto;
import Modelo.entities.Apartamento;
import java.io.Serializable;
import java.util.LinkedList;
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
 * Clase que determina la entidad Torre
 * 
 * @author Santiago
 */
@Entity
@Table(name = "TORRE")
public class Torre implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="seq_idTorre")
    @SequenceGenerator(name = "seq_idTorre", sequenceName = "seq_idTorre", allocationSize = 1)
    private int id_torre;
    private String nombre_torre;
    private int numero_apartamento;
    
    @OneToMany(mappedBy = "torre",cascade = CascadeType.ALL)
    private LinkedList<Apartamento> listaApartamentos;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "Id_torre", referencedColumnName = "Id_torre")
    private Proyecto proyecto;

    public Torre() {
    }

    public Torre(int id_torre, String nombre_torre, int numero_apartamento, LinkedList<Apartamento> listaApartamentos, Proyecto proyecto) {
        this.id_torre = id_torre;
        this.nombre_torre = nombre_torre;
        this.numero_apartamento = numero_apartamento;
        this.listaApartamentos = listaApartamentos;
        this.proyecto = proyecto;
    }

    public int getId_torre() {
        return id_torre;
    }

    public void setId_torre(int id_torre) {
        this.id_torre = id_torre;
    }

    public String getNombre_torre() {
        return nombre_torre;
    }

    public void setNombre_torre(String nombre_torre) {
        this.nombre_torre = nombre_torre;
    }

    public int getNumero_apartamento() {
        return numero_apartamento;
    }

    public void setNumero_apartamento(int numero_apartamento) {
        this.numero_apartamento = numero_apartamento;
    }

    public LinkedList<Apartamento> getListaApartamentos() {
        return listaApartamentos;
    }

    public void setListaApartamentos(LinkedList<Apartamento> listaApartamentos) {
        this.listaApartamentos = listaApartamentos;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    
    
}
