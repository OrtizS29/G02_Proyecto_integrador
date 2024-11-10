
package CONTROLADOR.gestionar;

import Modelo.entities.Cliente;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.persistir.IPersistenciaCliente;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class GestionarCliente {
    
    private IPersistenciaCliente persisCliente;

    public GestionarCliente(I_PersistenciaFactory fa) {
        persisCliente = fa.crearPersistirCliente();
    }

    public Cliente guardar(Cliente cliente) throws Exception {
        persisCliente.crear(cliente);
        return cliente;
    }

    public List<Cliente> traerClientes() {
        List<Cliente> listaClientes = persisCliente.traerClientes();
        return listaClientes;
    }

    public Cliente buscarPorId(Long ced_cliente) {
        Cliente cliente = null;
        cliente = persisCliente.obtener(ced_cliente);
        return cliente;
    }

    public void borrar(Long ced_cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void editar(Cliente cliente, Long cedulaCliente, String nombreCliente, String direccionCliente, 
            String sisben, String correo, Long telefono, Long subsidioMinisterio) throws Exception {
        
        cliente.setCedula(cedulaCliente);
        cliente.setNombre(nombreCliente);
        cliente.setDireccion(direccionCliente);
        cliente.setSisben(sisben);
        if (sisben.equals("SI")){
            cliente.setSubsidio_ministerio(subsidioMinisterio);
        }
        cliente.setCorreo(correo);
        cliente.setTelefono(telefono);
        persisCliente.editar(cliente);
    }

}
