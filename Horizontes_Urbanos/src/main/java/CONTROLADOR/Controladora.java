
package CONTROLADOR;

import Modelo.Administrador;
import Modelo.ControladoraPersistencia;
import Modelo.Proyecto;
import java.util.LinkedList;

/**
 *
 * @author Santiago
 */
public class Controladora {
    
    ControladoraPersistencia controlPer = new ControladoraPersistencia();   
    
    public void guardarAdministrador(int cedula,String nombre,String direccion,
            LinkedList<Proyecto> listaProyectos) throws Exception{
        
        //Creamos el dueño y asignamos valores
        Administrador administrador = new Administrador();
        administrador.setCedula(cedula);
        administrador.setNombre(nombre);
        administrador.setDireccion(direccion);
        administrador.setListaProyectos(listaProyectos);
        
        controlPer.crearAdministrador(administrador);
    } 
    
    
    
}
