package pe.edu.tecsup.apirest.repositories;


import java.sql.Date;
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
import pe.edu.tecsup.apirest.models.Datos;

@Repository
public class ConsultaRepository {

	private static final Logger logger = LoggerFactory.getLogger(ConsultaRepository.class);
			
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Datos> consultar(Long id_captura){
		logger.info("call consultar()");
		
		String sql = "SELECT rest_estados.estado_rostro,COUNT(rest_rostros.id) AS cantidad_rostros FROM rest_rostros INNER JOIN rest_estados ON rest_rostros.id_estado=rest_estados.id WHERE rest_rostros.id_captura=? GROUP BY estado_rostro\n" + 
				"\n" + 
				"";
		
		 List<Datos> datos = jdbcTemplate.query(sql, new RowMapper<Datos>() {
			public Datos mapRow(ResultSet rs, int rowNum) throws SQLException{
				Datos dato = new Datos();
				dato.setEstado_rostro(rs.getString("estado_rostro"));
				dato.setCantidad_rostros(rs.getInt("cantidad_rostros"));
				return dato;
			}
		},id_captura);
		logger.info("datos: "+datos);
		return datos;
	}
}
