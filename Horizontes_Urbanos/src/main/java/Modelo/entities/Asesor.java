
package Modelo.entities;

import java.io.Serializable;
import java.util.ArrayList;
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
    private ArrayList<Venta> listaVentas;
    
    @OneToMany(mappedBy = "asesor")
    private ArrayList<Pago> listaPagos;
    
    @OneToMany(mappedBy = "asesor",cascade = CascadeType.ALL) 
    private ArrayList<Telefono_asesor> listaTelefonosCliente;
    
    @OneToMany(mappedBy = "asesor",cascade = CascadeType.ALL) 
    private ArrayList<Correo_asesor> listaCorreoCliente;

    public Asesor() {
    }

    public Asesor(int cedula, String nombre, String direccion, ArrayList<Venta> listaVentas, ArrayList<Pago> listaPagos, ArrayList<Telefono_asesor> listaTelefonosCliente, ArrayList<Correo_asesor> listaCorreoCliente) {
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

    public ArrayList<Telefono_asesor> getListaTelefonosCliente() {
        return listaTelefonosCliente;
    }

    public void setListaTelefonosCliente(ArrayList<Telefono_asesor> listaTelefonosCliente) {
        this.listaTelefonosCliente = listaTelefonosCliente;
    }

    public ArrayList<Correo_asesor> getListaCorreoCliente() {
        return listaCorreoCliente;
    }

    public void setListaCorreoCliente(ArrayList<Correo_asesor> listaCorreoCliente) {
        this.listaCorreoCliente = listaCorreoCliente;
    }
    
    
    
}
