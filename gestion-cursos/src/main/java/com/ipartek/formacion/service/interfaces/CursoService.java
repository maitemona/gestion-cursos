package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dbms.persistence.Curso;

public interface CursoService {
	public Curso create(Curso curso);

	public Curso getById(long id);

	public List<Curso> getAll();

	public Curso update(Curso curso);

	public  void delete(long id);

	public List<Curso> getAllbyNombre(String nombre);
	public List<Curso> getTodos();

}
