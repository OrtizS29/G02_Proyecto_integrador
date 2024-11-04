
package Modelo.factory;

import Modelo.entities.Administrador;
import Modelo.entities.Apartamento;
import Modelo.entities.Asesor;
import Modelo.entities.Cliente;
import Modelo.entities.Correo_asesor;
import Modelo.entities.Correo_cliente;
import Modelo.entities.Pago;
import Modelo.entities.Telefono_asesor;
import Modelo.entities.Telefono_cliente;
import Modelo.entities.Torre;
import Modelo.entities.Usuario;
import Modelo.entities.Venta;
import Modelo.persistir.IPersistencia;
import Modelo.persistir.IPersistenciaProyecto;
import Modelo.persistir.IPersistenciaTorre;

/**
 *
 * @author Santiago
 */
public interface I_PersistenciaFactory {
    IPersistencia<Administrador> crearPersistirAdministrador();
    IPersistencia<Apartamento> crearPersistirApartamento();
    IPersistencia<Asesor> crearPersistirAsesor();
    IPersistencia<Cliente> crearPersistirCliente();
    IPersistencia<Correo_asesor> crearPersistirCorreo_asesor();
    IPersistencia<Correo_cliente> crearPersistirCorreo_cliente();
    IPersistencia<Pago> crearPersistirPago();
    IPersistenciaProyecto crearPersistirProyecto();
    IPersistencia<Telefono_asesor> crearPersistirTelefono_asesor();
    IPersistencia<Telefono_cliente> crearPersistirTelefono_cliente();
    IPersistenciaTorre crearPersistirTorre();
    IPersistencia<Usuario> crearPersistirUsuario();
    IPersistencia<Venta> crearPersistirVenta();
}
