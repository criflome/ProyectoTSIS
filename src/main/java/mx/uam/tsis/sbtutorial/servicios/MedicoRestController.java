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

import mx.uam.tsis.sbtutorial.negocio.MedicoService;
import mx.uam.tsis.sbtutorial.negocio.dominio.Medico;

@RestController
public class MedicoRestController {
	
	@Autowired
	MedicoService servicio;
	
	/**
	 * Metodo que regresa todos los Medicos
	 * @return
	 */
	@RequestMapping(value="/medicos", method=RequestMethod.GET)
    public Collection <Medico> dameMedicos() {
        return servicio.getMedicos();
    }
	
	/**
	 * Metodo para el registro de Medicos
	 * @param medico
	 * @return
	 */
	@RequestMapping(value="/medicos", method = RequestMethod.POST)
    public ResponseEntity<Medico> agregaMedico(@RequestBody Medico medico) {
            boolean retorno = servicio.addMedico(medico);
            if(retorno) {
                return new ResponseEntity<Medico>(medico, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Medico>(medico, HttpStatus.BAD_REQUEST);
            }
    }
	
	/**
	 * Busque da de medico por correo
	 * @param correo
	 * @return
	 */
	@RequestMapping(value="/medicos/{correo}", method=RequestMethod.GET)
    public ResponseEntity<Medico> buscaMedico(@PathVariable String correo) {
        Medico medico = servicio.getMedico(correo);
       	if(medico==null) {
       		return new ResponseEntity<Medico>(medico, HttpStatus.NOT_FOUND);
       	}else {
       		return new ResponseEntity<Medico>(medico, HttpStatus.OK);
       	}
    }
	
	/**
	 * Metodo para borrar Medicos
	 * @param correo
	 * @return
	 */
	@RequestMapping(value="/medicos/{correo}", method=RequestMethod.DELETE)
    public ResponseEntity<Medico> borraMedico(@PathVariable String correo) {
        Medico medico = servicio.getMedico(correo);
       	if(medico==null) {
       		return new ResponseEntity<Medico>(medico, HttpStatus.NOT_FOUND);
       	}else {
       		servicio.deleteMedico(medico);
       		return new ResponseEntity<Medico>(medico, HttpStatus.OK);
       	}
    }
	
}
