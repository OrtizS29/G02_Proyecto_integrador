
package Modelo.entities;

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
 * Clase que determina la entidad Telefono
 * 
 * @author Santiago
 */
@Entity
@Table(name = "Telefono")
public class Telefono implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="seq_idTelefono")
    @SequenceGenerator(name = "seq_idTelefono", sequenceName = "seq_idTelefono", allocationSize = 1)
    private int id;
    
    @Column(nullable = true)
    private int telefono;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "Cedula_asesor", referencedColumnName = "Cedula")
    private Asesor asesor;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "Cedula_cliente", referencedColumnName = "Cedula")
    private Cliente cliente;
    /*
    @ManyToOne(optional=false)
    @JoinColumn(name = "Cedula_administrador", referencedColumnName = "Cedula")
    private Administrador admin;*/

    public Telefono() {
    }

    public Telefono(int id, int telefono, Asesor asesor, Cliente cliente) {
        this.id = id;
        this.telefono = telefono;
        this.asesor = asesor;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Asesor getAsesor() {
        return asesor;
    }

    public void setAsesor(Asesor asesor) {
        this.asesor = asesor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}