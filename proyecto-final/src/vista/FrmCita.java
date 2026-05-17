package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controlador.CitaController;
import dao.Conexion;
import modelo.Cita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FrmCita extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JComboBox<ItemCombo> cboPaciente;
    private JComboBox<ItemCombo> cboMedico;
    private JComboBox<String> cboHoraInicio;
    private JComboBox<String> cboHoraFin;

    private JTextField txtFecha;

    private JTable tblCitas;
    private DefaultTableModel modelo;

    private CitaController controlador;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FrmCita frame = new FrmCita();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FrmCita() {

        controlador = new CitaController();

        setTitle("Gestión de Citas Médicas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 950, 500);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblTituloNueva = new JLabel("Nueva Cita");
        lblTituloNueva.setFont(new Font("Arial", Font.BOLD, 18));
        lblTituloNueva.setBounds(30, 25, 200, 30);
        contentPane.add(lblTituloNueva);

        JLabel lblPaciente = new JLabel("Paciente:");
        lblPaciente.setBounds(30, 80, 120, 25);
        contentPane.add(lblPaciente);

        cboPaciente = new JComboBox<>();
        cboPaciente.setBounds(150, 80, 280, 30);
        contentPane.add(cboPaciente);

        JLabel lblMedico = new JLabel("Médico:");
        lblMedico.setBounds(30, 130, 120, 25);
        contentPane.add(lblMedico);

        cboMedico = new JComboBox<>();
        cboMedico.setBounds(150, 130, 280, 30);
        contentPane.add(cboMedico);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(30, 180, 120, 25);
        contentPane.add(lblFecha);

        txtFecha = new JTextField();
        txtFecha.setBounds(150, 180, 280, 30);
        txtFecha.setText("2026-05-20");
        contentPane.add(txtFecha);

        JLabel lblFormato = new JLabel("Formato: yyyy-MM-dd");
        lblFormato.setBounds(150, 210, 180, 20);
        contentPane.add(lblFormato);

        JLabel lblHoraInicio = new JLabel("Hora inicio:");
        lblHoraInicio.setBounds(30, 245, 120, 25);
        contentPane.add(lblHoraInicio);

        cboHoraInicio = new JComboBox<>();
        cboHoraInicio.setBounds(150, 245, 130, 30);
        contentPane.add(cboHoraInicio);

        JLabel lblHoraFin = new JLabel("Hora fin:");
        lblHoraFin.setBounds(300, 245, 80, 25);
        contentPane.add(lblHoraFin);

        cboHoraFin = new JComboBox<>();
        cboHoraFin.setBounds(370, 245, 130, 30);
        contentPane.add(cboHoraFin);

        JButton btnGuardar = new JButton("Guardar Cita");
        btnGuardar.setBounds(150, 310, 170, 35);
        contentPane.add(btnGuardar);

        JLabel lblListado = new JLabel("Listado de Citas");
        lblListado.setFont(new Font("Arial", Font.BOLD, 18));
        lblListado.setBounds(500, 25, 250, 30);
        contentPane.add(lblListado);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(500, 80, 400, 310);
        contentPane.add(scrollPane);

        tblCitas = new JTable();

        modelo = new DefaultTableModel(
                new Object[][] {},
                new String[] {
                        "ID", "Fecha", "Hora", "Paciente", "Médico", "Estado"
                }
        );

        tblCitas.setModel(modelo);
        scrollPane.setViewportView(tblCitas);

        JButton btnEliminar = new JButton("Eliminar Cita");
        btnEliminar.setBounds(620, 405, 160, 30);
        contentPane.add(btnEliminar);

        cargarHoras();
        cargarPacientes();
        cargarMedicos();
        actualizarTabla();

        btnGuardar.addActionListener(e -> guardarCita());
        btnEliminar.addActionListener(e -> eliminarCita());
    }

    private void guardarCita() {

        try {
            ItemCombo paciente = (ItemCombo) cboPaciente.getSelectedItem();
            ItemCombo medico = (ItemCombo) cboMedico.getSelectedItem();

            if (paciente == null || medico == null) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar paciente y médico");
                return;
            }

            LocalDate fecha = LocalDate.parse(txtFecha.getText().trim());

            LocalTime horaInicio = LocalTime.parse(cboHoraInicio.getSelectedItem().toString());
            LocalTime horaFin = LocalTime.parse(cboHoraFin.getSelectedItem().toString());

            LocalDateTime fechaHora = LocalDateTime.of(fecha, horaInicio);
            LocalDateTime inicio = LocalDateTime.of(fecha, horaInicio);
            LocalDateTime fin = LocalDateTime.of(fecha, horaFin);

            int duracion = (int) Duration.between(inicio, fin).toMinutes();

            if (duracion <= 0) {
                JOptionPane.showMessageDialog(this, "La hora fin debe ser mayor que la hora inicio");
                return;
            }

            Cita cita = new Cita(
                    0,
                    paciente.getId(),
                    medico.getId(),
                    fechaHora,
                    "Pendiente",
                    "Pendiente de atención",
                    "Pendiente",
                    duracion,
                    inicio,
                    fin
            );

            String respuesta = controlador.agendarNuevaCita(cita);

            JOptionPane.showMessageDialog(this, respuesta);

            String correo = obtenerCorreoPaciente(paciente.getId());

            JOptionPane.showMessageDialog(
                    this,
                    "Notificación enviada al correo: " + correo
                            + "\nLa cita fue registrada correctamente."
            );

            actualizarTabla();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Revise la fecha y la hora ingresada");
        }
    }

    private void eliminarCita() {

        int fila = tblCitas.getSelectedRow();

        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una cita de la tabla");
            return;
        }

        int idCita = Integer.parseInt(tblCitas.getValueAt(fila, 0).toString());

        int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que deseas eliminar esta cita?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION) {
            String respuesta = controlador.eliminarCita(idCita);

            JOptionPane.showMessageDialog(this, respuesta);

            actualizarTabla();
        }
    }

    private void actualizarTabla() {

        modelo.setRowCount(0);

        List<Cita> lista = controlador.listarCitas();

        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

        for (Cita c : lista) {

            Object[] fila = {
                    c.getIdCita(),
                    c.getFechaHora().format(formatoFecha),
                    c.getFechaHora().format(formatoHora),
                    c.getNombrePaciente(),
                    c.getNombreMedico(),
                    c.getEstado()
            };

            modelo.addRow(fila);
        }
    }

    private void cargarPacientes() {

        cboPaciente.removeAllItems();

        String sql = "SELECT idPaciente, nombre, apellido FROM pacientes ORDER BY nombre";

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idPaciente");
                String nombre = rs.getString("nombre") + " " + rs.getString("apellido");

                cboPaciente.addItem(new ItemCombo(id, nombre));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarMedicos() {

        cboMedico.removeAllItems();

        String sql = "SELECT idMedico, nombre, apellido, especialidad FROM medicos ORDER BY nombre";

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idMedico");
                String nombre = rs.getString("nombre") + " " + rs.getString("apellido")
                        + " - " + rs.getString("especialidad");

                cboMedico.addItem(new ItemCombo(id, nombre));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarHoras() {

        cboHoraInicio.removeAllItems();
        cboHoraFin.removeAllItems();

        String[] horas = {
                "08:00", "08:30",
                "09:00", "09:30",
                "10:00", "10:30",
                "11:00", "11:30",
                "12:00", "12:30",
                "13:00", "13:30",
                "14:00", "14:30",
                "15:00", "15:30",
                "16:00", "16:30",
                "17:00", "17:30"
        };

        for (String h : horas) {
            cboHoraInicio.addItem(h);
            cboHoraFin.addItem(h);
        }

        cboHoraInicio.setSelectedItem("09:00");
        cboHoraFin.setSelectedItem("09:30");
    }

    private String obtenerCorreoPaciente(int idPaciente) {

        String correo = "sin correo";

        String sql = "SELECT correo FROM pacientes WHERE idPaciente=?";

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, idPaciente);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                correo = rs.getString("correo");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return correo;
    }

    class ItemCombo {

        private int id;
        private String texto;

        public ItemCombo(int id, String texto) {
            this.id = id;
            this.texto = texto;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return texto;
        }
    }
}