package com.ipartek.formacion.dbms.dao.intefaces;

import java.util.List;

import com.ipartek.formacion.dbms.persistence.Curso;

public interface CursoDAO extends DAOSetter{
	public Curso create(Curso curso);

	public Curso getById(long id);

	public List<Curso> getAll();
	public List<Curso> getTodos();

	public Curso update(Curso curso);

	public  void delete(long id);

	public List<Curso> getAllbyNombre(String nombre);



}
