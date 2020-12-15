package Dominio;

import Gestores.GestorUsuario;
import Persistencia.AgenteBD;

public class Usuario {
	protected String dni;
	protected String nombre;
	protected String rol;
	public GestorUsuario gestorUsuario;
	public AgenteBD agenteBD;

	public Usuario() {
		super();
	}

	public Usuario(String dni, String nombre, String rol, GestorUsuario gestorUsuario, AgenteBD agenteBD) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.rol = rol;
		this.gestorUsuario = gestorUsuario;
		this.agenteBD = agenteBD;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public GestorUsuario getGestorUsuario() {
		return gestorUsuario;
	}

	public void setGestorUsuario(GestorUsuario gestorUsuario) {
		this.gestorUsuario = gestorUsuario;
	}

	public AgenteBD getAgenteBD() {
		return agenteBD;
	}

	public void setAgenteBD(AgenteBD agenteBD) {
		this.agenteBD = agenteBD;
	}

	
	
	
	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", nombre=" + nombre + ", rol=" + rol + ", gestorUsuario=" + gestorUsuario
				+ ", agenteBD=" + agenteBD + "]";
	}

	public void autenticar() {
		throw new UnsupportedOperationException();
	}

	public void dar_de_alta() {
		throw new UnsupportedOperationException();
	}

}