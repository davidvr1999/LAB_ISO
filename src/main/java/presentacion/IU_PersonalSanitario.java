package main.java.presentacion;

import main.java.dominio.Ciudadano;
import main.java.dominio.GestorCiudadano;
import main.java.dominio.GestorUsuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class IU_PersonalSanitario {

    private static JFrame frmCovidlandiak;
    private static JTextField txtDni;
    private JTable table;


    public IU_PersonalSanitario() {
        frmCovidlandiak = new JFrame();
        this.frmCovidlandiak.setVisible(true);
        initialize();
    }

    private void initialize() {


        frmCovidlandiak.getContentPane().setBackground(Color.WHITE);
        frmCovidlandiak.setTitle("COVIDLANDIA 2K19 - Registro de Usuario.");
        frmCovidlandiak.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\img\\icon\\icon.png"));
        frmCovidlandiak.setResizable(true);
        frmCovidlandiak.setBounds(100, 100, 592, 555);
        frmCovidlandiak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCovidlandiak.getContentPane().setLayout(null);
        frmCovidlandiak.setLocationRelativeTo(null);


        List<Ciudadano> lista = GestorCiudadano.selectAllCiudadanos();
        Object[][] datos = new Object[lista.size()][4];

        for (int i = 0; i < lista.size(); i++) {
            datos[i][0] = lista.get(i).getDni();
            datos[i][1] = lista.get(i).getNombre();
            datos[i][2] = lista.get(i).getNTarjetaSanitaria();
            datos[i][3] = lista.get(i).getEmail();
        }

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setToolTipText("");
        scrollPane.setBounds(10, 39, 680, 255);
        frmCovidlandiak.add(scrollPane);

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 13));
        table.setModel(new DefaultTableModel(datos, new String[]{"DNI", "NOMBRE", "N TARJETA SANITARIA", "EMAIL"}) {
            Class[] columnTypes = new Class[]{String.class, Long.class};

            /*public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }*/

            boolean[] columnEditables = new boolean[]{false, false};

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPane.setViewportView(table);


    }


    public static JFrame getFrmCovidlandiak() {
        return frmCovidlandiak;
    }

    public static void setFrmCovidlandiak(JFrame frmCovidlandiak) {
        IU_PersonalSanitario.frmCovidlandiak = frmCovidlandiak;
    }
}