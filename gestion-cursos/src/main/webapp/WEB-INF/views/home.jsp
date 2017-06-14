<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="includes/header.jsp" />

<main>

	<section>
		<h2>Gestión Cursos</h2>
	<nav>
		<li>
			<a href="<c:url value='/cursos'/>">
			  Pulse para Editar listado de  Cursos
			</a>
		</li>	
		</ul>
	</nav>
		<section >
		<h2>Buscar curso por nombre</h2>
	
		 <form name="myForm" action="#" onsubmit="buscar();" >
			 <input type="text" name="buscar" id="buscar">
			  <input type="button" value="BUSCAR" id="boton">
		</form> 
		<div id="ocultar">	
	  	</div>		
	</section>
	<section class="row">
		<header class="col-xs-12"><h2>Listado de los 10 últimos cursos</h2></header>
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
								${curso.nombre}</a>
							</div>
							<div class="col-xs-2">
								${curso.codigo}
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
</main>

<%@include file="includes/footer.html" %>