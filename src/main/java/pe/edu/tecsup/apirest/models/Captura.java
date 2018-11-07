package pe.edu.tecsup.apirest.models;

import java.sql.Date;

public class Captura {
	private Integer id_captura;
	private Date fecha_captura;
	private String nombre_captura;
	private Integer id_usuario;
	
	public Integer getId_captura() {
		return id_captura;
	}
	public void setId_captura(Integer id_captura) {
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
	
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	@Override
	public String toString() {
		return "Captura[id_captura="+id_captura+",fecha_captura="+fecha_captura+",nombre_captura="+nombre_captura+",id_usuario="+id_usuario+"]";
	}
	
}
