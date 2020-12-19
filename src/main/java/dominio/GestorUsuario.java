package main.java.dominio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import main.java.persistencia.AgenteBD;
import main.java.presentacion.IU_PersonalSanitario;
import main.java.presentacion.IU_Usuario;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;

public class GestorUsuario {


    public ActionListener btnSUser(JFrame window) {

        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                switch (IU_Usuario.getcBRol().getSelectedItem().toString().toLowerCase()) {
                    case "personal sanitario":
                        Sanitario s = new Sanitario();

                        s.setDni(IU_Usuario.getTxtDni().getText());
                        s.setNombre(IU_Usuario.getTextField().getText());
                        s.setRol(IU_Usuario.getcBRol().getSelectedItem().toString());
                        s.setNSanitario(IU_Usuario.getTxtNSanitario().getText());

                        if (crearUsuario(s) != null) {
                            if (GestorPersonalSanitario.crearSanitario(s) != null) {
                                //JOptionPane.showMessageDialog(null, "Usuario Personal Sanitario creado correctamente");
                                IU_PersonalSanitario iu = new IU_PersonalSanitario();
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al crear el Personal Sanitario" + s.getNombre() + " con dni " + s.getDni());
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuario con dni " + s.getDni() + "ya existe ");
                        }

                        break;
                    case "ciudadano":

                        Ciudadano c = new Ciudadano();
                        c.setDni(IU_Usuario.getTxtDni().getText());
                        c.setEmail(IU_Usuario.getTxtEmail().getText());
                        c.setNombre(IU_Usuario.getTextField().getText());
                        c.setRol(IU_Usuario.getcBRol().getSelectedItem().toString());
                        c.setNTarjetaSanitaria(IU_Usuario.getTxtNTarjeta().getText());

                        if (crearUsuario(c) != null) {
                            if (GestorCiudadano.crearCiudadano(c) != null) {
                                JOptionPane.showMessageDialog(null, "Usuario Ciudadano creado correctamente");
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al crear el ciudadano" + c.getNombre() + " con dni " + c.getDni());
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuario con dni " + c.getDni() + "ya existe ");
                        }
                        break;

                }
            }

        };
    }

    public ItemListener selectTypeUser() {
        return new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                switch (IU_Usuario.getcBRol().getSelectedItem().toString().toLowerCase()) {
                    case "personal sanitario":
                        disableTokens(0);
                        IU_Usuario.getLblNSanitario().setVisible(true);
                        IU_Usuario.getTxtNSanitario().setVisible(true);
                        break;
                    case "ciudadano":
                        disableTokens(0);
                        IU_Usuario.getLblNTarjeta().setVisible(true);
                        IU_Usuario.getTxtNTarjeta().setVisible(true);
                        IU_Usuario.getLblEmail().setVisible(true);
                        IU_Usuario.getTxtEmail().setVisible(true);
                        IU_Usuario.getBtnVivienda().setVisible(true);
                        break;
                    default:
                        disableTokens(1);
                        break;
                }

            }
        };
    }

    public void disableTokens(int a) {
        if (a == 0) {
            IU_Usuario.getBtnRegistro().setEnabled(true);
        } else {
            IU_Usuario.getBtnRegistro().setEnabled(false);
        }
        IU_Usuario.getLblNSanitario().setVisible(false);
        IU_Usuario.getTxtNSanitario().setVisible(false);
        IU_Usuario.getLblEmail().setVisible(false);
        IU_Usuario.getTxtEmail().setVisible(false);
        IU_Usuario.getLblNTarjeta().setVisible(false);
        IU_Usuario.getTxtNTarjeta().setVisible(false);
        IU_Usuario.getBtnVivienda().setVisible(false);

    }

    private Usuario crearUsuario(Usuario u) {
        Usuario aux = null;
        Connection CONNECTION = AgenteBD.dbConnector();

        if (StringUtils.isNotBlank(u.getNombre()) && StringUtils.isNotBlank(u.getDni())) {
            if (this.buscarUsuario(u) == null) {

                PreparedStatement ps;
                try {
                    ps = CONNECTION.prepareStatement("INSERT INTO Usuario (dni, nombre, rol) VALUES (?, ?, ?);");

                    ps.setString(1, u.getDni());
                    ps.setString(2, u.getNombre());
                    ps.setString(3, u.getRol());
                    ps.executeUpdate();

                    ps.close();
                    CONNECTION.commit();
                    CONNECTION.close();
                    aux = u;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
        return aux;
    }

    public Usuario buscarUsuario(Usuario u) {
        Connection CONNECTION = AgenteBD.dbConnector();
        Usuario aux = null;

        PreparedStatement ps;
        try {
            ps = CONNECTION.prepareStatement("select * from Usuario where dni=?");

            ps.setString(1, u.getDni());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                aux = new Usuario();
                aux.setDni(rs.getString("dni"));
                aux.setNombre(rs.getString("nombre"));
                aux.setRol(rs.getString("rol"));
            }
            rs.close();
            ps.close();
            CONNECTION.commit();
            CONNECTION.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aux;
    }

    public static List<Usuario> selectAllUsers() {
        Connection CONNECTION = AgenteBD.dbConnector();
        List<Usuario> list = new ArrayList<Usuario>();
        Statement stmt = null;

        try {
            stmt = CONNECTION.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Usuario");

            while (rs.next()) {

                Usuario u = new Usuario();
                u.setDni(rs.getString("dni"));
                u.setNombre(rs.getString("nombre"));
                u.setRol(rs.getString("rol"));
                list.add(u);
            }

            rs.close();
            stmt.close();
            CONNECTION.commit();
            CONNECTION.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }


}