package pe.edu.tecsup.apirest.models;

import java.io.Serializable;

public class Cantidad_rostros implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long Cant_Rostros;

	public Long getCant_Rostros() {
		return Cant_Rostros;
	}
	public void setCant_Rostros(Long cant_Rostros) {
		Cant_Rostros = cant_Rostros;
	}
	@Override
	public String toString() {
		return "Cantidad_rostros [ Cant_Rostros=" + Cant_Rostros + "]";
	}
	
}
