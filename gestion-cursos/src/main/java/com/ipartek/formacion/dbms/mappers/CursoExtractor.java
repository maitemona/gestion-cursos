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



public class CursoExtractor implements ResultSetExtractor<Map<String, Curso>> {
	

	private static final Logger LOGGER = LoggerFactory.getLogger(CursoExtractor.class); 

	@Override
	public Map<String, Curso> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, Curso> cursos = new HashMap<String, Curso>();
		while (rs.next()) {
				Curso curso = new Curso();
				curso.setCodigo(rs.getString("codigo"));
				
				curso.setNombre(rs.getString("nombre"));
			
				curso.setId(rs.getInt("id"));
				cursos.put(curso.getCodigo(), curso);
		// TODO Auto-generated method stub
		
		}
		return cursos;
	}

}