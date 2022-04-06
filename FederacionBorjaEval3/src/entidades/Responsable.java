package entidades;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Responsable {
	/*
	 * EXAMEN 10 EJERCICIO 0 Se van a añadir 2 nuevas clases al diagrama de clases,
	 * Patrocinador y Responsable, junto a las relaciones entre sí y con el resto de
	 * entidades del diagrama.
	 */
	private long id;
	private String telefonoProf;
	private LocalTime horarioIni;
	private LocalTime horarioFin;

	private DatosPersona dp;
	private Patrocinador patrocinador;

	public Responsable() {

	}

	public Responsable(long id, String telefonoProf, LocalTime horarioIni, LocalTime horarioFin, DatosPersona dp) {
		this.id = id;
		this.telefonoProf = telefonoProf;
		this.horarioIni = horarioIni;
		this.horarioFin = horarioFin;
		this.dp = dp;
	}

	public void importarRepresentate() {

	}

	/*
	 * EXAMEN 10 EJERCICIO 4 Implementar el método data() para los responsables
	 * (clase Responsable.java) de forma que devuelva una cadena de caracteres con
	 * el siguiente orden: <idResponsable> | <idPersona> | <telefonoProf> |
	 * <horaIni(HH:mm)> | <horaFin(HH:mm)>
	 * 
	 */
	public String data() {
		return "" + this.getId() + "|" + dp.getId() + "|" + this.getTelefonoProf() + "|"
				+ this.getHorarioIni().format(DateTimeFormatter.ofPattern("HH:mm")) + "|"
				+ this.getHorarioFin().format(DateTimeFormatter.ofPattern("HH:mm"));

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTelefonoProf() {
		return telefonoProf;
	}

	public void setTelefonoProf(String telefonoProf) {
		this.telefonoProf = telefonoProf;
	}

	public LocalTime getHorarioIni() {
		return horarioIni;
	}

	public void setHorarioIni(LocalTime horarioIni) {
		this.horarioIni = horarioIni;
	}

	public LocalTime getHorarioFin() {
		return horarioFin;
	}

	public void setHorarioFin(LocalTime horarioFin) {
		this.horarioFin = horarioFin;
	}

	public DatosPersona getDp() {
		return dp;
	}

	public void setDp(DatosPersona dp) {
		this.dp = dp;
	}

	public Patrocinador getPatrocinador() {
		return patrocinador;
	}

	public void setPatrocinador(Patrocinador patrocinador) {
		this.patrocinador = patrocinador;
	}

	@Override
	public String toString() {
		return "Responsable [id=" + id + ", telefonoProf=" + telefonoProf + ", horarioIni=" + horarioIni
				+ ", horarioFin=" + horarioFin + ", dp=" + dp + ", patrocinador=" + patrocinador + "]";
	}

}
