package pe.edu.tecsup.apirest.models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="rest_capturas")
public class Captura implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_captura;
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha_captura;
	@NotNull
	private String nombre_captura;
	@NotNull
	private Integer cantidad_rostros;
/*	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="id_captura")
	private List<Rostro> rostros;*/
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "id_usuario")
	@JsonIgnore
	private Usuario usuario;
	
	public Long getId_captura() {
		return id_captura;
	}
	public  void setId_captura(Long id_captura) {
		this.id_captura = id_captura;
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
/*	public List<Rostro> getRostros() {
		return rostros;
	}
	public void setRostros(List<Rostro> rostros) {
		this.rostros = rostros;
	}
	public void addRostros(Rostro rostro) {
		this.rostros.add(rostro);
	}*/
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Captura [id_captura=" + id_captura + ", fecha_captura=" + fecha_captura + ", nombre_captura="
				+ nombre_captura + ", cantidad_rostros=" + cantidad_rostros + ", usuario=" + usuario + "]";
	}
	
	
	
}
