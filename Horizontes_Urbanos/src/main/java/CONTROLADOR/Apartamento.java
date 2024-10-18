
package CONTROLADOR;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Santiago
 */
@Entity
@Table(name = "APARTAMENTO")
public class Apartamento {
    
    @Id
    private int Id_apartamento;
    private int Num_apartemento;
    private int valor_apartamento;
    private String Tipo_unidad;
    private double Area;
    private String Matricula;
    private Date Fecha_escritura;
    /**
     * Falta poner llaves foraneas
     */
            
           
}
