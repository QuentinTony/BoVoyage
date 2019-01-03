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
	<div class="panel-group"
		style="width: 80%; margin-left: 10%; margin-right: 10%; text-align: center;">
		<div class="panel panel-default">
			<div class="panel-heading"
				style="font-size: 150%;background-image: url('http://localhost:8080/BoVoyage/destination/photoD/${formule.voyage.destination.id}')">
				<div style="color: darkblue; font-size: 150%; position: absolute;">
					<b>${formule.voyage.destination.pays}</b> -
					${formule.voyage.destination.villeArrive}
				</div>
				<div
					style="color: darkblue; font-size: 100%; text-decoration: line-through; text-align: right">${formule.voyage.prix}¤</div>
				<div style="color: red; font-size: 150%; text-align: right">${formule.voyage.prix *(1- formule.voyage.remise) }¤</div>

			</div>
			<div class="panel-body">
				<h4>
					Vous avez choisi la formule ${formule.voyage.villeDepart} -
					${formule.voyage.destination.villeArrive} pour
					${formule.nombrePersonne} personnes. <br /><br /> Vous partirez de
					${formule.voyage.villeDepart} le ${formule.voyage.dateDepart} et
					reviendrez de ${formule.voyage.destination.villeArrive} le
					${formule.voyage.dateRetour}. <br /><br /> Vous avez choisi l'hôtel
					${formule.hotel.type} ayant ${formule.hotel.categorie} étoiles se
					situant à  ${formule.voyage.destination.villeArrive}. <br /><br /> Vous
					avez choisi la location d'une ${formule.vehicule.type}. <br /> <br />Le
					prix final est de :${(formule.voyage.prix + formule.hotel.prix*formule.nombreNuit + formule.vehicule.prix*formule.nombreJour)*(formule.nombrePersonne)*(1-formule.voyage.remise)}
					¤. La remise est de ${formule.voyage.remise*100}%.
					<br/><br/><br/><br/>
					Détail du prix : 
					<table class="table" style="width:40%;margin-left: 30%;margin-right: 30%"><tr><td>Prix du Voyage : </td><td>${formule.voyage.prix}</td></tr>
					
					<tr><td>Prix de l'hôtel : </td><td>${formule.hotel.prix}</td></tr>
					<tr><td>Prix de la location : </td><td>${formule.vehicule.prix}</td></tr>
					
					<tr><td>Prix avant réduction par passager : </td><td>${(formule.voyage.prix + formule.hotel.prix*formule.nombreNuit + formule.vehicule.prix*formule.nombreJour)}</td></tr>
					<tr><td>Nombre de Passagers : </td><td>${formule.nombrePersonne}</td></tr>
					<tr><td>Prix totale avant réduction : </td><td>${(formule.voyage.prix + formule.hotel.prix*formule.nombreNuit + formule.vehicule.prix*formule.nombreJour)*(formule.nombrePersonne)}</td></tr>
										<tr><td><b>Prix totale après réduction : </b></td><td><b>${(formule.voyage.prix + formule.hotel.prix*formule.nombreNuit + formule.vehicule.prix*formule.nombreJour)*(formule.nombrePersonne)*(1-formule.voyage.remise)}</b></td></tr>
					
					</table>

					<form:form method="POST" action="validformulep"
						commandName="formule" cssClass="form-horizontal"
						modelAttribute="formule">

						<div style="visibility: hidden;">
							<form:input path="prixFinal"
								value="${(formule.voyage.prix + formule.hotel.prix*formule.nombreNuit + formule.vehicule.prix*formule.nombreJour)*(formule.nombrePersonne)*(1-formule.voyage.remise)}" />
						
							<form:input path="id" value="${formule.id}" />
						
							<form:input path="nombrePersonne"
								value="${formule.nombrePersonne}" />
						
							<form:input path="hotel.id" value="${formule.hotel.id}" />
						
							<form:input path="vehicule.id" value="${formule.vehicule.id}" />
						
							<form:input path="voyage.id" value="${formule.voyage.id}" />
					
						</div>

						<div id="validation" style="display: none">
							<button type="submit" class="btn btn-default">valider la
								commande</button>
						</div>
						<div id="validation"
							style="display: none; display: ${indice}!important;">
							<button type="submit" class="btn btn-default">valider la
								commande</button>
						</div>
					</form:form>
				</h4>
				<button style="display: ${indice1};">
					<a href="#modal-dialog" class="btn btn-default-modal-toggle"
						data-toggle="modal" data-modal-type="confirm"
						data-modal-title="Details Property" data-modal-text="see details">Payer
						en VISA</a>
				</button>
				<br/>
				<br/>
				<div id="paypal-button-container"></div>
			</div>
		</div>
	</div>

	<p>${msg}</p>



	<div id="modal-dialog" class="modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<a href="#" data-dismiss="modal" aria-hidden="true" class="close">Ã—</a>

				</div>
				<div class="modal-body">
					<div class="panel-group">
						<div class="panel panel-default">
							<div class="panel-heading">
								<div style="color: darkblue; font-size: 150%;">
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
												placeholder="Entrez votre cle de securitÃ©"
												required="required" path="cleSecurite" />
											<br /> <label for="Somme">Somme</label> <br /> <input
												type="number" class="form-control" id="Somme"
												style="width: 80%; position: relative; left: 10%"
												placeholder="Entrez la somme" required="required"
												name="dSomme"
												value="${(formule.voyage.prix + formule.hotel.prix + formule.vehicule.prix)*(1-formule.voyage.remise)}" />
											<input type="number" name="id" value="${formule.id }"
												style="display: none;" />

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
