
package Modelo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
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
    private Long cedula;
    private String nombre;
    private String direccion;
    
    @Column(nullable = true)
    private String correo;
    
    @Column(nullable = true)
    private int telefono;
    
    @OneToMany(mappedBy = "asesor")
    private ArrayList<Venta> listaVentas;
    
    @OneToMany(mappedBy = "asesor")
    private ArrayList<Pago> listaPagos;

    public Asesor() {
    }

    public Asesor(Long cedula, String nombre, String direccion, String correo, int telefono, ArrayList<Venta> listaVentas, ArrayList<Pago> listaPagos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.listaVentas = listaVentas;
        this.listaPagos = listaPagos;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
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
