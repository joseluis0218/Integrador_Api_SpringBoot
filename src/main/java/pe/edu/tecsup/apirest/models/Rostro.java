package pe.edu.tecsup.apirest.models;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="rest_rostros")
public class Rostro implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_rostro;
	@NotNull
	private String genero_rostro;
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "id_captura")
	@JsonIgnore
	private Captura captura;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_estado")
	private Estado estado;

	public Long getId_rostro() {
		return id_rostro;
	}
	public void setId_rostro(Long id_rostro) {
		this.id_rostro = id_rostro;
	}
	public String getGenero_rostro() {
		return genero_rostro;
	}
	public void setGenero_rostro(String genero_rostro) {
		this.genero_rostro = genero_rostro;
	}

	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Captura getCaptura() {
		return captura;
	}
	public void setCaptura(Captura captura) {
		this.captura = captura;
	}
	@Override
	public String toString() {
		return "Rostro [id_rostro=" + id_rostro + ", genero_rostro=" + genero_rostro + ", captura=" + captura
				+ ", estado=" + estado + "]";
	}
	
	
	
	
	
}
