package mx.uam.tsis.sbtutorial.negocio.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



/**
 * Entidad del modelo de dominio
 * 
 */
@Entity
public class Alumno {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long ID;

	private String nombre;
	
	private int matricula;
	
	@Column(name="GrupoID")
	private String grupoID;
	
	public Alumno() {}
	
	public Alumno(String nombre, int matricula) {
		this.nombre = nombre;
		this.matricula = matricula;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	/**
     * Cambia el nombre
     * 
     * @param nombre
     */
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setGrupo(String clave) {
    	this.grupoID = clave;
    }
    
	
	public int getMatricula() {
		return matricula;
	}
	
	/**
     * Asigna la matricula
     * 
     * @param matricula
     */
    public void setMatricula(Integer matricula){
        this.matricula=matricula;
    }


}
