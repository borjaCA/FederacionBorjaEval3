package entidades;

import java.time.LocalDate;
import java.util.Scanner;

import utils.Utilidades;
import validaciones.Validaciones;

public class Oro extends Metal {
	private long id;
	private float pureza; // % pureza
	// Ejercicio 5, parte B
	static private float maxPureza;
	static private long idMaxPureza;

	public Oro(long id, float pureza) {
		super();
		this.id = id;
		this.pureza = pureza;
		if (pureza > maxPureza) {
			maxPureza = pureza;
			idMaxPureza = id;
		}
	}

	public Oro(long id, float pureza, LocalDate fecha) {
		super();
		this.id = id;
		this.pureza = pureza;
		if (pureza > maxPureza) {
			maxPureza = pureza;
			idMaxPureza = id;
		}
		this.fecha = fecha;
	}

	public Oro() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getPureza() {
		return pureza;
	}

	public void setPureza(float pureza) {
		this.pureza = pureza;
	}

	@Override
	public String toString() {
		return "O" + id + "(" + pureza + "%) de fecha:" + this.getFecha() + " ¿asignado?=" + this.isAsignada();
	}

	//Examen 1 Ejercicio 5, parte B
	@Override
	public float maximaPurezaAlcanzada() {
		return Oro.maxPureza;
	}

	@Override
	public float[] cotasPurezaEfectiva() {
		float[] cotas = new float[2];
		cotas[0] = (float) (pureza - 0.15);
		cotas[1] = (float) (pureza + 0.15);
		return cotas;
	}

	public static long getIdMaxPureza() {
		return idMaxPureza;
	}

	public static void setIdMaxPureza(long idMaxPureza) {
		Oro.idMaxPureza = idMaxPureza;
	}

	public static Oro nuevoOro() {
		Oro ret = null;
		Scanner in = new Scanner(System.in);
		int id = 0;
		float pureza = 0.0F;
		boolean valido = false;
		do {
			System.out.println("Introduzca el id:");
			id = in.nextInt();
			valido = Validaciones.validarId(id);
			if (!valido)
				System.out.println("Valor incorrecto para el identificador.");
			else
				valido = true;
		} while (!valido);
		valido = false;
		do {
			System.out.println("Introduzca la pureza (%):");
			pureza = Utilidades.leerFloat();
			valido = Validaciones.validarPureza(pureza);
			if (!valido)
				System.out.println("Valor incorrecto para la pureza (%).");
			else
				valido = true;
		} while (!valido);
		System.out.println("Introduzca la fecha:");
		LocalDate fecha = Utilidades.leerFecha();
		ret = new Oro(id, pureza, fecha);
		return ret;
	}

}
