package mx.uam.tsis.sbtutorial.servicios;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.uam.tsis.sbtutorial.datos.LecturaPresionRepository;
import mx.uam.tsis.sbtutorial.negocio.LecturaPresionService;
import mx.uam.tsis.sbtutorial.negocio.PacienteService;
import mx.uam.tsis.sbtutorial.negocio.dominio.Grupo;
import mx.uam.tsis.sbtutorial.negocio.dominio.LecturaPresion;
import mx.uam.tsis.sbtutorial.negocio.dominio.Paciente;

@RestController
public class PacienteRestController {
	
	@Autowired
	PacienteService servicio;
	
	@Autowired
	LecturaPresionService servicioLecturaPresion;
	/**
	 * Metodo que regresa todos los pacientes
	 * @return
	 */
	@RequestMapping(value="/pacientes", method=RequestMethod.GET)
    public Collection <Paciente> damePacientes() {
        return servicio.getPacientes();
    }
	
	/**
	 * Metodo para el registro de pacientes
	 * @param paciente
	 * @return
	 */
	@RequestMapping(value="/pacientes", method = RequestMethod.POST)
    public ResponseEntity<Paciente> agregaPaciente(@RequestBody Paciente paciente) {
            boolean retorno = servicio.addPaciente(paciente);
            if(retorno) {
                return new ResponseEntity<Paciente>(paciente, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Paciente>(paciente, HttpStatus.BAD_REQUEST);
            }
    }
	
	/**
	 * Obtiene un paciente por correo
	 * @param correo
	 * @return Paciente
	 * @author Cristian 
	 */
	@RequestMapping(value="/pacientes/{correo}", method=RequestMethod.GET)
    public ResponseEntity<Paciente> getPaciente(@PathVariable("correo") String correo) {
        Paciente paciente = servicio.getPaciente(correo);
        
       	if(paciente==null) {
       		return new ResponseEntity<Paciente>(paciente, HttpStatus.NOT_FOUND);
       	}else {
       		return new ResponseEntity<Paciente>(paciente, HttpStatus.OK);
       	}
    }
	
	/**
	 * Busque da de paciente por correo
	 * @param correo
	 * @return
	 */
	@RequestMapping(value="/pacientes/{correo}/{contrasena}", method=RequestMethod.GET)
    public ResponseEntity<Paciente> buscaPaciente(@PathVariable("correo") String correo, @PathVariable("contrasena") String contrasena) {
        Paciente paciente = servicio.sesion(correo, contrasena);
       	if(paciente==null) {
       		return new ResponseEntity<Paciente>(paciente, HttpStatus.NOT_FOUND);
       	}else {
       		return new ResponseEntity<Paciente>(paciente, HttpStatus.OK);
       	}
    }
	
	/**
	 * Metodo para borrar Pacientes
	 * @param correo
	 * @return
	 */
	@RequestMapping(value="/pacientes/{correo}", method=RequestMethod.DELETE)
    public ResponseEntity<Paciente> borraPaciente(@PathVariable String correo) {
        Paciente paciente = servicio.getPaciente(correo);
       	if(paciente==null) {
       		return new ResponseEntity<Paciente>(paciente, HttpStatus.NOT_FOUND);
       	}else {
       		servicio.deletePaciente(paciente);
       		return new ResponseEntity<Paciente>(paciente, HttpStatus.OK);
       	}
    }
	

	/**
	 * (POST) Agrega Lectura presion del paciente
	 * @param correo
	 * @param pSintolica
	 * @param pDiastolica
	 * @return Paciente
	 */
	@RequestMapping(value="/pacientes/{correo}/{pSintolica}/{pDiastolica}", method=RequestMethod.POST) //@RequestBody Grupo grupo   @PathVariable int pSintolica, @PathVariable int pDiastolica
    public ResponseEntity<Paciente> agregaLectura(@PathVariable("correo") String correo, @PathVariable("pSintolica") int pSintolica, @PathVariable("pDiastolica") int pDiastolica) {
        //Obtenemos al paciente
		Paciente paciente = servicio.getPaciente(correo);
        LecturaPresion lectura = new LecturaPresion(pSintolica, pDiastolica);
		//Creamos el objeto presion
		//Agregamos la lectura a la pase de datos
		servicioLecturaPresion.addLectura(lectura);
		if(paciente==null || lectura==null) {
       		return new ResponseEntity<Paciente>(paciente, HttpStatus.NOT_FOUND);
       	}else {
			//LecturaPresion lecturaPresion = new LecturaPresion(pSintolica, pDiastolica);
			//Agregamos la lectura
			paciente.agregaLectura(lectura);
			//Actualiza los promedios de la presion
			paciente.setPromedios();
			//Actualizamos el repositorio
			boolean retorno = servicio.updatePaciente(paciente);
			
	       	if(retorno) {
	       		return new ResponseEntity<Paciente>(paciente, HttpStatus.OK);
	       	}else {
	       		return new ResponseEntity<Paciente>(paciente, HttpStatus.BAD_REQUEST);
	       	}
       	}
    }
	
	@RequestMapping(value="/lecturas", method=RequestMethod.GET)
    public Collection<LecturaPresion> dameLecturas() {
       	return servicioLecturaPresion.getPresion();
    }

	/**
	 * Metodo para obtener la lista de objetos Lectura Presion del paciente por correo
	 * @author Cristian
	 * @param correo
	 * @return
	 */
	@RequestMapping(value="/pacientes/{correo}/lecturas", method=RequestMethod.GET)
    public Collection <LecturaPresion> getLecturas(@PathVariable String correo) {
        Paciente paciente = servicio.getPaciente(correo);
		return paciente.getLecturas();
    
    }
	/**
	 * Metodo para obtener en un string la lista de Lectura Presion del paciente por correo
	 * @author Cristian
	 * @param correo
	 * @return
	 */
	@RequestMapping(value="/pacientes/{correo}/lecturasString", method=RequestMethod.GET)
    public ResponseEntity<String> getLecturasString(@PathVariable String correo) {
        Paciente paciente = servicio.getPaciente(correo);
        System.out.println(paciente.getLecturasString());
		String aux = paciente.getLecturasString();
		
		return new ResponseEntity<String>(aux, HttpStatus.OK);
    
    }
}
