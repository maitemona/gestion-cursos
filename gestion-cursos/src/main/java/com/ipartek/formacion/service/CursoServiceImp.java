package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipartek.formacion.dbms.dao.intefaces.CursoDAO;
import com.ipartek.formacion.dbms.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;

@Service("cursoServiceImp")
public class CursoServiceImp implements CursoService {

	private CursoDAO cursoDao;

	@Override
	public Curso getById(long codigo) {
		return cursoDao.getById(codigo);
	}

	@Override
	public List<Curso> getAll() {
		return cursoDao.getAll();
	}

	@Transactional
	@Override
	public Curso update(Curso curso) {

		return cursoDao.update(curso);
	}

	@Transactional
	@Override
	public void delete(long codigo) {

		//Curso curso = cursoDao.getById(codigo);
		
		cursoDao.delete(codigo);
	}

	@Transactional
	@Override
	public Curso create(Curso curso) {

		return cursoDao.create(curso);
	}

	@Override
	public List<Curso> getAllbyNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}



