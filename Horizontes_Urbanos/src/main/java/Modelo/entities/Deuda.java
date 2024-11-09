
package Modelo.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
 *
 * @author Santiago
 */
@Entity
@Table(name = "Deuda")
public class Deuda implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="seq_idDeuda")
    @SequenceGenerator(name = "seq_idDeuda", sequenceName = "seq_idDeuda", allocationSize = 1)
    private Long id_deuda;
    private Date fecha_inicia_deuda;
    private BigDecimal valor;
    
    @ManyToOne(optional=true)
    @JoinColumn(name = "Id_venta", referencedColumnName = "Id_venta")
    private Venta venta;

    public Deuda() {
    }

    public Deuda(Long id_deuda, Date fecha_inicia_deuda, BigDecimal valor, Venta venta) {
        this.id_deuda = id_deuda;
        this.fecha_inicia_deuda = fecha_inicia_deuda;
        this.valor = valor;
        this.venta = venta;
    }

    public Long getId_deuda() {
        return id_deuda;
    }

    public void setId_deuda(Long id_deuda) {
        this.id_deuda = id_deuda;
    }

    public Date getFecha_inicia_deuda() {
        return fecha_inicia_deuda;
    }

    public void setFecha_inicia_deuda(Date fecha_inicia_deuda) {
        this.fecha_inicia_deuda = fecha_inicia_deuda;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
}
