
package CONTROLADOR.gestionar;

import Modelo.entities.Apartamento;
import Modelo.entities.Cliente;
import Modelo.entities.Deuda;
import Modelo.entities.Pago;
import Modelo.entities.Venta;
import Modelo.factory.I_PersistenciaFactory;
import Modelo.persistir.IPersistencia;
import Modelo.persistir.IPersistenciaVenta;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class GestionarVenta {
    
    private IPersistenciaVenta persisVenta;
    private IPersistencia<Pago> persisPago;
    private IPersistencia<Cliente> persisCliente;
    private IPersistencia<Apartamento> persisApto;

    public GestionarVenta(I_PersistenciaFactory fa) {
        persisVenta = fa.crearPersistirVenta();
        persisCliente = fa.crearPersistirCliente();
        persisPago = fa.crearPersistirPago();
        persisApto = fa.crearPersistirApartamento();
    }

    public Venta guardar(Venta venta) throws Exception {
        persisVenta.crear(venta);
        return venta;
    }
    
    public Venta buscarPorId(Long id) {
        Venta venta = null;
        venta = persisVenta.obtener(id);
        return venta;
    }
    
    public void editar(Venta venta) throws Exception {
 
        persisVenta.editar(venta);
    }
    
    public void editarV(Venta venta,Date fecha,int numeroCoutas,BigDecimal precio_final,
            BigDecimal precio_base,BigDecimal intereses) throws Exception {
        
        venta.setFecha(fecha);
        venta.setNumero_coutas(numeroCoutas);
        venta.setPrecio_final(precio_final);
        venta.setPrecio_base(precio_base);
        venta.setIntereses(intereses);
        persisVenta.editar(venta);
    }
    
    
    
    public List<Venta> traerVentas() {
        List<Venta> listaVentas = persisVenta.traerEntidades();
        return listaVentas;
    }
    
    public List<Apartamento> obtenerAptosNoVendidos(){
        List<Apartamento> listaApartamentosNoVendidos = persisVenta.obtenerAptosNoVendidos();
        return listaApartamentosNoVendidos;
    }
    
    public List<Venta> obtenerVentaCliente(Long ced) {
        Cliente cliente = persisCliente.obtener(ced);
        return cliente.getListaVentas();
    }

    public int contarNPagos(Long id_venta){
        return persisVenta.contarNPagos(id_venta);
    }
    
    public int contarNDeudas(Long id_venta){
        return persisVenta.contarNDeudas(id_venta);
    }

    public List<Apartamento> obtenerAptosVendidos(Long id_venta, Long ced_cliente) {
        List<Apartamento> listaApartamentosVendidos = persisVenta.obtenerAptosVendidos(id_venta,ced_cliente);
        return listaApartamentosVendidos;
    }

    public void borrar(Cliente clienteSeleccionado, Long id_venta) throws Exception {
        /*
        if (clienteSeleccionado.getListaVentas().size()==1) {
            return false;
        }
        else{
            
            Venta venta = persisVenta.obtener(id_venta);
            
            for (Apartamento apartamento : new ArrayList<>(venta.getListaApartamentos())) {
                // Actualizar los atributos del apartamento
                apartamento.setFecha_escritura(null);
                apartamento.setVenta(null); // Desasocia el apartamento de la venta

                // Guardar el cambio en la base de datos
                persisApto.editar(apartamento);
            }
            
            for (Pago pago : new ArrayList<>(venta.getListaPagos())) {
                persisPago.eliminar(pago.getId_pago());
            }
            
            persisVenta.eliminar(venta.getId_venta());
            
            return true;
        }*/
        
         Venta venta = persisVenta.obtener(id_venta);
            
            for (Apartamento apartamento : new ArrayList<>(venta.getListaApartamentos())) {
                // Actualizar los atributos del apartamento
                apartamento.setFecha_escritura(null);
                apartamento.setVenta(null); // Desasocia el apartamento de la venta

                // Guardar el cambio en la base de datos
                persisApto.editar(apartamento);
            }
            
            for (Pago pago : new ArrayList<>(venta.getListaPagos())) {
                persisPago.eliminar(pago.getId_pago());
            }
            
            persisVenta.eliminar(venta.getId_venta());
    }
                    
}
