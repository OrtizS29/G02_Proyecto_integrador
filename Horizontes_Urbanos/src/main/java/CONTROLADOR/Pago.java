
package CONTROLADOR;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que determina la entidad Pago
 * 
 * @author Santiago
 */
@Entity
@Table(name = "Pago")
public class Pago {
    
    @Id
    private int id_pago;
    private Date fecha;
    private int valor_pago;
    
    @ManyToOne
    @JoinColumn(name = "Id_venta", referencedColumnName = "Id_venta")
    private Venta venta;
    
    @ManyToOne
    @JoinColumn(name = "Cedula_asesor", referencedColumnName = "Cedula")
    private Asesor asesor;
    
    @ManyToOne
    @JoinColumn(name = "Cedula_cliente", referencedColumnName = "Cedula")
    private Cliente cliente;
    
    /**
     * Falta poner llaves foraneas
     */
}
