
package CONTROLADOR;

import Modelo.entities.Asesor;
import Modelo.entities.Correo;
import Modelo.entities.Telefono;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.persistir.IPersistencia;
import Modelo.persistir.IPersistenciaAsesor;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class GestionarAsesor {
    
     private IPersistenciaAsesor persisAsesor;
     private IPersistencia<Telefono> persisTelefono;
     private IPersistencia<Correo> persisCorreo;

    public GestionarAsesor(I_PersistenciaFactory fa) {
        
        persisAsesor = fa.crearPersistirAsesor();
        persisTelefono = fa.crearPersistirTelefono();
        persisCorreo = fa.crearPersistirCorreo();
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
        System.out.println("Falta ver la logica");
    }
    
    public List<Asesor> traerAsesores(){
        List<Asesor> listaAsesores = persisAsesor.traerAsesores();
        return listaAsesores;
    }
}
