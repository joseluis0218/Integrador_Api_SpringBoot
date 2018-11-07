package pe.edu.tecsup.apirest.controllers;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.tecsup.apirest.models.Captura;
import pe.edu.tecsup.apirest.services.CapturaService;

@RestController
public class CapturaController {
	private static final Logger logger = LoggerFactory.getLogger(CapturaController.class);
	private static final String FILEPATH = "/opt/integrador-api/images";
	@Autowired
	private CapturaService capturaService;
	
	@GetMapping("/capturas")
	public List<Captura> capturas() {
		logger.info("call capturas");
			
		List<Captura> capturas = capturaService.listar();
		
		return capturas;
	}
	@GetMapping("/capturas/images/{filename:.+}")
	public ResponseEntity<Resource> files(@PathVariable String filename) throws Exception{
		logger.info("call images: " + filename);
		
		Resource resource = new UrlResource(Paths.get(FILEPATH).resolve(filename).toUri());
		logger.info("Resource: " + resource);
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\""+resource.getFilename()+"\"")
				.header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(Paths.get(FILEPATH).resolve(filename)))
				.header(HttpHeaders.CONTENT_LENGTH, String.valueOf(resource.contentLength()))
				.body(resource);
	}

}
