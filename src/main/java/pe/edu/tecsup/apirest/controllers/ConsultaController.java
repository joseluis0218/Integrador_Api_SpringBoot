package pe.edu.tecsup.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import pe.edu.tecsup.apirest.models.Cantidad_rostros;
import pe.edu.tecsup.apirest.models.Estado_rostros;
import pe.edu.tecsup.apirest.models.dao.ConsultaDao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/api")
public class ConsultaController {

	private static final Logger logger = LoggerFactory.getLogger(ConsultaController.class);

	@Autowired
	private ConsultaDao consultaDao;
	@GetMapping("/estados_rostros/{id_captura}")
	public ResponseEntity<?> dato(@PathVariable Long id_captura) throws Exception {
		logger.info("call datos");
		
		List<Estado_rostros> dato = consultaDao.consultar(id_captura);
		
		return ResponseEntity.ok().body(dato);
	}
	@GetMapping("/cantidad_rostros/{id_captura}")
	public ResponseEntity<?>  datos2(@PathVariable Long id_captura) throws Exception {
		logger.info("call datos2");
		
		List<Cantidad_rostros> dato = consultaDao.consultar2(id_captura);
		
		return ResponseEntity.ok().body(dato);
	}

	


}
