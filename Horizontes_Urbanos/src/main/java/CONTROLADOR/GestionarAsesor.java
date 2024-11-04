
package CONTROLADOR;

import Modelo.entities.Asesor;
import Modelo.entities.Correo_asesor;
import Modelo.entities.Telefono_asesor;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.persistir.IPersistencia;

/**
 *
 * @author Santiago
 */
public class GestionarAsesor {
    
     private IPersistencia<Asesor> persisAsesor;
     private IPersistencia<Telefono_asesor> persisTelAsesor;
     private IPersistencia<Correo_asesor> persisCorrAsesor;

    public GestionarAsesor(I_PersistenciaFactory fa) {
        
        persisAsesor = fa.crearPersistirAsesor();
        persisTelAsesor = fa.crearPersistirTelefono_asesor();
        persisCorrAsesor = fa.crearPersistirCorreo_asesor();
    }

    public Asesor guardar(Asesor asesor) throws Exception {
        persisAsesor.crear(asesor);
        return asesor;
    }
    
    public Telefono_asesor guardarTel(Telefono_asesor telAsesor) throws Exception {
        persisTelAsesor.crear(telAsesor);
        return telAsesor;
    }
     
    public Correo_asesor guardarCorr(Correo_asesor corrAsesor) throws Exception {
        persisCorrAsesor.crear(corrAsesor);
        return corrAsesor;
    }
}
