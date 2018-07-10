package mx.uam.tsis.sbtutorial.negocio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.tsis.sbtutorial.datos.PacienteRepository;
import mx.uam.tsis.sbtutorial.negocio.dominio.Alumno;
import mx.uam.tsis.sbtutorial.negocio.dominio.Paciente;

@Service
public class PacienteService {
	
	@Autowired
	PacienteRepository repository;
	
	/**
	 * Recupera todos los pacientes en la BD
	 * @return
	 */
	public Collection<Paciente> getPacientes() {
		// reglas de negocio se aplican aqui
		return repository.findAll();
	}
	
	/**
	 * Agrega un pacente a la BD
	 * @param paciente
	 * @return
	 */
	public boolean addPaciente(Paciente paciente) {
		if(repository.findByCorreo(paciente.getCorreo())==null) {
			repository.save(paciente);
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Busque da de paciente por correo
	 * @param correo
	 * @return
	 */
	public Paciente getPaciente(String correo) {
		return repository.findByCorreo(correo);
	}
	
	public void deletePaciente(Paciente paciente) {
		repository.delete(paciente);
	}

}
