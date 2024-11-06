
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
    private ArrayList<Telefono> listaTelefonos;
    
    @OneToMany(mappedBy = "asesor",cascade = CascadeType.ALL) 
    private ArrayList<Correo> listaCorreos;

    public Asesor() {
    }

    public Asesor(int cedula, String nombre, String direccion, ArrayList<Venta> listaVentas, ArrayList<Pago> listaPagos, ArrayList<Telefono> listaTelefonos, ArrayList<Correo> listaCorreos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaVentas = listaVentas;
        this.listaPagos = listaPagos;
        this.listaTelefonos = listaTelefonos;
        this.listaCorreos = listaCorreos;
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

    public ArrayList<Telefono> getListaTelefonos() {
        return listaTelefonos;
    }

    public void setListaTelefonos(ArrayList<Telefono> listaTelefonos) {
        this.listaTelefonos = listaTelefonos;
    }

    public ArrayList<Correo> getListaCorreos() {
        return listaCorreos;
    }

    public void setListaCorreos(ArrayList<Correo> listaCorreo) {
        this.listaCorreos = listaCorreo;
    }
}
