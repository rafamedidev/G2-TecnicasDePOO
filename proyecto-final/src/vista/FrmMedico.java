package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import modelo.Medico;

public class FrmMedico extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtColegiatura;


	public FrmMedico() {

		setTitle("Asignar Especialidad");
		setSize(450,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);


		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(30,30,100,20);
		contentPane.add(lblNombre);


		txtNombre = new JTextField();
		txtNombre.setBounds(150,30,200,20);
		contentPane.add(txtNombre);


		JLabel lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setBounds(30,80,100,20);
		contentPane.add(lblEspecialidad);


		String especialidades[] = {
				"Cardiologia",
				"Pediatria",
				"Traumatologia"
		};


		final JComboBox<String> cboEspecialidad =
				new JComboBox<>(especialidades);

		cboEspecialidad.setBounds(150,80,200,20);
		contentPane.add(cboEspecialidad);


		JLabel lblColegiatura = new JLabel("Colegiatura:");
		lblColegiatura.setBounds(30,130,100,20);
		contentPane.add(lblColegiatura);


		txtColegiatura = new JTextField();
		txtColegiatura.setBounds(150,130,200,20);
		contentPane.add(txtColegiatura);


		JButton btnAsignar = new JButton("Asignar");


		btnAsignar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String nombre = txtNombre.getText();

				String especialidad =
						cboEspecialidad.getSelectedItem().toString();

				String colegiatura =
						txtColegiatura.getText();


				Medico medico = new Medico(
						0,
						"",
						nombre,
						"",
						"",
						especialidad,
						colegiatura
				);


				JOptionPane.showMessageDialog(null,
						"Especialidad asignada correctamente\n\n" +
						"Médico: " + nombre +
						"\nEspecialidad: " +
						medico.getEspecialidad());

			}
		});


		btnAsignar.setBounds(150,200,120,25);
		contentPane.add(btnAsignar);

	}


	public static void main(String[] args) {

		new FrmMedico().setVisible(true);

	}
}