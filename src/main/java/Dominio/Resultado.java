package Dominio;

public class Resultado {
	private boolean positivo;
	public Ciudadano ciudadano;
	public Prueba prueba;
	
	
	
	public Resultado() {
		super();
	}
	public Resultado(boolean positivo, Ciudadano ciudadano, Prueba prueba) {
		super();
		this.positivo = positivo;
		this.ciudadano = ciudadano;
		this.prueba = prueba;
	}
	public boolean isPositivo() {
		return positivo;
	}
	public void setPositivo(boolean positivo) {
		this.positivo = positivo;
	}
	public Ciudadano getCiudadano() {
		return ciudadano;
	}
	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}
	public Prueba getPrueba() {
		return prueba;
	}
	public void setPrueba(Prueba prueba) {
		this.prueba = prueba;
	}
	@Override
	public String toString() {
		return "Resultado [positivo=" + positivo + ", ciudadano=" + ciudadano + ", prueba=" + prueba + "]";
	}

	
}