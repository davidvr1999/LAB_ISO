package dominio;

public class Vivienda {
	private Ciudadano ciudadano;
	private Responsable responsable;
	private String direccion;
	private String tipo;

	public Vivienda(Ciudadano ciudadano, Responsable responsable, String direccion, String tipo) {
		this.ciudadano = ciudadano;
		this.responsable = responsable;
		this.direccion = direccion;
		this.tipo = tipo;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}