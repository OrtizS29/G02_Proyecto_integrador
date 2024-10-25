
package Modelo.entities;

import Modelo.entities.Pago;
import Modelo.entities.Cliente;
import Modelo.entities.Asesor;
import Modelo.entities.Apartamento;
import java.io.Serializable;
import java.util.LinkedList;
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
    private int id_venta;
    private int precio_base;
    private int numero_coutas;
    private int precio_final;
    
    @Column(nullable = false)
    private Integer intereses;
    private int numero_apartamentos_comprados;
    
    @OneToMany(mappedBy = "venta")
    private LinkedList<Apartamento> listaApartamentos;
    
    @OneToMany(mappedBy = "venta")
    private LinkedList<Pago> listaPagos;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "Cedula_asesor", referencedColumnName = "Cedula")
    private Asesor asesor;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "Cedula_cliente", referencedColumnName = "Cedula")
    private Cliente cliente;

    public Venta() {
    }

    public Venta(int id_venta, int precio_base, int numero_coutas, int precio_final, Integer intereses, int numero_apartamentos_comprados, LinkedList<Apartamento> listaApartamentos, LinkedList<Pago> listaPagos, Asesor asesor, Cliente cliente) {
        this.id_venta = id_venta;
        this.precio_base = precio_base;
        this.numero_coutas = numero_coutas;
        this.precio_final = precio_final;
        this.intereses = intereses;
        this.numero_apartamentos_comprados = numero_apartamentos_comprados;
        this.listaApartamentos = listaApartamentos;
        this.listaPagos = listaPagos;
        this.asesor = asesor;
        this.cliente = cliente;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(int precio_base) {
        this.precio_base = precio_base;
    }

    public int getNumero_coutas() {
        return numero_coutas;
    }

    public void setNumero_coutas(int numero_coutas) {
        this.numero_coutas = numero_coutas;
    }

    public int getPrecio_final() {
        return precio_final;
    }

    public void setPrecio_final(int precio_final) {
        this.precio_final = precio_final;
    }

    public Integer getIntereses() {
        return intereses;
    }

    public void setIntereses(Integer intereses) {
        this.intereses = intereses;
    }

    public int getNumero_apartamentos_comprados() {
        return numero_apartamentos_comprados;
    }

    public void setNumero_apartamentos_comprados(int numero_apartamentos_comprados) {
        this.numero_apartamentos_comprados = numero_apartamentos_comprados;
    }

    public LinkedList<Apartamento> getListaApartamentos() {
        return listaApartamentos;
    }

    public void setListaApartamentos(LinkedList<Apartamento> listaApartamentos) {
        this.listaApartamentos = listaApartamentos;
    }

    public LinkedList<Pago> getListaPagos() {
        return listaPagos;
    }

    public void setListaPagos(LinkedList<Pago> listaPagos) {
        this.listaPagos = listaPagos;
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
