package dominio;

import java.util.Date;

public class Prueba {
	private Ciudadano ciudadano;
	private Date fecha;

	public Prueba(Ciudadano ciudadano, Date fecha) {
		this.ciudadano = ciudadano;
		this.fecha = fecha;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}
	
}