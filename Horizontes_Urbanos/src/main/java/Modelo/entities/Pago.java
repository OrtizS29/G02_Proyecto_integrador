
package Modelo.entities;

import Modelo.entities.Cliente;
import Modelo.entities.Asesor;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Clase que determina la entidad Pago
 * 
 * @author Santiago
 */
@Entity
@Table(name = "Pago")
public class Pago implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="seq_idPago")
    @SequenceGenerator(name = "seq_idPago", sequenceName = "seq_idPago", allocationSize = 1)
    private int id_pago;
    private Date fecha;
    private int valor_pago;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "Id_venta", referencedColumnName = "Id_venta")
    private Venta venta;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "Cedula_asesor", referencedColumnName = "Cedula")
    private Asesor asesor;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "Cedula_cliente", referencedColumnName = "Cedula")
    private Cliente cliente;

    public Pago() {
    }

    public Pago(int id_pago, Date fecha, int valor_pago, Venta venta, Asesor asesor, Cliente cliente) {
        this.id_pago = id_pago;
        this.fecha = fecha;
        this.valor_pago = valor_pago;
        this.venta = venta;
        this.asesor = asesor;
        this.cliente = cliente;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(int valor_pago) {
        this.valor_pago = valor_pago;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
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
