package pe.edu.tecsup.apirest.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="rest_estados")
public class Estado implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_estado;
	@NotNull
	private String estado_rostro;
	
	public Long getId_estado() {
		return id_estado;
	}
	public void setId_estado(Long id_estado) {
		this.id_estado = id_estado;
	}

	public String getEstado_rostro() {
		return estado_rostro;
	}
	public void setEstado_rostro(String estado_rostro) {
		this.estado_rostro = estado_rostro;
	}
	@Override
	public String toString() {
		return "Estado [id_estado=" + id_estado + ", estado_rostro=" + estado_rostro + "]";
	}
	
}
