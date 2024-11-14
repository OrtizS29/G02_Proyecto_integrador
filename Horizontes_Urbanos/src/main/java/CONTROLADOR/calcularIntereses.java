
package CONTROLADOR;

/**
 *
 * @author Santiago
 */
public class calcularIntereses {
    
    public Long calcularPrecioFinal(Long precio_base,int numeroCuotas,String sisben,Long sub_ministerio){
        long intereses = Math.round((precio_base * numeroCuotas) / 100); 
        Long precioFinal = precio_base+intereses;
        
        if(sisben.equals("SI")){
            precioFinal-=sub_ministerio;
        }
        
        return precioFinal;       
    }
}
