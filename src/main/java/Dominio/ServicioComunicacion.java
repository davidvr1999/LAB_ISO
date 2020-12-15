package Dominio;

import Gestores.GestorServicioComunicacion;

public class ServicioComunicacion {
	public GestorServicioComunicacion gestorServicioComunicacion;

	public GestorServicioComunicacion getGestorServicioComunicacion() {
		return gestorServicioComunicacion;
	}

	public void setGestorServicioComunicacion(GestorServicioComunicacion gestorServicioComunicacion) {
		this.gestorServicioComunicacion = gestorServicioComunicacion;
	}

	public void enviarNumeroInforme() {
		throw new UnsupportedOperationException();
	}
}