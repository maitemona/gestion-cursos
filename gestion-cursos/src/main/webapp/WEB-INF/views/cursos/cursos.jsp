<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<jsp:include page="../includes/header.jsp" />   
<c:url var="sendUrl" value="/cursos/search"/>
	<section>
		<h2>Buscar curso por nombre</h2>
	
	 <form name="myForm" action="#" onsubmit="buscar();" >
		 <input type="text" name="buscar" id="buscar">
		  <input type="button" value="BUSCAR" id="boton">
	</form> 
	
		
			<div id="ocultar">
					
					
			   		<!--  	<div id="nombre" class="col-xs-2  text-capitalize"></div>
			
	           
			            <div id="codigo" class="col-xs-4  text-capitalize"> </div>
			  
			        <div class="col-xs-6"></div>-->
    		</div>		
			
		
	</section>
	<section class="row">
		<header class="col-xs-12"><h2>Listado de los 10 últimos cursos</h2></header>
		<div class="col-xs-12">
		<a class="btn btn-primary" href="<c:url value="/cursos/addCurso"/>">Crear Curso</a> 
		</div>
		<div class="col-xs-12">
			<div class="row">
				<div class="col-xs-5">Nombre</div>
				<div class="col-xs-2">Codigo</div>
				<div class="col-xs-3"></div>
			</div>
			<c:choose>
				<c:when test="${not empty listadoCursos}">
					<c:forEach var="curso" items="${listadoCursos}">
						<div class="row">
							<div class="col-xs-5">
								<a href="<c:url value='/cursos/${curso.id}'/>">${curso.nombre}</a>
							</div>
							<div class="col-xs-2">
								${curso.codigo}
				            </div>
							
				            <div class="col-xs-3">
				            	<a class="btn btn-warning" href="<c:url value="/cursos/editCurso/${curso.id}"/>">Editar Curso</a>
				            	<a class="btn btn-danger" href="<c:url value="/cursos/deleteCurso/${curso.id}"/>">Borrar Curso</a>
				            </div>			
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div class="row">
						<p class="col-xs-12">No existen resultados</p>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</section>
<%@include file="../includes/footer.html" %>