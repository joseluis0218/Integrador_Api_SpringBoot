package pe.edu.tecsup.apirest.models.dao;

import java.util.List;

import pe.edu.tecsup.apirest.models.Usuario;

public interface IUsuarioDao {
	
	public List<Usuario> findAll();
}
