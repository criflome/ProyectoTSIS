package mx.uam.tsis.sbtutorial.datos;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import mx.uam.tsis.sbtutorial.negocio.dominio.Medico;

public interface MedicoRepository extends CrudRepository <Medico, Long>  {
	
	Medico findByCorreo(String correo);
	
	Collection<Medico> findAll();

}
