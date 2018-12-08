package pe.edu.tecsup.apirest.models;

import java.io.Serializable;
import java.util.Date;

public class Dato2 implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date fecha_captura;
	
	private Integer cantidad_rostros;

	public Date getFecha_captura() {
		return fecha_captura;
	}

	public void setFecha_captura(Date fecha_captura) {
		this.fecha_captura = fecha_captura;
	}

	public Integer getCantidad_rostros() {
		return cantidad_rostros;
	}

	public void setCantidad_rostros(Integer cantidad_rostros) {
		this.cantidad_rostros = cantidad_rostros;
	}
	@Override
	public String toString() {
		return "Dato2 [fecha_captura=" + fecha_captura + ", cantidad_rostros=" + cantidad_rostros + "]";
	}
	
}
