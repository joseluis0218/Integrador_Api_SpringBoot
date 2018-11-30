package pe.edu.tecsup.apirest.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="rest_estados")
public class Estado implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String estado_rostro;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="id_estado")	
	private List<Rostro> rostros;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getEstado_rostro() {
		return estado_rostro;
	}
	public void setEstado_rostro(String estado_rostro) {
		this.estado_rostro = estado_rostro;
	}	
	
	
	public List<Rostro> getRostros() {
		return rostros;
	}
	public void setRostros(List<Rostro> rostros) {
		this.rostros = rostros;
	}
	@Override
	public String toString() {
		return "Estado [id=" + id + ", estado_rostro=" + estado_rostro + ", rostros=" + rostros + "]";
	}

	
	
}
