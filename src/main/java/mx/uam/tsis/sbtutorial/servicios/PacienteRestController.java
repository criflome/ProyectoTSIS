package mx.uam.tsis.sbtutorial.servicios;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.uam.tsis.sbtutorial.negocio.PacienteService;
import mx.uam.tsis.sbtutorial.negocio.dominio.Alumno;
import mx.uam.tsis.sbtutorial.negocio.dominio.Paciente;

@RestController
public class PacienteRestController {
	
	@Autowired
	PacienteService servicio;
	
	@RequestMapping(value="/pacientes", method=RequestMethod.GET)
    public Collection <Paciente> damePacientes() {
        return servicio.getPacientes();
    }
	
	@RequestMapping(value="/pacientes", method = RequestMethod.POST)
    public ResponseEntity<Paciente> agregaPaciente(@RequestBody Paciente paciente) {
            boolean retorno = servicio.addPaciente(paciente);
            if(retorno) {
                return new ResponseEntity<Paciente>(paciente, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Paciente>(paciente, HttpStatus.BAD_REQUEST);
            }
    }

}
