package dominio;

public class Sanitario extends Usuario {
	private String _nSanitario;

	public void setNSanitario(String aNSanitario) {
		this._nSanitario = aNSanitario;
	}

	public String getNSanitario() {
		return this._nSanitario;
	}
}