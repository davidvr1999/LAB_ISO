package dominio;

public class Informe {
	private String numero;
	private String ruta;
	public Informe(String numero, String ruta) {
		this.numero = numero;
		this.ruta = ruta;
	}
	public String getNumero() {
		return numero;
	}
	public String getRuta() {
		return ruta;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

}