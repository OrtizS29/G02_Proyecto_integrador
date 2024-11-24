
package CONTROLADOR.gestionar;

import Modelo.entities.Apartamento;
import Modelo.entities.Cliente;
import Modelo.entities.Pago;
import Modelo.entities.Venta;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.persistir.IPersistencia;
import Modelo.persistir.IPersistenciaVenta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class GestionarCliente {
    
    private IPersistencia<Cliente> persisCliente;
    private IPersistenciaVenta persisVenta;
    private IPersistencia<Pago> persisPago;
    private IPersistencia<Apartamento> persisApto;

    public GestionarCliente(I_PersistenciaFactory fa) {
        persisCliente = fa.crearPersistirCliente();
        persisVenta = fa.crearPersistirVenta();
        persisPago = fa.crearPersistirPago();
        persisApto = fa.crearPersistirApartamento();
    }

    public Cliente guardar(Cliente cliente) throws Exception {
        persisCliente.crear(cliente);
        return cliente;
    }

    public List<Cliente> traerClientes() {
        List<Cliente> listaClientes = persisCliente.traerEntidades();
        return listaClientes;
    }

    public Cliente buscarPorId(Long ced_cliente) {
        Cliente cliente = null;
        cliente = persisCliente.obtener(ced_cliente);
        return cliente;
    }

    public void borrar(Long ced_cliente) throws Exception {
        
        Cliente cliente = persisCliente.obtener(ced_cliente);
        
        for(Venta venta :cliente.getListaVentas()){
            for(Pago pago:new ArrayList<>(venta.getListaPagos())){
                persisPago.eliminar(pago.getId_pago());
            }
            
            for (Apartamento apartamento : new ArrayList<>(venta.getListaApartamentos())) {
                // Actualizar los atributos del apartamento
                apartamento.setFecha_escritura(null);
                apartamento.setVenta(null); // Desasocia el apartamento de la venta

                // Guardar el cambio en la base de datos
                persisApto.editar(apartamento);
            }
            
            persisVenta.eliminar(venta.getId_venta());
        }
            
        persisCliente.eliminar(ced_cliente); 
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

    public List<Venta> obtenerVentasCliente(Long cedClienteSeleccionado) {
        Cliente cliente =persisCliente.obtener(cedClienteSeleccionado);
        return cliente.getListaVentas();
    }

}
