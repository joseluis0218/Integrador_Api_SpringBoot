package pe.edu.tecsup.apirest.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="rest_rostros")
public class Rostro implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message="Este campo no puede ser nulo")
	private String genero_rostro;
	@NotNull(message="Este campo no puede ser nulo")
	private String estado;	
	@NotNull(message="Este campo no puede ser nulo")
	private Long id_captura;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGenero_rostro() {
		return genero_rostro;
	}
	public void setGenero_rostro(String genero_rostro) {
		this.genero_rostro = genero_rostro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getId_captura() {
		return id_captura;
	}
	public void setId_captura(Long id_captura) {
		this.id_captura = id_captura;
	}
	@Override
	public String toString() {
		return "Rostro [id=" + id + ", genero_rostro=" + genero_rostro + ", estado=" + estado + ", id_captura="
				+ id_captura + "]";
	}
}
