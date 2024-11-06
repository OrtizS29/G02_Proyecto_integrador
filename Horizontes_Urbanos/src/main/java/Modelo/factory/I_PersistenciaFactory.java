
package Modelo.factory;

import Modelo.entities.Administrador;
import Modelo.entities.Apartamento;
import Modelo.entities.Cliente;
import Modelo.entities.Correo;
import Modelo.entities.Deuda;
import Modelo.entities.Pago;
import Modelo.entities.Telefono;
import Modelo.entities.Venta;
import Modelo.persistir.IPersistencia;
import Modelo.persistir.IPersistenciaAsesor;
import Modelo.persistir.IPersistenciaProyecto;
import Modelo.persistir.IPersistenciaTorre;
import Modelo.persistir.IPersistenciaUsuario;

/**
 *
 * @author Santiago
 */
public interface I_PersistenciaFactory {
    IPersistencia<Administrador> crearPersistirAdministrador();
    IPersistencia<Apartamento> crearPersistirApartamento();
    IPersistenciaAsesor crearPersistirAsesor();
    IPersistencia<Cliente> crearPersistirCliente();
    IPersistencia<Correo> crearPersistirCorreo();
    IPersistencia<Deuda> crearPersistirDeuda();
    IPersistencia<Pago> crearPersistirPago();
    IPersistenciaProyecto crearPersistirProyecto();
    IPersistencia<Telefono> crearPersistirTelefono();
    IPersistenciaTorre crearPersistirTorre();
    IPersistenciaUsuario crearPersistirUsuario();
    IPersistencia<Venta> crearPersistirVenta();
}
