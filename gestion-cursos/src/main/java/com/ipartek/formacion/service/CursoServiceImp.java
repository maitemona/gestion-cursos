package com.ipartek.formacion.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ipartek.formacion.dbms.dao.intefaces.CursoDAO;

import com.ipartek.formacion.dbms.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;

@Service
public class CursoServiceImp implements CursoService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CursoServiceImp.class);
	@Autowired
	private CursoDAO cursoDao = null;

	@Override
	public Curso getById(long id) {
		return cursoDao.getById(id);
		//LOGGER.info( + codigo);
	}

	@Override
	public List<Curso> getAll() {
		LOGGER.info("stoy service de list 10 cursos");
		
		List<Curso> cursos = cursoDao.getAll();
		LOGGER.info("numero de cursos:" + cursos);
		return cursos;
	}
	@Override
	public List<Curso> getTodos() {
		LOGGER.info("stoy service de list all cursos");
		
		List<Curso> cursos = cursoDao.getTodos();
		LOGGER.info("numero de cursos:" + cursos);
		return cursos;
	}
	@Transactional
	@Override
	public Curso update(Curso curso) {

		return cursoDao.update(curso);
	}

	@Transactional
	@Override
	public void delete(long id) {

		//Curso curso = cursoDao.getById(codigo);
		
		cursoDao.delete(id);
	}

	@Transactional
	@Override
	public Curso create(Curso curso) {

		return cursoDao.create(curso);
	}

	@Override
	public List<Curso> getAllbyNombre(String nombre) {
			LOGGER.info("stoy service de list all cursos por nombre");
		
		List<Curso> cursos = cursoDao.getAllbyNombre(nombre);
		LOGGER.info("numero de cursos:" + cursos);
		return cursos;
	}

}



