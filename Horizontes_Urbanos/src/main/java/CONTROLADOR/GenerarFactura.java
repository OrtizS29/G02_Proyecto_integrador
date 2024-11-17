
package CONTROLADOR;

import Modelo.ConexionORACLE;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * 
 * @author Santiago
 */
public class GenerarFactura {

    
    
    public GenerarFactura() {
    }
    
    public void generarFactura(Long idVenta) {
        try {
            // Ruta absoluta del archivo Jasper compilado
            String path = "C:\\proyecto_integrador\\G02_Proyecto_integrador\\Horizontes_Urbanos\\src\\main\\resources\\reportes\\facturaPago.jasper";

            // Parámetros que necesita el reporte
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("id_venta", idVenta);
            
            ConexionORACLE conexion = new ConexionORACLE("Constructora", "constructora688"); // Usa el usuario y contraseña correctos
            Connection connection = conexion.isConectado() ? conexion.getConnection() : null;
            
            if (connection == null) {
                System.out.println("No se pudo establecer la conexión con la base de datos.");
                return;
            }
            
            // Cargar el archivo Jasper
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            // Llenar el reporte con datos
            JasperPrint print = JasperFillManager.fillReport(reporte, parametros,connection);

            // Exportar a PDF
            String rutaPDF = "factura_" + idVenta + ".pdf";
            JasperExportManager.exportReportToPdfFile(print, rutaPDF);

            System.out.println("Factura generada correctamente en: " + rutaPDF);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
