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
<header><%@include file='template/header.html'%></header>
<body>



	<c:forEach var="v" items="${listVoyage}">
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading"
					style="font-size: 150%; background-image:${v.destination.photo}">
					
					
					<div style="color: darkblue; font-size: 150%; position: absolute;">
						${v.destination.pays} - ${v.destination.villeArrive}</div>
					<div
						style="color: darkblue; font-size: 100%; text-decoration: line-through; text-align: right">${v.prix}¤</div>
					<div style="color: red; font-size: 150%; text-align: right">${v.prix *(1- v.remise) }¤</div>

				</div>
				<div class="panel-body">
					<table class="table table-bordered">

						<tr>
							<th>ID</th>
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
							<td>${v.id}</td>
							<td>${v.prix}</td>
							<td>${v.remise*100}%</td>
							<td>${v.prix *(1- v.remise) }</td>
							<td>${v.villeDepart }</td>
							<td>${v.destination.villeArrive }</td>
							<td>${v.dateDepart}</td>
							<td>${v.dateRetour}</td>
							<td>${v.destination.photo}</td>
						</tr>

					</table>
					<h3 style="text-align: center">Plus que ${v.stockPassager}
						places disponibles</h3>
					<button>
						<a	href="${pageContext.request.contextPath}/bovoyage/getvoyage?id=${v.id}">Voir
							les détails</a>
					</button>
				</div>

			</div>
		</div>
	</c:forEach>
</body>
	<footer>
	<%@include file='template/footer.html'%>
	</footer>

</html>