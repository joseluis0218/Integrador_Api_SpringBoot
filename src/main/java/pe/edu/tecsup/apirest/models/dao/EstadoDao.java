package pe.edu.tecsup.apirest.models.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.tecsup.apirest.models.Estado;
import pe.edu.tecsup.apirest.repositories.EstadoRepository;
@Service
public class EstadoDao {
	@Autowired
	EstadoRepository estadoRepository;
	
	public Estado save(Estado estado) {
		return estadoRepository.save(estado);
	}
	public List<Estado> findAll(){
		return estadoRepository.findAll();
	}
	
	public Estado findOne(Long estadoid) {
		return estadoRepository.findById(estadoid);
	}
	
	public void delete(Estado estado) {
		estadoRepository.delete(estado);
	}
}
