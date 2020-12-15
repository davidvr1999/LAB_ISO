package Dominio;

import Gestores.GestorPropietario;

public class Responsable extends Usuario {
	private Vivienda vivienda;
	public GestorPropietario gestorPropietario;

	public void darDeAltaVivienda() {
		throw new UnsupportedOperationException();
	}

	public void darDeAltaInquilino() {
		throw new UnsupportedOperationException();
	}

	public void informarResidentes() {
		throw new UnsupportedOperationException();
	}

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	public GestorPropietario getGestorPropietario() {
		return gestorPropietario;
	}

	public void setGestorPropietario(GestorPropietario gestorPropietario) {
		this.gestorPropietario = gestorPropietario;
	}

}