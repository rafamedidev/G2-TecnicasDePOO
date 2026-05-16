package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static String bd = "SistemaHospitalario";

    private static String url =
            "jdbc:mysql://localhost:3306/" + bd;

    private static String user = "root";

    // TU CONTRASEÑA REAL DE MYSQL
    private static String pass = "root";

    public static Connection conectar() {

        Connection cn = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            cn = DriverManager.getConnection(url, user, pass);

            System.out.println("Conexión exitosa");

        } catch (Exception e) {

            System.out.println("Error en conexión: " + e.getMessage());
        }

        return cn;
    }
}