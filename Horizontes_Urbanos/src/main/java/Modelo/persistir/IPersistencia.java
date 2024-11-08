
package Modelo.persistir;

import Modelo.entities.Proyecto;
import Modelo.entities.Usuario;

/**
 * Interfaz generica que tiene los metodos para hacer el CRUD (crea,eliminar,editar,leer)
 * 
 * @author Santiago
 */
public interface IPersistencia<T> {
    
    /**
     * Metodo para crear una clase entidad
     * 
     * @param entidad 
     * @throws Exception 
     */
    public void crear(T entidad) throws Exception;
    
    /**
     * Metodo para buscar u obtener una entidad en la BD
     * 
     * @param id
     * @return
     * @throws Exception 
     */
    public T obtener(int id);
    
    /**
     * Metodo para editar o modificar obtener una entidad en la BD
     * 
     * @param entidad
     * @throws Exception 
     */
    public void editar(T entidad) throws Exception;
    
    /**
     * Metodo para eliminar o borrar una entiDAD en la BD
     * 
     * @param id
     * @throws Exception 
     */
    public void eliminar(int id) throws Exception;
 
}
