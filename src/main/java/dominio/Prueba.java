package dominio;

public class Prueba {
	private Ciudadano _ciudadano = getCiudadano();

	public void setCiudadano(Ciudadano aCiudadano) {
		this._ciudadano = aCiudadano;
	}

	public Ciudadano getCiudadano() {
		return this._ciudadano;
	}
}