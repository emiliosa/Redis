package ar.edu.uade.TPORedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ar.edu.uade.Bean.*;
import ar.edu.uade.DAO.Conexion;

public class App {
	public static void main(String[] args) {
		
		Conexion.getConexion().del("La Plaza");
		Conexion.getConexion().del("La Calesita");
		Conexion.getConexion().del("La Sombrilla");
		Conexion.getConexion().del("La Esmeralda");
		Conexion.getConexion().del("La Silla");
		Conexion.getConexion().del("La Mesa");
		Conexion.getConexion().del("La Patrona");
		Conexion.getConexion().del("La Tele");
		Conexion.getConexion().del("La Luz");

		Persona p0 = new Persona(10203040, "nom0", "ape0");
		Persona p1 = new Persona(10203041, "nom1", "ape1");
		Persona p2 = new Persona(10203042, "nom2", "ape2");
		Persona p3 = new Persona(10203043, "nom3", "ape3");
		Persona p4 = new Persona(10203044, "nom4", "ape4");
		Persona p5 = new Persona(10203045, "nom5", "ape5");
		Persona p6 = new Persona(10203046, "nom6", "ape6");
		Persona p7 = new Persona(10203047, "nom7", "ape7");
		Persona p8 = new Persona(10203048, "nom8", "ape8");
		Persona p9 = new Persona(10203049, "nom9", "ape9");
		
		Edificio e0 = new Edificio("La Plaza", "Av La Plaza 1234");
		Edificio e1 = new Edificio("La Calesita", "Av La Calesita 1234");
		Edificio e2 = new Edificio("La Sombrilla", "Av La Sombrilla 1234");
		Edificio e3 = new Edificio("La Esmeralda", "Av La Esmeralda 1234");
		Edificio e4 = new Edificio("La Silla", "Av La Silla 1234");
		Edificio e5 = new Edificio("La Mesa", "Av La Mesa 1234");
/*		Edificio e6 = new Edificio("La Patrona", "Av La Patrona 1234");
		Edificio e7 = new Edificio("La Tele", "Av La Tele 1234");
		Edificio e8 = new Edificio("La Luz", "Av La Luz 1234");
*/		
		List<Persona> persAux = new ArrayList<Persona>();

		persAux.add(p0);
		Unidad u0 = new Unidad(e0, "01", "Ocupado", persAux);
		Conexion.guardar(u0);
		persAux.clear();
		
		persAux.add(p1);
		Unidad u1 = new Unidad(e1, "A", "Ocupado", persAux);
		Conexion.guardar(u1);
		persAux.clear();
		
		persAux.add(p2);
		Unidad u2 = new Unidad(e2, "04", "Ocupado", persAux);
		Conexion.guardar(u2);
		persAux.clear();
		
		persAux.add(p3);
		Unidad u3 = new Unidad(e3, "01", "Ocupado", persAux);
		Conexion.guardar(u3);
		persAux.clear();
		
		persAux.add(p0);
		persAux.add(p4);
		Unidad u4 = new Unidad(e4, "1", "Libre", persAux);
		Conexion.guardar(u4);
		persAux.clear();
		
		persAux.add(p5);
		Unidad u5 = new Unidad(e5, "01", "Libre", persAux);
		Conexion.guardar(u5);
		persAux.clear();
		
		persAux.add(p6);
		Unidad u6 = new Unidad(e0, "02", "Ocupado", persAux);
		Conexion.guardar(u6);
		persAux.clear();
		
		persAux.add(p7);
		persAux.add(p8);
		Unidad u7 = new Unidad(e0, "03", "Ocupado", persAux);
		Conexion.guardar(u7);
		persAux.clear();
		
		persAux.add(p9);
		Unidad u8 = new Unidad(e3, "02", "Libre", persAux);
		Conexion.guardar(u8);
		persAux.clear();
		
		System.out.println("");
		Set<String> resultado = Conexion.recuperar(u4);
		for(String it : resultado) {
			System.out.println(it);
		}
		resultado.clear();
		
		System.out.println("");
		persAux.add(p9);
		u5 = new Unidad(e5, "02", "Ocupado", persAux);
		Conexion.actualizar(u5);
		persAux.clear();

		System.out.println("");
		Conexion.eliminar(u4.getEdificio().getNombre());
		resultado = Conexion.recuperar(u4);
		for(String it : resultado) {
			System.out.println(it);
		}
	}
}
