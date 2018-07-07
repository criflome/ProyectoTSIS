/**
 * 
 */
package mx.uam.tsis.sbtutorial.negocio.dominio;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Cristian 
 *
 */
@Entity
public class LecturaPresion {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long ID;
	
	private Date fecha;
	private int pSintolica;
	private int pDiastolica;
	
	/**
	 * Columna para poder hacer la relacion @OnetoMany con la clase Paciente
	 */
	@Column(name="PacienteID")
	private Long PacienteID;
	
	/**
	 * Constructor vacío
	 */
	public LecturaPresion() {
	}

	/**
	 * Constructor sin ID
	 * @param fecha
	 * @param pSintolica
	 * @param pDiastolica
	 */
	public LecturaPresion(Date fecha, int pSintolica, int pDiastolica) {
		this.fecha = fecha;
		this.pSintolica = pSintolica;
		this.pDiastolica = pDiastolica;
	}

	
	/**
	 * Constructor completo
	 * @param iD
	 * @param fecha
	 * @param pSintolica
	 * @param pDiastolica
	 */
	public LecturaPresion(Long iD, Date fecha, int pSintolica, int pDiastolica) {
		ID = iD;
		this.fecha = fecha;
		this.pSintolica = pSintolica;
		this.pDiastolica = pDiastolica;
	}

	
	/**
	 * toString para desplegar los datos deacuerdo a la logica del negocio
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		//return "LecturaPresion [fecha=" + fecha + ", pSintolica=" + pSintolica + ", pDiastolica=" + pDiastolica + "]";
		String fechaFormato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(fecha);
		return  pSintolica + " sobre " + pDiastolica + "\t" + fechaFormato;
	}
	
	
	
}
