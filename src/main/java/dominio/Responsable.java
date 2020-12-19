package main.java.dominio;

public class Responsable extends Usuario {
	private Vivienda _vivienda;

	public void setVivienda(Vivienda aVivienda) {
		this._vivienda = aVivienda;
	}

	public Vivienda getVivienda() {
		return this._vivienda;
	}
}