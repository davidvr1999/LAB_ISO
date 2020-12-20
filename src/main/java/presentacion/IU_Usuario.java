package presentacion;

import dominio.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.table.DefaultTableModel;

public class IU_Usuario {

    private static JFrame frmCovidlandiak;
    private static JTextField txtDni;
    private static JTextField txtNombre;
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
    private static JTable table;
    private static JTextField txtDireccion;
    private static JTextField txtLocalidad;
    private static JTextField txtProvincia;
    private static JTextField txtCodigoPostal;
    private static JTextField txtResponsable;
    private static JRadioButton rdbtnRespNo;
    private static JRadioButton rdbtnRespSi;
    private static JLabel lblResponsablePr;
    private static JLabel lblCdigoPostal;
    private static JLabel lblProvincia;
    private static JLabel lblLocalidad;
    private static JLabel lblDireccinCompleta;
    private static JLabel lblRol;
    private static JLabel lblNombre;
    private static JLabel lblDNI;
    private static JLabel lblDniResponsable;
    private static JButton btnVolver;
    private static JButton btnAadir;
    private static JScrollPane scrollPane;
    private static JLabel lblTipoVivienda;
    private static JComboBox cBTipo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IU_Usuario window = new IU_Usuario();
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
    public IU_Usuario() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private static void initialize() {
        gu = new GestorUsuario();
        frmCovidlandiak = new JFrame();
        frmCovidlandiak.setResizable(false);
        frmCovidlandiak.getContentPane().setBackground(Color.WHITE);
        frmCovidlandiak.setTitle("COVIDLANDIA 2K19 - Registro de Usuario.");
        frmCovidlandiak.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\img\\icon\\icon.png"));
        frmCovidlandiak.setBounds(100, 100, 592, 555);
        frmCovidlandiak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCovidlandiak.getContentPane().setLayout(null);
        frmCovidlandiak.setLocationRelativeTo(null);
        
        lblDNI = new JLabel("DNI:");
        lblDNI.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDNI.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        lblDNI.setBounds(188, 66, 74, 23);
        frmCovidlandiak.getContentPane().add(lblDNI);

        txtDni = new JTextField();
        txtDni.setFont(new Font("Arial", Font.PLAIN, 20));
        txtDni.setBounds(290, 63, 150, 30);
        frmCovidlandiak.getContentPane().add(txtDni);
        txtDni.setColumns(10);

        lblNombre = new JLabel("Nombre completo:");
        lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        lblNombre.setBounds(88, 115, 174, 38);
        frmCovidlandiak.getContentPane().add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(new Rectangle(0, 0, 150, 30));
        txtNombre.setFont(new Font("Arial", Font.PLAIN, 20));
        txtNombre.setBounds(290, 120, 150, 30);
        frmCovidlandiak.getContentPane().add(txtNombre);
        txtNombre.setColumns(10);

        lblRol = new JLabel("Rol:");
        lblRol.setHorizontalAlignment(SwingConstants.RIGHT);
        lblRol.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        lblRol.setBounds(126, 189, 136, 18);
        frmCovidlandiak.getContentPane().add(lblRol);

        cBRol = new JComboBox();
        cBRol.setBounds(new Rectangle(0, 0, 150, 30));
        cBRol.setFont(new Font("Arial", Font.PLAIN, 12));
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
        btnVivienda.addActionListener(gu.btnVivienda());
        btnVivienda.setVisible(false);
        btnVivienda.setBounds(290, 383, 150, 30);
        frmCovidlandiak.getContentPane().add(btnVivienda);
        
        scrollPane = new JScrollPane();
        scrollPane.setVisible(false);
        scrollPane.setBounds(23, 278, 994, 365);
        frmCovidlandiak.getContentPane().add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        table.setRowSelectionAllowed(false);
        table.setVisible(false);
        table.setBackground(Color.WHITE);
        
        txtDireccion = new JTextField();
        txtDireccion.setVisible(false);
        txtDireccion.setFont(new Font("Arial", Font.PLAIN, 20));
        txtDireccion.setColumns(10);
        txtDireccion.setBounds(300, 63, 150, 30);
        frmCovidlandiak.getContentPane().add(txtDireccion);
        
        lblDireccinCompleta = new JLabel("Dirección:");
        lblDireccinCompleta.setVisible(false);
        lblDireccinCompleta.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDireccinCompleta.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        lblDireccinCompleta.setBounds(68, 66, 194, 23);
        frmCovidlandiak.getContentPane().add(lblDireccinCompleta);
        
        txtLocalidad = new JTextField();
        txtLocalidad.setVisible(false);
        txtLocalidad.setFont(new Font("Arial", Font.PLAIN, 20));
        txtLocalidad.setColumns(10);
        txtLocalidad.setBounds(300, 115, 150, 30);
        frmCovidlandiak.getContentPane().add(txtLocalidad);
        
        lblLocalidad = new JLabel("Localidad:");
        lblLocalidad.setVisible(false);
        lblLocalidad.setHorizontalAlignment(SwingConstants.RIGHT);
        lblLocalidad.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        lblLocalidad.setBounds(68, 118, 194, 23);
        frmCovidlandiak.getContentPane().add(lblLocalidad);
        
        txtProvincia = new JTextField();
        txtProvincia.setVisible(false);
        txtProvincia.setFont(new Font("Arial", Font.PLAIN, 20));
        txtProvincia.setColumns(10);
        txtProvincia.setBounds(300, 164, 150, 30);
        frmCovidlandiak.getContentPane().add(txtProvincia);
        
        lblProvincia = new JLabel("Provincia:");
        lblProvincia.setVisible(false);
        lblProvincia.setHorizontalAlignment(SwingConstants.RIGHT);
        lblProvincia.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        lblProvincia.setBounds(68, 167, 194, 23);
        frmCovidlandiak.getContentPane().add(lblProvincia);
        
        txtCodigoPostal = new JTextField();
        txtCodigoPostal.setVisible(false);
        txtCodigoPostal.setFont(new Font("Arial", Font.PLAIN, 20));
        txtCodigoPostal.setColumns(10);
        txtCodigoPostal.setBounds(785, 59, 150, 30);
        frmCovidlandiak.getContentPane().add(txtCodigoPostal);
        
        lblCdigoPostal = new JLabel("Código Postal:");
        lblCdigoPostal.setVisible(false);
        lblCdigoPostal.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCdigoPostal.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        lblCdigoPostal.setBounds(553, 59, 194, 30);
        frmCovidlandiak.getContentPane().add(lblCdigoPostal);
        
        txtResponsable = new JTextField();
        txtResponsable.setVisible(false);
        txtResponsable.setFont(new Font("Arial", Font.PLAIN, 20));
        txtResponsable.setColumns(10);
        txtResponsable.setBounds(785, 164, 150, 30);
        frmCovidlandiak.getContentPane().add(txtResponsable);
        
        lblResponsablePr = new JLabel("¿Eres tú el\r\n responsable?");
        lblResponsablePr.setVisible(false);
        lblResponsablePr.setHorizontalAlignment(SwingConstants.RIGHT);
        lblResponsablePr.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        lblResponsablePr.setBounds(519, 118, 228, 23);
        frmCovidlandiak.getContentPane().add(lblResponsablePr);
        
        rdbtnRespNo = new JRadioButton("No");
        rdbtnRespNo.addItemListener(gu.rdbtnResponsableNo());
        rdbtnRespNo.setVisible(false);
        rdbtnRespNo.setBackground(null);
        rdbtnRespNo.setFont(new Font("Arial", Font.PLAIN, 20));
        rdbtnRespNo.setBounds(785, 118, 95, 23);
        frmCovidlandiak.getContentPane().add(rdbtnRespNo);
        
        rdbtnRespSi = new JRadioButton("Sí");
        rdbtnRespSi.setSelected(true);
        rdbtnRespSi.setVisible(false);
        rdbtnRespSi.setBackground(null);
        rdbtnRespSi.addItemListener(gu.rdbtnResponsableSi());
        rdbtnRespSi.setFont(new Font("Arial", Font.PLAIN, 20));
        rdbtnRespSi.setBounds(897, 118, 95, 23);
        frmCovidlandiak.getContentPane().add(rdbtnRespSi);
        
        lblDniResponsable = new JLabel("DNI responsable:");
        lblDniResponsable.setVisible(false);
        lblDniResponsable.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDniResponsable.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        lblDniResponsable.setBounds(519, 164, 228, 23);
        frmCovidlandiak.getContentPane().add(lblDniResponsable);
        
        lblTipoVivienda = new JLabel("Tipo:");
        lblTipoVivienda.setVisible(false);
        lblTipoVivienda.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTipoVivienda.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        lblTipoVivienda.setBounds(34, 220, 228, 23);
        frmCovidlandiak.getContentPane().add(lblTipoVivienda);
        
        btnVolver = new JButton("Volver");
        btnVolver.setVisible(false);
        btnVolver.addActionListener(gu.btnVolver());
        btnVolver.setBounds(290, 684, 150, 30);
        frmCovidlandiak.getContentPane().add(btnVolver);
        
        btnAadir = new JButton("Añadir");
        btnAadir.setVisible(false);
        btnAadir.addActionListener(gu.btnAnadirVivienda());
        btnAadir.setBounds(577, 684, 150, 30);
        frmCovidlandiak.getContentPane().add(btnAadir);
        
        cBTipo = new JComboBox();
        cBTipo.setVisible(false);
        cBTipo.setFont(new Font("Arial", Font.PLAIN, 12));
        cBTipo.setBounds(new Rectangle(0, 0, 150, 30));
        cBTipo.setBounds(300, 218, 150, 30);
        frmCovidlandiak.getContentPane().add(cBTipo);
        gu.rellenarCombos();
    }

