package pe.edu.tecsup.apirest.repositories;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pe.edu.tecsup.apirest.models.Usuario;

@Repository
public class UsuarioRepository {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioRepository.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Usuario> listar(){
		logger.info("call listar()");
		
		String sql = "select * from rest_usuario";
		
		List<Usuario> usuarios = jdbcTemplate.query(sql, new RowMapper<Usuario>() {
			public Usuario  mapRow(ResultSet rs, int rowNum) throws SQLException {
				Usuario usuario = new Usuario();
				usuario.setId_usuario(rs.getInt(1));
				usuario.setNombres(rs.getString(2));
				usuario.setApellidos(rs.getString(3));
				usuario.setUsuario(rs.getString(4));
				usuario.setContraseña(rs.getString(5));
				usuario.setEmail(rs.getString(6));
				return usuario;

			}				
		});

		logger.info("usuarios: " + usuarios);
		
		return usuarios;
	}

}
