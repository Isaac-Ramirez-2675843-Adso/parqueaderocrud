/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author User
 */
public class Conexion {
    Connection con;
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parqueacrud", "root", "");
            
        } catch (Exception e) {
            System.out.println("Error al abrir base de datos" +e.toString());
        } 
                
    }
    public Connection getConnection(){
        return con;
    }
}
