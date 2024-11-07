
package CONTROLADOR;

import Modelo.entities.Asesor;
import Modelo.entities.Usuario;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.persistir.IPersistenciaAsesor;
import Modelo.persistir.IPersistenciaUsuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class GestionarAsesor {
    
     private IPersistenciaAsesor persisAsesor;
     private IPersistenciaUsuario persisUsuario;

    public GestionarAsesor(I_PersistenciaFactory fa) {
        
        persisAsesor = fa.crearPersistirAsesor();
        persisUsuario = fa.crearPersistirUsuario();
    }

    public Asesor guardar(Asesor asesor) throws Exception {
        persisAsesor.crear(asesor);
        return asesor;
    }
    
    public Asesor buscarPorId(int id) {
        Asesor asesor = null;
        asesor = persisAsesor.obtener(id);
        return asesor;
    }
    
    public void editar(Asesor asesor, int cedula,String nombre,String direccion) throws Exception {
        
        asesor.setCedula(cedula);
        asesor.setNombre(nombre);
        asesor.setDireccion(direccion);
        persisAsesor.editar(asesor);
    }
    
    public void borrar(int id){
        
        try {
            
            Asesor asesor = persisAsesor.obtener(id);
            
            if(asesor != null){
                
                Usuario usuarioAse = persisUsuario.obtenerAsesorCed(id);
                if(usuarioAse != null){
                    persisUsuario.eliminar(usuarioAse.getId());
                }
                
                persisAsesor.eliminar(id);
            }
            
        } catch (Exception e) {
            Logger.getLogger(GestionarProyecto.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public List<Asesor> traerAsesores(){
        List<Asesor> listaAsesores = persisAsesor.traerAsesores();
        return listaAsesores;
    }
}
