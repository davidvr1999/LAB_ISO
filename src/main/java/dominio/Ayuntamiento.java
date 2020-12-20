package dominio;

public class Ayuntamiento {
	private String cp;
	private String localidad;
	private String provincia;
	
	public Ayuntamiento() {
		
	}
	
	public Ayuntamiento(String cp, String localidad, String provincia) {
		this.cp = cp;
		this.localidad = localidad;
		this.provincia = provincia;
	}
	public String getCp() {
		return cp;
	}
	public String getLocalidad() {
		return localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
}