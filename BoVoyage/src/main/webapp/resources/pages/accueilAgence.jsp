<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
<style type="text/css">
.grid-container {
	display: grid;
	grid-template-columns: auto auto auto;
	padding: 10px;
	marge: 10px;
	grid-column-gap: 20px;
	grid-row-gap: 20px;
}

.grid-item {
	background-color: lightblue;
	border: 2px solid darkblue;
	border-radius: 5%;
	font-size: 30px;
	padding: 10px;
	marge: 10px;
	text-align: center;
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/monJS.js"></script>
</head>
<body>
	<%@include file='template/headerAgence.html'%>
	<h1
		style="color: darkblue; text-align: center; text-decoration: underline;">Bienvenue
		dans votre espace Gestion de BoVoyage</h1>
	<br/>

	<div class="grid-container">
		<div class="grid-item">
			<form:form method="POST" action="rechercheVoyagep"
				commandName="voyage" cssClass="form-horizontal">

				<label for="voyage">Voyage :</label>
				<br />
				<form:select class="form-control" path="id">
					<c:forEach items="${listvoyage}" var="list">

						<option value="${list.id}">${list.villeDepart}-Du
							${list.dateDepart} au ${list.dateRetour}</option>

					</c:forEach>
				</form:select>

				<button type="submit" class="btn btn-default ">Rechercher</button>

			</form:form>
		</div>
		<div class="grid-item">

			<form:form method="POST" action="rechercheDestinationp"
				commandName="destination" cssClass="form-horizontal">

				<label for="dest">Destination :</label>
				<br />
				<form:select class="form-control" id="dest" path="id">
					<c:forEach items="${listdestination}" var="list">
						<form:option value="${list.id}"
							label="${list.pays} - ${list.villeArrive}" />
					</c:forEach>
				</form:select>

				<button type="submit" class="btn btn-default ">Rechercher</button>

			</form:form>
		</div>
		<div class="grid-item">
			<form:form method="POST" action="rechercheHotelp" commandName="hotel"
				cssClass="form-horizontal">

				<label for="destination">Hôtel :</label>
				<br />
				<form:select class="form-control " id="hotel" path="id">
					<c:forEach items="${listhotel}" var="list">
						<form:option value="${list.id}"
							label="${list.type}* - ${list.type}" />

					</c:forEach>
				</form:select>

				<button type="submit" class="btn btn-default ">Rechercher</button>

			</form:form>
		</div>
		<div class="grid-item">
			<form:form method="POST" action="recherchePrestationp"
				commandName="prestation" cssClass="form-horizontal">

				<label for="prest">Prestation :</label>
				<br />
				<form:select class="form-control" id="prest" path="id">
					<c:forEach items="${listprestation}" var="list">
						<form:option value="${list.id}"
							label="${list.destination.villeArrive} - ${list.type}" />
					</c:forEach>
				</form:select>

				<button type="submit" class="btn btn-default ">Rechercher</button>

			</form:form>
		</div>
		<div class="grid-item">
			<form:form method="POST" action="rechercheVehiculep"
				commandName="vehicule" cssClass="form-horizontal">
				<label for="voiture">Vehicule :</label>
				<br />
				<form:select class="form-control" id="voiture" path="id">
					<c:forEach items="${listvehicule}" var="list">

						<form:option value="${list.id}" label="${list.id} - ${list.type}" />
					</c:forEach>
				</form:select>

				<button type="submit" class="btn btn-default ">Rechercher</button>

			</form:form>
		</div>
	</div>
	<br/>
<div class="panel-body">
			<form>
			<a href="${pageContext.request.contextPath}/j_spring_security_logout">Se deconnecter</a>
				</form></div>
	<%@include file="template/footer.html"%>
</body>
</html>