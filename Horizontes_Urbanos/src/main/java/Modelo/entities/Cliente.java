
package Modelo.entities;

import java.io.Serializable;
import java.util.ArrayList;
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
    private ArrayList<Telefono> listaTelefonosCliente;
    
    @OneToMany(mappedBy = "cliente")
    private ArrayList<Correo> listaCorreosCliente;
    
    @OneToMany(mappedBy = "cliente")
    private ArrayList<Venta> listaVentas;
    
    @OneToMany(mappedBy = "cliente")
    private ArrayList<Pago> listaPagos;

    public Cliente() {
    }

    public Cliente(int cedula, String nombre, String direccion, Integer subsidio_ministerio, Integer sisben, ArrayList<Telefono> listaTelefonosCliente, ArrayList<Correo> listaCorreosCliente, ArrayList<Venta> listaVentas, ArrayList<Pago> listaPagos) {
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

    public ArrayList<Telefono> getListaTelefonosCliente() {
        return listaTelefonosCliente;
    }

    public void setListaTelefonosCliente(ArrayList<Telefono> listaTelefonosCliente) {
        this.listaTelefonosCliente = listaTelefonosCliente;
    }

    public ArrayList<Correo> getListaCorreosCliente() {
        return listaCorreosCliente;
    }

    public void setListaCorreosCliente(ArrayList<Correo> listaCorreosCliente) {
        this.listaCorreosCliente = listaCorreosCliente;
    }

    public ArrayList<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(ArrayList<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public ArrayList<Pago> getListaPagos() {
        return listaPagos;
    }

    public void setListaPagos(ArrayList<Pago> listaPagos) {
        this.listaPagos = listaPagos;
    }

    
}
