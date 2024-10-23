
package Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Clase que determina la entidad Correo Asesor
 * 
 * @author Santiago
 */
@Entity
@Table(name = "Correo_asesor")
public class Correo_asesor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="seq_idcoase")
    @SequenceGenerator(name = "seq_idcoase", sequenceName = "seq_idcoase", allocationSize = 1)
    private int id;
    
    @Column(nullable = true)
    private String correo;
    
    @ManyToOne
    @JoinColumn(name = "Cedula_administrador", referencedColumnName = "Cedula")
    private Administrador administrador;
    
}
