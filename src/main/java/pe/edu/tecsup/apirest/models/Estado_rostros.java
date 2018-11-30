package pe.edu.tecsup.apirest.models;

import java.io.Serializable;

public class Estado_rostros implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String estado_rostro;

	

	public String getEstado_rostro() {
		return estado_rostro;
	}
	public void setEstado_rostro(String estado_rostro) {
		this.estado_rostro = estado_rostro;
	}
	@Override
	public String toString() {
		return "Estado_rostros [estado_rostro=" + estado_rostro + "]";
	}
}
