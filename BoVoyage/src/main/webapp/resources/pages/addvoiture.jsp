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

	<%@include file='template/headerAgence.html'%>

	<!-- PARTIE AJOUT -->

	<div class="panel panel-info"
		style="width: 30%; position: relative; left: 35%; text-align: center; color: darkblue">
		<div class="panel-heading"
			style="background-color: lightblue; color: darkblue">
			<b>Ajouter un hôtel</b>
		</div>
		<div class="panel-body">
			<form:form method="POST" action="addvoiturep"
		commandName="addVoiture" cssClass="form-horizontal">
				<label for="type">Type de Voiture:</label> <br /> <form:input type="text"
					placeholder="Entrez un type de voiture" id="type" path="type"/> <br /> <br /> <br /> <label
					for="prix">Prix /Jour /personne:</label> <br /> <form:input
					type="number" path="prix" placeholder="Entrez un prix" id="prix" /> <br /> <br />
				<div
					style="width: 30%; position: relative; left: 35%; text-align: center; color: darkblue">
					<label id="labelimage">Insérer une image :</label>
					<div class="input-group" id="img">
						<span class="input-group-btn"><br /> <span
							class="btn btn-default btn-file"> Charger une photo <form:input
								type="file" id="imgInp" path="photo"/>
						</span> </span> <img id='img-upload' style="width: 30%" />
					</div>
				</div>
				<br /> <br />
				<button type="submit" class="btn btn-default ">Ajouter</button>

			</form:form>
		</div>
	</div>
</body>
</html>