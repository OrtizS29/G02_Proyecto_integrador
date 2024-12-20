
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
    private Long cedula;
    private String nombre;
    private String direccion;
    
    @Column(nullable = true)
    private Long subsidio_ministerio;
    
    @Column(nullable = true)
    private String sisben;

    @Column(nullable = true)
    private String correo;
    
    @Column(nullable = true)
    private Long telefono;
    
    @OneToMany(mappedBy = "cliente")
    private ArrayList<Venta> listaVentas;
    
    @OneToMany(mappedBy = "cliente")
    private ArrayList<Pago> listaPagos;

    public Cliente() {
    }

    public Cliente(Long cedula, String nombre, String direccion, Long subsidio_ministerio, String sisben, String correo, Long telefono, ArrayList<Venta> listaVentas, ArrayList<Pago> listaPagos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.subsidio_ministerio = subsidio_ministerio;
        this.sisben = sisben;
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

    public Long getSubsidio_ministerio() {
        return subsidio_ministerio;
    }

    public void setSubsidio_ministerio(Long subsidio_ministerio) {
        this.subsidio_ministerio = subsidio_ministerio;
    }

    public String getSisben() {
        return sisben;
    }

    public void setSisben(String sisben) {
        this.sisben = sisben;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
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
