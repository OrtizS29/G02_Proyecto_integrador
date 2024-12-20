
package Modelo.entities;

import Modelo.entities.Pago;
import Modelo.entities.Cliente;
import Modelo.entities.Asesor;
import Modelo.entities.Apartamento;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
 * Clase que determina la entidad Venta
 * 
 * @author Santiago
 */
@Entity
@Table(name = "Venta")
public class Venta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="seq_idVenta")
    @SequenceGenerator(name = "seq_idVenta", sequenceName = "seq_idVenta", allocationSize = 1)
    private Long id_venta;
    private BigDecimal precio_base;//
    @Column(name = "Numero_cuotas")
    private int numero_coutas;//
    private BigDecimal precio_final;
    private Date fecha;//
    @Column(nullable = false)
    private BigDecimal intereses;//
    
    @OneToMany(mappedBy = "venta",cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Apartamento> listaApartamentos;//
    
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Pago> listaPagos;//
    
    @OneToMany(mappedBy = "venta",cascade = CascadeType.ALL)
    private ArrayList<Deuda> listaDeuda;//
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "Cedula_asesor", referencedColumnName = "Cedula",nullable = false)
    private Asesor asesor;//
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "Cedula_cliente", referencedColumnName = "Cedula")
    private Cliente cliente;//

    public Venta() {
    }

    public Venta(Long id_venta, BigDecimal precio_base, int numero_coutas, BigDecimal precio_final, Date fecha, BigDecimal intereses, ArrayList<Apartamento> listaApartamentos, ArrayList<Pago> listaPagos, ArrayList<Deuda> listaDeuda, Asesor asesor, Cliente cliente) {
        this.id_venta = id_venta;
        this.precio_base = precio_base;
        this.numero_coutas = numero_coutas;
        this.precio_final = precio_final;
        this.fecha = fecha;
        this.intereses = intereses;
        this.listaApartamentos = listaApartamentos;
        this.listaPagos = listaPagos;
        this.listaDeuda = listaDeuda;
        this.asesor = asesor;
        this.cliente = cliente;
    }

    public Long getId_venta() {
        return id_venta;
    }

    public void setId_venta(Long id_venta) {
        this.id_venta = id_venta;
    }

    public BigDecimal getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(BigDecimal precio_base) {
        this.precio_base = precio_base;
    }

    public int getNumero_coutas() {
        return numero_coutas;
    }

    public void setNumero_coutas(int numero_coutas) {
        this.numero_coutas = numero_coutas;
    }

    public BigDecimal getPrecio_final() {
        return precio_final;
    }

    public void setPrecio_final(BigDecimal precio_final) {
        this.precio_final = precio_final;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getIntereses() {
        return intereses;
    }

    public void setIntereses(BigDecimal intereses) {
        this.intereses = intereses;
    }

    public ArrayList<Apartamento> getListaApartamentos() {
        return listaApartamentos;
    }

    public void setListaApartamentos(ArrayList<Apartamento> listaApartamentos) {
        this.listaApartamentos = listaApartamentos;
    }

    public ArrayList<Pago> getListaPagos() {
        return listaPagos;
    }

    public void setListaPagos(ArrayList<Pago> listaPagos) {
        this.listaPagos = listaPagos;
    }

    public ArrayList<Deuda> getListaDeuda() {
        return listaDeuda;
    }

    public void setListaDeuda(ArrayList<Deuda> listaDeuda) {
        this.listaDeuda = listaDeuda;
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
