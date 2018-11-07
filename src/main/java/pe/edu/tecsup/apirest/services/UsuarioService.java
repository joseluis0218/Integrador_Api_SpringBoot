package pe.edu.tecsup.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.tecsup.apirest.models.Usuario;
import pe.edu.tecsup.apirest.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario>listar(){
		return usuarioRepository.listar();
	}
}
