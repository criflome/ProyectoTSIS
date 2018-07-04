package mx.uam.tsis.sbtutorial.datos;

import java.util.Collection;

import mx.uam.tsis.sbtutorial.negocio.dominio.Alumno;

/**
 * Interface para el DAO de alumno 
 *
 */
public interface AlumnoDAO {
	
	/**
	 * Agrega un alumno a la BD
	 * 
	 * @param alumno
	 * @return true si se agrego exitosamente
	 */
	public boolean create(Alumno alumno);
	
	/**
	 * Recupera un alumno a partir de su matricula
	 * 
	 * @param matricula
	 * @return el alumno o null
	 */
	public Alumno retrieve(int matricula);

	/**
	 * Recupera a todos los alumnos
	 * 
	 * @return coleccion con todos los alumnos
	 */
	public Collection <Alumno> retrieveAll();

	/**
	 * Actualiza el alumno persistente respecto al que esta en memoria
	 * 
	 * @param alumno
	 * @return true si se actualizo correctamente
	 */
	public boolean update(Alumno alumno);
	
	/**
	 * Borra un alumno
	 * 
	 * @param al El alumno a borrar
	 * @return true si se borro correctamente
	 */
	public boolean delete(Alumno al);
}
