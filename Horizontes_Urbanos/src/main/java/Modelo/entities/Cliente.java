
package Modelo.entities;

import java.io.Serializable;
import java.util.LinkedList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que determina la entidad Cliente
 * 
 * @author Santiago
 */
@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {
    
    @Id
    private int cedula;
    private String nombre;
    private String direccion;
    
    @Column(nullable = true)
    private Integer subsidio_ministerio;
    
    @Column(nullable = true)
    private Integer sisben;
    
    @OneToMany(mappedBy = "cliente")
    private LinkedList<Telefono_cliente> listaTelefonosCliente;
    
    @OneToMany(mappedBy = "cliente")
    private LinkedList<Correo_cliente> listaCorreosCliente;
    
    @OneToMany(mappedBy = "cliente")
    private LinkedList<Venta> listaVentas;
    
    @OneToMany(mappedBy = "cliente")
    private LinkedList<Pago> listaPagos;

    public Cliente() {
    }

    public Cliente(int cedula, String nombre, String direccion, Integer subsidio_ministerio, Integer sisben, LinkedList<Telefono_cliente> listaTelefonosCliente, LinkedList<Correo_cliente> listaCorreosCliente, LinkedList<Venta> listaVentas, LinkedList<Pago> listaPagos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.subsidio_ministerio = subsidio_ministerio;
        this.sisben = sisben;
        this.listaTelefonosCliente = listaTelefonosCliente;
        this.listaCorreosCliente = listaCorreosCliente;
        this.listaVentas = listaVentas;
        this.listaPagos = listaPagos;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getSubsidio_ministerio() {
        return subsidio_ministerio;
    }

    public void setSubsidio_ministerio(Integer subsidio_ministerio) {
        this.subsidio_ministerio = subsidio_ministerio;
    }

    public Integer getSisben() {
        return sisben;
    }

    public void setSisben(Integer sisben) {
        this.sisben = sisben;
    }

    public LinkedList<Telefono_cliente> getListaTelefonosCliente() {
        return listaTelefonosCliente;
    }

    public void setListaTelefonosCliente(LinkedList<Telefono_cliente> listaTelefonosCliente) {
        this.listaTelefonosCliente = listaTelefonosCliente;
    }

    public LinkedList<Correo_cliente> getListaCorreosCliente() {
        return listaCorreosCliente;
    }

    public void setListaCorreosCliente(LinkedList<Correo_cliente> listaCorreosCliente) {
        this.listaCorreosCliente = listaCorreosCliente;
    }

    public LinkedList<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(LinkedList<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public LinkedList<Pago> getListaPagos() {
        return listaPagos;
    }

    public void setListaPagos(LinkedList<Pago> listaPagos) {
        this.listaPagos = listaPagos;
    }
    
    
}
