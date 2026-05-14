package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Usuario;

public class UsuarioDAO {

    public Usuario login(String usuario, String password) {

        Usuario user = null;

        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";

        try {

            Connection cn = Conexion.conectar();

            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, usuario);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                user = new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("usuario"),
                        rs.getString("password"),
                        rs.getString("rol"),
                        true
                );
            }

        } catch (Exception e) {

            System.out.println("Error en DAO login: " + e.getMessage());
        }

        return user;
    }

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