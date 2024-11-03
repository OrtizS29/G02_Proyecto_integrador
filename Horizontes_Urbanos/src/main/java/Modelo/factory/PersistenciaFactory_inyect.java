
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
import Modelo.persistir.PersistirAdministrador;
import Modelo.persistir.PersistirApartamento;
import Modelo.persistir.PersistirAsesor;
import Modelo.persistir.PersistirCliente;
import Modelo.persistir.PersistirCorreo_asesor;
import Modelo.persistir.PersistirCorreo_cliente;
import Modelo.persistir.PersistirPago;
import Modelo.persistir.PersistirProyecto;
import Modelo.persistir.PersistirTelefono_asesor;
import Modelo.persistir.PersistirTelefono_cliente;
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
    public IPersistencia<Asesor> crearPersistirAsesor() {
        return new PersistirAsesor();
    }

    @Override
    public IPersistencia<Cliente> crearPersistirCliente() {
        return new PersistirCliente();
    }

    @Override
    public IPersistencia<Correo_asesor> crearPersistirCorreo_asesor() {
        return new PersistirCorreo_asesor();
    }

    @Override
    public IPersistencia<Correo_cliente> crearPersistirCorreo_cliente() {
        return new PersistirCorreo_cliente();
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
    public IPersistencia<Telefono_asesor> crearPersistirTelefono_asesor() {
        return new PersistirTelefono_asesor();
    }

    @Override
    public IPersistencia<Telefono_cliente> crearPersistirTelefono_cliente() {
        return new PersistirTelefono_cliente();
    }

    @Override
    public IPersistencia<Torre> crearPersistirTorre() {
        return new PersistirTorre();
    }

    @Override
    public IPersistencia<Usuario> crearPersistirUsuario() {
        return new PersistirUsuario();
    }

    @Override
    public IPersistencia<Venta> crearPersistirVenta() {
        return new PersistirVenta();
    }
    
    
}
