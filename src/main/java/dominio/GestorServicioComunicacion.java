package dominio;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class GestorServicioComunicacion {

	private ServicioComunicacion servCom = new ServicioComunicacion("covidlandia2k19@gmail.com", "LosZorrunos@Covid.");
	
	 public void notificarResultados(Ciudadano c, String ninforme) {

	        Properties prop = new Properties();
	        prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "587");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.starttls.enable", "true"); //TLS

	        Session session = Session.getInstance(prop,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(servCom.getCorreoEnvio(), servCom.getPwdEnvio());
	                    }
	                });

	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(servCom.getCorreoEnvio()));
	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse(c.getEmail())
	            );
	            message.setSubject("Resultado PCR");
	            message.setText("Hola "+c.getNombre().toUpperCase()+","
	                    + "\n\nYa puedes ver el resultado de tu prueba. El número de informe es: "+ninforme
	                    + "\n\nPuedes ver el resultado en nuestra aplicación (CovidLandia-2k19) o en nuestra página web: www.covidlandia2k19.com");

	            Transport.send(message);

	            JOptionPane.showMessageDialog(null, "Mensaje mandado correctamente a \n"+c.getNombre().toUpperCase()+".", "HECHO!", JOptionPane.INFORMATION_MESSAGE);

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }
}