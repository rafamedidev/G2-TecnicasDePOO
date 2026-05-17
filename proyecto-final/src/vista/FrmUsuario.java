package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;

import dao.UsuarioDAO;

public class FrmUsuario extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JTextField txtUsuario;
    private JTextField txtPassword;

    private JComboBox<String> cboRol;

    private UsuarioDAO dao = new UsuarioDAO();

    public FrmUsuario() {
    	this.setLocationRelativeTo(null);
        setTitle("Gestión de Usuarios");

        setSize(500, 330);

        this.setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel();

        contentPane.setLayout(null);

        setContentPane(contentPane);

        JLabel lblTitulo = new JLabel("GESTIÓN DE USUARIOS");

        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));

        lblTitulo.setBounds(0, 20, 500, 30);
        
        contentPane.add(lblTitulo);

        JLabel lblUsuario = new JLabel("Usuario:");

        lblUsuario.setBounds(70, 80, 100, 25);

        contentPane.add(lblUsuario);

        txtUsuario = new JTextField();

        txtUsuario.setBounds(180, 80, 220, 25);

        contentPane.add(txtUsuario);

        JLabel lblPass = new JLabel("Contraseña:");

        lblPass.setBounds(70, 125, 100, 25);

        contentPane.add(lblPass);

        txtPassword = new JTextField();

        txtPassword.setBounds(180, 125, 220, 25);

        contentPane.add(txtPassword);

        JLabel lblRol = new JLabel("Rol:");

        lblRol.setBounds(70, 170, 100, 25);

        contentPane.add(lblRol);

        String roles[] = {
                "Admin",
                "Medico",
                "Recepcion"
        };

        cboRol = new JComboBox<>(roles);

        cboRol.setBounds(180, 170, 220, 25);

        contentPane.add(cboRol);

        JButton btnRegistrar = new JButton("Registrar");

        btnRegistrar.setBounds(180, 225, 130, 35);

        contentPane.add(btnRegistrar);

        btnRegistrar.addActionListener(e -> registrarUsuario());
    }

    private void registrarUsuario() {

        String usuario = txtUsuario.getText().trim();

        String password = txtPassword.getText().trim();

        String rol = cboRol.getSelectedItem().toString();
        
        if (usuario.isEmpty() || password.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Complete todos los campos");

            return;
        }

        if (dao.registrar(usuario, password, rol)) {

            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");

            limpiarCampos();

        } else {

            JOptionPane.showMessageDialog(null, "No se pudo registrar el usuario");
        }
    }

    private void limpiarCampos() {

        txtUsuario.setText("");

        txtPassword.setText("");

        cboRol.setSelectedIndex(0);
    }

    public static void main(String[] args) {

        new FrmUsuario().setVisible(true);
    }
}