package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HistoriaClinicaDAO {

    public ResultSet listarPacientes() {

        String sql = "SELECT idPaciente, nombre, apellido FROM pacientes ORDER BY nombre ASC";

        try {

            Connection cn = Conexion.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);

            return ps.executeQuery();

        } catch (Exception e) {

            System.out.println("Error al listar pacientes: " + e.getMessage());

            return null;
        }
    }

    public ResultSet listarMedicos() {

        String sql = "SELECT idMedico, nombre, apellido, especialidad FROM medicos ORDER BY nombre ASC";

        try {

            Connection cn = Conexion.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);

            return ps.executeQuery();

        } catch (Exception e) {

            System.out.println("Error al listar médicos: " + e.getMessage());

            return null;
        }
    }

    public ResultSet buscarHistorialPorPaciente(int idPaciente) {

        String sql = "SELECT c.fechaHora, c.diagnostico, c.tratamiento, c.estado, c.duracionMinutos, "
                + "CONCAT(m.nombre, ' ', m.apellido) AS medico, "
                + "m.especialidad "
                + "FROM citas c "
                + "LEFT JOIN medicos m ON c.idMedico = m.idMedico "
                + "WHERE c.idPaciente = ? "
                + "ORDER BY c.fechaHora DESC";

        try {

            Connection cn = Conexion.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, idPaciente);

            return ps.executeQuery();

        } catch (Exception e) {

            System.out.println("Error al buscar historial: " + e.getMessage());

            return null;
        }
    }

    public String obtenerHistorialBasePaciente(int idPaciente) {

        String historial = "";

        String sql = "SELECT historialClinico FROM pacientes WHERE idPaciente = ?";

        try {

            Connection cn = Conexion.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, idPaciente);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                historial = rs.getString("historialClinico");
            }

        } catch (Exception e) {

            System.out.println("Error al obtener historial base: " + e.getMessage());
        }

        return historial;
    }

    public boolean agregarDiagnostico(int idPaciente, int idMedico, String diagnostico, String tratamiento) {

        String sql = "INSERT INTO citas(idPaciente, idMedico, fechaHora, estado, diagnostico, tratamiento, duracionMinutos) "
                + "VALUES (?, ?, NOW(), 'Atendida', ?, ?, 0)";

        try {

            Connection cn = Conexion.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, idPaciente);
            ps.setInt(2, idMedico);
            ps.setString(3, diagnostico);
            ps.setString(4, tratamiento);

            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            System.out.println("Error al agregar diagnóstico: " + e.getMessage());

            return false;
        }
    }

    public boolean registrarAltaMedica(int idPaciente, String diagnosticoFinal) {

        String resumen = "Paciente dado de alta médica. Diagnóstico final: " + diagnosticoFinal;

        String sqlPaciente = "UPDATE pacientes SET estado = 'Alta médica', fechaAlta = NOW(), diagnosticoFinal = ? "
                + "WHERE idPaciente = ?";

        String sqlCita = "INSERT INTO citas(idPaciente, fechaHora, estado, diagnostico, resumenAlta, duracionMinutos) "
                + "VALUES (?, NOW(), 'Alta médica', ?, ?, 0)";

        try {

            Connection cn = Conexion.conectar();

            PreparedStatement psPaciente = cn.prepareStatement(sqlPaciente);

            psPaciente.setString(1, diagnosticoFinal);
            psPaciente.setInt(2, idPaciente);

            psPaciente.executeUpdate();

            PreparedStatement psCita = cn.prepareStatement(sqlCita);

            psCita.setInt(1, idPaciente);
            psCita.setString(2, diagnosticoFinal);
            psCita.setString(3, resumen);

            psCita.executeUpdate();

            return true;

        } catch (Exception e) {

            System.out.println("Error al registrar alta médica: " + e.getMessage());

            return false;
        }
    }
}