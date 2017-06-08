package com.ipartek.formacion.dbms.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dbms.persistence.Curso;

public class CursoMapper implements RowMapper<Curso> {

	@Override
	public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
		Curso curso = new Curso();
		curso.setCodigo(rs.getString("codigo"));
		curso.setNombre(rs.getString("nombre"));
		curso.setId(rs.getLong("id"));
		return curso;
	}
	
		

}
