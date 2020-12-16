package dominio;

public class Ciudadano extends Usuario {
	private boolean _positivo;
	private String _email;
	private String _nTarjetaSanitaria;
	
	public Informe informe;

	public Ciudadano(boolean _positivo, String _email, String _nTarjetaSanitaria, Informe informe) {
		this._positivo = _positivo;
		this._email = _email;
		this._nTarjetaSanitaria = _nTarjetaSanitaria;
		this.informe = informe;
	}

	public void setPositivo(boolean aPositivo) {
		this._positivo = aPositivo;
	}

	public boolean isPositivo() {
		return this._positivo;
	}

	public void setEmail(String aEmail) {
		this._email = aEmail;
	}

	public String getEmail() {
		return this._email;
	}

	public void setNTarjetaSanitaria(String aNTarjetaSanitaria) {
		this._nTarjetaSanitaria = aNTarjetaSanitaria;
	}

	public String getNTarjetaSanitaria() {
		return this._nTarjetaSanitaria;
	}
}