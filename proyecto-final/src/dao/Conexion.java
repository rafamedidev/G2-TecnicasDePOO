package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    private String bd = "SistemaHospitalario";
    private String url = "jdbc:mysql://localhost:3306/" + bd;
    private String user = "root";
    private String pass = "root";

    public Connection conectar() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Error en clase Conexion: " + e.getMessage());
        }
        return cn;
    }
}