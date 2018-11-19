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

import pe.edu.tecsup.apirest.models.Estado;
import pe.edu.tecsup.apirest.models.dao.EstadoDao;

@RestController
@RequestMapping("/api")
public class EstadoController {
	@Autowired
	EstadoDao estadoDao;
	
	@PostMapping(value="/estados", headers="content-type=application/x-www-form-urlencoded")
	public Estado createEstado(@Valid @RequestBody Estado estado) {
		return estadoDao.save(estado);
	}
	@GetMapping("/estados")
	public List<Estado> getAllEstados(){
		return estadoDao.findAll();
	}
	
	@GetMapping("/estados/{id}")
	public ResponseEntity<Estado> getEstadoById(@PathVariable(value="id") Long estadoid){
			
		Estado estado = estadoDao.findOne(estadoid);
		if(estado==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(estado);
	}
	
	@PutMapping("/estados/{id}")
	public ResponseEntity<Estado> updateEstado(@PathVariable(value="id") Long estadoid,@Valid @RequestBody Estado estadoDetails){
		Estado estado = estadoDao.findOne(estadoid);
		if(estado==null) {
			return ResponseEntity.notFound().build();
		}
		estado.setEstado_rostro(estadoDetails.getEstado_rostro());
		Estado updateEstado = estadoDao.save(estado);
		return ResponseEntity.ok().body(updateEstado);
	}
	
	@DeleteMapping("/estados/{id}")
	public ResponseEntity<Estado> deleteEstado(@PathVariable(value="id") Long estadoid){
		Estado estado = estadoDao.findOne(estadoid);
		if(estado==null) {
		return ResponseEntity.notFound().build();
		}
		estadoDao.delete(estado);
		return ResponseEntity.ok().build();
}
}