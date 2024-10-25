
package Modelo.entities;

import java.io.Serializable;
import java.util.LinkedList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa la entidad Asesor
 * 
 * author Santiago
 */
@Entity
@Table(name = "Asesor")
public class Asesor implements Serializable {
    
    @Id
    private int cedula;
    private String nombre;
    private String direccion;
    
    @OneToMany(mappedBy = "asesor")
    private LinkedList<Venta> listaVentas;
    
    @OneToMany(mappedBy = "asesor")
    private LinkedList<Pago> listaPagos;
    
    @OneToMany(mappedBy = "asesor",cascade = CascadeType.ALL) 
    private LinkedList<Telefono_asesor> listaTelefonosCliente;
    
    @OneToMany(mappedBy = "asesor",cascade = CascadeType.ALL) 
    private LinkedList<Correo_asesor> listaCorreoCliente;

    public Asesor() {
    }

    public Asesor(int cedula, String nombre, String direccion, LinkedList<Venta> listaVentas, LinkedList<Pago> listaPagos, LinkedList<Telefono_asesor> listaTelefonosCliente, LinkedList<Correo_asesor> listaCorreoCliente) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaVentas = listaVentas;
        this.listaPagos = listaPagos;
        this.listaTelefonosCliente = listaTelefonosCliente;
        this.listaCorreoCliente = listaCorreoCliente;
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

    public LinkedList<Telefono_asesor> getListaTelefonosCliente() {
        return listaTelefonosCliente;
    }

    public void setListaTelefonosCliente(LinkedList<Telefono_asesor> listaTelefonosCliente) {
        this.listaTelefonosCliente = listaTelefonosCliente;
    }

    public LinkedList<Correo_asesor> getListaCorreoCliente() {
        return listaCorreoCliente;
    }

    public void setListaCorreoCliente(LinkedList<Correo_asesor> listaCorreoCliente) {
        this.listaCorreoCliente = listaCorreoCliente;
    }
    
    
    
    
}
