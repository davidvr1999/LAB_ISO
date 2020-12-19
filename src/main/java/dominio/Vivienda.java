package main.java.dominio;

public class Vivienda {
	private Ciudadano _ciudadano;
	private Responsable _responsable;
	private String _tipo;

	public void setCiudadano(Ciudadano aCiudadano) {
		this._ciudadano = aCiudadano;
	}

	public Ciudadano getCiudadano() {
		return this._ciudadano;
	}

	public void setResponsable(Responsable aResponsable) {
		this._responsable = aResponsable;
	}

	public Responsable getResponsable() {
		return this._responsable;
	}

	public void setTipo(String aTipo) {
		this._tipo = aTipo;
	}

	public String getTipo() {
		return this._tipo;
	}
}