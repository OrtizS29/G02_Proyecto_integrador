
package Modelo.factory;

import Modelo.entities.Administrador;
import Modelo.entities.Apartamento;
import Modelo.entities.Asesor;
import Modelo.entities.Cliente;
import Modelo.entities.Correo;
import Modelo.entities.Deuda;
import Modelo.entities.Pago;
import Modelo.entities.Telefono;
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
    IPersistencia<Correo> crearPersistirCorreo();
    IPersistencia<Deuda> crearPersistirDeuda();
    IPersistencia<Pago> crearPersistirPago();
    IPersistenciaProyecto crearPersistirProyecto();
    IPersistencia<Telefono> crearPersistirTelefono();
    IPersistenciaTorre crearPersistirTorre();
    IPersistencia<Usuario> crearPersistirUsuario();
    IPersistencia<Venta> crearPersistirVenta();
}
