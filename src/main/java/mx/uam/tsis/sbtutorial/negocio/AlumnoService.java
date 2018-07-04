package mx.uam.tsis.sbtutorial.negocio;
import java.util.Collection;
import mx.uam.tsis.sbtutorial.datos.AlumnoDAO;
import mx.uam.tsis.sbtutorial.negocio.dominio.Alumno;
import mx.uam.tsis.sbtutorial.datos.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * En este servicio se lleva a cabo toda la logica de negocio
 * relacionada con los alumnos
 * 
 *
 */
@Service
public class AlumnoService {
	@Autowired
	private AlumnoRepository repository;
	
	/**
	 * Recupera un alumno a partir de la matricula
	 * 
	 * @param matricula
	 * @return el alumno o null
	 */
	public Alumno getAlumno(int matricula) {
		// reglas de negocio se aplican aqui
		return repository.findByMatricula(matricula);
	}
	/**
	 * Recupera todos los alumnos
	 * 
	 * @return coleccion de alumnos
	 */
	public Collection<Alumno> getAlumnos() {
		// reglas de negocio se aplican aqui
		return repository.findAll();
	}
	/**
	 * Agrega un alumno
	 * 
	 * @param alumno El alumno a agregar
	 * @return true si se agrego exitosamente, false sino
	 */
	public boolean addAlumno(Alumno alumno) {
		if(repository.findByMatricula(alumno.getMatricula())==null) {
			repository.save(alumno);
			return true;
		}else {
			return false;
		}
	}
	public void deleteAlumno(Alumno alumno) {
		repository.delete(alumno);
	}
}
