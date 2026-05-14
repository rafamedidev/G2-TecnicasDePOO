package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.Paciente;

public class PacienteDAO {

    // REGISTRAR
    public boolean registrar(Paciente p) {

        String sql = "INSERT INTO pacientes(dni,nombre,apellido,telefono,correo,historialClinico,contactoEmergencia) VALUES (?,?,?,?,?,?,?)";

        try {

            Connection con = Conexion.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getDni());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getApellido());
            ps.setString(4, p.getTelefono());
            ps.setString(5, p.getCorreo());
            ps.setString(6, p.getHistorialClinico());
            ps.setString(7, p.getContactoEmergencia());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    // LISTAR
    public ArrayList<Paciente> listar() {

        ArrayList<Paciente> lista = new ArrayList<>();

        String sql = "SELECT * FROM pacientes";

        try {

            Connection con = Conexion.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Paciente p = new Paciente(
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getString("historialClinico"),
                        rs.getString("contactoEmergencia")
                );

                p.setCorreo(rs.getString("correo"));

                lista.add(p);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return lista;
    }

    // ACTUALIZAR
    public boolean actualizar(Paciente p) {

        String sql = "UPDATE pacientes SET nombre=?, apellido=?, telefono=?, correo=?, historialClinico=?, contactoEmergencia=? WHERE dni=?";

        try {

            Connection con = Conexion.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getTelefono());
            ps.setString(4, p.getCorreo());
            ps.setString(5, p.getHistorialClinico());
            ps.setString(6, p.getContactoEmergencia());
            ps.setString(7, p.getDni());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    // ELIMINAR
    public boolean eliminar(String dni) {

        String sql = "DELETE FROM pacientes WHERE dni=?";

        try {

            Connection con = Conexion.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, dni);

            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    // BUSCAR
    public ArrayList<Paciente> buscar(String criterio) {

        ArrayList<Paciente> lista = new ArrayList<>();

        String sql = "SELECT * FROM pacientes WHERE dni LIKE ? OR nombre LIKE ? OR apellido LIKE ?";

        try {

            Connection con = Conexion.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "%" + criterio + "%");
            ps.setString(2, "%" + criterio + "%");
            ps.setString(3, "%" + criterio + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Paciente p = new Paciente(
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getString("historialClinico"),
                        rs.getString("contactoEmergencia")
                );

                p.setCorreo(rs.getString("correo"));

                lista.add(p);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return lista;
    }
}