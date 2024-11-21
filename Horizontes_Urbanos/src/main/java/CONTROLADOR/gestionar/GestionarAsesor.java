
package CONTROLADOR.gestionar;

import Modelo.entities.Asesor;
import Modelo.entities.Pago;
import Modelo.entities.Usuario;
import Modelo.entities.Venta;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.persistir.IPersistencia;
import Modelo.persistir.IPersistenciaUsuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class GestionarAsesor {
    
     private IPersistencia<Asesor> persisAsesor;
     private IPersistenciaUsuario persisUsuario;
     private IPersistencia<Pago> persisPago;
     private IPersistencia<Venta> persisVenta;

    public GestionarAsesor(I_PersistenciaFactory fa) {
        
        
        persisAsesor = fa.crearPersistirAsesor();
        persisUsuario = fa.crearPersistirUsuario();
        persisPago = fa.crearPersistirPago();
        persisVenta = fa.crearPersistirVenta();
    }

    public Asesor guardar(Asesor asesor) throws Exception {
        persisAsesor.crear(asesor);
        return asesor;
    }
    
    public Asesor buscarPorId(Long id) {
        Asesor asesor = null;
        asesor = persisAsesor.obtener(id);
        return asesor;
    }
    
    public void editar(Asesor asesor, Long cedula,String nombre,String direccion,String correo,
            Long telefono) throws Exception {
        
        asesor.setCedula(cedula);
        asesor.setNombre(nombre);
        asesor.setDireccion(direccion);
        asesor.setCorreo(correo);
        asesor.setTelefono(telefono);
        
        persisAsesor.editar(asesor);
    }
    
    
    
    public void borrar(Long id){
        
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
        List<Asesor> listaAsesores = persisAsesor.traerEntidades();
        return listaAsesores;
    }
}
