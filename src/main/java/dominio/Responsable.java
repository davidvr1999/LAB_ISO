package dominio;

public class Responsable extends Usuario {
	private String dni;
	private String email;
	public Responsable(String dni, String nombre,String email, String rol) {
		super(dni, nombre, rol);
		this.dni = dni;
		this.email=email;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}