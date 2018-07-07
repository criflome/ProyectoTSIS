package mx.uam.tsis.sbtutorial.datos;
import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import mx.uam.tsis.sbtutorial.negocio.dominio.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, Long> {
	
	Paciente findByCorreo(String Correo);
	
	Collection<Paciente> findAll();

}
