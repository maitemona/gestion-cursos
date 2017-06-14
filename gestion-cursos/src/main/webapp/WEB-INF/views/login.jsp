<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Login</title>
<!-- Latest compiled and minified CSS -->
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
<spring:message var="seccion" code="home.titulo" />
<c:set scope="request" var="seccion" value="${seccion}"/>
<jsp:include page="includes/header.jsp" />
<main>
	<section>
		<c:url  var ="loginURL" value="/login.html" />
		<form:form action="${loginURL}" method="post">
			<div class="input-group input-sm">
				<label>
					Usuario:
				</label>
				<input type="text" id="userID" name="userID" required>
			</div>
			<div class="input-group input-sm">
				<label>
					Password:
				</label>
				<input type="password" id="password" name="password" required>
			</div>
			<input type="submit" value="Log IN" class="btn btn-block bg-primary" />
		</form:form>
	</section>
</main>

<%@include file="includes/footer.html" %>