package dominio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import presentacion.IU_Usuario;

public class GestorUsuario {

	public ActionListener btnSUser() {

		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Caca de vaca!");
			}

		};
	}

	public ItemListener selectTypeUser() {
		return new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String rol = IU_Usuario.getcBRol().getSelectedItem().toString();

				switch (rol.toLowerCase()) {
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

				case "responsable de vivienda":
					disableTokens(0);
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
		}else {
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
	
	
}