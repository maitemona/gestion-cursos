package com.ipartek.formacion.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.ipartek.formacion.dbms.persistence.Curso;

import com.ipartek.formacion.service.interfaces.CursoService;


@Controller()
@RequestMapping("/cursos")
public class CursoController {
	@Autowired
	private CursoService cS;
	private ModelAndView mav = null;
	@Autowired
	private ServletContext servletContext;
	private static final Logger LOGGER = LoggerFactory.getLogger(CursoController.class);
	@InitBinder("curso")
	public void initBinder(WebDataBinder binder, Locale locale) {
		// DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT,
		// locale);	
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		 //LOGGER.info("stoy controller de list all cursos");
		 mav = new ModelAndView("/cursos/cursos");
		List<Curso> cursos = cS.getAll();
		 LOGGER.info("tamaño:" + cursos.size());
		 mav.addObject("listadoCursos", cursos);
		return mav;
	}

	@RequestMapping(value = "/{id}")
	public String getById(@PathVariable("id") long id, Model model)  {
		LOGGER.info("stoy controller de getbyid curso");
		Curso curso = cS.getById(id);
		if (curso == null) {
			curso = new Curso();
		}
		 LOGGER.info("tamaño:" + curso.getId());
		model.addAttribute("curso", curso);
		return "cursos/curso";
	}

	//Crear nuevo curso
		@RequestMapping(value = "/addCurso")
		public ModelAndView addCurso() {
			mav = new ModelAndView("/cursos/curso");
			Curso curso = new Curso();
			//curso.setActivo(true);
			mav.addObject("curso", curso);
			
			return mav;
		}


	//Editar un curso
	@RequestMapping(value = "/editCurso/{id}", method = RequestMethod.GET)
	public ModelAndView editCurso(@PathVariable("id") long id) {
		mav = new ModelAndView("/cursos/curso");
		Curso curso = cS.getById(id);
		 LOGGER.info(id + " " + curso.toString());
		mav.addObject("curso", curso);
		
		return mav;
	}

	@RequestMapping(value = "/deleteCurso/{id}")
	public String deleteCurso(@PathVariable("id") long id, Model model) {
		cS.delete(id);
		return "redirect:/cursos";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCurso (
			@ModelAttribute("curso") Curso curso, BindingResult bindingResult, ModelMap model,
			RedirectAttributes redirectMap) throws IOException {

		/*
		 * Model ModelMap RedirectAttributes
		 */
		String destino = "";
		

		LOGGER.info(curso.toString());
		if (bindingResult.hasErrors()) {
			// bindingResult.
			LOGGER.info("curso tiene errores" + bindingResult.getErrorCount());

			//mensaje = new Mensaje(MensajeType.MSG_TYPE_DANGER);

		//	txt = "Los datos de formulario contienen errores";

		//	model.addAttribute("mensaje", mensaje);
			destino = "/cursos/curso";
		} else {
			destino = "redirect:/cursos";
			if (curso.getId() > 0) {
				LOGGER.info(curso.toString());
				try {
					cS.update(curso);
				//	txt = "El curso se ha actualizado correctamente.";
					//mensaje = new Mensaje(MensajeType.MSG_TYPE_SUCCESS);
				} catch (Exception e) {
					LOGGER.error("Se ha lanzadado una excepcion update. " + e.toString());
					//mensaje = new Mensaje(MensajeType.MSG_TYPE_DANGER);
					//txt = "Ha habido problemas en la actualización.";
					// destino = "cursos/cursoform";
				}

			} else {
				LOGGER.info(curso.toString());
				
				try {
					cS.create(curso);
					
				} catch (Exception e) {
					LOGGER.info("Se ha lanzadado una excepcion create. " + e.toString());
					
					// destino = "cursos/cursoform";
				}
			}
			
		}
		return destino;
	}

	

}