package com.ipartek.formacion.dbms.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dbms.dao.intefaces.CursoDAO;

import com.ipartek.formacion.dbms.mappers.CursoMapper;
import com.ipartek.formacion.dbms.persistence.Curso;

@Repository("cursoDaoImp")
public class CursoDAOImp  implements CursoDAO{

	@Autowired
	@Qualifier("mysqlDataSource")
	private DataSource dataSource;
	//private JdbcTemplate template;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;
	private final static Logger LOGGER = LoggerFactory.getLogger(CursoDAOImp.class);

	@Autowired
	@Qualifier("mysqlDataSource") // es lo mismo que @Inject
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource);
	}
	

	@Override
	public Curso create(Curso curso) {
		final String SQL = "cursoCreate";
		// se llama al construcctor dado que cachea el SqlParameterSource
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		jdbcCall.withProcedureName(SQL);
		// crear un mapa con los parametros de procedimiento almacenado de
		// entrada (IN).
		SqlParameterSource in = new MapSqlParameterSource().addValue("pnombre", curso.getNombre())
				.addValue("pcodigo", curso.getCodigo());

		LOGGER.info(curso.toString());
		// se ejecuta la consulta
		Map<String, Object> out = jdbcCall.execute(in);
		// en out se han recogido los parametros out de la consulta a BBDD.
		curso.setId((Integer) out.get("pid"));

		return curso;
	}

	@Override
	public Curso getById(long id) {
		Curso curso = null;
		final String SQL = "CALL cursogetbyID(?);";
		LOGGER.info("select sql"+ SQL);
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		try {
			curso = jdbctemplate.queryForObject(SQL, new CursoMapper(), new Object[] { id });
			LOGGER.info(curso.toString());
		} catch (EmptyResultDataAccessException e) {
			curso = null;
			LOGGER.info("No se ha encontrado Alumno para codigo: " + id + " " + e.getMessage());
		}
		
		return curso;
	}

	@Override
	public List<Curso> getAll() {
		//LOGGER.info("getAll() dddddd");
		final String SQL = "CALL cursogetAll();";
		List<Curso> cursos = null;
		try {
			cursos = jdbctemplate.query(SQL, new CursoMapper());
			LOGGER.info(String.valueOf(cursos.size()));
		} catch (EmptyResultDataAccessException e) {
			cursos = null;
			LOGGER.info("sin datos:" + e.getMessage() + " " + SQL);
		}

		return cursos;
	}

	@Override
	public Curso update(Curso curso) {
		final String SQL = "cursoUpdate";
		// se llama al construcctor dado que cachea el SqlParameterSource
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		jdbcCall.withProcedureName(SQL);
		// crear un mapa con los parametros de procedimiento almacenado de
		// entrada (IN).
		SqlParameterSource in = new MapSqlParameterSource().addValue("pnombre", curso.getNombre())
				.addValue("pcodigo", curso.getCodigo())
				.addValue("pid", curso.getId());

		LOGGER.info(curso.toString());
		// se ejecuta
		jdbcCall.execute(in);
		return curso;
	}

	@Override
	public void delete(long id) {
		final String SQL= "cursoDelete";
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		jdbcCall.withProcedureName(SQL);
		SqlParameterSource in =new MapSqlParameterSource()
				.addValue("pcodigo", id);
		
		LOGGER.info(String.valueOf(id));
		jdbcCall.execute(in);
		
	}

	@Override
	public List<Curso> getAllbyNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
