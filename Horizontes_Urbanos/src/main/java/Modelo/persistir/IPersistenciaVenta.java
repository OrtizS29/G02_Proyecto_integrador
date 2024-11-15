
package Modelo.persistir;

import Modelo.entities.Apartamento;
import Modelo.entities.Venta;
import java.util.List;

/**
 *
 * @author Santiago
 */
public interface IPersistenciaVenta extends IPersistencia<Venta> {
    
    public List<Apartamento> obtenerAptosNoVendidos();
    int contarNPagos(Long id_venta);
    public List<Apartamento> obtenerAptosVendidos(Long id_venta, Long ced_cliente);
}
