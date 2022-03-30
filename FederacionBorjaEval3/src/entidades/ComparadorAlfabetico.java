package entidades;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;



import utils.Datos;
/*
 * Crear una nueva clase ComparadorAlfabetico que sirva para implementar la
interfaz Comparator para las personas, de forma que se las pueda ordenar por orden alfabético
creciente de su atributo nombre. 

EJERCICIO1 APARTADO B EXAMEN 9
 */
public class ComparadorAlfabetico implements Comparator<DatosPersona> {

	@Override
	public int compare(DatosPersona o1, DatosPersona o2) {
		return Integer.compare(o1.getNombre().charAt(0), o2.getNombre().charAt(0));
	}
	
	public void nombresordenados() {
		LinkedList<DatosPersona> ret = new LinkedList<DatosPersona>();
		for (DatosPersona dp: Datos.PERSONAS) {
			ret.add(dp);
		}
		Collections.sort(ret, new ComparadorAlfabetico());
		System.out.println("Las personas ordenadas son: ");
		Iterator<DatosPersona> it =  ret.iterator();
		
		int i = 1; 
		while (it.hasNext()) {
			 System.out.println( i + ": " + it.next().toString() + "");
			i++;
		}
		
		
	}
}
