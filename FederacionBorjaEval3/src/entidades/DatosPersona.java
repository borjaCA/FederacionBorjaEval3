package entidades;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import utils.ConexBD;
import utils.Datos;
import utils.Utilidades;
import validaciones.Validaciones;

public class DatosPersona implements Comparable<DatosPersona>{
	private long id;
	private String nombre;
	private String telefono;
	private LocalDate fechaNac;

	private Documentacion nifnie; // Examen 2 Ejercicio 3.2

	public DatosPersona(long id, String nombre, String telefono, LocalDate fechaNac) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
	}

	// Examen 2 Ejercicio 3.2
	public DatosPersona(long id, String nombre, String telefono, LocalDate fechaNac, Documentacion nifnie) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
		this.nifnie = nifnie;
	}

	public DatosPersona() {
		// TODO Auto-generated constructor stub
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Documentacion getNifnie() {
		return nifnie;
	}

	public void setNifnie(Documentacion nifnie) {
		this.nifnie = nifnie;
	}

	/**
	 * Implementar el metodo data() para las personas de forma que devuelvan una
	 * cadena con el siguiente ordern idPersona | nombre | telefono |
	 * fechaNac(dd/MM/YYYY) | NIFNIE
	 * 
	 * @return Ejercicio 1, APARTADO A: EXAMEN 9:
	 */
	public String data() {
		String ret = "";
		ret = this.getId() + "|" + this.getNombre() + "|" + this.getTelefono() + "|"
				+ this.getFechaNac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "|" + this.getNifnie();

		return ret;
	}

	@Override
	public String toString() {
		return nombre + " NIF/NIE: " + nifnie.mostrar() + " Tfn:" + telefono + " ("
				+ fechaNac.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ")";
	}

	// Examen 2 Ejercicio 3.3
	// Examen 5 Ejercicio 3
	public static DatosPersona nuevaPersona() {
		DatosPersona ret = null;
		Scanner in;
		long id = -1;
		String nombre = "";
		String tfn = "";
		boolean valido = false;
		do {
			System.out.println("Introduzca el id de la nueva persona:");
			in = new Scanner(System.in);
			id = in.nextInt();
			valido = Validaciones.validarId(id);
			if (!valido)
				System.out.println("ERROR: Valor incorrecto para el identificador.");
			else
				valido = true;
		} while (!valido);
		valido = false;
		do {
			System.out.println("Introduzca el nombre de la nueva persona:");
			in = new Scanner(System.in);
			nombre = in.nextLine();
			valido = Validaciones.validarNombre(nombre);
			if (!valido)
				System.out.println("ERROR: El valor introducido para el nombre no es válido. ");
		} while (!valido);
		do {
			System.out.println("Introduzca el teléfono de la nueva persona:");
			in = new Scanner(System.in);
			tfn = in.nextLine();
			valido = Validaciones.validarTelefono(tfn);
			if (!valido)
				System.out.println("ERROR: El valor introducido para el teléfono no es válido. ");
		} while (!valido);
		System.out.println("Introduzca la fecha de nacimiento de la nueva persona");
		LocalDate fecha = Utilidades.leerFecha();
		System.out.println("¿Va a introducir un NIF? (pulse 'S' par SÍ o 'N' para NIE)");
		boolean esnif = Utilidades.leerBoolean();
		Documentacion doc;
		valido = false;
		do {
			if (esnif)
				doc = NIF.nuevoNIF();
			else
				doc = NIE.nuevoNIE();
			valido = doc.validar();
			if (!valido)
				System.out.println("ERROR: El documento introducido no es válido.");
		} while (!valido);
		ret = new DatosPersona(id, nombre, tfn, fecha, doc);
		return ret;
	}

	/*
	 * Implementar luego una función estática en DatosPersona.java que recorra todo
	 * el array PERSONAS de la clase Datos.java y exporte hacia un fichero de
	 * caracteres de nombre atletas_alfabetico.txt los datos de todas las personas,
	 * cada una en una línea diferente, a través del método data() del apartado A y
	 * habiendo sido ordenadas previamente mediante el ComparadorAlfabetico del
	 * apartado B. EJERCICIO 1 APARTADO C EXAMEN 3 EVALUACION
	 */
	public static void recorrerpersona() {
		System.out.println("Guardando datos persona en un fichero");
		File fOut = new File("atletas_alfabetico.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		String data;
		ComparadorAlfabetico cp = new ComparadorAlfabetico();
		try {
			fw = new FileWriter(fOut);
			bw = new BufferedWriter(fw);
			for (DatosPersona dp : Datos.PERSONAS) {
				cp.nombresordenados();
				bw.write(dp.data() + "\n");
				bw.flush();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
		System.out.println("---------- Guardados los datos --------");
	}

	/*
	 * Incluir además en esa clase una función estática insertarPersonas() para
	 * obtener todos los datos del array PERSONAS de la clase Datos.java y
	 * ordenarlos según el comparador anterior (del apartado A de este ejercicio)
	 * sobre una lista. Finalmente recorrerla mediante un iterador e ir insertando
	 * en la BD relacional bdfederacion sobre la tabla personas.
	 * 
	 * EJERCICIO 2 APARTADO EXAMEN 9 EVALUACION 3:
	 */
	public static void insertarPersonas() {
		Connection conex = ConexBD.establecerConexion();
		String ConsultaInsertSTR = "insert into personas(id, nombre, teléfono, nifnie) values (?,?,?,?)";
		try {
			PreparedStatement pstmt = conex.prepareStatement(ConsultaInsertSTR);
			for (DatosPersona dp : Datos.PERSONAS) {
				dp.compareTo(dp);
				pstmt.setLong(1, dp.getId());
				pstmt.setString(2, dp.getNombre());
				pstmt.setString(3, dp.getTelefono());
				pstmt.setString(4, dp.getNifnie().mostrar());
				int resultadoInsercion = pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}
	}
/*
 * Implementar la interfaz Comparable para las personas (clase
DatosPersona.java), de forma que se ordenen según su fecha de nacimiento de menor a mayor
edad y si 2 personas tienen el mismo valor de fecha, entonces se desempatará en función del campo
Documentacion (NIF/NIE).

EJERCICIO 2 APARTADO A EXAMEN 9 EVALUACION 3
 */
	@Override
	public int compareTo(DatosPersona o) {

		int comparafechas = this.getFechaNac().compareTo(o.getFechaNac());
		int comparadocumentacion = this.getNifnie().compareTo(o.getNifnie());
		if (comparafechas == 0) {
		return comparadocumentacion;
		} else
		return comparafechas;


	}
}
