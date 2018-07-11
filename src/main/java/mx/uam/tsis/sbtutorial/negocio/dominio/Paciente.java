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
public class Paciente {
	@Id
	@Column(name="ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long ID;
	
	private String nombre;
	private String apellidos;
	private String correo;
	private String contrasena;
	private Long telefono_casa;
	private Long telefono_mobil;
	private String direccion;
	//private List<Medico> Medicos;
	
	@OneToMany
	@JoinColumn(name="PacienteID", referencedColumnName="ID")
	private List<LecturaPresion> Lecturas;
	
	public Paciente() {}
	
	/**
	 * Constructor de Registro de Pacientes
	 * @param Nombre
	 * @param Apellidos
	 * @param Correo
	 * @param Telefono_casa
	 * @param Telefono_mobil
	 * @param Direccion
	 */
	public Paciente(String Nombre, String Apellidos, String Correo, String contrasena, Long Telefono_casa, Long Telefono_mobil, String Direccion) {
		this.nombre = Nombre;
		this.apellidos = Apellidos;
		this.correo = Correo;
		this.contrasena = contrasena;
		this.telefono_casa = Telefono_casa;
		this.telefono_mobil = Telefono_mobil;
		this.direccion = Direccion;
		Lecturas =  new ArrayList<LecturaPresion>();
	}
	
	public void setNombre(String Nombre) {
		this.nombre = Nombre;
	}
	public void setApellidos(String Apellidos) {
		this.apellidos = Apellidos;
	}
	public void setCorreo(String Correo) {
		this.correo = Correo;
	}
	public void setTelefono_casa(Long Telefono_casa) {
		this.telefono_casa = Telefono_casa;
	}
	public void setTelefono_mobil(Long  Telefono_mobil) {
		this.telefono_mobil = Telefono_mobil;
	}
	public void setDireccion(String Direccion) {
		this.direccion = Direccion;
	}
	public void setContrasena(String Contrasena) {
		this.contrasena = Contrasena;
	}
	/**
	 * Obtiene las lecturas de rpesion del paciente
	 * @return List<LecturaPresion>
	 */
	public List<LecturaPresion> getLecturas(){
		return this.Lecturas;
	}
	/**
	 * Agrega el dato de una lectura de presión
	 * @param Lectura
	 * @return true si se agrego la lectura de presion, false en otro caso
	 */
	public boolean agregaLectura(LecturaPresion Lectura) {
		return Lecturas.add(Lectura);
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getApellidos() {
		return this.apellidos;
	}
	public String getCorreo() {
		return this.correo;
	}
	public Long getTelefono_casa() {
		return this.telefono_casa;
	}
	public Long getTelefono_mobil() {
		return this.telefono_mobil;
	}
	public String getDireccion() {
		return this.direccion;
	}
	public String getContrasena() {
		return this.contrasena;
	}
}
