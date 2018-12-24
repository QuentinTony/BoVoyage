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
<title>Vous entrez dans l'espace Administrateur de BoVoyage</title>
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

	<form:form method="POST" action="isexistagencep"
		commandName="isExistAgence" cssClass="form-horizontal">




		<div class="panel panel-info"
			style="width: 30%; position: relative; left: 35%; text-align: center; color: darkblue">
			<div class="panel-heading"
				style="background-color: lightblue; color: darkblue" >
				<b>Accès à votre espace Administrateur de BoVoyage</b>
			</div>
			<div class="radio">
				<label><input id="radmark" type="radio" name="optradio"  >Service
					Marketing</label>
			</div>
			<div class="radio">
				<label><input id="raddir" type="radio" name="optradio" >Direction
					Générale</label>
			</div>
			<div class="radio">
				<label><input id="radgest" type="radio" name="optradio">Gestionnaire
					Site</label>
			</div>

			<div class="panel-body">
				<label for="email">Adresse Electronique</label> <br /> <input
					type="email" class="form-control " id="email"
					style="width: 80%; position: relative; left: 10%"
					placeholder="Entrez votre adresse électronique" /> <br /> <label
					for="mdp">Mot de passe</label> <br /> <input type="password"
					class="form-control" id="mdp"
					style="width: 80%; position: relative; left: 10%"
					placeholder="Entrez votre mot de passe" /> <br />
				<button id="mark" type="submit" class="btn btn-default " style="display: none">Entrez dans
					votre espace Marketing</button>
				<button id="dir" type="submit" class="btn btn-default " style="display: none">Entrez dans
					votre espace Direction</button>
				<button id="gest" type="submit" class="btn btn-default " style="display: none">Entrez dans
					votre espace Gestionnaire</button>
			</div>
		</div>
	</form:form>
	<br />
	<br />
	<div
		style="width: 30%; position: relative; left: 35%; text-align: center;">
		<a href="${pageContext.request.contextPath}/bovoyage/listvoyage"
			class="btn btn-default btn-lg active" role="button">Revenir à la
			page d'accueil</a>
	</div>
	<br />
	<br />

<script>

$('#radmark').click(function() {
	   if($('#radmark').is(':checked')) { document.getElementById('mark').style.display = 'block';
	   document.getElementById('dir').style.display = 'none';
	   document.getElementById('gest').style.display = 'none'; }
	});
	
$('#raddir').click(function() {
	   if($('#raddir').is(':checked')) { document.getElementById('dir').style.display = 'block'; 
	   document.getElementById('mark').style.display = 'none';
	   document.getElementById('gest').style.display = 'none'; }
	});
$('#radgest').click(function() {
	   if($('#radgest').is(':checked')) { document.getElementById('gest').style.display = 'block'; 
	   document.getElementById('mark').style.display = 'none';
	   document.getElementById('dir').style.display = 'none';}
	});

</script>

</body>
</html>