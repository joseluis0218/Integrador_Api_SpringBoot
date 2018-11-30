package pe.edu.tecsup.apirest.models.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.tecsup.apirest.models.Cantidad_rostros;
import pe.edu.tecsup.apirest.models.Estado_rostros;
import pe.edu.tecsup.apirest.repositories.ConsultaRepository;

@Service
public class ConsultaDao {

	@Autowired
	private ConsultaRepository consultaRepository;
	
	public List<Estado_rostros> consultar(){
		return consultaRepository.consultar();
	}
	
	public List<Cantidad_rostros> consultar2(){
		return consultaRepository.consultar2();
	}
	
}