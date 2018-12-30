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

 Vous avez choisi la formule ${formule.voyage.villeDepart} - ${formule.voyage.destination.villeArrive} pour ${formule.nombrePersonne} personnes. 
 <br/>
 Vous partirez de ${formule.voyage.villeDepart} le ${formule.voyage.dateDepart} et reviendrez de ${formule.voyage.destination.villeArrive} le ${formule.voyage.dateRetour}. 
<br/>
Vous avez choisi l'hôtel ${formule.hotel.type} ayant ${formule.hotel.categorie} étoiles se situant à ${formule.voyage.destination.villeArrive}.
<br/>
Vous avez choisi la location d'une ${formule.vehicule.type}.
<br/>
Le prix final est de  : ${formule.voyage.prix + formule.hotel.prix + formule.vehicule.prix} ¤. La remise est de ${formule.voyage.remise}.

<form:form method="POST" action="validformulep" commandName="formule"
		cssClass="form-horizontal" modelAttribute="formule">
		<form:input path="prixFinal" value="${(formule.voyage.prix + formule.hotel.prix + formule.vehicule.prix)*(1-formule.voyage.remise)}" /><br/>
		<div style="visibility: hidden;">
		<form:input path="id" value="${formule.id}" /><br/>
		<form:input path="nombrePersonne" value="${formule.nombrePersonne}" /><br/>
		<form:input path="hotel.id" value="${formule.hotel.id}" /><br/>
		<form:input path="vehicule.id" value="${formule.vehicule.id}" /><br/>
		<form:input path="voyage.id" value="${formule.voyage.id}" /><br/>
		</div>
		
		<button type="submit" class="btn btn-default"> Accepter ce devis et accéder à la plateforme de payement</button>
		</form:form>
	<%@include file='template/footer.html'%>
</body>
</html>