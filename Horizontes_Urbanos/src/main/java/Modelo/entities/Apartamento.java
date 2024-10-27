
package Modelo.entities;

import java.io.Serializable;
import java.sql.Date;
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
 * Clase que determina la entidad Apartamento
 * 
 * @author Santiago
 */
@Entity
@Table(name = "Apartamento")
public class Apartamento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="seq_idApartamento")
    @SequenceGenerator(name = "seq_idApartamento", sequenceName = "seq_idApartamento", allocationSize = 1)
    private int id_apartamento;
    private int num_apartamento;
    private int valor_apartamento;
    private String tipo_unidad;
    private double area;
    private String matricula;
    @Column(nullable = true)
    private Date fecha_escritura;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "Id_torre", referencedColumnName = "Id_torre")
    private Torre torre;
    
    @ManyToOne(optional=true)
    @JoinColumn(name = "Id_venta", referencedColumnName = "Id_venta")
    private Venta venta;

    public Apartamento() {
    }

    public Apartamento(int id_apartamento, int num_apartemento, int valor_apartamento, String tipo_unidad, double area, String matricula, Date fecha_escritura, Torre torre, Venta venta) {
        this.id_apartamento = id_apartamento;
        this.num_apartamento = num_apartemento;
        this.valor_apartamento = valor_apartamento;
        this.tipo_unidad = tipo_unidad;
        this.area = area;
        this.matricula = matricula;
        this.fecha_escritura = fecha_escritura;
        this.torre = torre;
        this.venta = venta;
    }

    public int getId_apartamento() {
        return id_apartamento;
    }

    public void setId_apartamento(int id_apartamento) {
        this.id_apartamento = id_apartamento;
    }

    public int getNum_apartamento() {
        return num_apartamento;
    }

    public void setNum_apartamento(int num_apartamento) {
        this.num_apartamento = num_apartamento;
    }

    public int getValor_apartamento() {
        return valor_apartamento;
    }

    public void setValor_apartamento(int valor_apartamento) {
        this.valor_apartamento = valor_apartamento;
    }

    public String getTipo_unidad() {
        return tipo_unidad;
    }

    public void setTipo_unidad(String tipo_unidad) {
        this.tipo_unidad = tipo_unidad;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getFecha_escritura() {
        return fecha_escritura;
    }

    public void setFecha_escritura(Date fecha_escritura) {
        this.fecha_escritura = fecha_escritura;
    }

    public Torre getTorre() {
        return torre;
    }

    public void setTorre(Torre torre) {
        this.torre = torre;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    
            
           
}
