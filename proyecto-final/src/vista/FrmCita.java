package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import controlador.CitaController;
import modelo.Cita;
import java.time.LocalDateTime;
import java.util.List;

public class FrmCita extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDiagnostico;
	private JTextField txtDuracion;
	private JTable tblCitas;
	private DefaultTableModel modelo;
	private CitaController controlador;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCita frame = new FrmCita();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmCita() {
		controlador = new CitaController();
		setTitle("Panel de Control - Citas Médicas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 500); // Ventana más grande para la tabla
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblDiagnostico = new JLabel("Diagnóstico:");
		lblDiagnostico.setBounds(30, 20, 100, 14);
		contentPane.add(lblDiagnostico);

		txtDiagnostico = new JTextField();
		txtDiagnostico.setBounds(140, 17, 400, 25);
		contentPane.add(txtDiagnostico);

		JLabel lblDuracion = new JLabel("Duración (min):");
		lblDuracion.setBounds(30, 60, 100, 14);
		contentPane.add(lblDuracion);

		txtDuracion = new JTextField();
		txtDuracion.setBounds(140, 57, 100, 25);
		contentPane.add(txtDuracion);

		JButton btnAgendar = new JButton("Agendar Cita");
		btnAgendar.setBounds(140, 100, 150, 30);
		contentPane.add(btnAgendar);

		// Configuración de la Tabla
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 150, 520, 280);
		contentPane.add(scrollPane);
		
		tblCitas = new JTable();
		modelo = new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Fecha/Hora", "Estado", "Diagnóstico", "Min." });
		tblCitas.setModel(modelo);
		scrollPane.setViewportView(tblCitas);
		
		// Ajuste manual de anchos de columna
		tblCitas.getColumnModel().getColumn(0).setPreferredWidth(20);  // ID pequeño
		tblCitas.getColumnModel().getColumn(1).setPreferredWidth(100); // Fecha/Hora más ancho
		tblCitas.getColumnModel().getColumn(2).setPreferredWidth(60);  // Estado
		tblCitas.getColumnModel().getColumn(3).setPreferredWidth(250); // Diagnóstico amplio
		tblCitas.getColumnModel().getColumn(4).setPreferredWidth(40);  // Minutos pequeño

		// Cargar datos al abrir
		actualizarTabla();

		btnAgendar.addActionListener(e -> {
			try {
				String diag = txtDiagnostico.getText();
				int dur = Integer.parseInt(txtDuracion.getText());

				Cita nuevaCita = new Cita(0, LocalDateTime.now(), "Pendiente", diag, dur);
				String respuesta = controlador.agendarNuevaCita(nuevaCita);

				JOptionPane.showMessageDialog(this, respuesta);
				
				txtDiagnostico.setText("");
				txtDuracion.setText("");
				
				actualizarTabla(); // Refresca la tabla automáticamente
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Por favor, ingresa una duración válida.");
			}
		});
	}

	public void actualizarTabla() {
		modelo.setRowCount(0); // Limpia la tabla actual
		List<Cita> lista = controlador.listarCitas(); // Asegúrate que el controlador tenga este método
		
		for (Cita c : lista) {
			Object[] fila = {
				c.getIdCita(),
				c.getFechaHora().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
				c.getEstado(),
				c.getDiagnostico(),
				c.getDuracionMinutos()
			};
			modelo.addRow(fila);
		}
	}
}