package dominio;

public class Responsable extends Usuario {
	private String email;
	public Responsable(String dni, String nombre,String email, String rol) {
		super(dni, nombre, rol);
		this.email=email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}