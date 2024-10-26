
package CONTROLADOR;

import Modelo.entities.Apartamento;
import Modelo.entities.Torre;
import Modelo.entities.Venta;
import Modelo.persistir.PersistirApartamento;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class GestionarApartamento implements Gestionar<Apartamento>{
    
    private PersistirApartamento persisApto;

    public GestionarApartamento() {
        persisApto = new PersistirApartamento();
    }

    public void guardarApartamento(int num_apartemento,int valor_apartamento,String tipo_unidad,
            double area,String matricula,Date fecha_escritura,Torre torre,Venta venta) throws Exception{
        Apartamento apartamento = new Apartamento();
        apartamento.setNum_apartemento(num_apartemento);
        apartamento.setValor_apartamento(valor_apartamento);
        apartamento.setTipo_unidad(tipo_unidad);
        apartamento.setArea(area);
        apartamento.setMatricula(matricula);
        apartamento.setFecha_escritura(fecha_escritura);
        apartamento.setTorre(torre);
        apartamento.setVenta(venta);
        persisApto.crear(apartamento);
    }
    
    @Override
    public void guardar(Apartamento entidad) {
        try {
            persisApto.crear(entidad);
        } catch (Exception ex) {
            Logger.getLogger(GestionarApartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Apartamento buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar(Apartamento entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void borrar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
