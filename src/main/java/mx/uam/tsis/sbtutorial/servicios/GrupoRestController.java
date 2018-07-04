package mx.uam.tsis.sbtutorial.servicios;
import java.util.Collection;
import mx.uam.tsis.sbtutorial.negocio.AlumnoService;
import mx.uam.tsis.sbtutorial.negocio.GrupoService;
import mx.uam.tsis.sbtutorial.negocio.dominio.Alumno;
import mx.uam.tsis.sbtutorial.negocio.dominio.Grupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
public class GrupoRestController {
	@Autowired
	private GrupoService servicioGrupos;
	@Autowired
	private AlumnoService servicioAlumnos;
	@RequestMapping(value="/grupos", method=RequestMethod.GET)
    public Collection <Grupo> dameGrupos() {
        return servicioGrupos.getGrupos();
    }
	@RequestMapping(value="/grupos/{clave}", method=RequestMethod.DELETE)
    public ResponseEntity<Grupo> EliminaGrupo(@PathVariable String clave) {
        Grupo gr = servicioGrupos.getGrupo(clave);
       	if(gr==null) {
       		return new ResponseEntity<Grupo>(gr, HttpStatus.NOT_FOUND);
       	}else {
       		servicioGrupos.deleteGrupo(gr);
       		return new ResponseEntity<Grupo>(gr, HttpStatus.OK);
       	}
    }
	@RequestMapping(value="/grupos", method = RequestMethod.POST)
    public ResponseEntity<Grupo> agregaGrupo(@RequestBody Grupo grupo) {
            boolean retorno = servicioGrupos.addGrupo(grupo);
            if(retorno) {
                return new ResponseEntity<Grupo>(grupo, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Grupo>(grupo, HttpStatus.BAD_REQUEST);
            }
    }
	@RequestMapping(value="/grupos/{clave}/alumnos/{matricula}", method=RequestMethod.PUT)
    public ResponseEntity<Grupo> agregaAlumno(@PathVariable("clave") String clave, @PathVariable("matricula") int matricula) {
        Alumno alumno = servicioAlumnos.getAlumno(matricula);
        Grupo grupo = servicioGrupos.getGrupo(clave);
       	if(alumno ==null || grupo == null) {
       		return new ResponseEntity<Grupo>(grupo, HttpStatus.NOT_FOUND);
       	}else {
       		grupo.agregaAlumno(alumno);
       		servicioGrupos.save(grupo);
       		return new ResponseEntity<Grupo>(grupo, HttpStatus.OK);
       	}
    }
	@RequestMapping(value="/grupos/{clave}/alumnos/{matricula}", method=RequestMethod.DELETE)
    public ResponseEntity<Grupo> borraAlumno(@PathVariable("clave") String clave, @PathVariable("matricula") int matricula) {
        Alumno alumno = servicioAlumnos.getAlumno(matricula);
        Grupo grupo = servicioGrupos.getGrupo(clave);
       	if(alumno ==null || grupo == null) {
       		return new ResponseEntity<Grupo>(grupo, HttpStatus.NOT_FOUND);
       	}else {
       		grupo.borraAlumno(alumno);
       		servicioGrupos.save(grupo);
       		return new ResponseEntity<Grupo>(grupo, HttpStatus.OK);
       	}
    }
	@RequestMapping(value="/grupos/{clave}/alumnos", method=RequestMethod.GET)
    public Collection buscaAlumnos(@PathVariable("clave") String clave) {
        Grupo grupo = servicioGrupos.getGrupo(clave);
       	if(grupo == null) {
       		return null;
       	}else {
       		return grupo.getAlumnos();
       	}
    }
}
