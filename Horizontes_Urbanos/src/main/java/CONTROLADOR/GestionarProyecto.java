
package CONTROLADOR;

import Modelo.entities.Administrador;
import Modelo.entities.Proyecto;
import Modelo.entities.Torre;
import Modelo.persistir.PersistirAdministrador;
import Modelo.persistir.PersistirProyecto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class GestionarProyecto implements Gestionar<Proyecto> {
    
    private PersistirProyecto persisProyecto;
    private PersistirAdministrador persisAdmin;

    public GestionarProyecto() {
        persisProyecto = new PersistirProyecto();
        persisAdmin = new PersistirAdministrador();
    }

    public void guardarProyecto(String nombre_proyecto,int numero_torres,
            Administrador administrador) throws Exception{
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre_proyecto(nombre_proyecto);
        proyecto.setNumero_torres(numero_torres);
        proyecto.setListaTorres(new ArrayList<>());
        proyecto.setAdministrador(administrador);
        persisProyecto.crear(proyecto);
    }
    
    @Override
    public Proyecto guardar(Proyecto entidad) {
        try {
            persisProyecto.crear(entidad);
        } catch (Exception ex) {
            Logger.getLogger(GestionarProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entidad;
            
        
    }

    @Override
    public Proyecto buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar(Proyecto entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void borrar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<Proyecto> obtenerProyectosAdmin() throws Exception{
        Administrador administrador = persisAdmin.obtener(68293849);
        return administrador.getListaProyectos();
    }
    
}
