package ar.edu.uade.DAO;

import java.util.Set;

import ar.edu.uade.Bean.Persona;
import ar.edu.uade.Bean.Unidad;
import redis.clients.jedis.Jedis;

public class Conexion {

	private static Jedis conexion;

	private Conexion(Jedis conexion) {
		Conexion.conexion = conexion;
	}

	public static Jedis getConexion() {
		if (conexion == null)
			conexion = new Jedis("localhost");
//		System.out.println("Server info: " + conexion.info());
		return conexion;
	}

	public static void guardar(Unidad u) {
		System.out.println("GUARDAR");
		String aux = new String();
		for(Persona it : u.getPersonas()) {
			aux = it.getDni() + " " + it.getApellido() + " " + it.getNombre();
			Conexion.getConexion().sadd(u.getEdificio().getNombre(), u.getUf() + " " + u.getEstado() + " " + aux);
		}
		Set<String> resultado = Conexion.getConexion().smembers(u.getEdificio().getNombre());
		for(String it : resultado) {
			System.out.println(u.getEdificio().getNombre() + " " + it);
		}
	}
	
	public static Set<String> recuperar(Unidad u){
		System.out.println("RECUPERAR");
		System.out.println(u.getEdificio().getNombre());
		Set<String> resultado = Conexion.getConexion().smembers(u.getEdificio().getNombre());
		return resultado;
	}
	
	public static void actualizar(Unidad u) {
		System.out.println("ACTUALIZAR");

		Set<String> resultado = Conexion.getConexion().smembers(u.getEdificio().getNombre());
		for(String it : resultado)
			System.out.println(u.getEdificio().getNombre() + " " + it);
		System.out.println(u.getPersonas().get(0).getNombre());
		
		Conexion.getConexion().del(u.getEdificio().getNombre());
		resultado.clear();
		
		String aux = new String();
		for(Persona it : u.getPersonas()) {
			aux = it.getDni() + " " + it.getApellido() + " " + it.getNombre();
			Conexion.getConexion().sadd(u.getEdificio().getNombre(), u.getUf() + " " + u.getEstado() + " " + aux);
		}
		resultado = Conexion.getConexion().smembers(u.getEdificio().getNombre());
		for(String it : resultado)
			System.out.println(u.getEdificio().getNombre() + " " + it);
	}

	
	public static void eliminar(String id) {
		System.out.println("ELIMINAR");
		Conexion.getConexion().del(id);
	}

}
