
package Modelo.entities;

import Modelo.entities.Cliente;
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
 * Clase que determina la entidad Telefono Cliente
 * 
 * @author Santiago
 */
@Entity
@Table(name = "Telefono_cliente")
public class Telefono_cliente implements Serializable {
     
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="seq_idTelCli")
    @SequenceGenerator(name = "seq_idTelCli", sequenceName = "seq_idTelCli", allocationSize = 1)
    private int id;
    
    @Column(nullable = true)
    private Integer telefono;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "Cedula_cliente", referencedColumnName = "Cedula")
    private Cliente cliente;

    public Telefono_cliente() {
    }

    public Telefono_cliente(int id, Integer telefono, Cliente cliente) {
        this.id = id;
        this.telefono = telefono;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
