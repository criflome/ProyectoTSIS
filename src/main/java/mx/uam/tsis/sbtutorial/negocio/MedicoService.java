package mx.uam.tsis.sbtutorial.negocio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.tsis.sbtutorial.datos.MedicoRepository;
import mx.uam.tsis.sbtutorial.negocio.dominio.Medico;

@Service
public class MedicoService {
	
	@Autowired
	MedicoRepository repository;
	
	/**
	 * Recupera todos los Medicos en la BD
	 * @return
	 */
	public Collection<Medico> getMedicos() {
		// reglas de negocio se aplican aqui
		return repository.findAll();
	}
	
	/**
	 * Agrega un pacente a la BD
	 * @param medico
	 * @return
	 */
	public boolean addMedico(Medico medico) {
		if(repository.findByCorreo(medico.getCorreo())==null) {
			repository.save(medico);
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Busque da de medico por correo
	 * @param correo
	 * @return
	 */
	public Medico getMedico(String correo) {
		return repository.findByCorreo(correo);
	}
	
	public void deleteMedico(Medico medico) {
		repository.delete(medico);
	}


}
