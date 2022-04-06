package principalBorja;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

import entidades.Patrocinador;
import entidades.Responsable;
import utils.Datos;

public class PrincipalExam10 {

	public static void main(String[] args) {
	}

	public static void crearTabla() {
		/*
		 * EXAMEN 10 EJERCICIO 8
		 */

		List<Patrocinador> patroci = new LinkedList<Patrocinador>();

		Responsable resp1 = new Responsable(1, "902422202", LocalTime.of(00, 00), LocalTime.of(23, 59),
				Datos.buscarPersonaPorId(1011));
		Patrocinador patro1 = new Patrocinador(1, "ALSA", 500.00, "www.alsa.es", resp1);
		patroci.add(patro1);

		Responsable resp2 = new Responsable(2, "985181105", LocalTime.of(9, 00), LocalTime.of(18, 00),
				Datos.buscarPersonaPorId(1012));
		Patrocinador patro2 = new Patrocinador(2, "Ayto.Gijon", 250.00, "www.gijon.es", resp2);
		patroci.add(patro2);

		Responsable resp3 = new Responsable(3, "985103000", LocalTime.of(8, 30), LocalTime.of(20, 00),
				Datos.buscarPersonaPorId(1012));
		Patrocinador patro3 = new Patrocinador(3, "Universidad de Oviedo", 350.00, "www.uniovi.es", resp3);
		patroci.add(patro3);

		Responsable resp4 = new Responsable(4, "985185503", LocalTime.of(8, 30), LocalTime.of(18, 00),
				Datos.buscarPersonaPorId(1012));
		Patrocinador patro4 = new Patrocinador(4, "CIFP la Laboral", 255.99, "www.cifplalaboral.es", resp3);
		patroci.add(patro4);

	}

}
