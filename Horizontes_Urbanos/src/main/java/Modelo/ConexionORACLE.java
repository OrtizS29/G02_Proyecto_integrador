
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

//Clase que va a conectar o desconectar la base de datos
public class ConexionORACLE {

    //se crea la clase Connection
    private Connection conn = null;
    //Se crea el url, usuario, contrasena de la base de datos
    private String url,user,pass;

    //Constructor vacio que llama a un metodo conectar
    public ConexionORACLE() {
        conectar();
    }

    //Metodo que conecta la base de datos
    private void conectar(){

        try {
            Class.forName("oracle.jdbc.OracleDriver"); //El driver DB
            url = "jdbc:oracle:thin:@localhost:1521:XE";
            user = "Constructora";
            pass = "constructora688";
            conn = DriverManager.getConnection(url, user, pass);
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
}
