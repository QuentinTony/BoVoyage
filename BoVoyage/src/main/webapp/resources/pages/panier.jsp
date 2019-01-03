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


		<div class="panel-group"
			style="width: 80%; margin-left: 10%; margin-right: 10%; text-align: center;">
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
				<h4>
					Vous êtes intéressés par le voyage en ${voyage.destination.pays}
					dans la ville de ${voyage.destination.villeArrive} en partance de
					${voyage.villeDepart }.<br /><br /> Le voyage sélectionné a lieu du
					${voyage.dateDepart} au ${voyage.dateRetour}. <br /><br /> Le prix
					initial est de ${voyage.prix} ¤. <br /><br /> Grâce à BoVoyage, nous
					avons réussi à vous obtenir ${voyage.remise*100}% de remise.<br /><br />
					Le prix de base pour ce magnifique voyage est de ${voyage.prix *(1- voyage.remise) }
					¤.
				</h4>
					<div style="visibility: hidden">
						<form:input path="voyage.id" value="${voyage.id}"
							style="width:20%" />
						<br />
					</div>
				
					<h3 style="text-align: center">Plus que
						${voyage.stockPassager} places disponibles</h3>
					<br />
					<div style="margin-left: 35%; margin-right: 35%">
						<br /> <br /> <label for="hotel">Voici la liste des
							hôtels de ${voyage.destination.villeArrive }</label>
						<form:select class="form-control" id="hotel" path="hotel.id">
						
								<c:forEach items="${listehotel}" var="list">
									<form:option value="${list.id}"
										label="${list.type} - ${list.categorie} - ${list.hebergement} - ${list.prix }¤" />
								</c:forEach>
						</form:select>


						<br /> <br /> <label for="vehicule">Voici la liste des
							Véhicule possibles de ${voyage.destination.villeArrive}</label>
						<form:select class="form-control" id="vehicule" path="vehicule.id">
								<c:forEach items="${listVehicule}" var="list">
									<form:option value="${list.id}"
										label="${list.type} - ${list.prix} ¤" />
								</c:forEach>
						</form:select>

						<br /> <label for="passager">Nombre de passagers (total)
							:</label> <br />
						<form:input id="passager" type="number" path="nombrePersonne"
							min="0" max="${voyage.stockPassager}" />
						<br /> <br />

					</div>
					<button type="submit" class="btn btn-default ">Valider
						cette Formule et Enregistrer les Passagers</button>
				</div>
			</div>
		</div>
	</form:form>




	<%@include file='template/footer.html'%>
</body>
</html>