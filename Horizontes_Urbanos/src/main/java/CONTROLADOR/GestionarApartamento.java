
package CONTROLADOR;

import Modelo.entities.Apartamento;
import Modelo.entities.Torre;
import Modelo.entities.Venta;
import Modelo.persistir.PersistirApartamento;
import Modelo.persistir.PersistirTorre;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class GestionarApartamento implements Gestionar<Apartamento>{
    
    private PersistirApartamento persisApto;
    private PersistirTorre persisTorre;

    public GestionarApartamento() {
        persisTorre = new PersistirTorre();
        persisApto = new PersistirApartamento();
    }

    public void guardarApartamento(int num_apartemento,int valor_apartamento,String tipo_unidad,
            double area,String matricula,Date fecha_escritura,Torre torre,Venta venta) throws Exception{
        Apartamento apartamento = new Apartamento();
        apartamento.setNum_apartamento(num_apartemento);
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
    public Apartamento guardar(Apartamento entidad) {
        try {
            persisApto.crear(entidad);
        } catch (Exception ex) {
            Logger.getLogger(GestionarApartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entidad;
    }

    @Override
    public Apartamento buscarPorId(int id) {
        Apartamento apto = null;
        apto = persisApto.obtener(id);
        return apto;
    }

    public void editarApto(Apartamento apto, int numeroApartamento, int valorApartamento, String tipoUnidad, double area, String matricula, Date fechaEscritura) throws Exception {
        
        apto.setNum_apartamento(numeroApartamento);
        apto.setValor_apartamento(valorApartamento);
        apto.setTipo_unidad(tipoUnidad);
        apto.setArea(area);
        apto.setMatricula(matricula);
        apto.setFecha_escritura(fechaEscritura);
        persisApto.editar(apto);
    }

    @Override
    public void editar(Apartamento entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void borrarA(int id,Torre torreSeleccionada) {
        try {
            
            Apartamento apto = persisApto.obtener(id);
            
            torreSeleccionada.getListaApartamentos().remove(apto);
             persisTorre.editar(torreSeleccionada);
            persisApto.eliminar(id);
        
        } catch (Exception ex) {
            Logger.getLogger(GestionarApartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Apartamento> obtenerApartamentoTorres(int id){
        Torre torre = persisTorre.obtener(id);
        return torre.getListaApartamentos();
    }

    @Override
    public void borrar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
