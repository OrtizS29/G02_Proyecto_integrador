
package Modelo;

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
public class Asesor {
    
    @Id
    private int cedula;
    private String nombre;
    private String direccion;
    
    @OneToMany(mappedBy = "venta")
    private LinkedList<Venta> listaVentas;
    
    @OneToMany(mappedBy = "venta")
    private LinkedList<Pago> listaPagos;
    
    @OneToMany(mappedBy = "asesor",cascade = CascadeType.ALL) 
    private LinkedList<Telefono_asesor> listaTelefonosCliente;
    
    @OneToMany(mappedBy = "asesor",cascade = CascadeType.ALL) 
    private LinkedList<Correo_asesor> listaCorreoCliente;
    
    
}
