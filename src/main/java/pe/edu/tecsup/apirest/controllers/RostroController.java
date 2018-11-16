package pe.edu.tecsup.apirest.controllers;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.tecsup.apirest.models.Rostro;
import pe.edu.tecsup.apirest.models.dao.RostroDao;
@RestController
@RequestMapping("/api")
public class RostroController {
	
	@Autowired
	RostroDao rostroDao;
	
	@PostMapping("/rostros")
	public Rostro createRostro(@Valid @RequestBody Rostro user) {
		return rostroDao.save(user);
	}
	@GetMapping("/rostros")
	public List<Rostro> getAllUsers(){
		return rostroDao.findAll();
	}
	
	@GetMapping("/rostros/{id}")
	public ResponseEntity<Rostro> getRostroById(@PathVariable(value="id") Long rostroid){
			
		Rostro rostro = rostroDao.findOne(rostroid);
		if(rostro==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(rostro);
	}
	
	@PutMapping("/rostros/{id}")
	public ResponseEntity<Rostro> updateRostro(@PathVariable(value="id") Long rostroid,@Valid @RequestBody Rostro rostroDetails){
		Rostro rostro = rostroDao.findOne(rostroid);
		if(rostro==null) {
			return ResponseEntity.notFound().build();
		}
		rostro.setId_rostro(rostroDetails.getId_rostro());
		rostro.setGenero_rostro(rostroDetails.getGenero_rostro());
		rostro.setEstado(rostroDetails.getEstado());
		Rostro updateRostro = rostroDao.save(rostro);
		return ResponseEntity.ok().body(updateRostro);
	}
	
	@DeleteMapping("/rostros/{id}")
	public ResponseEntity<Rostro> deleteRostro(@PathVariable(value="id") Long rostroid){
		Rostro rostro = rostroDao.findOne(rostroid);
		if(rostro==null) {
		return ResponseEntity.notFound().build();
		}
		rostroDao.delete(rostro);
		return ResponseEntity.ok().build();
}
}