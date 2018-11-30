package pe.edu.tecsup.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.tecsup.apirest.models.Cantidad_rostros;
import pe.edu.tecsup.apirest.models.Estado_rostros;
import pe.edu.tecsup.apirest.models.dao.ConsultaDao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/api")
public class ConsultaController {

	private static final Logger logger = LoggerFactory.getLogger(ConsultaController.class);
	
	
	@Autowired
	private ConsultaDao consultaDao;
	
	@GetMapping("/estados_rostros")
	public List<Estado_rostros> datos() {
		logger.info("call datos");
		
		List<Estado_rostros> datos = consultaDao.consultar();
		
		return datos;
	}
	@GetMapping("/cantidad_rostros")
	public List<Cantidad_rostros> datos2() {
		logger.info("call datos2");
		
		List<Cantidad_rostros> datos = consultaDao.consultar2();
		
		return datos;
	}
}
