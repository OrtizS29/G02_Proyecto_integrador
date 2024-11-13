
package CONTROLADOR;

/**
 *
 * @author Santiago
 */
public class calcularIntereses {
    
    public Long calcularPrecioFinal(Long precio_base,int numeroCuotas){
        long intereses = Math.round((precio_base * numeroCuotas) / 100); 
        long precioFinal = precio_base+intereses;
        return Long.valueOf(precioFinal);       
    }
}
