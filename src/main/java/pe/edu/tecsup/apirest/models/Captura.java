package pe.edu.tecsup.apirest.models;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="rest_capturas")
public class Captura implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha_captura;
	@NotNull
	private String nombre_captura;
	@NotNull
	private Integer cantidad_rostros;
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="id_captura")
	private List<Rostro> rostros;
	
	public Long getId() {
		return id;
	}
	public  void setId(Long id) {
		this.id = id;
	}
	public Date getFecha_captura() {
		return fecha_captura;
	}
	public void setFecha_captura(Date fecha_captura) {
		this.fecha_captura = fecha_captura;
	}
	public String getNombre_captura() {
		return nombre_captura;
	}
	public void setNombre_captura(String nombre_captura) {
		this.nombre_captura = nombre_captura;
	}
	public Integer getCantidad_rostros() {
		return cantidad_rostros;
	}
	public void setCantidad_rostros(Integer cantidad_rostros) {
		this.cantidad_rostros = cantidad_rostros;
	}
	public List<Rostro> getRostros() {
		return rostros;
	}
	public void setRostros(List<Rostro> rostros) {
		this.rostros = rostros;
	}
	@Override
	public String toString() {
		return "Captura [id=" + id + ", fecha_captura=" + fecha_captura + ", nombre_captura=" + nombre_captura
				+ ", cantidad_rostros=" + cantidad_rostros + ", rostros=" + rostros + "]";
	}

	
}
