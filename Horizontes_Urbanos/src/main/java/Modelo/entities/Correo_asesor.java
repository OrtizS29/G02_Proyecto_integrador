
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
 * Clase que determina la entidad Correo Asesor
 * 
 * @author Santiago
 */
@Entity
@Table(name = "Correo_asesor")
public class Correo_asesor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="seq_idcoase")
    @SequenceGenerator(name = "seq_idcoase", sequenceName = "seq_idcoase", allocationSize = 1)
    private int id;
    
    @Column(nullable = true)
    private String correo;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "Cedula_asesor", referencedColumnName = "Cedula")
    private Asesor asesor;

    public Correo_asesor() {
    } 

    public Correo_asesor(int id, String correo, Asesor asesor) {
        this.id = id;
        this.correo = correo;
        this.asesor = asesor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Asesor getAsesor() {
        return asesor;
    }

    public void setAsesor(Asesor asesor) {
        this.asesor = asesor;
    }
    
    
}
