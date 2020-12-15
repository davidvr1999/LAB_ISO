package Dominio;

import java.util.Vector;

import Persistencia.AgenteBD;

public class Ayuntamiento<GestorAyuntamiento> {
	private Vivienda vivienda;
	public AgenteBD agenteBD;
	public Vector<Vivienda> listaViviendas = new Vector<Vivienda>();
	public GestorAyuntamiento gestorAyuntamiento;

	public Ayuntamiento() {
		super();
	}

	public Ayuntamiento(Vivienda vivienda, AgenteBD agenteBD, Vector<Vivienda> listaViviendas,
			GestorAyuntamiento gestorAyuntamiento) {
		super();
		this.vivienda = vivienda;
		this.agenteBD = agenteBD;
		this.listaViviendas = listaViviendas;
		this.gestorAyuntamiento = gestorAyuntamiento;
	}

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	public AgenteBD getAgenteBD() {
		return agenteBD;
	}

	public void setAgenteBD(AgenteBD agenteBD) {
		this.agenteBD = agenteBD;
	}

	public Vector<Vivienda> getListaViviendas() {
		return listaViviendas;
	}

	public void setListaViviendas(Vector<Vivienda> listaViviendas) {
		this.listaViviendas = listaViviendas;
	}

	public GestorAyuntamiento getGestorAyuntamiento() {
		return gestorAyuntamiento;
	}

	public void setGestorAyuntamiento(GestorAyuntamiento gestorAyuntamiento) {
		this.gestorAyuntamiento = gestorAyuntamiento;
	}

	@Override
	public String toString() {
		return "Ayuntamiento [vivienda=" + vivienda + ", agenteBD=" + agenteBD + ", listaViviendas=" + listaViviendas
				+ ", gestorAyuntamiento=" + gestorAyuntamiento + "]";
	}

	public void enviarDatosPoblacion() {
		throw new UnsupportedOperationException();
	}

}