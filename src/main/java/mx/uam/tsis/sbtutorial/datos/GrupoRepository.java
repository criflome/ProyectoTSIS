package mx.uam.tsis.sbtutorial.datos;

import java.util.Collection;

import mx.uam.tsis.sbtutorial.negocio.dominio.Alumno;
import mx.uam.tsis.sbtutorial.negocio.dominio.Grupo;
import org.springframework.data.repository.CrudRepository;

public interface GrupoRepository extends CrudRepository<Grupo, Long> {

	Grupo findByClave(String clave);
	
	Collection<Grupo> findAll();
	
}
