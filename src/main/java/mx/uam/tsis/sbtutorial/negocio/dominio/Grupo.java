package mx.uam.tsis.sbtutorial.negocio.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Grupo {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long ID;
	
	@OneToMany
	@JoinColumn(name="GrupoID", referencedColumnName="ID")
	private List<Alumno> Alumnos;
	
	private String clave;
	private String materia;
	
	public Grupo() {}
	
	public Grupo(String clave, String materia) {
		this.clave = clave;
		this.materia = materia;
		Alumnos = new ArrayList<Alumno>();
	}
	
	public String getClave() {
		return this.clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String getMateria() {
		return this.materia;
	}
	
	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	public void agregaAlumno(Alumno alumno) {
		if(Alumnos.contains(alumno)) {
			return;
		}else {
			Alumnos.add(alumno);
		}
	}
	
	public void borraAlumno(Alumno alumno) {
		if(Alumnos.contains(alumno)) {
			Alumnos.remove(alumno);
		}
	}
	
	public List<Alumno> getAlumnos(){
		return this.Alumnos;
	}
	
	
}
