package presentacion;

import dominio.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_PersonalSanitario {

    private static JFrame frmCovidlandiak;
    private static JTextField txtDni;
    private static JTable table;
    private static JButton btnNotificar;
    private static GestorPersonalSanitario gps;
    private JScrollPane scrollPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	IU_PersonalSanitario window = new IU_PersonalSanitario();
                    window.frmCovidlandiak.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public IU_PersonalSanitario() {
        frmCovidlandiak = new JFrame();
        this.frmCovidlandiak.setVisible(true);
        initialize();
    }

    private void initialize() {

    	gps = new GestorPersonalSanitario();
        frmCovidlandiak.getContentPane().setBackground(Color.WHITE);
        frmCovidlandiak.setTitle("COVIDLANDIA 2K19 - Notificar Usuario.");
        frmCovidlandiak.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\img\\icon\\icon.png"));
        frmCovidlandiak.setResizable(false);
        frmCovidlandiak.setBounds(100, 100, 715, 555);
        frmCovidlandiak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCovidlandiak.getContentPane().setLayout(null);
        frmCovidlandiak.setLocationRelativeTo(null);

        scrollPane = new JScrollPane();
        scrollPane.setToolTipText("");
        scrollPane.setBounds(10, 39, 680, 255);
        frmCovidlandiak.getContentPane().add(scrollPane);

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 13));
        gps.rellenarTabla();
        table.getSelectionModel().addListSelectionListener(gps.habBtnNotificar());
        scrollPane.setViewportView(table);
        
        btnNotificar = new JButton("Notificar");
        btnNotificar.setEnabled(false);
        btnNotificar.addActionListener(gps.btnNotificar());
        btnNotificar.setBounds(272, 372, 159, 101);
        frmCovidlandiak.getContentPane().add(btnNotificar);


    }

    public static JFrame getFrmCovidlandiak() {
        return frmCovidlandiak;
    }

    public static void setFrmCovidlandiak(JFrame frmCovidlandiak) {
        IU_PersonalSanitario.frmCovidlandiak = frmCovidlandiak;
    }

	public static JTextField getTxtDni() {
		return txtDni;
	}

	public static JTable getTable() {
		return table;
	}

	public static JButton getBtnNotificar() {
		return btnNotificar;
	}

	public static GestorPersonalSanitario getGps() {
		return gps;
	}
}