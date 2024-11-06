
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
import Modelo.persistir.PersistirAdministrador;
import Modelo.persistir.PersistirApartamento;
import Modelo.persistir.PersistirAsesor;
import Modelo.persistir.PersistirCliente;
import Modelo.persistir.PersistirCorreo;
import Modelo.persistir.PersistirDeuda;
import Modelo.persistir.PersistirPago;
import Modelo.persistir.PersistirProyecto;
import Modelo.persistir.PersistirTelefono;
import Modelo.persistir.PersistirTorre;
import Modelo.persistir.PersistirUsuario;
import Modelo.persistir.PersistirVenta;

/**
 *
 * @author Santiago
 */
public class PersistenciaFactory_inyect implements I_PersistenciaFactory{

    @Override
    public IPersistencia<Administrador> crearPersistirAdministrador() {
        return new PersistirAdministrador();
    }

    @Override
    public IPersistencia<Apartamento> crearPersistirApartamento() {
        return new PersistirApartamento();
    }

    @Override
    public IPersistenciaAsesor crearPersistirAsesor() {
        return new PersistirAsesor();
    }

    @Override
    public IPersistencia<Cliente> crearPersistirCliente() {
        return new PersistirCliente();
    }

    @Override
    public IPersistencia<Pago> crearPersistirPago() {
        return new PersistirPago();
    }

    @Override
    public IPersistenciaProyecto crearPersistirProyecto() {
        return new PersistirProyecto();
    }

    @Override
    public IPersistenciaTorre crearPersistirTorre() {
        return new PersistirTorre();
    }

    @Override
    public IPersistenciaUsuario crearPersistirUsuario() {
        return new PersistirUsuario();
    }

    @Override
    public IPersistencia<Venta> crearPersistirVenta() {
        return new PersistirVenta();
    }

    @Override
    public IPersistencia<Correo> crearPersistirCorreo() {
        return new PersistirCorreo();
    }

    @Override
    public IPersistencia<Deuda> crearPersistirDeuda() {
        return new PersistirDeuda();
    }

    @Override
    public IPersistencia<Telefono> crearPersistirTelefono() {
        return new PersistirTelefono();
    }
    
    
}
