package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dominio.*;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_Usuario {

	private JFrame frame;
	private JTextField txtDni;
	private JTextField textField;
	private GestorUsuario gu;
	private JTextField txtNSanitario;
	private JTextField txtEmail;
	private JTextField txtNTarjeta;
	private JTextField txtDNIResponsable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Usuario window = new IU_Usuario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IU_Usuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		gu = new GestorUsuario();
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 685, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(67, 57, 47, 14);
		frame.getContentPane().add(lblDNI);
		
		txtDni = new JTextField();
		txtDni.setBounds(142, 54, 136, 20);
		frame.getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(67, 98, 47, 14);
		frame.getContentPane().add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(142, 95, 136, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Rol");
		lblNewLabel.setBounds(67, 147, 47, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Personal sanitario", "Responsable de vivienda", "Ciudadano"}));
		comboBox.setBounds(142, 143, 136, 22);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(gu.btnSUser());
		btnNewButton.setBounds(128, 235, 106, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNSanitario = new JLabel("Nº Sanitario");
		lblNSanitario.setBounds(398, 57, 74, 14);
		frame.getContentPane().add(lblNSanitario);
		
		txtNSanitario = new JTextField();
		txtNSanitario.setBounds(507, 54, 96, 20);
		frame.getContentPane().add(txtNSanitario);
		txtNSanitario.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(396, 147, 47, 14);
		frame.getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(507, 144, 96, 20);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNTarjeta = new JLabel("Nº Tarjeta");
		lblNTarjeta.setBounds(396, 187, 74, 14);
		frame.getContentPane().add(lblNTarjeta);
		
		txtNTarjeta = new JTextField();
		txtNTarjeta.setBounds(507, 184, 96, 20);
		frame.getContentPane().add(txtNTarjeta);
		txtNTarjeta.setColumns(10);
		
		txtDNIResponsable = new JTextField();
		txtDNIResponsable.setBounds(507, 269, 96, 20);
		frame.getContentPane().add(txtDNIResponsable);
		txtDNIResponsable.setColumns(10);
		
		JLabel lblDNIResponsable = new JLabel("DNI Responsable");
		lblDNIResponsable.setBounds(398, 272, 101, 14);
		frame.getContentPane().add(lblDNIResponsable);
		
		JLabel lblTipoVivienda = new JLabel("Tipo Vivienda");
		lblTipoVivienda.setBounds(396, 311, 76, 14);
		frame.getContentPane().add(lblTipoVivienda);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Residencia/Hotel", "Particular"}));
		comboBox_1.setBounds(507, 307, 96, 22);
		frame.getContentPane().add(comboBox_1);
	}
}
