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
	public FrmMenu() {
		setBackground(SystemColor.activeCaption);
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 554);
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
		btnMenuCitas.setForeground(Color.BLACK);
		btnMenuCitas.setIcon(new ImageIcon(FrmMenu.class.getResource("/images/cita-medica.png")));
		btnMenuCitas.setFont(new Font("Arial", Font.BOLD, 26));
		btnMenuCitas.setHorizontalAlignment(SwingConstants.CENTER);
		btnMenuCitas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMenuCitas.setVerticalTextPosition(SwingConstants.CENTER);
		btnMenuCitas.setBounds(37, 106, 195, 142);
		contentPane.add(btnMenuCitas);
		
		JButton btnMenuPacientes = new JButton("PACIENTES");
		btnMenuPacientes.setForeground(Color.WHITE);
		btnMenuPacientes.setSelectedIcon(new ImageIcon(FrmMenu.class.getResource("/images/key1.png")));
		btnMenuPacientes.setIcon(new ImageIcon(FrmMenu.class.getResource("/images/pacientes.png")));
		btnMenuPacientes.setFont(new Font("Arial", Font.BOLD, 20));
		btnMenuPacientes.setHorizontalAlignment(SwingConstants.CENTER);
		btnMenuPacientes.setVerticalAlignment(SwingConstants.CENTER);
		btnMenuPacientes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMenuPacientes.setVerticalTextPosition(SwingConstants.CENTER);
		btnMenuPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMenuPacientes.setBounds(37, 254, 195, 142);
		contentPane.add(btnMenuPacientes);
		
		JButton btnMenuMedicos = new JButton("MEDICOS");
		btnMenuMedicos.setForeground(Color.BLACK);
		btnMenuMedicos.setFont(new Font("Arial", Font.BOLD, 25));
		btnMenuMedicos.setHorizontalAlignment(SwingConstants.CENTER);
		btnMenuMedicos.setIcon(new ImageIcon(FrmMenu.class.getResource("/images/doctor.png")));
		btnMenuMedicos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMenuMedicos.setVerticalTextPosition(SwingConstants.CENTER);
		btnMenuMedicos.setBounds(242, 106, 195, 142);
		contentPane.add(btnMenuMedicos);
		
		JButton btnMenuHistorial = new JButton("HISTORIAL CLINICO");
		btnMenuHistorial.setForeground(Color.WHITE);
		btnMenuHistorial.setIcon(new ImageIcon(FrmMenu.class.getResource("/images/historialclinico.png")));
		btnMenuHistorial.setHorizontalAlignment(SwingConstants.CENTER);
		btnMenuHistorial.setVerticalAlignment(SwingConstants.CENTER);
		btnMenuHistorial.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMenuHistorial.setVerticalTextPosition(SwingConstants.CENTER);
		btnMenuHistorial.setFont(new Font("Arial", Font.BOLD, 16));
		btnMenuHistorial.setBounds(242, 254, 195, 142);
		contentPane.add(btnMenuHistorial);
		
		JButton btnMenuReportes = new JButton("REPORTES");
		btnMenuReportes.setForeground(Color.WHITE);
		btnMenuReportes.setIcon(new ImageIcon(FrmMenu.class.getResource("/images/reporte.png")));
		btnMenuReportes.setHorizontalAlignment(SwingConstants.CENTER);
		btnMenuReportes.setVerticalAlignment(SwingConstants.CENTER);
		btnMenuReportes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMenuReportes.setVerticalTextPosition(SwingConstants.CENTER);
		btnMenuReportes.setFont(new Font("Arial", Font.BOLD, 16));
		btnMenuReportes.setBounds(447, 106, 195, 142);
		contentPane.add(btnMenuReportes);
		
		JLabel lblMenuUsuario = new JLabel("¡Hola,");
		lblMenuUsuario.setBounds(37, 89, 46, 14);
		contentPane.add(lblMenuUsuario);
		
		JButton btnNewButton = new JButton("🔑 Cambiar clave");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(757, 11, 130, 23);
		contentPane.add(btnNewButton);

	}
}
