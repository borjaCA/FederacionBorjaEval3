package entidades;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/*
 *EXAMEN 10 EJERCICIO 0 
 *Se van a añadir 2 nuevas clases al diagrama de clases, Patrocinador y Responsable, junto
a las relaciones entre sí y con el resto de entidades del diagrama. 
 */
public class Patrocinador {
	private long id;
	private String nombre;
	private String web;
	private double dotacion;

	private Responsable rep;
	private Prueba[] prueba;

	public Patrocinador() {

	}

	public Patrocinador(long id, String nombre, double dotacion, String sweb, Responsable responsable) {
		this.id = id;
		this.nombre = nombre;
		this.dotacion = dotacion;
		this.web = web;
		this.rep = responsable;
	}

	public String mostrarBasico() {
		return nombre;

	}

	public String mostrarcompleto() {
		return nombre;

	}

	/*
	 * EXAMEN 10 EJERCICIO 8< Implementar el método data() para los patrocinadores
	 * (clase Patrocinador.java) de forma que devuelva una cadena de caracteres con
	 * el siguiente orden: <idPatrocinador> | <idRepresentante> | <nombre> |
	 * <dotacion> | <web>
	 */
	public String data() {
		String ret = "";
		ret = this.getId() + "|" + rep.getId() + "|" + this.nombre + "|" + this.dotacion + "|" + this.web;
		return ret;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public double getDotacion() {
		return dotacion;
	}

	public void setDotacion(double dotacion) {
		this.dotacion = dotacion;
	}

	public Responsable getRep() {
		return rep;
	}

	public void setRep(Responsable rep) {
		this.rep = rep;
	}

	public Prueba[] getPrueba() {
		return prueba;
	}

	public void setPrueba(Prueba[] prueba) {
		this.prueba = prueba;
	}

	@Override
	public String toString() {
		return "Patrocinador [id=" + id + ", nombre=" + nombre + ", web=" + web + ", dotacion=" + dotacion + ", rep="
				+ rep + ", prueba=" + Arrays.toString(prueba) + "]";
	}

	public static Patrocinador nuevoPatrocinador() {
		// TODO Auto-generated method stub
		return null;
	}

}
