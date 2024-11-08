
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Clase que va a conectar o desconectar la base de datos
public class ConexionORACLE {

    //se crea la clase Connection
    private Connection conn = null;
    //Se crea el url, usuario, contrasena de la base de datos
    private String url;

    //Constructor vacio que llama a un metodo conectar
    public ConexionORACLE(String usuario,String contraseña) {
        conectar(usuario,contraseña);
    }

    //Metodo que conecta la base de datos
    private void conectar(String usuario,String contraseña) {

        try {
            Class.forName("oracle.jdbc.OracleDriver"); //El driver DB
            url = "jdbc:oracle:thin:@localhost:1521:XE";
            conn = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Se conecto");
        } catch (Exception e) {
            System.out.println("Error, no se pudo conectar");
        }
    }

    //Metodo que desconectar la base de datos
    public void desconectar(){

        try {
            conn.close();
            System.out.println("Se desconecto");
        } catch (Exception e) {
            System.out.println("Error, no se pudo desconectar");
        }
    }
    
    public boolean isConectado() {
        try {
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
}
