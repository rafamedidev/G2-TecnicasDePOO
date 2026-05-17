package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReporteDAO {

    public int totalPacientes() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM pacientes";

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                total = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("Error total pacientes: " + e.getMessage());
        }

        return total;
    }

    public int citasDelDia() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM citas WHERE DATE(fechaHora) = CURDATE()";

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                total = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("Error citas del día: " + e.getMessage());
        }

        return total;
    }
}