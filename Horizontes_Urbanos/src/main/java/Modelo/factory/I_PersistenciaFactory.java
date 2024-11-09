
package Modelo.factory;

import Modelo.entities.Administrador;
import Modelo.entities.Apartamento;
import Modelo.entities.Cliente;
import Modelo.entities.Deuda;
import Modelo.entities.Pago;
import Modelo.entities.Venta;
import Modelo.persistir.IPersistencia;
import Modelo.persistir.IPersistenciaAsesor;
import Modelo.persistir.IPersistenciaCliente;
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
    IPersistenciaCliente crearPersistirCliente();
    IPersistencia<Deuda> crearPersistirDeuda();
    IPersistencia<Pago> crearPersistirPago();
    IPersistenciaProyecto crearPersistirProyecto();
    IPersistenciaTorre crearPersistirTorre();
    IPersistenciaUsuario crearPersistirUsuario();
    IPersistencia<Venta> crearPersistirVenta();
}
