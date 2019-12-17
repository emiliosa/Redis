package ar.edu.uade.Bean;

public class Edificio {

	private String nombre;
	private String direccion;
//	private List<Unidad> unidades;

//	public Edificio(String nombre, String direccion, List<Unidad> unidades) {
	public Edificio(String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
//		this.unidades = unidades;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

/*
	public List<Unidad> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<Unidad> unidades) {
		this.unidades = unidades;
	}
*/
	
}
