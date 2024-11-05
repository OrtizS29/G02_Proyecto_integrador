
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
 * Clase que determina la entidad Correo 
 * 
 * @author Santiago
 */
@Entity
@Table(name = "Correo")
public class Correo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="seq_idCorreo")
    @SequenceGenerator(name = "seq_idCorreo", sequenceName = "seq_idCorreo", allocationSize = 1)
    private int id;
    
    @Column(nullable = true)
    private String correo;
    
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

    public Correo() {
    }

    public Correo(int id, String correo, Asesor asesor, Cliente cliente) {
        this.id = id;
        this.correo = correo;
        this.asesor = asesor;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    } 
}
