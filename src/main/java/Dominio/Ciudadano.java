package Dominio;

import Gestores.GestorCiudadano;
import Gestores.GestorUsuario;
import Persistencia.AgenteBD;

public class Ciudadano extends Usuario {
	private boolean positivo;
	private String email;
	public GestorCiudadano gestorCiudadano;
	public Vivienda vivienda;
	public Resultado resultado;
	public Informe informe;

	public Ciudadano() {
		super();
	}

	public Ciudadano(boolean positivo, String email, GestorCiudadano gestorCiudadano, Vivienda vivienda,
			Resultado resultado, Informe informe) {
		super();
		this.positivo = positivo;
		this.email = email;
		this.gestorCiudadano = gestorCiudadano;
		this.vivienda = vivienda;
		this.resultado = resultado;
		this.informe = informe;
	}

	public boolean isPositivo() {
		return positivo;
	}

	public void setPositivo(boolean positivo) {
		this.positivo = positivo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public GestorCiudadano getGestorCiudadano() {
		return gestorCiudadano;
	}

	public void setGestorCiudadano(GestorCiudadano gestorCiudadano) {
		this.gestorCiudadano = gestorCiudadano;
	}

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	public Informe getInforme() {
		return informe;
	}

	public void setInforme(Informe informe) {
		this.informe = informe;
	}

	@Override
	public String toString() {
		return "Ciudadano [positivo=" + positivo + ", email=" + email + ", gestorCiudadano=" + gestorCiudadano
				+ ", vivienda=" + vivienda + ", resultado=" + resultado + ", informe=" + informe + "]";
	}

	public Ciudadano(String dni, String nombre, String rol, GestorUsuario gestorUsuario, AgenteBD agenteBD) {
		super(dni, nombre, rol, gestorUsuario, agenteBD);
		// TODO Auto-generated constructor stub
	}

	public void consultarResultado() {
		throw new UnsupportedOperationException();
	}

}