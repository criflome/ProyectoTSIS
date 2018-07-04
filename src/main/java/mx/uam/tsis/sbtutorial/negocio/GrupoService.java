package mx.uam.tsis.sbtutorial.negocio;
import java.util.Collection;
import mx.uam.tsis.sbtutorial.negocio.dominio.Alumno;
import mx.uam.tsis.sbtutorial.negocio.dominio.Grupo;
import mx.uam.tsis.sbtutorial.datos.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoService {
	@Autowired
	GrupoRepository repository;
	public Collection<Grupo> getGrupos() {
		// reglas de negocio se aplican aqui
		return repository.findAll();
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
	}
}
