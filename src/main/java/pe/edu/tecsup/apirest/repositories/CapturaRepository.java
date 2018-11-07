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

import pe.edu.tecsup.apirest.models.Captura;

@Repository
public class CapturaRepository {
	private static final Logger logger = LoggerFactory.getLogger(CapturaRepository.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Captura>listar(){
		logger.info("call listar()");
		String sql = "select * from rest_captura";
		List<Captura> capturas = jdbcTemplate.query(sql, new RowMapper<Captura>() {
			public Captura mapRow(ResultSet rs, int rowNum)throws SQLException{
				Captura captura = new Captura();
				captura.setId_captura(rs.getInt("id_captura"));
				captura.setFecha_captura(rs.getDate("fecha_captura"));
				captura.setNombre_captura(rs.getString("nombre_captura"));
				captura.setId_usuario(rs.getInt("id_usuario"));
				return captura;
			}
		});
		
		logger.info("capturas:"+capturas);
		return capturas;
	}
}
