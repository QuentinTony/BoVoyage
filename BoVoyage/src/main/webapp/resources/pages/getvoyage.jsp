<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
	pageEncoding="ISO-8859-15"%>

<!-- AJouter la tagLib core de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- ajout de la taglIb form de spring MVC -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>

<title>Bienvenue dans BoVoyage-Voyages Nordiques</title>

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
	<form:form method="POST" action="getvoyagep"
		commandName="voyage" cssClass="form-horizontal" modelAttribute="voyage" >
	<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading"
					style="font-size: 150%;background-image: ${voyage.destination.photo}">
					<div style="color: darkblue; font-size: 150%; position: absolute;">
						<b>${voyage.destination.pays}</b> - ${voyage.destination.villeArrive}</div>
					<div
						style="color: darkblue; font-size: 100%; text-decoration: line-through; text-align: right">${voyage.prix}¤</div>
					<div style="color: red; font-size: 150%; text-align: right">${voyage.prix *(1- voyage.remise) }¤</div>

				</div>
				<div class="panel-body">
					<table class="table table-bordered">

						<tr>
							<th>Prix</th>
							<th>Remise</th>
							<th>Prix Soldé</th>
							<th>Ville de Départ</th>
							<th>Ville de Retour</th>
							<th>Date de Départ</th>
							<th>Date de Retour</th>
							<th>Photo</th>
						</tr>
						<tr>
							<td>${voyage.prix}</td>
							<td>${voyage.remise*100}%</td>
							<td>${voyage.prix *(1- voyage.remise) }</td>
							<td>${voyage.villeDepart }</td>
							<td>${voyage.destination.villeArrive }</td>
							<td>${voyage.dateDepart}</td>
							<td>${voyage.dateRetour}</td>
														<td><img src="${voyage.destination.photo}"></td>
							
						</tr>

					</table>
					<h3 style="text-align: center">Plus que ${voyage.stockPassager}
						places disponibles</h3>
					

				</div>

			</div>
		</div>
		</form:form>
	<%@include file='template/footer.html'%>
</body>
</html>