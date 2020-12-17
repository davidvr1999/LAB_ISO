package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class IU_Ciudadano {

	private JFrame frmCovidlandiak;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Ciudadano window = new IU_Ciudadano();
					window.frmCovidlandiak.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IU_Ciudadano() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCovidlandiak = new JFrame();
		frmCovidlandiak.setResizable(false);
		frmCovidlandiak.setTitle("CovidLandia-2k19");
		frmCovidlandiak.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\img\\icon\\covid-19.png"));
		frmCovidlandiak.setBounds(100, 100, 799, 606);
		frmCovidlandiak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCovidlandiak.getContentPane().setLayout(null);
		
		JLabel lblBienvenida = new JLabel("Bienvenido/a al sistema de gestión de pruebas PCR por COVID-19.");
		lblBienvenida.setBounds(94, 74, 442, 83);
		frmCovidlandiak.getContentPane().add(lblBienvenida);
	}
}
