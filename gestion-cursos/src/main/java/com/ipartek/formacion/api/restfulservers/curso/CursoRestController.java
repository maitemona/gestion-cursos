package com.ipartek.formacion.api.restfulservers.curso;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ipartek.formacion.dbms.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoService;

@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RestController
@RequestMapping(value = "/api/cursos")
public class CursoRestController implements Serializable{

	private static final long serialVersionUID = -6698866485450376235L;
	@Autowired
	CursoService cS;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
	}

	
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Curso> getById(@PathVariable("id") int id) {
		Curso curso = cS.getById(id);
		ResponseEntity<Curso> response = null;

		if (curso == null) {// 404
			response = new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		} else {// 200
			response = new ResponseEntity<Curso>(curso, HttpStatus.OK);
		}

		return response;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Curso>> getAll() {
		List<Curso> cursos = cS.getAll();
		ResponseEntity<List<Curso>> response = null;

		if (cursos == null || cursos.isEmpty()) {
			response = new ResponseEntity<List<Curso>>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
		}

		return response;
	}
	
	
	@RequestMapping(value = "/{nombre}",method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Curso>> getAllbyNombre(@PathVariable("nombre") String nombre) {
		List<Curso> cursos = cS.getAllbyNombre(nombre);
		ResponseEntity<List<Curso>> response = null;

		if (cursos == null || cursos.isEmpty()) {
			response = new ResponseEntity<List<Curso>>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
		}

		return response;
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Integer> create(@RequestBody Curso curso, UriComponentsBuilder ucBuilder) {
		Curso cur = cS.getById(curso.getId());
		ResponseEntity<Integer> response = null;

		if (cur != null) {
			response = new ResponseEntity<Integer>(0,HttpStatus.CONFLICT);
		} else {
			try {
				Curso aux = cS.create(curso);
				response = new ResponseEntity<Integer>(HttpStatus.CREATED);
			} catch (Exception e) {
				response = new ResponseEntity<Integer>(-1, HttpStatus.NOT_ACCEPTABLE);

			}
			// Si no reciclase el metodo getById la respuesta es <Alumno>
			// response = new ResponseEntity<Alumno>(alumno,HttpStatus.CREATED);
			// se manipulan los encabezados HTTP para llamar al metodo getById
			// del RestController

		}

		return response;
	}
	@RequestMapping(value = "/{id}", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.PUT, produces = {
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Curso> update(@PathVariable("id") int id,  @RequestBody Curso curso) {
		Curso cur = cS.getById(id);
		ResponseEntity<Curso> response = null;

		if (cur == null) {
			response = new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		} else {
			try {
				cur = cS.update(curso);
				response = new ResponseEntity<Curso>(cur, HttpStatus.ACCEPTED);

			} catch (Exception e) {
				response = new ResponseEntity<Curso>(HttpStatus.NOT_ACCEPTABLE);
			}
		}

		return response;
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Curso> deleteById(@PathVariable("id") long id) {
		Curso cur = cS.getById(id);
		ResponseEntity<Curso> response = null;
		if (cur == null) {
			response = new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		} else {
			cS.delete(id);
			response = new ResponseEntity<Curso>( HttpStatus.ACCEPTED);
		}
		return response;
	}

}
