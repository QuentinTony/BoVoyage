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
<script src="https://www.paypalobjects.com/api/checkout.js"></script>
</head>
<header><%@include file='template/header.html'%></header>
<body>

	Vous avez choisi la formule ${formule.voyage.villeDepart} -
	${formule.voyage.destination.villeArrive} pour
	${formule.nombrePersonne} personnes. Le nombre de jours et de nuits
	sont de ${formule.nombreJour} jours / ${formule.nombreNuit} nuits.
	<br /> Vous partirez de ${formule.voyage.villeDepart} le
	${formule.voyage.dateDepart} et reviendrez de
	${formule.voyage.destination.villeArrive} le
	${formule.voyage.dateRetour}.
	<br /> Vous avez choisi l'hôtel ${formule.hotel.type} ayant
	${formule.hotel.categorie} étoiles se situant à
	${formule.voyage.destination.villeArrive}.
	<br /> Vous avez choisi la location d'une ${formule.vehicule.type}.
	<br /> Le prix final avant remise est de : ${formule.voyage.prix + formule.hotel.prix*formule.nombreNuit + formule.vehicule.prix*formule.nombreJour}
	¤ par personne. La remise est de ${formule.voyage.remise}. La somme à
	régler est de ${(formule.voyage.prix + formule.hotel.prix*formule.nombreNuit + formule.vehicule.prix*formule.nombreJour)*(formule.nombrePersonne)*(1-formule.voyage.remise)}.

	<form:form method="POST" action="validformulep" commandName="formule"
		cssClass="form-horizontal" modelAttribute="formule">
		<div style="visibility: hidden;">
			<form:input path="prixFinal"
				value="${(formule.voyage.prix + formule.hotel.prix*formule.nombreNuit + formule.vehicule.prix*formule.nombreJour)*(formule.nombrePersonne)*(1-formule.voyage.remise)}" />
			<br />
			<form:input path="id" value="${formule.id}" />
			<br />
			<form:input path="nombrePersonne" value="${formule.nombrePersonne}" />
			<br />
			<form:input path="hotel.id" value="${formule.hotel.id}" />
			<br />
			<form:input path="vehicule.id" value="${formule.vehicule.id}" />
			<br />
			<form:input path="voyage.id" value="${formule.voyage.id}" />
			<br />
		</div>

		<div id="validation" style="display: none">
			<button type="submit" class="btn btn-default">valider la
				commande</button>
		</div>

	</form:form>

	<div id="paypal-button-container"></div>

	<script type="text/javascript">
		paypal.Button
				.render(
						{

							env : 'sandbox', // sandbox | production

							// PayPal Client IDs - replace with your own
							// Create a PayPal app: https://developer.paypal.com/developer/applications/create
							client : {
								sandbox : 'AQEnCIX14-sxyPE5W3ERKcpO915et1I6uwnVUPJ5ynPPvMI2CCFbaDqH_YfPiJLfkQ-Xg4p0_SpPuDNf',
								production : '<insert production client id>'
							},

							// Show the buyer a 'Pay Now' button in the checkout flow
							commit : true,

							// payment() is called when the button is clicked
							payment : function(data, actions) {

								// Make a call to the REST api to create the payment
								return actions.payment.create({
									payment : {
										transactions : [ {
											amount : {
												total : '0.01',
												currency : 'EUR'
											}
										} ]
									}
								});
							},

							// onAuthorize() is called when the buyer approves the payment
							onAuthorize : function(data, actions) {
								$('#validation').css("display","block");
								// Make a call to the REST api to execute the payment
								return actions.payment.execute().then(
										function() {
											window.alert('Payment Complete!');
										});
							}

						}, '#paypal-button-container');
	</script>


	<%@include file='template/footer.html'%>
</body>
</html>