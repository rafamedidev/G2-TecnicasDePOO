package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.HistoriaClinicaDAO;

public class FrmHistoriaClinica extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JComboBox<ItemCombo> cboPaciente;
    private JComboBox<ItemCombo> cboMedico;

    private JTextArea txtHistorialBase;

    private JTextField txtDiagnostico;
    private JTextField txtTratamiento;
    private JTextField txtDiagnosticoFinal;

    private JTable tblHistorial;
    private DefaultTableModel modelo;

    private HistoriaClinicaDAO dao = new HistoriaClinicaDAO();

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            try {

                FrmHistoriaClinica frame = new FrmHistoriaClinica();

                frame.setVisible(true);

            } catch (Exception e) {

                e.printStackTrace();
            }
        });
    }

    public FrmHistoriaClinica() {

        setTitle("Historia Clínica");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setBounds(100, 100, 900, 620);

        setLocationRelativeTo(null);

        contentPane = new JPanel();

        contentPane.setLayout(null);

        setContentPane(contentPane);

        JLabel lblTitulo = new JLabel("HISTORIA CLÍNICA", SwingConstants.CENTER);

        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));

        lblTitulo.setBounds(0, 20, 900, 30);

        contentPane.add(lblTitulo);

        JLabel lblPaciente = new JLabel("Paciente:");

        lblPaciente.setBounds(40, 80, 120, 25);

        contentPane.add(lblPaciente);

        cboPaciente = new JComboBox<>();

        cboPaciente.setBounds(150, 80, 280, 25);

        contentPane.add(cboPaciente);

        JButton btnVerHistorial = new JButton("Ver Historial");

        btnVerHistorial.setBounds(450, 80, 140, 25);

        contentPane.add(btnVerHistorial);

        JLabel lblHistorialBase = new JLabel("Historial base del paciente:");

        lblHistorialBase.setBounds(40, 120, 200, 25);

        contentPane.add(lblHistorialBase);

        txtHistorialBase = new JTextArea();

        txtHistorialBase.setLineWrap(true);

        txtHistorialBase.setWrapStyleWord(true);

        txtHistorialBase.setEditable(false);

        JScrollPane scrollHistorialBase = new JScrollPane(txtHistorialBase);

        scrollHistorialBase.setBounds(40, 150, 820, 70);

        contentPane.add(scrollHistorialBase);

        JLabel lblMedico = new JLabel("Médico:");

        lblMedico.setBounds(40, 245, 120, 25);

        contentPane.add(lblMedico);

        cboMedico = new JComboBox<>();

        cboMedico.setBounds(150, 245, 320, 25);

        contentPane.add(cboMedico);

        JLabel lblDiagnostico = new JLabel("Diagnóstico:");

        lblDiagnostico.setBounds(40, 285, 120, 25);

        contentPane.add(lblDiagnostico);

        txtDiagnostico = new JTextField();

        txtDiagnostico.setBounds(150, 285, 320, 25);

        contentPane.add(txtDiagnostico);

        JLabel lblTratamiento = new JLabel("Tratamiento:");

        lblTratamiento.setBounds(500, 285, 120, 25);

        contentPane.add(lblTratamiento);

        txtTratamiento = new JTextField();

        txtTratamiento.setBounds(610, 285, 250, 25);

        contentPane.add(txtTratamiento);

        JButton btnAgregarDiagnostico = new JButton("Agregar Diagnóstico");

        btnAgregarDiagnostico.setBounds(150, 325, 180, 30);

        contentPane.add(btnAgregarDiagnostico);

        JLabel lblDiagnosticoFinal = new JLabel("Diagnóstico final:");

        lblDiagnosticoFinal.setBounds(40, 380, 130, 25);

        contentPane.add(lblDiagnosticoFinal);

        txtDiagnosticoFinal = new JTextField();

        txtDiagnosticoFinal.setBounds(170, 380, 420, 25);

        contentPane.add(txtDiagnosticoFinal);

        JButton btnAltaMedica = new JButton("Registrar Alta Médica");

        btnAltaMedica.setBounds(610, 378, 190, 30);

        contentPane.add(btnAltaMedica);

        JLabel lblTabla = new JLabel("Historial de atenciones registradas:");

        lblTabla.setBounds(40, 425, 300, 25);

        contentPane.add(lblTabla);

        JScrollPane scrollPane = new JScrollPane();

        scrollPane.setBounds(40, 455, 820, 100);

        contentPane.add(scrollPane);

        tblHistorial = new JTable();

        modelo = new DefaultTableModel(
                new Object[][] {},
                new String[] {
                        "Fecha", "Diagnóstico", "Tratamiento", "Médico", "Especialidad", "Estado", "Duración"
                }
        );

        tblHistorial.setModel(modelo);

        scrollPane.setViewportView(tblHistorial);

        cargarPacientes();

        cargarMedicos();

        btnVerHistorial.addActionListener(e -> cargarHistorial());

        btnAgregarDiagnostico.addActionListener(e -> agregarDiagnostico());

        btnAltaMedica.addActionListener(e -> registrarAltaMedica());
    }

    private void cargarPacientes() {

        cboPaciente.removeAllItems();

        try {

            ResultSet rs = dao.listarPacientes();

            while (rs != null && rs.next()) {

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

        try {

            ResultSet rs = dao.listarMedicos();

            while (rs != null && rs.next()) {

                int id = rs.getInt("idMedico");

                String nombre = rs.getString("nombre") + " " + rs.getString("apellido")
                        + " - " + rs.getString("especialidad");

                cboMedico.addItem(new ItemCombo(id, nombre));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private void cargarHistorial() {

        modelo.setRowCount(0);

        ItemCombo paciente = (ItemCombo) cboPaciente.getSelectedItem();

        if (paciente == null) {

            JOptionPane.showMessageDialog(this, "Seleccione un paciente");

            return;
        }

        String historialBase = dao.obtenerHistorialBasePaciente(paciente.getId());

        txtHistorialBase.setText(historialBase);

        try {

            ResultSet rs = dao.buscarHistorialPorPaciente(paciente.getId());

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            while (rs != null && rs.next()) {

                String fecha = rs.getTimestamp("fechaHora").toLocalDateTime().format(formato);

                String diagnostico = rs.getString("diagnostico");

                String tratamiento = rs.getString("tratamiento");

                String medico = rs.getString("medico");

                String especialidad = rs.getString("especialidad");

                String estado = rs.getString("estado");

                int duracion = rs.getInt("duracionMinutos");

                Object[] fila = {
                        fecha,
                        diagnostico,
                        tratamiento,
                        medico,
                        especialidad,
                        estado,
                        duracion + " min"
                };

                modelo.addRow(fila);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private void agregarDiagnostico() {

        ItemCombo paciente = (ItemCombo) cboPaciente.getSelectedItem();

        ItemCombo medico = (ItemCombo) cboMedico.getSelectedItem();

        if (paciente == null || medico == null) {

            JOptionPane.showMessageDialog(this, "Seleccione paciente y médico");

            return;
        }

        String diagnostico = txtDiagnostico.getText().trim();

        String tratamiento = txtTratamiento.getText().trim();

        if (diagnostico.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Ingrese el diagnóstico");

            return;
        }

        if (tratamiento.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Ingrese el tratamiento");

            return;
        }

        if (dao.agregarDiagnostico(paciente.getId(), medico.getId(), diagnostico, tratamiento)) {

            JOptionPane.showMessageDialog(this, "Diagnóstico agregado correctamente");

            txtDiagnostico.setText("");

            txtTratamiento.setText("");

            cargarHistorial();

        } else {

            JOptionPane.showMessageDialog(this, "No se pudo agregar el diagnóstico");
        }
    }

    private void registrarAltaMedica() {

        ItemCombo paciente = (ItemCombo) cboPaciente.getSelectedItem();

        if (paciente == null) {

            JOptionPane.showMessageDialog(this, "Seleccione un paciente");

            return;
        }

        String diagnosticoFinal = txtDiagnosticoFinal.getText().trim();

        if (diagnosticoFinal.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Ingrese el diagnóstico final");

            return;
        }

        int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que deseas registrar el alta médica de este paciente?",
                "Confirmar Alta Médica",
                JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION) {

            if (dao.registrarAltaMedica(paciente.getId(), diagnosticoFinal)) {

                String resumen = "RESUMEN DE SALIDA\n\n"
                        + "Paciente: " + paciente.toString() + "\n"
                        + "Estado: Alta médica\n"
                        + "Diagnóstico final: " + diagnosticoFinal + "\n"
                        + "El paciente fue dado de alta correctamente.";

                JOptionPane.showMessageDialog(this, resumen);

                txtDiagnosticoFinal.setText("");

                cargarHistorial();

            } else {

                JOptionPane.showMessageDialog(this, "No se pudo registrar el alta médica");
            }
        }
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