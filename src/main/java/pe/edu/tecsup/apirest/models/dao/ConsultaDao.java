package pe.edu.tecsup.apirest.models.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.tecsup.apirest.models.Datos;
import pe.edu.tecsup.apirest.repositories.ConsultaRepository;

@Service
public class ConsultaDao {

	@Autowired
	private ConsultaRepository consultaRepository;
	
	public List<Datos> consultar(Long id_captura) throws Exception{
		return consultaRepository.consultar(id_captura);
	}
}