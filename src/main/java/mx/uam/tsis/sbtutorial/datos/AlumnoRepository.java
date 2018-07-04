package mx.uam.tsis.sbtutorial.datos;

import java.util.Collection;
import mx.uam.tsis.sbtutorial.negocio.dominio.Alumno;
import org.springframework.data.repository.CrudRepository;

/**
 * Este es un repository de alumnos
 * 
 */
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
	/**
	 * Permite encontrar un alumno a partir de su matricula
	 * 
	 * @param matricula la matricula del alumno
	 * @return el alumno o null
	 * */
	Alumno findByMatricula(int matricula);
	/**
     * Regresa una coleccion que contiene a todos los alumnos
     * 
     */
	Collection<Alumno> findAll();
	
}
