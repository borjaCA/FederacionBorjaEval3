package entidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import dao.operacionesCRUD;
import utils.ConexBD;
import utils.Datos;
import utils.Utilidades;
import validaciones.Validaciones;

public class Atleta extends Participante implements operacionesCRUD<Atleta> {
	private long idAtleta;
	private float altura;
	private float peso;

	private DatosPersona persona;

	public Atleta(long id, int dorsal, char calle, long idAtleta, float altura, float peso) {
		super(id, dorsal, calle);
		this.idAtleta = idAtleta;
		this.altura = altura;
		this.peso = peso;
		this.persona = Datos.buscarPersonaPorId(id);
	}

	public Atleta(long id, int dorsal, char calle, long idAtleta, float altura, float peso, DatosPersona dp) {
		super(id, dorsal, calle);
		this.idAtleta = idAtleta;
		this.altura = altura;
		this.peso = peso;
		this.persona = dp;
	}

	public Atleta(long idAtleta, float altura, float peso, DatosPersona dp) {
		super();
		this.idAtleta = idAtleta;
		this.altura = altura;
		this.peso = peso;
		this.persona = dp;
	}

	public Atleta(long idParticipante, Atleta a, int dorsal, char calle) {
		super(idParticipante, dorsal, calle);
		this.idAtleta = a.idAtleta;
		this.altura = a.altura;
		this.peso = a.peso;
		this.persona = Datos.buscarPersonaPorId(a.idAtleta);
	}

	@Override
	public long getId() {
		return idAtleta;
	}

	@Override
	public void setId(long id) {
		this.idAtleta = id;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public DatosPersona getPersona() {
		return this.persona;
	}

	// Examen 5 Ejercicio 5
	/***
	 * Función que pregunta al usuario por cada uno de los campos para un nuevo
	 * Atleta, los valida y si son correctos devuelve un objeto Atleta completo
	 * 
	 * @return un objeto Atleta completo válido o null si hubo algún error
	 */
	public static Atleta nuevoAtleta() {
		Atleta ret = null;
		long id = -1;
		float altura = 0.0F;
		float peso = 0.0F;
		int elecc = -1;
		DatosPersona dp = null;
		Scanner in;
		boolean valido = false;
		do {
			System.out.println("Introduzca el id del nuevo atleta:");
			in = new Scanner(System.in);
			id = in.nextInt();
			if (id > 0)
				valido = true;
			else
				System.out.println("Valor incorrecto para el identificador.");
		} while (!valido);

		valido = false;
		do {
			System.out.println("Introduzca el peso del nuevo atleta (xx,xx)Kgs:");
			peso = Utilidades.leerFloat();
			valido = Validaciones.validarPeso(peso);
			if (!valido)
				System.out.println("ERROR: El valor introducido para el peso no es válido.");
		} while (!valido);

		valido = false;
		do {
			System.out.println("Introduzca la altura del nuevo atleta (xx,xx)m:");
			altura = Utilidades.leerFloat();
			valido = Validaciones.validarAltura(altura);
			if (!valido)
				System.out.println("ERROR: El valor introducido para la altura no es válido.");
		} while (!valido);

		System.out.println("Introduzca ahora los datos personales:");
		in = new Scanner(System.in);
		dp = DatosPersona.nuevaPersona();

		ret = new Atleta(id, altura, peso, dp);
		return ret;
	}

	/***
	 * Función que devuelve una cadena de caracteres con los datos del atleta con el
	 * siguiente formato: <nombre> “ (” <documentacion> ”) del año
	 * ”<fechaNac.año>’\t’<peso>”Kgs. ”<altura>”m.“
	 */
	@Override
	public String toString() {
		return "" + persona.getNombre() + " (" + persona.getNifnie().mostrar() + ") del año "
				+ persona.getFechaNac().getYear() + "\t" + peso + "Kgs. " + altura + "m.";
	}

	@Override
	public boolean InsertarConID(Atleta elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long InsertarSinID(Atleta elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public Atleta buscarPorID(long idAtleta) {
		Atleta ret = null;
		int a = -1;
		Connection conex = null;
		Statement consulta = null;
		ResultSet resultado = null;
		try {
			

			conex = ConexBD.establecerConexion();

			String consultaStr = "SELECT * FROM lugares where id"+idAtleta;
			if (conex == null)
				conex = ConexBD.getCon();
			consulta = conex.createStatement();
			resultado = consulta.executeQuery(consultaStr);
			while (idAtleta	 == resultado.getInt(1)) {
				while (resultado.next()) {
					String nombre = resultado.getString(2);
					String ubicacion = resultado.getString(3);
					boolean airelibre = resultado.getBoolean(4);

				}
				return ret;
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una Excepcion:" + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				System.out.println("Cerrando recursos...");
				if (resultado != null)
					resultado.close();
				if (consulta != null)
					consulta.close();
				if (conex != null)
					conex.close();
			} catch (SQLException e) {
				System.out.println("Se ha producido una Excepcion:" + e.getMessage());
				e.printStackTrace();
			}
		}
		System.out.println("FIN");
		return ret;
	}

}
