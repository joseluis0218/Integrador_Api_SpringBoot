package pe.edu.tecsup.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.tecsup.apirest.models.Rostro;
import pe.edu.tecsup.apirest.repositories.RostroRepository;
import java.util.List;
@Service
public class RostroService {

	@Autowired
	private RostroRepository rostroRepository;
	
	public List<Rostro>listar(){
		return rostroRepository.listar();
	}
}
