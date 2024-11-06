
package CONTROLADOR;

import Modelo.entities.Asesor;
import Modelo.entities.Correo;
import Modelo.entities.Telefono;
import Modelo.entities.Usuario;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.persistir.IPersistencia;
import Modelo.persistir.IPersistenciaAsesor;
import Modelo.persistir.IPersistenciaUsuario;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class GestionarAsesor {
    
     private IPersistenciaAsesor persisAsesor;
     private IPersistencia<Telefono> persisTelefono;
     private IPersistencia<Correo> persisCorreo;
     private IPersistenciaUsuario persisUsuario;

    public GestionarAsesor(I_PersistenciaFactory fa) {
        
        persisAsesor = fa.crearPersistirAsesor();
        persisTelefono = fa.crearPersistirTelefono();
        persisCorreo = fa.crearPersistirCorreo();
        persisUsuario = fa.crearPersistirUsuario();
    }

    public Asesor guardar(Asesor asesor) throws Exception {
        persisAsesor.crear(asesor);
        return asesor;
    }
    
    public Telefono guardarTel(Telefono telefono) throws Exception {
        persisTelefono.crear(telefono);
        return telefono;
    }
     
    public Correo guardarCorr(Correo correo) throws Exception {
        persisCorreo.crear(correo);
        return correo;
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
                
                List<Correo> correAEliminar = new ArrayList<>(asesor.getListaCorreos());
                for(Correo correo:correAEliminar){
                    persisCorreo.eliminar(correo.getId());
                    asesor.getListaCorreos().remove(correo);
                }
                
                List<Telefono> telAEliminar = new ArrayList<>(asesor.getListaTelefonos());
                for(Telefono telefono:telAEliminar){
                    persisTelefono.eliminar(telefono.getId());
                    asesor.getListaTelefonos().remove(telefono);
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
