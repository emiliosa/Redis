package ar.edu.uade.Bean;

import java.util.List;

public class Unidad {

	private Edificio edificio;
	private String uf;
	private String estado;
	private List<Persona> personas;

	public Unidad(Edificio edificio, String uf, String estado, List<Persona> personas) {
		super();
		this.edificio = edificio;
		this.uf = uf;
		this.estado = estado;
		this.personas = personas;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

}
