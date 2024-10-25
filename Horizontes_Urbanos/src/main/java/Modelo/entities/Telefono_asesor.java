
package Modelo.entities;

import Modelo.entities.Asesor;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Clase que determina la entidad Telefono Asesor
 * 
 * @author Santiago
 */
@Entity
@Table(name = "Telefono_asesor")
public class Telefono_asesor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="seq_idTelAse")
    @SequenceGenerator(name = "seq_idTelAse", sequenceName = "seq_idTelAse", allocationSize = 1)
    private int id;
    
    @Column(nullable = true)
    private Integer telefono;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "Cedula_asesor", referencedColumnName = "Cedula")
    private Asesor asesor;

    public Telefono_asesor() {
    }

    public Telefono_asesor(int id, Integer telefono, Asesor asesor) {
        this.id = id;
        this.telefono = telefono;
        this.asesor = asesor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Asesor getAsesor() {
        return asesor;
    }

    public void setAsesor(Asesor asesor) {
        this.asesor = asesor;
    }
    
    
}
