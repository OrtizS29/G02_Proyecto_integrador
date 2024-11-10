
package CONTROLADOR;

import Modelo.entities.Apartamento;
import Modelo.entities.Torre;
import Modelo.entities.Venta;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.persistir.IPersistencia;
import Modelo.persistir.IPersistenciaTorre;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class GestionarApartamento {
    
    private IPersistencia<Apartamento> persisApto;
    private IPersistenciaTorre persisTorre;

    public GestionarApartamento(I_PersistenciaFactory fa) {
        persisTorre = fa.crearPersistirTorre();
        persisApto = fa.crearPersistirApartamento();
    }

    public void guardarApartamento(int num_apartemento,Long valor_apartamento,String tipo_unidad,
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
    
    
    public Apartamento guardar(Apartamento apto) {
        try {
            persisApto.crear(apto);
        } catch (Exception ex) {
            Logger.getLogger(GestionarApartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return apto;
    }

    public Apartamento buscarPorId(Long id) {
        Apartamento apto = null;
        apto = persisApto.obtener(id);
        return apto;
    }

    public void editarApto(Apartamento apto, int numeroApartamento, Long valorApartamento, String tipoUnidad, 
            double area, String matricula, Date fechaEscritura) throws Exception {
        
        apto.setNum_apartamento(numeroApartamento);
        apto.setValor_apartamento(valorApartamento);
        apto.setTipo_unidad(tipoUnidad);
        apto.setArea(area);
        apto.setMatricula(matricula);
        apto.setFecha_escritura(fechaEscritura);
        persisApto.editar(apto);
    }

    public boolean borrarA(Long id,Torre torreSeleccionada) throws Exception {
        if (torreSeleccionada.getListaApartamentos().size()==1) {
            return false;
        }
        else{
            Apartamento apto = persisApto.obtener(id);
            //elimino el apartamento en la BD
            persisApto.eliminar(apto.getId_apartamento());
            //para actualizar la torre
            Torre torreRecargada = persisTorre.obtener(torreSeleccionada.getId_torre());
                
            if (!torreRecargada.getListaApartamentos().contains(apto)) {
                //se actualiza la lista de apartamentos
                torreSeleccionada.setListaApartamentos(torreRecargada.getListaApartamentos());
                return true;
            } 
            else {
                // Si algo salio mal sale esta excepcion
                throw new Exception("El apartamento no se eliminó correctamente de la torre.");
            } 
        }
    }
    
    public List<Apartamento> obtenerApartamentoTorres(Long id){
        Torre torre = persisTorre.obtener(id);
        return torre.getListaApartamentos();
    }


    
    
}
