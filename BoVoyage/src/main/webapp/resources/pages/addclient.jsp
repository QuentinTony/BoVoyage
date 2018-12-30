<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- AJouter la tagLib core de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- ajout de la taglIb form de spring MVC -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<title>BoVoyage-Voyages Nordiques</title>
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
	<header>
		<canvas id="canvas" style="position: absolute; z-index: 2"></canvas>
		<div
			style="text-decoration: underline; color: lightblue; position: absolute; z-index: 2; font-family: Calibri; left: 26%; text-shadow: 10px 8px darkblue; font-size: 500%">WINTER
			IS COMING</div>
		<div id="myCarousel" class="carousel slide" data-ride="carousel"
			style="z-index: 1; height: 10%">

			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img
						src="${pageContext.request.contextPath}/resources/image/header1.jpg"
						alt="Finlande" style="width: 100%; height: 150px;">
					<div class="carousel-caption"></div>
				</div>
				<div class="item">
					<img
						src="${pageContext.request.contextPath}/resources/image/header2.jpg"
						alt="Norvege" style="width: 100%; height: 150px;">
					<div class="carousel-caption"></div>
				</div>
				<div class="item">
					<img
						src="${pageContext.request.contextPath}/resources/image/header3.jpg"
						alt="Suede" style="width: 100%; height: 150px;">
					<div class="carousel-caption"></div>
				</div>

			</div>
		</div>
	</header>
<br/>
<br/>
	<div class="panel panel-info"
		style="width: 30%; position: relative; left: 35%; text-align: center; color: darkblue">
		<div class="panel-heading"
			style="background-color: lightblue; color: darkblue">
			<b>Formulaire d'ajout d'un client</b>
		</div>
		<div class="panel-body">
			<form:form method="POST" action="addclientp" commandName="client"
				cssClass="form-horizontal" modelAttribute="client">
				<label for="nom">Nom :</label>
				<br />
				<form:input type="text" class="form-control" id="nom" path="nom"
					placeholder="Entrer un nom" />
					<form:errors path="nom" cssStyle="color: red;"/>
				<br />
				<label for="prenom">Prenom :</label>
				<br />
				<form:input type="text" class="form-control" id="prenom"
					path="prenom" placeholder="Entrer un prenom" />
					<form:errors path="prenom" cssStyle="color: red;"/>
				<br />
				<label for="email">Email :</label>
				<br />
				<form:input type="email" class="form-control" id="email"
					path="mail" placeholder="Entrer un email valide" />
					<form:errors path="mail" cssStyle="color: red;"/>
				<br />
				<label for="mdp">Mot de passe :</label>
				<br />
				<form:input type="password" class="form-control" id="mdp"
					path="mdp" placeholder="Entrer un mot de passe" />
					<form:errors path="mdp" cssStyle="color: red;"/>
				<br />
				<label for="dn">Date de naissance :</label>
				<br />
				<form:input type="date" class="form-control" id="dn" path="dn"
					placeholder="Entrer une date de naissance" />
					<form:errors path="dn" cssStyle="color: red;"/>
				<br />
				<label for="telephone">Telephone :</label>
				<br />
				<form:input type="text" class="form-control" id="telephone"
					path="telephone" placeholder="Entrer un numéro de téléphone" />
					<form:errors path="telephone" cssStyle="color: red;"/>
				<br />
				<br />
				<button type="submit" class="btn btn-default ">S'incrire</button>

			</form:form>
		</div>
	</div>

</body>
</html>