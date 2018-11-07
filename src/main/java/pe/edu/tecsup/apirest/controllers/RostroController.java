package pe.edu.tecsup.apirest.controllers;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.tecsup.apirest.models.Rostro;
import pe.edu.tecsup.apirest.services.RostroService;
@RestController
public class RostroController {

	private static final Logger logger = LoggerFactory.getLogger(RostroController.class);

	@Autowired
	private RostroService rostroService;
	
	@GetMapping("/rostros")
	public List<Rostro> rostros() {
		logger.info("call rostros");
		
		List<Rostro> rostros = rostroService.listar();
		
		return rostros;
	}

	
}
