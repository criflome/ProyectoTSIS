package mx.uam.tsis.sbtutorial.presentacion;

/**
 * Esta clase el el controlador para Spring MVC
 */
import mx.uam.tsis.sbtutorial.negocio.AlumnoService;
import mx.uam.tsis.sbtutorial.negocio.dominio.Alumno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controlador MVC de la pagina
 * 
 * 
 */
@Controller (value="alumnoController")
public class AlumnoController {
	
	@Autowired
	private AlumnoService servicioAlumnos;

	/**
	 * Este metodo esta mapeado con la pagina buscaAlumno. El parametro
	 * se envia como /buscaAlumno?matricula=xxx
	 * 
	 */
    @RequestMapping("/buscaAlumno")
    public String buscaAlumno(@RequestParam(value="matricula", required=false, defaultValue="123") String matricula, Model model) {
        
    	//Obtiene al alumno del servicio
    	Alumno al = servicioAlumnos.getAlumno(Integer.parseInt(matricula));
        
    	if(al!=null) {
    		// agrega el alumno al modelo de la UI 
    		model.addAttribute("alumno", al);
    		return "vistaAlumno";
    	} else {
    		return "vistaAlumnoError";
    	}
    	
    }
    
    /**
     * Este metodo esta mapeado con la pagina buscaAlumno. El parametro
     * se envia como /agregaAlumno?matricula=xxx&nombre=xxx
     * 
     */
    @RequestMapping("/agregaAlumno")
    public String agregaAlumno(@RequestParam(value="matricula", required=true) int matricula, @RequestParam(value="nombre", required=true) String nombre, Model model) {
    	//Crear al alumno y solicitar al servicio de alumnos que se agregue el alumno con el metodo addAlumno (ver Paso 2.2)
        Alumno a = new Alumno(nombre,matricula);
        if(servicioAlumnos.addAlumno(a)) {
        	model.addAttribute("alumno", a);
        	return "vistaAgregaAlumno";
        }else{
        	return "vistaErrorAgregaAlumno";
        }  	
    }  

    
}