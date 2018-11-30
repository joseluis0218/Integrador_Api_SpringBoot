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

import pe.edu.tecsup.apirest.models.Cantidad_rostros;
import pe.edu.tecsup.apirest.models.Estado_rostros;

@Repository
public class ConsultaRepository {

	private static final Logger logger = LoggerFactory.getLogger(ConsultaRepository.class);
			
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Estado_rostros> consultar(){
		logger.info("call consultar()");
		
		String sql = "SELECT rest_estados.estado_rostro FROM rest_rostros INNER JOIN rest_estados ON rest_rostros.id_estado=rest_estados.id GROUP BY estado_rostro";
		
		 List<Estado_rostros> datos = jdbcTemplate.query(sql, new RowMapper<Estado_rostros>() {
			public Estado_rostros mapRow(ResultSet rs, int rowNum) throws SQLException{
				Estado_rostros dato = new Estado_rostros();
				dato.setEstado_rostro(rs.getString("estado_rostro"));
				return dato;
			}
		});
		logger.info("datos: "+datos);
		return datos;
	}

	
	public List<Cantidad_rostros> consultar2(){
		logger.info("call consultar2()");
		
		String sql = "SELECT COUNT(rest_rostros.id) AS Cant_Rostros FROM rest_rostros INNER JOIN rest_estados ON rest_rostros.id_estado=rest_estados.id GROUP BY estado_rostro";
		
		 List<Cantidad_rostros> datos = jdbcTemplate.query(sql, new RowMapper<Cantidad_rostros>() {
			public Cantidad_rostros mapRow(ResultSet rs, int rowNum) throws SQLException{
				Cantidad_rostros dato = new Cantidad_rostros();
				dato.setCant_Rostros(rs.getLong("Cant_Rostros"));
				return dato;
			}
		});
		logger.info("datos: "+datos);
		return datos;
	}
}
