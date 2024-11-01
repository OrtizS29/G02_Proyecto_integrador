
package CONTROLADOR;

import Modelo.entities.Apartamento;
import Modelo.entities.Proyecto;
import Modelo.entities.Torre;
import Modelo.persistir.PersistirApartamento;
import Modelo.persistir.PersistirTorre;
import Modelo.persistir.PersistirProyecto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class GestionarTorre {

    private PersistirTorre persisTorre;
    private PersistirProyecto persisProyecto;
    private PersistirApartamento persisApartamento;
    
    public GestionarTorre() {
        persisTorre = new PersistirTorre();
        persisProyecto = new PersistirProyecto();
        persisApartamento = new PersistirApartamento();
    }

    public void guardarTorre(String numero_torre,int numero_apartamento,
            ArrayList<Apartamento> listaApartamentos,Proyecto proyecto) throws Exception{
        Torre torre = new Torre();
        torre.setNumero_torre(numero_apartamento);
        torre.setNumero_apartamentos(numero_apartamento);
        torre.setListaApartamentos(listaApartamentos);
        torre.setProyecto(proyecto);
        persisTorre.crear(torre);
    }
    
    
    public Torre guardar(Torre torre) {
        try {
            persisTorre.crear(torre);
        } catch (Exception ex) {
            Logger.getLogger(GestionarTorre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return torre;
    }

    
    public Torre buscarPorId(int id) {
        Torre torre = null;
        torre = persisTorre.obtener(id);
        return torre;
    }

    
    public void editar(Torre torre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean borrarT(Proyecto proyectoSeleccionado, int id_torre) throws Exception {
        
        if (proyectoSeleccionado.getListaTorres().size()==1) {
            return false;
        }
        else{
            
            Torre torre = persisTorre.obtener(id_torre);
        
            for (Apartamento apartamento : new ArrayList<>(torre.getListaApartamentos())) {
                persisApartamento.eliminar(apartamento.getId_apartamento());
            }
            
            persisTorre.eliminar(torre.getId_torre());
            
            return true;
        }
            
    }

    
    public void borrar(int id) {
        
    }
    
    public List<Torre> obtenerTorresProyecto(int id){
        Proyecto proyecto = persisProyecto.obtener(id);
        return proyecto.getListaTorres();
    }

    public void editarTorre(Torre torre, int numeroTorre, int numeroAptos) throws Exception {
        
        torre.setNumero_torre(numeroTorre);
        torre.setNumero_apartamentos(numeroAptos);
        persisTorre.editarNumeroYNumeroT(torre);
    }

    
}
