package Dominio;

import Gestores.GestorPersonalSanitario;

public class Sanitario extends Usuario {
	public GestorPersonalSanitario gestorPersonalSanitario;

	public GestorPersonalSanitario getGestorPersonalSanitario() {
		return gestorPersonalSanitario;
	}

	public void setGestorPersonalSanitario(GestorPersonalSanitario gestorPersonalSanitario) {
		this.gestorPersonalSanitario = gestorPersonalSanitario;
	}

	public void notificarResultados() {
		throw new UnsupportedOperationException();
	}

	public void comprobarAccesoPrueba() {
		throw new UnsupportedOperationException();
	}
}