package entidades;

public interface operacionesCRUD<T> {
	/**
	 * Este metodo inserta en la taba correspodiente de bdfederaciones un nuevo
	 * registro
	 * 
	 * @param elemento de tipo que se quiere insertar como nuevo elemento completo
	 *                 (con id)
	 * @return true si la insercion fue exitosa, false en caso contrario
	 */
	public boolean InsertarConID(T elemento);

	/**
	 * Este metodo inserta en la taba correspodiente de bdfederaciones un nuevo
	 * registro
	 * 
	 * @param elemento de tipo que se quiere insertar como nuevo elemento
	 *                 completo(sin id, autocompletable)
	 * @return id del nuevo elemento insertado si tuvo exito, o -1 en caso contrario
	 */

	public long InsertarSinID(T elemento);

	/*
	 * EXAMEN 10 EJERCICIO 10 Añadir a la interfaz operacionesCRUD<T> un nuevo
	 * método T buscarPorID(long id) que devuelve el objeto T cuyo identificador
	 * coincide con el valor que se pasa como parámetro (o null en caso de que no
	 * exista) haciendo una consulta a la tabla correspondiente a la entidad del
	 * tipo T en la BD bdfederacion. Reimplementar ese método para las entidades
	 * Atleta y Patrocinador, así como para la enumeración Lugar
	 */
	public T buscarPorID(long idelemento);
}
