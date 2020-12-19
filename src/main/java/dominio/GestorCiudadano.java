package main.java.dominio;

import main.java.persistencia.AgenteBD;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestorCiudadano {

    public void consultarResultado() {
        throw new UnsupportedOperationException();
    }


    public static Ciudadano crearCiudadano(Ciudadano c) {

        Ciudadano aux = null;
        Connection CONNECTION = AgenteBD.dbConnector();

        PreparedStatement ps;
        try {
            ps = CONNECTION.prepareStatement("INSERT INTO Ciudadano VALUES (?, ?, ?, ?);");

            ps.setString(1, c.getNTarjetaSanitaria());
            ps.setString(2, c.getEmail());
            ps.setBoolean(3, Boolean.FALSE);
            ps.setString(4, c.getDni());
            ps.executeUpdate();

            ps.close();
            CONNECTION.commit();
            CONNECTION.close();
            aux = c;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return aux;
    }


    public static List<Ciudadano> selectAllCiudadanos() {
        Connection CONNECTION = AgenteBD.dbConnector();
        List<Ciudadano> list = new ArrayList<Ciudadano>();
        Statement stmt = null;

        try {
            stmt = CONNECTION.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Ciudadano");

            while (rs.next()) {
                Ciudadano c = new Ciudadano();
                c.setDni(rs.getString("fk_user_ciudadano"));
                c.setPositivo(rs.getBoolean("positUltPCR"));
                c.setNTarjetaSanitaria(rs.getString("nTarjetaSanitaria"));
                c.setEmail(rs.getString("email"));

                PreparedStatement ps = CONNECTION.prepareStatement("select * from Usuario where dni=?");
                ps.setString(1, c.getDni());
                ResultSet rs2 = ps.executeQuery();

                if (rs2.next()) {
                    c.setNombre(rs2.getString("nombre"));
                    c.setRol(rs2.getString("rol"));
                }


                list.add(c);
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