package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


public class FrmMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	// Variables globales para acceder a la sesion del usuario actual
	private String usuarioActual;
	private String rolActual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenu frame = new FrmMenu();
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
	/**
	 * @param usuario
	 * @param rol
	 */
	public FrmMenu() {
		this("Invitado","Sin rol");
	}
	public FrmMenu(String usuario,String rol) {
		
		this.usuarioActual=usuario;
		this.rolActual=rol;
		
		setBackground(SystemColor.activeCaption);
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 554);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("SISTEMA DE GESTION HOSPITALARIA");
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 42, 887, 36);
		contentPane.add(lblTitulo);
		
		JButton btnMenuCitas = new JButton("CITAS");
		btnMenuCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmCita().setVisible(true); // Abre la ventana de Cita
			}
		});
		btnMenuCitas.setForeground(Color.BLACK);
		btnMenuCitas.setIcon(new ImageIcon(FrmMenu.class.getResource("/images/cita-medica.png")));
		btnMenuCitas.setFont(new Font("Arial", Font.BOLD, 16));
		btnMenuCitas.setHorizontalAlignment(SwingConstants.CENTER);
		btnMenuCitas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMenuCitas.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMenuCitas.setBounds(37, 106, 195, 142);
		contentPane.add(btnMenuCitas);
		
		JButton btnMenuPacientes = new JButton("PACIENTES");
		btnMenuPacientes.setForeground(Color.BLACK);
		btnMenuPacientes.setSelectedIcon(new ImageIcon(FrmMenu.class.getResource("/images/key1.png")));
		btnMenuPacientes.setIcon(new ImageIcon(FrmMenu.class.getResource("/images/pacientes.png")));
		btnMenuPacientes.setFont(new Font("Arial", Font.BOLD, 16));
		btnMenuPacientes.setHorizontalAlignment(SwingConstants.CENTER);
		btnMenuPacientes.setVerticalAlignment(SwingConstants.CENTER);
		btnMenuPacientes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMenuPacientes.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMenuPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmPaciente().setVisible(true);
			}
		});
		btnMenuPacientes.setBounds(37, 254, 195, 142);
		contentPane.add(btnMenuPacientes);
		
		JButton btnMenuMedicos = new JButton("MEDICOS");
		btnMenuMedicos.setForeground(Color.BLACK);
		btnMenuMedicos.setFont(new Font("Arial", Font.BOLD, 16));
		btnMenuMedicos.setHorizontalAlignment(SwingConstants.CENTER);
		btnMenuMedicos.setIcon(new ImageIcon(FrmMenu.class.getResource("/images/doctor.png")));
		btnMenuMedicos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMenuMedicos.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMenuMedicos.setBounds(242, 106, 195, 142);
		btnMenuMedicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmMedico().setVisible(true);
			}
		});
		contentPane.add(btnMenuMedicos);
		
		JButton btnMenuHistorial = new JButton("HISTORIAL CLINICO");
		btnMenuHistorial.setForeground(Color.BLACK);
		btnMenuHistorial.setIcon(new ImageIcon(FrmMenu.class.getResource("/images/historialclinico.png")));
		btnMenuHistorial.setHorizontalAlignment(SwingConstants.CENTER);
		btnMenuHistorial.setVerticalAlignment(SwingConstants.CENTER);
		btnMenuHistorial.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMenuHistorial.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMenuHistorial.setFont(new Font("Arial", Font.BOLD, 16));
		btnMenuHistorial.setBounds(242, 254, 195, 142);
		contentPane.add(btnMenuHistorial);
		
		JButton btnMenuReportes = new JButton("REPORTES");
		btnMenuReportes.setForeground(Color.BLACK);
		btnMenuReportes.setIcon(new ImageIcon(FrmMenu.class.getResource("/images/reporte.png")));
		btnMenuReportes.setHorizontalAlignment(SwingConstants.CENTER);
		btnMenuReportes.setVerticalAlignment(SwingConstants.CENTER);
		btnMenuReportes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMenuReportes.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMenuReportes.setFont(new Font("Arial", Font.BOLD, 16));
		btnMenuReportes.setBounds(447, 106, 195, 142);
		btnMenuReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmReporte().setVisible(true);
			}
		});
		contentPane.add(btnMenuReportes);
		
		JLabel lblMenuUsuario = new JLabel("");
		lblMenuUsuario.setBounds(37, 89, 300, 14);
		contentPane.add(lblMenuUsuario);
		lblMenuUsuario.setText("¡Hola, " + usuario + "! - Rol:" + rol);
		
		JButton btnMenuCambiarClave = new JButton("🔑 Cambiar clave");
		btnMenuCambiarClave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmCambioClave(usuarioActual).setVisible(true);
			}
		});
		btnMenuCambiarClave.setBounds(757, 11, 130, 23);
		contentPane.add(btnMenuCambiarClave);
		
		JButton btnMenuAdminSys = new JButton("ADMIN USUARIOS");
		btnMenuAdminSys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmUsuario().setVisible(true);
			}
		});
		btnMenuAdminSys.setVerticalTextPosition(SwingConstants.TOP);
		btnMenuAdminSys.setVerticalAlignment(SwingConstants.CENTER);
		btnMenuAdminSys.setIcon(new ImageIcon(FrmMenu.class.getResource("/images/system-administrator.png")));
		btnMenuAdminSys.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMenuAdminSys.setHorizontalAlignment(SwingConstants.CENTER);
		btnMenuAdminSys.setForeground(Color.BLACK);
		btnMenuAdminSys.setFont(new Font("Arial", Font.BOLD, 12));
		btnMenuAdminSys.setBounds(718, 354, 169, 150);
		contentPane.add(btnMenuAdminSys);

	}
}
