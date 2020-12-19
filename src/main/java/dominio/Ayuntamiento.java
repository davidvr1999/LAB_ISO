package main.java.dominio;

import java.util.Vector;

public class Ayuntamiento {
	private Vivienda _vivienda;
	public Vector<Vivienda> _unnamed_Vivienda_ = new Vector<Vivienda>();

	public void setVivienda(Vivienda aVivienda) {
		this._vivienda = aVivienda;
	}

	public Vivienda getVivienda() {
		return this._vivienda;
	}
}