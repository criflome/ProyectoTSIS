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

	private float promedioPSintolica;
	private float promedioPDiastolica;
	
	private String genero;
	private int edad;
	//private List<Medico> Medicos;
	
	@OneToMany
	@JoinColumn(name="PacienteID", referencedColumnName="ID")
	private List<LecturaPresion> Lecturas;
	
	public Paciente() {}
	
	
	
	/**
	 * COnstructor de la clase paciente
	 * @param nombre
	 * @param apellidos
	 * @param genero
	 * @param edad
	 * @param correo
	 * @param contrasena
	 * @param telefono_casa
	 * @param telefono_mobil
	 * @param direccion
	 */
	public Paciente(String nombre, String apellidos, String genero, int edad, String correo, String contrasena,
			Long telefono_casa, Long telefono_mobil, String direccion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.genero = genero;
		this.edad = edad;
		this.correo = correo;
		this.contrasena = contrasena;
		this.telefono_casa = telefono_casa;
		this.telefono_mobil = telefono_mobil;
		this.direccion = direccion;
		this.Lecturas = new ArrayList<LecturaPresion> ();
	}


	/**
	 * Actualiza el promedio de las presiones
	 */
	public void setPromedios() {
		float pSintolica=0;
		float pDiastolica=0;
		float n = (float)Lecturas.size();
		
		for (LecturaPresion presiones: Lecturas) {
		    pSintolica= pSintolica + presiones.getpSintolica();
		    pDiastolica = pDiastolica + presiones.getpDiastolica();
		}	
		this.promedioPSintolica = pSintolica / n;
		this.promedioPDiastolica = pDiastolica / n;
		
	}
	/**
	 * Obtiene el promedio de la lecutra de presion Sintolica
	 * @return
	 */
	public float getPromedioPSintolica() {
		return this.promedioPSintolica;
	}
	
	/**
	 * Obtiene el promedio de la lecutra de presion Diastolica
	 * @return
	 */
	public float getPromedioPDiastolica() {
		return this.promedioPDiastolica;
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



	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}



	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}



	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}



	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}