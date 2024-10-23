
package Modelo;

import Modelo.Pago;
import Modelo.Cliente;
import Modelo.Asesor;
import Modelo.Apartamento;
import java.util.LinkedList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que determina la entidad Venta
 * 
 * @author Santiago
 */
@Entity
@Table(name = "Venta")
public class Venta {
    
    @Id
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
    
    @ManyToOne
    @JoinColumn(name = "Cedula_cliente", referencedColumnName = "Cedula")
    private Cliente cliente;
    
    
}
