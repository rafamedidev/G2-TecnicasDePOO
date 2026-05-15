package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UsuarioDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCambioClave extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtContrasenaActual;
	private JPasswordField txtContrasenaNueva;
	
	private String usuarioLogeado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCambioClave frame = new FrmCambioClave("");
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
	public FrmCambioClave(String usuario) {
		this.usuarioLogeado=usuario;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
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
		lblMostrarUsuario.setText(usuario); //label donde muestra el usuario que se cambiara contraseña
		contentPane.add(lblMostrarUsuario);
		
		JLabel lblContrasenaNueva = new JLabel("Nueva contraseña:");
		lblContrasenaNueva.setBounds(81, 124, 125, 14);
		contentPane.add(lblContrasenaNueva);
		
		JButton btnGuardarNClave = new JButton("Guardar");
		btnGuardarNClave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 1. Obtener los datos de los campos
		        String actual = new String(txtContrasenaActual.getPassword());
		        String nueva = new String(txtContrasenaNueva.getPassword());

		        if (actual.isEmpty() || nueva.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
		            return;
		        }

		        UsuarioDAO dao = new UsuarioDAO();

		        // 2. Validar identidad: Intentamos un login con la clave actual
		        // Reutilizamos tu método login() que ya funciona
		        modelo.Usuario u = dao.login(usuarioLogeado, actual);

		        if (u != null) {
		            // 3. Lógica de negocio: Usamos el método cambiarContraseña de TU MODELO
		            if (u.cambiarContraseña(nueva)) {
		                
		                // 4. Persistencia: Si el modelo aceptó la clave, la mandamos a la BD
		                if (dao.actualizarPassword(usuarioLogeado, u.getPassword())) {
		                    JOptionPane.showMessageDialog(null, "¡Contraseña actualizada con éxito!");
		                    dispose(); // Cerramos solo esta ventana
		                } else {
		                    JOptionPane.showMessageDialog(null, "Error técnico al guardar en la base de datos.");
		                }
		                
		            } else {
		                JOptionPane.showMessageDialog(null, "La nueva contraseña no cumple con los requisitos.");
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "La contraseña actual es incorrecta.");
		        }
			}
		});
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
		
		this.getRootPane().setDefaultButton(btnGuardarNClave);

	}
}
