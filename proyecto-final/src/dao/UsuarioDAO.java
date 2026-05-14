package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    // LOGIN
    public boolean login(String usuario, String password) {

        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";

        try {

            Connection cn = Conexion.conectar();

            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, usuario);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            return rs.next();

        } catch (Exception e) {

            System.out.println("Error en DAO: " + e.getMessage());

            return false;
        }
    }

    // REGISTRAR
    public boolean registrar(String usuario, String password, String rol) {

        String sql = "INSERT INTO usuarios(usuario, password, rol) VALUES (?, ?, ?)";

        try {

            Connection cn = Conexion.conectar();

            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, usuario);
            pst.setString(2, password);
            pst.setString(3, rol);

            pst.executeUpdate();

            return true;

        } catch (Exception e) {

            System.out.println("Error al registrar usuario: " + e.getMessage());

            return false;
        }
    }
}