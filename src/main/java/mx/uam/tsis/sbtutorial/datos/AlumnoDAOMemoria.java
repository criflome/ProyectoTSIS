package mx.uam.tsis.sbtutorial.datos;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import mx.uam.tsis.sbtutorial.negocio.dominio.Alumno;

/**
 * El DAO
 * 
 */
@Repository (value="AlumnoDAO")
public class AlumnoDAOMemoria implements AlumnoDAO {
	
	private Map <Integer, Alumno> alumnos = new HashMap <Integer, Alumno> ();
	
	/**
	 * Constructor
	 * 
	 */
	public AlumnoDAOMemoria() {
		// Poblamos la BD con dos objetos
		Alumno al = new Alumno("Juan",123);
		create(al);
		al = new Alumno("Sandra",333);
		create(al);
	}
	
	/**
	 * Agrega un alumno a la BD
	 * 
	 * @param alumno
	 * @return true si se agrego exitosamente
	 */
	public boolean create(Alumno alumno) {
		alumnos.put(alumno.getMatricula(),alumno);
		return true;
	}
	
	/**
	 * Recupera un alumno a partir de su matricula
	 * 
	 * @param matricula
	 * @return el alumno o null
	 */
	public Alumno retrieve(int matricula) {
		return alumnos.get(matricula);
	}

	/**
	 * Recupera a todos los alumnos
	 * 
	 * @return coleccion con todos los alumnos
	 */
	public Collection <Alumno> retrieveAll(){
		return alumnos.values();
	}

	/**
	 * Actualiza el alumno persistente respecto al que esta en memoria
	 * 
	 * @param alumno
	 * @return true si se actualizo correctamente
	 */
	public boolean update(Alumno alumno) {
		// Dado que no hay BD siempre regresa true
		return true;
	}
	
	/**
	 * Borra un alumno
	 * 
	 * @param al El alumno a borrar
	 * @return true si se borro correctamente
	 */
	public boolean delete(Alumno al) {
		alumnos.remove(al.getMatricula());
		return true;
	}
}
