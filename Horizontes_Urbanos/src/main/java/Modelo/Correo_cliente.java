
package Modelo;

import Modelo.Cliente;
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
 * Clase que determina la entidad Correo Cliente
 * 
 * @author Santiago
 */
@Entity
@Table(name = "Correo_cliente")
public class Correo_cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="seq_idCoCli")
    @SequenceGenerator(name = "seq_idCoCli", sequenceName = "seq_idCoCli", allocationSize = 1)
    private int id;
    
    @Column(nullable = true)
    private String correo;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "Cedula_cliente", referencedColumnName = "Cedula")
    private Cliente cliente;

    public Correo_cliente() {
    }

    public Correo_cliente(int id, String correo, Cliente cliente) {
        this.id = id;
        this.correo = correo;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
