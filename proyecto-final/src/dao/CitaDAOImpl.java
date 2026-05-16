package dao;

import modelo.Cita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CitaDAOImpl implements ICitaDAO {

    @Override
    public boolean insertar(Cita c) {

        String sql = "INSERT INTO citas(idMedico, idPaciente, fechaHora, estado, diagnostico, tratamiento, duracionMinutos, horaInicio, horaFin) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            Connection cn = Conexion.conectar();

            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, c.getIdMedico());
            pst.setInt(2, c.getIdPaciente());
            pst.setTimestamp(3, Timestamp.valueOf(c.getFechaHora()));
            pst.setString(4, c.getEstado());
            pst.setString(5, c.getDiagnostico());
            pst.setString(6, c.getTratamiento());
            pst.setInt(7, c.getDuracionMinutos());
            pst.setTimestamp(8, Timestamp.valueOf(c.getHoraInicio()));
            pst.setTimestamp(9, Timestamp.valueOf(c.getHoraFin()));

            return pst.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }

    @Override
    public boolean actualizar(Cita c) {

        String sql = "UPDATE citas SET idMedico=?, idPaciente=?, fechaHora=?, estado=?, diagnostico=?, tratamiento=?, duracionMinutos=?, horaInicio=?, horaFin=? "
                + "WHERE idCita=?";

        try {

            Connection cn = Conexion.conectar();

            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, c.getIdMedico());
            pst.setInt(2, c.getIdPaciente());
            pst.setTimestamp(3, Timestamp.valueOf(c.getFechaHora()));
            pst.setString(4, c.getEstado());
            pst.setString(5, c.getDiagnostico());
            pst.setString(6, c.getTratamiento());
            pst.setInt(7, c.getDuracionMinutos());
            pst.setTimestamp(8, Timestamp.valueOf(c.getHoraInicio()));
            pst.setTimestamp(9, Timestamp.valueOf(c.getHoraFin()));
            pst.setInt(10, c.getIdCita());

            return pst.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }

    @Override
    public List<Cita> listar() {

        List<Cita> lista = new ArrayList<>();

        String sql = "SELECT c.idCita, c.idPaciente, c.idMedico, c.fechaHora, c.estado, "
                + "c.diagnostico, c.tratamiento, c.duracionMinutos, c.horaInicio, c.horaFin, c.resumenAlta, "
                + "CONCAT(p.nombre, ' ', p.apellido) AS paciente, "
                + "p.correo AS correoPaciente, "
                + "CONCAT(m.nombre, ' ', m.apellido) AS medico, "
                + "m.especialidad AS especialidad "
                + "FROM citas c "
                + "LEFT JOIN pacientes p ON c.idPaciente = p.idPaciente "
                + "LEFT JOIN medicos m ON c.idMedico = m.idMedico "
                + "ORDER BY c.idCita ASC";

        try {

            Connection cn = Conexion.conectar();

            PreparedStatement pst = cn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Cita c = new Cita(
                        rs.getInt("idCita"),
                        rs.getInt("idPaciente"),
                        rs.getInt("idMedico"),
                        rs.getTimestamp("fechaHora").toLocalDateTime(),
                        rs.getString("estado"),
                        rs.getString("diagnostico"),
                        rs.getString("tratamiento"),
                        rs.getInt("duracionMinutos"),
                        rs.getTimestamp("horaInicio") != null ? rs.getTimestamp("horaInicio").toLocalDateTime() : null,
                        rs.getTimestamp("horaFin") != null ? rs.getTimestamp("horaFin").toLocalDateTime() : null
                );

                c.setResumenAlta(rs.getString("resumenAlta"));
                c.setNombrePaciente(rs.getString("paciente"));
                c.setCorreoPaciente(rs.getString("correoPaciente"));
                c.setNombreMedico(rs.getString("medico"));
                c.setEspecialidad(rs.getString("especialidad"));

                lista.add(c);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public boolean eliminar(int id) {

        String sql = "DELETE FROM citas WHERE idCita=?";

        try {

            Connection cn = Conexion.conectar();

            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, id);

            return pst.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }
}