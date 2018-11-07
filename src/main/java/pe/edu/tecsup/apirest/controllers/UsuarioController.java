package pe.edu.tecsup.apirest.controllers;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.tecsup.apirest.models.Usuario;
import pe.edu.tecsup.apirest.services.UsuarioService;

@RestController
public class UsuarioController {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	
	private UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public List<Usuario>usuarios(){
		logger.info("call usuarios()");
		List<Usuario> usuarios = usuarioService.listar();
		return usuarios;
	}
}
