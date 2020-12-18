package dominio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorUsuario {

	
	public ActionListener btnSUser() {

		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					System.out.println("Caca de vaca!");
			}

		};
	}
}