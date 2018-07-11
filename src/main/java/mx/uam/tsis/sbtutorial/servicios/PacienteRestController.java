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
	 * Busque da de paciente por correo
	 * @param correo
	 * @return
	 */
	@RequestMapping(value="/pacientes/{correo}", method=RequestMethod.GET)
    public ResponseEntity<Paciente> buscaPaciente(@PathVariable String correo) {
        Paciente paciente = servicio.getPaciente(correo);
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
	

	@RequestMapping(value="/pacientes/{correo}/presion", method=RequestMethod.POST) //@RequestBody Grupo grupo   @PathVariable int pSintolica, @PathVariable int pDiastolica
    public ResponseEntity<Paciente> agregaLectura(@PathVariable("correo")  String correo, @RequestBody LecturaPresion lectura ) {
        //Obtenemos al paciente
		Paciente paciente = servicio.getPaciente(correo);
        //Creamos el objeto presion
		//Agregamos la lectura a la pase de datos
		servicioLecturaPresion.addLectura(lectura);
		
		//LecturaPresion lecturaPresion = new LecturaPresion(pSintolica, pDiastolica);
		//Agregamos la lectura
		paciente.agregaLectura(lectura);
		//Actualizamos el repositorio
		boolean retorno = servicio.updatePaciente(paciente);
		
       	if(retorno) {
       		return new ResponseEntity<Paciente>(paciente, HttpStatus.OK);
       	}else {
       		return new ResponseEntity<Paciente>(paciente, HttpStatus.BAD_REQUEST);
       	}
    }

}
