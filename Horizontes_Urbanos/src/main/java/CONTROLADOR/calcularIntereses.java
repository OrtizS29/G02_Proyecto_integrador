
package CONTROLADOR;

import java.math.BigDecimal;

/**
 *
 * @author Santiago
 */
public class calcularIntereses {
    
    public BigDecimal calcularPrecioFinal(BigDecimal precio_base,int numeroCuotas,String sisben,Long sub_ministerio){
        /**
        long intereses = Math.round((precio_base * numeroCuotas) / 100); 
        Long precioFinal = precio_base+intereses;
        
        if(sisben.equals("SI")){
            precioFinal-=sub_ministerio;
        }
        
        return precioFinal; */
        BigDecimal porcentaje = new BigDecimal("100");  // 100 como BigDecimal
        BigDecimal interes = (precio_base.multiply(new BigDecimal(numeroCuotas))).divide(porcentaje, 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal precioFinal = precio_base.add(interes);
        
        if ("SI".equals(sisben)) {
            // Convierte sub_ministerio de Long a BigDecimal
            BigDecimal subMin = new BigDecimal(sub_ministerio);
            precioFinal = precioFinal.subtract(subMin);
        }

        return precioFinal;
    }
}
