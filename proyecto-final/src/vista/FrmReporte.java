package vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dao.ReporteDAO;

public class FrmReporte extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JLabel lblResultadoTitulo;
    private JLabel lblResultadoValor;

    private ReporteDAO dao = new ReporteDAO();

    public FrmReporte() {

        setTitle("Reportes");
        setSize(650, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblTitulo = new JLabel("REPORTES DEL SISTEMA", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setBounds(0, 20, 650, 30);
        contentPane.add(lblTitulo);

        JLabel lblOpciones = new JLabel("Opciones de Reporte");
        lblOpciones.setFont(new Font("Arial", Font.BOLD, 13));
        lblOpciones.setBounds(40, 70, 200, 25);
        contentPane.add(lblOpciones);

        JButton btnTotalPacientes = new JButton("Total de Pacientes");
        btnTotalPacientes.setBounds(40, 110, 180, 35);
        contentPane.add(btnTotalPacientes);

        JButton btnCitasDia = new JButton("Citas del Día");
        btnCitasDia.setBounds(40, 160, 180, 35);
        contentPane.add(btnCitasDia);

        JLabel lblResultados = new JLabel("Resultado del Reporte");
        lblResultados.setFont(new Font("Arial", Font.BOLD, 13));
        lblResultados.setBounds(280, 70, 250, 25);
        contentPane.add(lblResultados);

        JPanel panelResultado = new JPanel();
        panelResultado.setLayout(null);
        panelResultado.setBounds(280, 110, 310, 85);
        contentPane.add(panelResultado);

        lblResultadoTitulo = new JLabel("Seleccione una opción");
        lblResultadoTitulo.setFont(new Font("Arial", Font.PLAIN, 14));
        lblResultadoTitulo.setBounds(20, 15, 220, 25);
        panelResultado.add(lblResultadoTitulo);

        lblResultadoValor = new JLabel("-");
        lblResultadoValor.setHorizontalAlignment(SwingConstants.CENTER);
        lblResultadoValor.setFont(new Font("Arial", Font.BOLD, 28));
        lblResultadoValor.setBounds(230, 15, 60, 45);
        panelResultado.add(lblResultadoValor);

        btnTotalPacientes.addActionListener(e -> mostrarTotalPacientes());
        btnCitasDia.addActionListener(e -> mostrarCitasDelDia());
    }

    private void mostrarTotalPacientes() {
        int total = dao.totalPacientes();

        lblResultadoTitulo.setText("Total de Pacientes Registrados");
        lblResultadoValor.setText(String.valueOf(total));
    }

    private void mostrarCitasDelDia() {
        int total = dao.citasDelDia();

        lblResultadoTitulo.setText("Citas para Hoy");
        lblResultadoValor.setText(String.valueOf(total));
    }

    public static void main(String[] args) {
        new FrmReporte().setVisible(true);
    }
}