package Dominio;

import Persistencia.AgenteBD;

public class Vivienda {

	public Ciudadano ciudadano;
	public Ayuntamiento ayuntamiento;
	public Responsable responsable;
	public AgenteBD agenteBD;

	public Vivienda() {
		super();
	}

	public Vivienda(Ciudadano ciudadano, Ayuntamiento ayuntamiento, Responsable responsable, AgenteBD agenteBD) {
		super();
		this.ciudadano = ciudadano;
		this.ayuntamiento = ayuntamiento;
		this.responsable = responsable;
		this.agenteBD = agenteBD;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public Ayuntamiento getAyuntamiento() {
		return ayuntamiento;
	}

	public void setAyuntamiento(Ayuntamiento ayuntamiento) {
		this.ayuntamiento = ayuntamiento;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public AgenteBD getAgenteBD() {
		return agenteBD;
	}

	public void setAgenteBD(AgenteBD agenteBD) {
		this.agenteBD = agenteBD;
	}

	@Override
	public String toString() {
		return "Vivienda [ciudadano=" + ciudadano + ", ayuntamiento=" + ayuntamiento + ", responsable=" + responsable
				+ ", agenteBD=" + agenteBD + "]";
	}

}