package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class FrmCambioClave extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtContrasenaActual;
	private JPasswordField txtContrasenaNueva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCambioClave frame = new FrmCambioClave();
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
	public FrmCambioClave() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuarioActual = new JLabel("Usuario:");
		lblUsuarioActual.setBounds(81, 65, 125, 14);
		contentPane.add(lblUsuarioActual);
		
		JLabel lblTituloCambioClave = new JLabel("CAMBIO DE CONTRASEÑA");
		lblTituloCambioClave.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTituloCambioClave.setBounds(110, 11, 244, 14);
		lblTituloCambioClave.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloCambioClave.setVerticalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTituloCambioClave);
		
		JLabel lblContrasenaActual = new JLabel("Contraseña actual:");
		lblContrasenaActual.setBounds(81, 95, 125, 14);
		contentPane.add(lblContrasenaActual);
		
		JLabel lblMostrarUsuario = new JLabel("");
		lblMostrarUsuario.setBounds(216, 65, 120, 14);
		contentPane.add(lblMostrarUsuario);
		
		JLabel lblContrasenaNueva = new JLabel("Nueva contraseña:");
		lblContrasenaNueva.setBounds(81, 124, 125, 14);
		contentPane.add(lblContrasenaNueva);
		
		JButton btnGuardarNClave = new JButton("Guardar");
		btnGuardarNClave.setBounds(117, 170, 89, 23);
		contentPane.add(btnGuardarNClave);
		
		JButton btnCancelarNClave = new JButton("Cancelar");
		btnCancelarNClave.setBounds(216, 170, 89, 23);
		contentPane.add(btnCancelarNClave);
		
		txtContrasenaActual = new JPasswordField();
		txtContrasenaActual.setBounds(216, 92, 120, 20);
		contentPane.add(txtContrasenaActual);
		
		txtContrasenaNueva = new JPasswordField();
		txtContrasenaNueva.setBounds(216, 121, 120, 20);
		contentPane.add(txtContrasenaNueva);

	}
}
