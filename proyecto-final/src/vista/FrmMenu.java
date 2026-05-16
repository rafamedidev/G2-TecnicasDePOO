package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
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
		setTitle("Menú Principal - Gestión Hospitalaria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 554);
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
	    contentPane.setBackground(new Color(245, 247, 250)); // Fondo neutro profesional
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	    
	    // --- CABECERA ---
	    JPanel header = new JPanel();
	    header.setBackground(Color.WHITE);
	    header.setBounds(0, 0, 950, 80);
	    header.setLayout(null);
	    header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(220, 220, 220)));
	    contentPane.add(header);
		
	    // VENTANA PRINCIPAL
	    JLabel lblTitulo = new JLabel("SISTEMA DE GESTION HOSPITALARIA");
	    lblTitulo.setForeground(new Color(26, 35, 126)); // Azul Indigo médico
	    lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
	    lblTitulo.setBounds(20, 20, 500, 40);
	    header.add(lblTitulo);
		
	    // - BOTON FORMULARIO CITAS
		JButton btnMenuCitas = new JButton("CITAS");
		btnMenuCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmCita().setVisible(true); // Abre la ventana de Cita
			}
		});
		estilizarBoton(btnMenuCitas, "/images/cita-medica.png");
		btnMenuCitas.setBounds(37, 130, 200, 160);
		contentPane.add(btnMenuCitas);
		
		// - BOTON FORMULARIO PACIENTES
		JButton btnMenuPacientes = new JButton("PACIENTES");
		estilizarBoton(btnMenuPacientes, "/images/pacientes.png");
	    btnMenuPacientes.setBounds(37, 310, 200, 160);
		btnMenuPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmPaciente().setVisible(true);
			}
		});
		contentPane.add(btnMenuPacientes);
		
		// BOTON FORMULARIO MEDICOS
		JButton btnMenuMedicos = new JButton("MEDICOS");
		estilizarBoton(btnMenuMedicos, "/images/doctor.png");
	    btnMenuMedicos.setBounds(257, 130, 200, 160);
		btnMenuMedicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmMedico().setVisible(true);
			}
		});
		contentPane.add(btnMenuMedicos);
		
		// BOTON FORMULARIO HISTORIAL CLINICO
		JButton btnMenuHistorial = new JButton("HISTORIAL CLINICO");
		btnMenuHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmHistoriaClinica().setVisible(true);
			}
		});
		estilizarBoton(btnMenuHistorial, "/images/historialclinico.png");
	    btnMenuHistorial.setBounds(257, 310, 200, 160);
	    contentPane.add(btnMenuHistorial);
		
	    // BOTON FORMULARIO REPORTES
		JButton btnMenuReportes = new JButton("REPORTES");
		estilizarBoton(btnMenuReportes, "/images/reporte.png");
	    btnMenuReportes.setBounds(477, 130, 200, 160);
		btnMenuReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmReporte().setVisible(true);
			}
		});
		contentPane.add(btnMenuReportes);
		
		// LABEL PARA MOSTRAR USUARIO CON SESION INICIADA Y ROL
		JLabel lblMenuUsuario = new JLabel("");
		lblMenuUsuario.setFont(new Font("Segoe UI", Font.ITALIC, 13));
	    lblMenuUsuario.setForeground(new Color(100, 116, 139));
	    lblMenuUsuario.setBounds(37, 95, 400, 20);
		contentPane.add(lblMenuUsuario);
		lblMenuUsuario.setText("¡Hola, " + usuario + "! - Rol: " + rol);
		
		// BOTON CAMBIAR CLAVE
		JButton btnMenuCambiarClave = new JButton("");
		btnMenuCambiarClave.setToolTipText("Cambiar contraseña");
		btnMenuCambiarClave.setFocusPainted(false);
		btnMenuCambiarClave.setBorderPainted(false);
		btnMenuCambiarClave.setContentAreaFilled(false); // Lo hacemos transparente inicialmente
		btnMenuCambiarClave.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnMenuCambiarClave.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnMenuCambiarClave.setForeground(new Color(71, 85, 105));
		btnMenuCambiarClave.setIcon(new ImageIcon(FrmMenu.class.getResource("/images/keyChange.png")));
		btnMenuCambiarClave.setBounds(753, 20, 63, 49);
		btnMenuCambiarClave.setHorizontalAlignment(SwingConstants.RIGHT);
		// Efecto Hover para que el usuario sepa que es clickeable
		btnMenuCambiarClave.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnMenuCambiarClave.setForeground(new Color(37, 99, 235)); // Azul brillante al pasar el mouse
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnMenuCambiarClave.setForeground(new Color(71, 85, 105)); // Vuelve al color original
		    }
		});
		btnMenuCambiarClave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmCambioClave(usuarioActual).setVisible(true);
			}
		});
		header.add(btnMenuCambiarClave);
		
		JButton btnCerrarSesion = new JButton("");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, 
			            "¿Estás seguro de que deseas cerrar sesión?", "Cerrar Sesión", 
			            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			            
			        if (confirm == JOptionPane.YES_OPTION) {
			            ejecutarCerrarSesion();
			        }
			}
		});
		btnCerrarSesion.setToolTipText("Cerrar Sesion");
		btnCerrarSesion.setBounds(820, 20, 72, 49);
		btnCerrarSesion.setFocusPainted(false);
		btnCerrarSesion.setBorderPainted(false);
		btnCerrarSesion.setContentAreaFilled(false); // Lo hacemos transparente inicialmente
		btnCerrarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCerrarSesion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnCerrarSesion.setForeground(new Color(71, 85, 105));
		btnCerrarSesion.setIcon(new ImageIcon(FrmMenu.class.getResource("/images/cerrar-sesion.png")));
		header.add(btnCerrarSesion);
		
		// BOTON DE ADMIN
		JButton btnMenuAdminSys = new JButton("ADMIN SISTEMA");
		estilizarBoton(btnMenuAdminSys, "/images/system-administrator.png");
	    btnMenuAdminSys.setBackground(new Color(45, 52, 54)); // Gris muy oscuro
	    btnMenuAdminSys.setForeground(Color.GRAY);
	    btnMenuAdminSys.setBounds(700, 310, 200, 160);
		btnMenuAdminSys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmUsuario().setVisible(true);
			}
		});
		contentPane.add(btnMenuAdminSys);

	}
	private void estilizarBoton(JButton btn, String iconPath) {
	    btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
	    btn.setBackground(Color.WHITE);
	    btn.setForeground(new Color(51, 51, 51));
	    btn.setFocusPainted(false);
	    btn.setVerticalTextPosition(SwingConstants.BOTTOM);
	    btn.setHorizontalTextPosition(SwingConstants.CENTER);
	    
	    // Borde suave redondeado (simulado con LineBorder)
	    btn.setBorder(BorderFactory.createCompoundBorder(
	        BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
	        BorderFactory.createEmptyBorder(10, 10, 10, 10)
	    ));
	    
	    try {
	        btn.setIcon(new ImageIcon(FrmMenu.class.getResource(iconPath)));
	    } catch(Exception e) {
	        System.out.println("No se pudo cargar: " + iconPath);
	    }

	    // Efecto Hover nativo
	    btn.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	            btn.setBackground(new Color(232, 240, 254)); // Celeste muy claro al pasar el mouse
	        }
	        public void mouseExited(java.awt.event.MouseEvent evt) {
	            btn.setBackground(Color.WHITE);
	        }
	    });
	}
	private void ejecutarCerrarSesion() {
	    this.dispose(); 
	    this.usuarioActual = null;
	    this.rolActual = null;
	    
	    // Abre el login de nuevo
	    // Como el login suele ser la puerta de entrada, lo llamamos directamente
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                FrmLogin login = new FrmLogin();
	                login.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}
}
