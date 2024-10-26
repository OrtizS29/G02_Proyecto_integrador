
package CONTROLADOR;

/**
 *
 * @author CLAUDIA
 */
public interface Gestionar<T> {
    
    /**
     * 
     * @param entidad 
     */
    public void guardar(T entidad);
    
    /**
     * 
     * @param id
     * @return 
     */
    public T buscarPorId(int id);
    
    /**
     * 
     * @param entidad 
     */
    public void editar(T entidad);
   
    /**
     * 
     * @param id 
     */
    public void borrar(int id);
    
}
