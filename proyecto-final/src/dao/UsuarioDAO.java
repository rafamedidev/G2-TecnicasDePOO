package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Usuario;

public class UsuarioDAO {
    /*
    public boolean login(String usuario, String password) {
        Conexion instancia = new Conexion();
        Connection cn = instancia.conectar();
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, password);
            
            ResultSet rs = pst.executeQuery();
            return rs.next();
            
        } catch (Exception e) {
            System.out.println("Error en DAO: " + e.getMessage());
            return false;
        }
    }*/
	public Usuario login(String usuario, String password) {

        Usuario user = null;

        Connection cn = Conexion.conectar();

        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";

        try {

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

            System.out.println("Error en DAO: " + e.getMessage());
        }

        return user;
    }
}