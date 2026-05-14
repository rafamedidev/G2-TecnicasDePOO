package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.PacienteDAO;
import modelo.Paciente;

public class FrmPaciente extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtDni;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JTextField txtHistorialClinico;
    private JTextField txtContactoEmergencia;
    private JTextField txtBuscar;

    private JTable tablaPacientes;
    private DefaultTableModel modeloTabla;

    private PacienteDAO dao = new PacienteDAO();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FrmPaciente frame = new FrmPaciente();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FrmPaciente() {
        setTitle("Gestión de Pacientes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 950, 600);
        getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("GESTIÓN DE PACIENTES");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setBounds(330, 20, 300, 30);
        getContentPane().add(lblTitulo);

        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(40, 80, 120, 25);
        getContentPane().add(lblDni);

        txtDni = new JTextField();
        txtDni.setBounds(170, 80, 200, 25);
        getContentPane().add(txtDni);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(40, 120, 120, 25);
        getContentPane().add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(170, 120, 200, 25);
        getContentPane().add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(40, 160, 120, 25);
        getContentPane().add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setBounds(170, 160, 200, 25);
        getContentPane().add(txtApellido);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(40, 200, 120, 25);
        getContentPane().add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(170, 200, 200, 25);
        getContentPane().add(txtTelefono);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(40, 240, 120, 25);
        getContentPane().add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(170, 240, 200, 25);
        getContentPane().add(txtCorreo);

        JLabel lblHistorial = new JLabel("Historial Clínico:");
        lblHistorial.setBounds(430, 80, 140, 25);
        getContentPane().add(lblHistorial);

        txtHistorialClinico = new JTextField();
        txtHistorialClinico.setBounds(580, 80, 250, 25);
        getContentPane().add(txtHistorialClinico);

        JLabel lblContacto = new JLabel("Contacto Emergencia:");
        lblContacto.setBounds(430, 120, 150, 25);
        getContentPane().add(lblContacto);

        txtContactoEmergencia = new JTextField();
        txtContactoEmergencia.setBounds(580, 120, 250, 25);
        getContentPane().add(txtContactoEmergencia);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(40, 310, 120, 30);
        getContentPane().add(btnRegistrar);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(180, 310, 120, 30);
        getContentPane().add(btnActualizar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(320, 310, 120, 30);
        getContentPane().add(btnEliminar);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(460, 310, 120, 30);
        getContentPane().add(btnLimpiar);

        JLabel lblBuscar = new JLabel("Buscar por DNI / Nombre / Apellido:");
        lblBuscar.setBounds(40, 365, 250, 25);
        getContentPane().add(lblBuscar);

        txtBuscar = new JTextField();
        txtBuscar.setBounds(280, 365, 260, 25);
        getContentPane().add(txtBuscar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(560, 365, 110, 25);
        getContentPane().add(btnBuscar);

        JButton btnListar = new JButton("Listar Todo");
        btnListar.setBounds(690, 365, 120, 25);
        getContentPane().add(btnListar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(40, 410, 860, 120);
        getContentPane().add(scrollPane);

        tablaPacientes = new JTable();
        scrollPane.setViewportView(tablaPacientes);

        listarPacientes();

        btnRegistrar.addActionListener(e -> registrarPaciente());

        btnActualizar.addActionListener(e -> actualizarPaciente());

        btnEliminar.addActionListener(e -> eliminarPaciente());

        btnBuscar.addActionListener(e -> buscarPaciente());

        btnLimpiar.addActionListener(e -> limpiarCampos());

        btnListar.addActionListener(e -> listarPacientes());

        tablaPacientes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                seleccionarPaciente();
            }
        });
    }

    private void registrarPaciente() {
        if (validarCampos()) {

            Paciente p = new Paciente(
                    txtDni.getText().trim(),
                    txtNombre.getText().trim(),
                    txtApellido.getText().trim(),
                    txtTelefono.getText().trim(),
                    txtHistorialClinico.getText().trim(),
                    txtContactoEmergencia.getText().trim()
            );

            p.setCorreo(txtCorreo.getText().trim());

            if (dao.registrar(p)) {
                JOptionPane.showMessageDialog(null, "Paciente registrado correctamente");
                listarPacientes();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar el paciente");
            }
        }
    }

    private void actualizarPaciente() {
        if (txtDni.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un paciente de la tabla");
            return;
        }

        if (validarCampos()) {

            Paciente p = new Paciente(
                    txtDni.getText().trim(),
                    txtNombre.getText().trim(),
                    txtApellido.getText().trim(),
                    txtTelefono.getText().trim(),
                    txtHistorialClinico.getText().trim(),
                    txtContactoEmergencia.getText().trim()
            );

            p.setCorreo(txtCorreo.getText().trim());

            if (dao.actualizar(p)) {
                JOptionPane.showMessageDialog(null, "Paciente actualizado correctamente");
                listarPacientes();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el paciente");
            }
        }
    }

    private void eliminarPaciente() {
        if (txtDni.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione o ingrese el DNI del paciente");
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(
                null,
                "¿Seguro que deseas eliminar este paciente?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION) {
            if (dao.eliminar(txtDni.getText().trim())) {
                JOptionPane.showMessageDialog(null, "Paciente eliminado correctamente");
                listarPacientes();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el paciente");
            }
        }
    }

    private void buscarPaciente() {
        String criterio = txtBuscar.getText().trim();

        if (criterio.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un DNI, nombre o apellido para buscar");
            return;
        }

        cargarTabla(dao.buscar(criterio));

        if (tablaPacientes.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No se encontraron pacientes");
        }
    }

    private void listarPacientes() {
        cargarTabla(dao.listar());
    }

    private void cargarTabla(ArrayList<Paciente> lista) {
        modeloTabla = new DefaultTableModel();

        modeloTabla.addColumn("DNI");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Teléfono");
        modeloTabla.addColumn("Correo");
        modeloTabla.addColumn("Historial Clínico");
        modeloTabla.addColumn("Contacto Emergencia");

        for (Paciente p : lista) {
            Object[] fila = {
                    p.getDni(),
                    p.getNombre(),
                    p.getApellido(),
                    p.getTelefono(),
                    p.getCorreo(),
                    p.getHistorialClinico(),
                    p.getContactoEmergencia()
            };

            modeloTabla.addRow(fila);
        }

        tablaPacientes.setModel(modeloTabla);
    }

    private void seleccionarPaciente() {
        int fila = tablaPacientes.getSelectedRow();

        if (fila >= 0) {
            txtDni.setText(tablaPacientes.getValueAt(fila, 0).toString());
            txtNombre.setText(tablaPacientes.getValueAt(fila, 1).toString());
            txtApellido.setText(tablaPacientes.getValueAt(fila, 2).toString());
            txtTelefono.setText(tablaPacientes.getValueAt(fila, 3).toString());
            txtCorreo.setText(tablaPacientes.getValueAt(fila, 4).toString());
            txtHistorialClinico.setText(tablaPacientes.getValueAt(fila, 5).toString());
            txtContactoEmergencia.setText(tablaPacientes.getValueAt(fila, 6).toString());
        }
    }

    private boolean validarCampos() {
        if (txtDni.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El DNI es obligatorio");
            return false;
        }

        if (txtDni.getText().trim().length() != 8) {
            JOptionPane.showMessageDialog(null, "El DNI debe tener 8 dígitos");
            return false;
        }

        if (!txtDni.getText().trim().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "El DNI solo debe contener números");
            return false;
        }

        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre es obligatorio");
            return false;
        }

        if (txtApellido.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El apellido es obligatorio");
            return false;
        }

        if (txtTelefono.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El teléfono es obligatorio");
            return false;
        }

        if (txtCorreo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El correo es obligatorio");
            return false;
        }

        if (!txtCorreo.getText().contains("@")) {
            JOptionPane.showMessageDialog(null, "Ingrese un correo válido");
            return false;
        }

        return true;
    }

    private void limpiarCampos() {
        txtDni.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtHistorialClinico.setText("");
        txtContactoEmergencia.setText("");
        txtBuscar.setText("");
    }
}