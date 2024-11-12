
package Modelo.factory;

import Modelo.entities.Administrador;
import Modelo.entities.Apartamento;
import Modelo.entities.Asesor;
import Modelo.entities.Cliente;
import Modelo.entities.Deuda;
import Modelo.entities.Pago;
import Modelo.persistir.IPersistencia;
import Modelo.persistir.IPersistenciaProyecto;
import Modelo.persistir.IPersistenciaTorre;
import Modelo.persistir.IPersistenciaUsuario;
import Modelo.persistir.IPersistenciaVenta;

/**
 *
 * @author Santiago
 */
public interface I_PersistenciaFactory {
    IPersistencia<Administrador> crearPersistirAdministrador();
    IPersistencia<Apartamento> crearPersistirApartamento();
    IPersistencia<Asesor> crearPersistirAsesor();
    IPersistencia<Cliente> crearPersistirCliente();
    IPersistencia<Deuda> crearPersistirDeuda();
    IPersistencia<Pago> crearPersistirPago();
    IPersistenciaProyecto crearPersistirProyecto();
    IPersistenciaTorre crearPersistirTorre();
    IPersistenciaUsuario crearPersistirUsuario();
    IPersistenciaVenta crearPersistirVenta();
}
