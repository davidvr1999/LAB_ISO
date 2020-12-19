package main.java.dominio;

import main.java.persistencia.AgenteBD;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class GestorPersonalSanitario {


    public static Sanitario crearSanitario(Sanitario s) {
        Sanitario aux = null;

        Connection CONNECTION = AgenteBD.dbConnector();

        PreparedStatement ps;
        try {
            ps = CONNECTION.prepareStatement("INSERT INTO Sanitario VALUES (?, ?);");

            ps.setString(1, s.getNSanitario());
            ps.setString(2, s.getDni());
            ps.executeUpdate();

            ps.close();
            CONNECTION.commit();
            CONNECTION.close();
            aux = s;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aux;
    }

    public static void notificarResultados() {

        final String username = "username@gmail.com";
        final String password = "password";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("to_username_a@gmail.com, to_username_b@yahoo.com")
            );
            message.setSubject("Testing Gmail TLS");
            message.setText("Dear Mail Crawler,"
                    + "\n\n Please do not spam my email!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void comprobarAccesoPrueba() {
        //TODO: futuras versiones
    }
}