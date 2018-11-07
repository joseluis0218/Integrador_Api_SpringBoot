package pe.edu.tecsup.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.tecsup.apirest.models.Captura;
import pe.edu.tecsup.apirest.repositories.CapturaRepository;
@Service
public class CapturaService {
	@Autowired
	private CapturaRepository capturaRepository;
	
	public List<Captura>listar(){
		return capturaRepository.listar();
	}
}
