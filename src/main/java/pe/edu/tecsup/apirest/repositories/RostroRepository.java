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
import pe.edu.tecsup.apirest.models.Rostro;

@Repository
public class RostroRepository {
	private static final Logger logger = LoggerFactory.getLogger(RostroRepository.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Rostro>listar(){
		logger.info("call listar()");
		String sql = "select * from rest_rostro";
		List<Rostro> rostros = jdbcTemplate.query(sql, new RowMapper<Rostro>() {
			public Rostro mapRow(ResultSet rs, int rowNum)throws SQLException{
				Rostro rostro = new Rostro();
				rostro.setId_rostro(rs.getInt("id_rostro"));
				rostro.setGenero_rostro(rs.getString("genero_rostro"));
				rostro.setEstado_rostro(rs.getString("estado_rostro"));
				rostro.setId_captura_id(rs.getInt("id_captura"));
				return rostro;
			}
		});
		
		logger.info("rostros:"+rostros);
		return rostros;
	}

}