	public static JLabel getLblTipoVivienda() {
		return lblTipoVivienda;
	}

	public static JComboBox getcBTipo() {
		return cBTipo;
	}

	public static JScrollPane getScrollPane() {
		return scrollPane;
	}

	public static JFrame getFrmCovidlandiak() {
		return frmCovidlandiak;
	}

	public static JTextField getTxtDni() {
		return txtDni;
	}

	public static JTextField getTxtNombre() {
		return txtNombre;
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

	public static JButton getBtnVivienda() {
		return btnVivienda;
	}

	public static JTable getTable() {
		return table;
	}

	public static JTextField getTxtDireccion() {
		return txtDireccion;
	}

	public static JTextField getTxtLocalidad() {
		return txtLocalidad;
	}

	public static JTextField getTxtProvincia() {
		return txtProvincia;
	}

	public static JTextField getTxtCodigoPostal() {
		return txtCodigoPostal;
	}

	public static JTextField getTxtResponsable() {
		return txtResponsable;
	}

	public static JRadioButton getRdbtnRespNo() {
		return rdbtnRespNo;
	}

	public static JRadioButton getRdbtnRespSi() {
		return rdbtnRespSi;
	}

	public static JLabel getLblResponsablePr() {
		return lblResponsablePr;
	}

	public static JLabel getLblCdigoPostal() {
		return lblCdigoPostal;
	}

	public static JLabel getLblProvincia() {
		return lblProvincia;
	}

	public static JLabel getLblLocalidad() {
		return lblLocalidad;
	}

	public static JLabel getLblDireccinCompleta() {
		return lblDireccinCompleta;
	}

	public static JLabel getLblRol() {
		return lblRol;
	}

	public static JLabel getLblNombre() {
		return lblNombre;
	}

	public static JLabel getLblDNI() {
		return lblDNI;
	}

	public static JLabel getLblDniResponsable() {
		return lblDniResponsable;
	}

	public static JButton getBtnVolver() {
		return btnVolver;
	}

	public static JButton getBtnAadir() {
		return btnAadir;
	}
}
