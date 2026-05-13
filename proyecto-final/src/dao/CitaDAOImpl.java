package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import modelo.Cita;
import java.util.List;

public class CitaDAOImpl implements ICitaDAO {

    private Conexion conexion = new Conexion();

    @Override
    public boolean insertar(Cita c) {
        String sql = "INSERT INTO citas (fechaHora, estado, diagnostico, duracionMinutos) VALUES (?, ?, ?, ?)";
        
        try (Connection cn = conexion.conectar();
             PreparedStatement pst = cn.prepareStatement(sql)) {
            
            pst.setTimestamp(1, java.sql.Timestamp.valueOf(c.getFechaHora()));
            pst.setString(2, c.getEstado());
            pst.setString(3, c.getDiagnostico());
            pst.setInt(4, c.getDuracionMinutos());
            
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace(); 
            return false;
        }
    }

    @Override
    public boolean actualizar(Cita c) {
        return false;
    }

    @Override
    public List<Cita> listar() {
        List<Cita> lista = new java.util.ArrayList<>();
        String sql = "SELECT * FROM citas ORDER BY idCita ASC";
        
        try (java.sql.Connection cn = conexion.conectar();
             java.sql.PreparedStatement pst = cn.prepareStatement(sql);
             java.sql.ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                Cita c = new Cita(
                    rs.getInt("idCita"),
                    rs.getTimestamp("fechaHora").toLocalDateTime(),
                    rs.getString("estado"),
                    rs.getString("diagnostico"),
                    rs.getInt("duracionMinutos")
                );
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean eliminar(int id) {
        return false;
    } 
}