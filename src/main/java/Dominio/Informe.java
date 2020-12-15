package Dominio;

public class Informe {
	private String numero;
	public Ciudadano ciudadano;

	public Informe() {
		super();
	}

	public Informe(String numero, Ciudadano ciudadano) {
		super();
		this.numero = numero;
		this.ciudadano = ciudadano;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	@Override
	public String toString() {
		return "Informe [numero=" + numero + ", ciudadano=" + ciudadano + "]";
	}

}