
package CONTROLADOR;

import Modelo.entities.Asesor;
import Modelo.entities.Correo;
import Modelo.entities.Telefono;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.persistir.IPersistencia;

/**
 *
 * @author Santiago
 */
public class GestionarAsesor {
    
     private IPersistencia<Asesor> persisAsesor;
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
}
