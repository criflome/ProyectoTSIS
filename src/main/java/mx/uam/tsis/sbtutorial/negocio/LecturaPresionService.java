package mx.uam.tsis.sbtutorial.negocio;
import java.util.Collection;
import mx.uam.tsis.sbtutorial.negocio.dominio.Alumno;
import mx.uam.tsis.sbtutorial.negocio.dominio.Grupo;
import mx.uam.tsis.sbtutorial.negocio.dominio.LecturaPresion;
import mx.uam.tsis.sbtutorial.datos.GrupoRepository;
import mx.uam.tsis.sbtutorial.datos.LecturaPresionRepository;
import mx.uam.tsis.sbtutorial.datos.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LecturaPresionService {
	@Autowired
	LecturaPresionRepository repositoryPresion;
	PacienteRepository repositoryPasiente;
	
	/*public Collection<LecturaPresion> getPresion() {
		// reglas de negocio se aplican aqui
		return repositoryPasiente.
	}
	public Grupo getGrupo(String clave) {
		// reglas de negocio se aplican aqui
		return repository.findByClave(clave);
	}
	public boolean addGrupo(Grupo grupo) {
		if(repository.findByClave(grupo.getClave())==null) {
			repository.save(grupo);
			return true;
		}else {
			return false;
		}
	}
	public void deleteGrupo(Grupo grupo) {
		repository.delete(grupo);
	}
	public Grupo save(Grupo grupo) {
		return repository.save(grupo);
	}*/
}
