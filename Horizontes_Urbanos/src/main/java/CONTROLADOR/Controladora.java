
package CONTROLADOR;

import Modelo.Administrador;
import Modelo.Apartamento;
import Modelo.ControladoraPersistencia;
import java.util.LinkedList;

/**
 *
 * @author Santiago
 */
public class Controladora {
    
    ControladoraPersistencia controlPer = new ControladoraPersistencia();   
    
    public void guardarAdministrador(int cedula,String nombre,String direccion,
            LinkedList<Apartamento> listaApartamentos) throws Exception{
        
        //Creamos el dueño y asignamos valores
        Administrador administrador = new Administrador();
        administrador.setCedula(cedula);
        administrador.setNombre(nombre);
        administrador.setDireccion(direccion);
        administrador.setListaApartamentos(listaApartamentos);
        
        controlPer.crearAdministrador(administrador);
    } 
    
    
    
}
