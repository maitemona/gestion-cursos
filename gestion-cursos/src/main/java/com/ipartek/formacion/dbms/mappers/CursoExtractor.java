package com.ipartek.formacion.dbms.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;


import com.ipartek.formacion.dbms.persistence.Curso;



public class CursoExtractor implements ResultSetExtractor<Map<Long, Curso>> {
	

	private static final Logger LOGGER = LoggerFactory.getLogger(CursoExtractor.class); 

	@Override
	public Map<Long, Curso> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Long, Curso> cursos = new HashMap<Long, Curso>();
		while (rs.next()) {
			// recogemos el codigo de curso
			Long idcodigo = rs.getLong("id");
			Curso curso = cursos.get(idcodigo);
			if (curso == null) {
				curso = new Curso();
				curso.setCodigo(rs.getString("codigo"));
				
				curso.setNombre(rs.getString("nombre"));
			
				curso.setId(rs.getInt("id"));
				cursos.put(idcodigo, curso);
			}
		// TODO Auto-generated method stub
		
		}
		LOGGER.info("Size" + cursos.size());
		return cursos;
	}

}