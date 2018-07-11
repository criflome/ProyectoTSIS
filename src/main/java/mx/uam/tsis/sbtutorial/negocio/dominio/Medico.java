package mx.uam.tsis.sbtutorial.negocio.dominio;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medico {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ID;
	
	private String nombre;
	private String apellidos;
	private String correo;
	private String contrasena;
	private Long telefono_mobil;
	
	//private List<Paciente> pacientes;
	
	/**
	 * Contructor para el registro de Medicos
	 * @param nombre
	 * @param apellidos
	 * @param correo
	 * @param contrasena
	 * @param telefono_mobil
	 */
	public Medico(String nombre, String apellidos, String correo, String contrasena, Long telefono_mobil) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contrasena = contrasena;
		this.telefono_mobil = telefono_mobil;
	}
	
	public Medico() {
	
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
	public void setTelefono_mobil(Long  Telefono_mobil) {
		this.telefono_mobil = Telefono_mobil;
	}
	public void setContrasena(String Contrasena) {
		this.contrasena = Contrasena;
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
	public Long getTelefono_mobil() {
		return this.telefono_mobil;
	}
	public String getContrasena() {
		return this.contrasena;
	}
}
