
package CONTROLADOR;

import Modelo.entities.Administrador;
import Modelo.entities.Apartamento;
import Modelo.entities.Proyecto;
import Modelo.entities.Torre;
import Modelo.persistir.PersistirAdministrador;
import Modelo.persistir.PersistirApartamento;
import Modelo.persistir.PersistirProyecto;
import Modelo.persistir.PersistirTorre;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class GestionarProyecto {
    
    private PersistirAdministrador persisAdmin;
    private PersistirProyecto persisProyecto;
    private PersistirTorre  persisTorre;
    private PersistirApartamento persisApartamento;

    public GestionarProyecto() {
        persisProyecto = new PersistirProyecto();
        persisAdmin = new PersistirAdministrador();
        persisTorre = new PersistirTorre();
        persisApartamento = new PersistirApartamento();
    }

    //Guardar
    public void guardarProyecto(String nombre_proyecto,
            Administrador administrador) throws Exception{
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre_proyecto(nombre_proyecto);
        proyecto.setListaTorres(new ArrayList<>());
        proyecto.setAdministrador(administrador);
        persisProyecto.crear(proyecto);
        //guardar(proyecto);
    }
    
    public Proyecto guardar(Proyecto proyecto) {
        try {
            persisProyecto.crear(proyecto);
        } catch (Exception ex) {
            Logger.getLogger(GestionarProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proyecto;   
    }

    public Proyecto buscarPorId(int id) {
        Proyecto proyecto = null;
        proyecto = persisProyecto.obtener(id);
        return proyecto;
    }

    public void editarProyecto(Proyecto proyect, String nombreProyecto) throws Exception {
        
        proyect.setNombre_proyecto(nombreProyecto);
        persisProyecto.editarNombreYProyecto(proyect);
    }
    
    public void editar(Proyecto proyecto) {
        try {
            persisProyecto.editar(proyecto);
        } catch (Exception ex) {
            Logger.getLogger(GestionarProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrar(int id) {
        try {
            Proyecto proyecto = persisProyecto.obtener(id);
        
            if(proyecto != null){
               
                for (Torre torre : proyecto.getListaTorres()) {
                   
                    for (Apartamento apartamento : new ArrayList<>(torre.getListaApartamentos())) { // Crear una copia
                        persisApartamento.eliminar(apartamento.getId_apartamento());
                    }
                    
                    persisTorre.eliminar(torre.getId_torre());    
                }

                Administrador administrador = proyecto.getAdministrador();
                if (administrador != null) {
                    administrador.getListaProyectos().remove(proyecto);
                    
                }

                persisProyecto.eliminar(id);
            }
        
        } catch (Exception ex) {
        Logger.getLogger(GestionarProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Proyecto> obtenerProyectosAdmin(){
        Administrador administrador = persisAdmin.obtener(68293849);
        return administrador.getListaProyectos();
    }

    public int contarNTorres(String nombre_proyecto) {
        return persisProyecto.contarNTorres(nombre_proyecto);
    }

}
