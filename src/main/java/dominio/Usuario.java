package dominio;

public class Usuario {
	protected String _dni;
	protected String _nombre;
	protected String _rol;

	public void setDni(String aDni) {
		this._dni = aDni;
	}

	public String getDni() {
		return this._dni;
	}

	public void setNombre(String aNombre) {
		this._nombre = aNombre;
	}

	public String getNombre() {
		return this._nombre;
	}

	public void setRol(String aRol) {
		this._rol = aRol;
	}

	public String getRol() {
		return this._rol;
	}
}