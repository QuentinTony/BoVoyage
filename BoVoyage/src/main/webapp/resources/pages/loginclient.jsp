<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- AJouter la tagLib core de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- ajout de la taglIb form de spring MVC -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vous entrez dans l'espace Client de BoVoyage</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/monCSS.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/monJS.js"></script>
</head>
<body>

<%@include file='template/header.html'%>

	<br />
	<br />

	<form:form method="POST" action="loginp"
		commandName="client" cssClass="form-horizontal" modelAttribute="client">
		<div class="panel panel-info" style="width:30%; position:relative;left:35%; text-align: center;color:darkblue">
			<div class="panel-heading" style=" background-color: lightblue;color:darkblue"><b>Accès à votre espace Client de BoVoyage</b></div>
			<div class="panel-body">
				<label for="email">Adresse Electronique</label> <br /> <form:input path="mail"
					type="email" class="form-control " id="email" style="width: 80%; position:relative; left:10%"
					placeholder="Entrez votre adresse électronique"/> <br /> <label
					for="mdp">Mot de passe</label> <br /> <form:input path="nom" type="password"
					class="form-control" id="mdp" style="width: 80%; position:relative; left:10%"
					placeholder="Entrez votre mot de passe"/> <br />
				<button type="submit" class="btn btn-default " >Entrez dans
					votre espace Client</button>
			</div>
		</div>
	</form:form>
	<br />
	<br />
	<div   style="width:30%; position:relative;left:35%; text-align: center;">
	<a href="accueil.jsp" class="btn btn-default btn-lg active"
		role="button">Revenir à la page d'accueil</a></div>
	<br />
	<br />

	<%@include file="template/footer.html"%>
</body>
</html>