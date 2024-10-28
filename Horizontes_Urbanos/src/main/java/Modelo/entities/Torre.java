
package Modelo.entities;

import Modelo.entities.Proyecto;
import Modelo.entities.Apartamento;
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
    private int numero_torre;
    private int numero_apartamentos;
    
    @OneToMany(mappedBy = "torre",cascade = CascadeType.ALL,orphanRemoval = true)
    private ArrayList<Apartamento> listaApartamentos;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "Id_proyecto", referencedColumnName = "Id_proyecto",nullable = false)
    private Proyecto proyecto;

    public Torre() {
    }

    public Torre(int id_torre, int numero_torre, int numero_apartamento, ArrayList<Apartamento> listaApartamentos, Proyecto proyecto) {
        this.id_torre = id_torre;
        this.numero_torre = numero_torre;
        this.numero_apartamentos = numero_apartamento;
        this.listaApartamentos = listaApartamentos;
        this.proyecto = proyecto;
    }

    public int getId_torre() {
        return id_torre;
    }

    public void setId_torre(int id_torre) {
        this.id_torre = id_torre;
    }

    public int getNumero_torre() {
        return numero_torre;
    }

    public void setNumero_torre(int numero_torre) {
        this.numero_torre = numero_torre;
    }

    public int getNumero_apartamentos() {
        return numero_apartamentos;
    }

    public void setNumero_apartamentos(int numero_apartamentos) {
        this.numero_apartamentos = numero_apartamentos;
    }

    public ArrayList<Apartamento> getListaApartamentos() {
        return listaApartamentos;
    }

    public void setListaApartamentos(ArrayList<Apartamento> listaApartamentos) {
        this.listaApartamentos = listaApartamentos;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    
    
}
