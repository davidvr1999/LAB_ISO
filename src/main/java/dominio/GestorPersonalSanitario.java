package dominio;

import persistencia.AgenteBD;
import presentacion.IU_PersonalSanitario;
import javax.swing.event.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class GestorPersonalSanitario {
	private List<Ciudadano> lista = GestorCiudadano.selectAllCiudadanos();

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

	public ActionListener btnNotificar() {

		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorServicioComunicacion gsc = new GestorServicioComunicacion();
				Ciudadano c = seleccionarCiudadano();
				gsc.notificarResultados(c, String.valueOf(generarNInforme()));
			}

		};
	}

	protected Ciudadano seleccionarCiudadano() {
		int element = IU_PersonalSanitario.getTable().getSelectedRow();
		return lista.get(element);
	}

	public void rellenarTabla() {
		Object[][] datos = new Object[lista.size()][4];

		for (int i = 0; i < lista.size(); i++) {
			datos[i][0] = lista.get(i).getDni();
			datos[i][1] = lista.get(i).getNombre();
			datos[i][2] = lista.get(i).getNTarjetaSanitaria();
			datos[i][3] = lista.get(i).getEmail();
		}
		IU_PersonalSanitario.getTable().setModel(
				new DefaultTableModel(datos, new String[] { "DNI", "NOMBRE", "N TARJETA SANITARIA", "EMAIL" }));
	}

	public long generarNInforme() {
		Random rand = new Random();
		long num = (rand.nextLong() * 9000000000000000000L);
		if (num < 0) {
			num *= -1;
		}
		return num;
	}

	public ListSelectionListener habBtnNotificar() {

		return new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				IU_PersonalSanitario.getBtnNotificar().setEnabled(true);
			}
		};
	}

	public void comprobarAccesoPrueba() {
		// TODO: futuras versiones
	}
}