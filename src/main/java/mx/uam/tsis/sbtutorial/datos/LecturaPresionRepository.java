/**
 * 
 */
package mx.uam.tsis.sbtutorial.datos;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import mx.uam.tsis.sbtutorial.negocio.dominio.LecturaPresion;

/**
 * @author Cristian Lap
 *
 */
public interface LecturaPresionRepository extends CrudRepository<LecturaPresion, Long> {
	
	Collection<LecturaPresion> findAll();
	
}
