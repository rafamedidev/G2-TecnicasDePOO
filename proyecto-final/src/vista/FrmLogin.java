package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UsuarioDAO;
import modelo.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class FrmLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("ACCESO AL SISTEMA");
		lblNewLabel.setBounds(104, 11, 185, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblNewLabel);
		
		JLabel lbl_img_login = new JLabel("");
		lbl_img_login.setIcon(new ImageIcon(FrmLogin.class.getResource("/images/Login.png")));
		lbl_img_login.setBounds(10, 44, 125, 135);
		contentPane.add(lbl_img_login);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 1. Obtener los datos de los campos de texto
				String user = txtUsuario.getText();
				String pass = new String(txtContra.getPassword());

				// 2. Llamar al DAO para validar
				UsuarioDAO dao = new UsuarioDAO();

				//if (dao.login(user, pass)) {
				Usuario usuarioLogueado = dao.login(user, pass);
				if (usuarioLogueado!=null) {
				    javax.swing.JOptionPane.showMessageDialog(null, "¡Bienvenido al Sistema!");
				    // Aquí podrías abrir la siguiente ventana más adelante
				    FrmMenu menu = new FrmMenu(usuarioLogueado.getUsername(),usuarioLogueado.getRol());
				    menu.setVisible(true);
				    FrmLogin.this.dispose();
				    
				} else {
				    javax.swing.JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
			        txtContra.setText("");
			        txtUsuario.requestFocus();
				}
			}
		});
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIngresar.setBounds(174, 153, 89, 23);
		contentPane.add(btnIngresar);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(273, 153, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario.setBounds(177, 61, 64, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContra = new JLabel("Contraseña:");
		lblContra.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContra.setBounds(177, 103, 89, 14);
		contentPane.add(lblContra);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(276, 58, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContra = new JPasswordField();
		txtContra.setBounds(276, 101, 86, 20);
		contentPane.add(txtContra);
		
		// Action para presionar boton btnIngresar con la tecla enter
		getRootPane().setDefaultButton(btnIngresar);

	}
}
