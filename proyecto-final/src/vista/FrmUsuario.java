package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class FrmUsuario extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtUsuario;
	private JTextField txtPassword;

	public FrmUsuario() {

		setTitle("Gestión de Usuarios");
		setSize(450,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(30,30,100,20);
		contentPane.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(140,30,200,20);
		contentPane.add(txtNombre);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(30,70,100,20);
		contentPane.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(140,70,200,20);
		contentPane.add(txtUsuario);

		JLabel lblPass = new JLabel("Contraseña:");
		lblPass.setBounds(30,110,100,20);
		contentPane.add(lblPass);

		txtPassword = new JTextField();
		txtPassword.setBounds(140,110,200,20);
		contentPane.add(txtPassword);

		JLabel lblRol = new JLabel("Rol:");
		lblRol.setBounds(30,150,100,20);
		contentPane.add(lblRol);

		String roles[] = {"Administrador","Medico","Recepcionista"};

		JComboBox<String> cboRol = new JComboBox<>(roles);
		cboRol.setBounds(140,150,200,20);
		contentPane.add(cboRol);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(140,200,120,25);
		contentPane.add(btnRegistrar);
	}

	public static void main(String[] args) {
		new FrmUsuario().setVisible(true);
	}
}