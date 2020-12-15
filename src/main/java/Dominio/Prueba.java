package Dominio;

public class Prueba {
	private Ciudadano ciudadano;
	public Resultado resultado;

	public Prueba() {
		super();
	}

	public Prueba(Ciudadano ciudadano, Resultado resultado) {
		super();
		this.ciudadano = ciudadano;
		this.resultado = resultado;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "Prueba [ciudadano=" + ciudadano + ", resultado=" + resultado + "]";
	}

}