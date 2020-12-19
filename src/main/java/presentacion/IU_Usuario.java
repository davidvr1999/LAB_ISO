package main.java.presentacion;

import main.java.dominio.*;

import javax.swing.*;
import java.awt.*;

public class IU_Usuario {

    private static JFrame frmCovidlandiak;
    private static JTextField txtDni;
    private static JTextField textField;
    private static GestorUsuario gu;
    private static JTextField txtNSanitario;
    private static JTextField txtEmail;
    private static JTextField txtNTarjeta;
    private static JButton btnRegistro;
    private static JComboBox cBRol;
    private static JLabel lblNSanitario;
    private static JLabel lblEmail;
    private static JLabel lblNTarjeta;
    private static JButton btnVivienda;

    public static JFrame getFrmCovidlandiak() {
        return frmCovidlandiak;
    }

    public static JButton getBtnVivienda() {
        return btnVivienda;
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IU_Usuario window = new IU_Usuario();
                    window.frmCovidlandiak.setVisible(true);
                    GestorUsuario.selectAllUsers().stream().forEach(usuario -> System.out.println(((main.java.dominio.Usuario) usuario).toString()));
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
    private static void initialize() {
        gu = new GestorUsuario();
        frmCovidlandiak = new JFrame();
        frmCovidlandiak.getContentPane().setBackground(Color.WHITE);
        frmCovidlandiak.setTitle("COVIDLANDIA 2K19 - Registro de Usuario.");
        frmCovidlandiak.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\img\\icon\\icon.png"));
        frmCovidlandiak.setResizable(false);
        frmCovidlandiak.setBounds(100, 100, 592, 555);
        frmCovidlandiak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCovidlandiak.getContentPane().setLayout(null);
        frmCovidlandiak.setLocationRelativeTo(null);

        JLabel lblDNI = new JLabel("DNI:");
        lblDNI.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDNI.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        lblDNI.setBounds(188, 66, 74, 23);
        frmCovidlandiak.getContentPane().add(lblDNI);

        txtDni = new JTextField();
        txtDni.setFont(new Font("Arial", Font.PLAIN, 20));
        txtDni.setBounds(290, 63, 150, 30);
        frmCovidlandiak.getContentPane().add(txtDni);
        txtDni.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre completo:");
        lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        lblNombre.setBounds(88, 115, 174, 38);
        frmCovidlandiak.getContentPane().add(lblNombre);

        textField = new JTextField();
        textField.setBounds(new Rectangle(0, 0, 150, 30));
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        textField.setBounds(290, 120, 150, 30);
        frmCovidlandiak.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("Rol:");
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        lblNewLabel.setBounds(126, 189, 136, 18);
        frmCovidlandiak.getContentPane().add(lblNewLabel);

        cBRol = new JComboBox();
        cBRol.setBounds(new Rectangle(0, 0, 150, 30));
        cBRol.setFont(new Font("Arial", Font.PLAIN, 12));
        cBRol.setModel(new DefaultComboBoxModel(new String[]{"", "Personal sanitario", "Ciudadano"}));
        cBRol.setBounds(290, 184, 150, 30);
        cBRol.addItemListener(gu.selectTypeUser());
        frmCovidlandiak.getContentPane().add(cBRol);

        btnRegistro = new JButton("Registrar");
        btnRegistro.setEnabled(false);
        btnRegistro.addActionListener(gu.btnSUser(frmCovidlandiak));
        btnRegistro.setBounds(290, 434, 150, 30);
        frmCovidlandiak.getContentPane().add(btnRegistro);

        lblNSanitario = new JLabel("Nº Sanitario:");
        lblNSanitario.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNSanitario.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        lblNSanitario.setVisible(false);
        lblNSanitario.setBounds(104, 278, 158, 23);
        frmCovidlandiak.getContentPane().add(lblNSanitario);

        txtNSanitario = new JTextField();
        txtNSanitario.setBounds(new Rectangle(0, 0, 150, 30));
        txtNSanitario.setFont(new Font("Arial", Font.PLAIN, 20));
        txtNSanitario.setVisible(false);
        txtNSanitario.setBounds(290, 275, 150, 30);
        frmCovidlandiak.getContentPane().add(txtNSanitario);
        txtNSanitario.setColumns(10);

        lblEmail = new JLabel("Email:");
        lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        lblEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        lblEmail.setVisible(false);
        lblEmail.setBounds(139, 265, 123, 20);
        frmCovidlandiak.getContentPane().add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(new Rectangle(0, 0, 150, 30));
        txtEmail.setFont(new Font("Arial", Font.PLAIN, 20));
        txtEmail.setVisible(false);
        txtEmail.setBounds(290, 261, 150, 30);
        frmCovidlandiak.getContentPane().add(txtEmail);
        txtEmail.setColumns(10);

        lblNTarjeta = new JLabel("Nº Tarjeta sanitaria:");
        lblNTarjeta.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNTarjeta.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        lblNTarjeta.setVisible(false);
        lblNTarjeta.setBounds(68, 320, 194, 38);
        frmCovidlandiak.getContentPane().add(lblNTarjeta);

        txtNTarjeta = new JTextField();
        txtNTarjeta.setBounds(new Rectangle(0, 0, 150, 30));
        txtNTarjeta.setFont(new Font("Arial", Font.PLAIN, 20));
        txtNTarjeta.setVisible(false);
        txtNTarjeta.setBounds(290, 325, 150, 30);
        frmCovidlandiak.getContentPane().add(txtNTarjeta);
        txtNTarjeta.setColumns(10);

        btnVivienda = new JButton("Vivienda/s");
        btnVivienda.setVisible(false);
        btnVivienda.setBounds(290, 383, 150, 30);
        frmCovidlandiak.getContentPane().add(btnVivienda);
    }

    public static JFrame getFrame() {
        return frmCovidlandiak;
    }

    public static JTextField getTxtDni() {
        return txtDni;
    }

    public static JTextField getTextField() {
        return textField;
    }

    public static GestorUsuario getGu() {
        return gu;
    }

    public static JTextField getTxtNSanitario() {
        return txtNSanitario;
    }

    public static JTextField getTxtEmail() {
        return txtEmail;
    }

    public static JTextField getTxtNTarjeta() {
        return txtNTarjeta;
    }

    public static JButton getBtnRegistro() {
        return btnRegistro;
    }

    public static JComboBox getcBRol() {
        return cBRol;
    }

    public static JLabel getLblNSanitario() {
        return lblNSanitario;
    }

    public static JLabel getLblEmail() {
        return lblEmail;
    }

    public static JLabel getLblNTarjeta() {
        return lblNTarjeta;
    }
}
