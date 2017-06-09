<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
	<c:url var="sendUrl" value="/cursos/save"/>
	<c:url var="cancelUrl" value="/cursos"/>
	<c:set var="accion" value="crear"/>
	<c:if test="${!empty curso}">
		<c:set var="accion" value="editar"/>
	</c:if>
	<section class="row">
		<header class="col-xs-12 col-md-10 col-md-offset-2"><h2>${accion}</h2></header>
		<div class="container-fluid">
			<form:form action="${sendUrl}" enctype="multipart/form-data" method="post" cssClass="form-horizontal" id="cursoForm" modelAttribute="curso">
				<c:if test="${!empty curso}">
					<form:hidden path="id"/>
					
				</c:if>
				<div class="form-group">
						<form:label path="nombre" cssClass="control-label  col-xs-2"><spring:message code="form.nombre" text="Nombre"/></form:label>
						<div class="col-xs-5">
							<form:input type="text" path="nombre" cssClass="form-control" cssErrorClass="form-control text-danger"/>
						</div>
					<form:errors path="nombre" cssClass="text-danger col-xs-5"></form:errors>
				</div>
				<div class="form-group">
						<form:label path="codigo" cssClass="control-label  col-xs-2">codigo</form:label>
						<div class="col-xs-5">
							<form:input type="text" path="codigo" cssClass="form-control" cssErrorClass="form-control text-danger"/>
						</div>
					<form:errors path="codigo" cssClass="text-danger col-xs-5"></form:errors>
				</div>
				<div class="form-group">
					<div class="col-md-offset-3">
						<button type="submit" class="btn btn-success">${accion}</button>
						<a class="btn btn-warning" href="${cancelUrl}">Cancelar</a>
					</div>
				</div>
				
			</form:form>
		</div>
	</section>