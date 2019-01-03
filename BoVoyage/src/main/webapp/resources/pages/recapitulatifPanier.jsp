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
	${formule.nombrePersonne} personnes.
	<br /> Vous partirez de ${formule.voyage.villeDepart} le
	${formule.voyage.dateDepart} et reviendrez de
	${formule.voyage.destination.villeArrive} le
	${formule.voyage.dateRetour}.
	<br /> Vous avez choisi l'hôtel ${formule.hotel.type} ayant
	${formule.hotel.categorie} étoiles se situant à
	${formule.voyage.destination.villeArrive}.
	<br /> Vous avez choisi la location d'une ${formule.vehicule.type}.
	<br /> Le prix final est de : ${formule.voyage.prix + formule.hotel.prix + formule.vehicule.prix}
	¤. La remise est de ${formule.voyage.remise}.

	<form:form method="POST" action="validformulep" commandName="formule"
		cssClass="form-horizontal" modelAttribute="formule">
		<form:input path="prixFinal"
			value="${(formule.voyage.prix + formule.hotel.prix + formule.vehicule.prix)*(1-formule.voyage.remise)}" />
		<br />
		<div style="visibility: hidden;">
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
		<div id="validation" style="display: none; display: ${indice}!important;">
			<button type="submit" class="btn btn-default">valider la
				commande</button>
		</div>
	</form:form>
		
	<p>${msg}</p>


	<button style="display: ${indice1};">
		<a href="#modal-dialog" class="btn btn-default-modal-toggle"
			data-toggle="modal" data-modal-type="confirm"
			data-modal-title="Details Property" data-modal-text="see details" >Payer
			en VISA</a>
	</button>
	<div id="modal-dialog" class="modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<a href="#" data-dismiss="modal" aria-hidden="true" class="close">×</a>
					
				</div>
				<div class="modal-body">
					<div class="panel-group">
						<div class="panel panel-default">
							<div class="panel-heading">
								<div
									style="color: darkblue; font-size: 150%; position: absolute;">
									<b>Informations CB</b>
								</div>

							</div>
							<div class="panel-body">

								<form:form method="POST" action="submitVirement"
									commandName="compte" cssClass="form-horizontal"
									modelAttribute="compte">




									<div class="panel panel-info"
										style="width: 50%; position: relative; left: 15%; text-align: center; color: darkblue">
										<div class="panel-heading"
											style="background-color: lightblue; color: darkblue">
											<b>Paiment de votre commande <span
												class="glyphicon glyphicon-euro"></span></b>
										</div>


										<div class="panel-body">
											<label for="numCarte">Numero de carte :</label> <br />
											<form:input type="number" class="form-control " id="numCarte"
												cssStyle="width: 80%; position: relative; left: 10%"
												placeholder="Entrez votre numero de carte"
												required="required" path="numeroCarte" />

											<br /> <label for="DateExp">Date expiration</label> <br />
											<form:input type="date" class="form-control" id="DateExp"
												cssStyle="width: 80%; position: relative; left: 10%"
												placeholder="Entrez votre date d'expiration"
												path="dateExperiation" required="required" />

											<br /> <label for="CleSecurite">cryptogramme (au dos
												de la carte)</label> <br />
											<form:input type="number" class="form-control"
												id="CleSecurite"
												cssStyle="width: 80%; position: relative; left: 10%"
												placeholder="Entrez votre cle de securité"
												required="required" path="cleSecurite" />
											<br /> <label for="Somme">Somme</label> <br /> <input
												type="number" class="form-control" id="Somme"
												style="width: 80%; position: relative; left: 10%"
												placeholder="Entrez la somme" required="required"
												name="dSomme" value="${(formule.voyage.prix + formule.hotel.prix + formule.vehicule.prix)*(1-formule.voyage.remise)}" /> <input type="number"
												name="id" value="${formule.id }" style="display: none;"/>

											<button type="submit" class="btn btn-default ">payer</button>
										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



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
								$('#validation').css("display", "block");
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
