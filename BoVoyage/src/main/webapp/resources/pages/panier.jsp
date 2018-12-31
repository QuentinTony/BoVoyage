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


	<form:form method="POST" action="selectformulep" commandName="formule"
		cssClass="form-horizontal" modelAttribute="formule">
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading"
					style="font-size: 150%;background-image:url('http://localhost:8080/BoVoyage/destination/photoD/${voyage.destination.id}')">
					<div style="color: darkblue; font-size: 150%; position: absolute;">
						<b>${voyage.destination.pays}</b> -
						${voyage.destination.villeArrive}
					</div>
					<div
						style="color: darkblue; font-size: 100%; text-decoration: line-through; text-align: right">${voyage.prix}¤</div>
					<div style="color: red; font-size: 150%; text-align: right">${voyage.prix *(1- voyage.remise) }¤</div>

				</div>
				<div class="panel-body">
				
				<label for="hotel" >Voici la liste des hôtels de ${voyage.destination.villeArrive }</label><div style="visibility: hidden">
<form:input path="voyage.id" value="${voyage.id}" />
<br/></div>
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
					<h3 style="text-align: center">Plus que
						${voyage.stockPassager} places disponibles</h3>
<br/><br/>
		
					
					<br />
					<label for="hotel" >Voici la liste des hôtels de ${voyage.destination.villeArrive }</label>
<form:select class="form-control" id="hotel" path="hotel.id">
						<c:forEach items="${listehotel}" var="list">
							<form:option value="${list.id}"
								label="${list.type} - ${list.categorie} - ${list.hebergement}" />
						</c:forEach>
					</form:select>
					
<!-- 					<br /> <br /> <label for="prestation">Voici la liste des -->
<%-- 						prestations possibles de ${voyage.destination.villeArrive}</label> --%>
<%-- 					<form:select multiple="true" class="form-control" id="listPrestation" --%>
<%-- 						path="prestation.id"> --%>
<%-- 						<c:forEach items="${listPrestation}" var="list"> --%>
<%-- 							<form:option value="${list.id}" --%>
<%-- 								label="${list.type} - ${list.prix}" /> --%>
<%-- 						</c:forEach> --%>
<%-- 					</form:select> --%>

					<br /> <br /> <label for="vehicule">Voici la liste des
						Véhicule possibles de ${voyage.destination.villeArrive}</label>
					<form:select class="form-control" id="vehicule"
						path="vehicule.id">
						<c:forEach items="${listVehicule}" var="list">
							<form:option value="${list.id}"
								label="${list.type} - ${list.prix}" />
						</c:forEach>
					</form:select>

					<br /> 
					
					<label for="passager">Nombre de passagers :</label>
				<br />
				<form:input id="passager" type="number" path="nombrePersonne" />
				<br />


				</div>

			</div>
		</div>
		<button type="submit" class="btn btn-default ">
						Valider cette formule
					</button>
	</form:form>




	<%@include file='template/footer.html'%>
</body>
</html>