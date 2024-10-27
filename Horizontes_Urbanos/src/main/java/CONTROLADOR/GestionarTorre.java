
package CONTROLADOR;

import Modelo.entities.Apartamento;
import Modelo.entities.Proyecto;
import Modelo.entities.Torre;
import Modelo.persistir.PersistirTorre;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class GestionarTorre implements Gestionar<Torre>{

    private PersistirTorre persisTorre;
    
    public GestionarTorre() {
        persisTorre = new PersistirTorre();
    }

    public void guardarTorre(String numero_torre,int numero_apartamento,
            ArrayList<Apartamento> listaApartamentos,Proyecto proyecto) throws Exception{
        Torre torre = new Torre();
        torre.setNumero_torre(numero_apartamento);
        torre.setNumero_apartamento(numero_apartamento);
        torre.setListaApartamentos(listaApartamentos);
        torre.setProyecto(proyecto);
        persisTorre.crear(torre);
    }
    
    @Override
    public Torre guardar(Torre entidad) {
        try {
            persisTorre.crear(entidad);
        } catch (Exception ex) {
            Logger.getLogger(GestionarTorre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entidad;
    }

    @Override
    public Torre buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar(Torre entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void borrar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
