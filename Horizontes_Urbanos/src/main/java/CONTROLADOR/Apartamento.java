
package CONTROLADOR;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que determina la entidad Apartamento
 * 
 * @author Santiago
 */
@Entity
@Table(name = "Apartamento")
public class Apartamento {
    
    @Id
    private int Id_apartamento;
    private int Num_apartemento;
    private int valor_apartamento;
    private String Tipo_unidad;
    private double Area;
    private String Matricula;
    private Date Fecha_escritura;
    
    @ManyToOne
    @JoinColumn(name = "Id_torre", referencedColumnName = "Id_torre")
    private Torre torre;
    
    @ManyToOne
    @JoinColumn(name = "Id_venta", referencedColumnName = "Id_venta")
    private Venta venta;
    /**
     * Falta poner llaves foraneas
     */
            
           
}
