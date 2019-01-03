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

<style>
.grid-container {
	
	display: inline-grid;
	grid-template-columns: 75% 75% 75%;
	padding: 10px;
}

.grid-item {
	text-align: center;
	margin-left: 2.5%;
	
}
</style>
</head>
<header><%@include file='template/header.html'%></header>
<body>
<H2 style="text-align: center">Voici la liste des voyages correspondant à votre recherche avancée.</H2>
<br/>
	<div class="grid-container">
		<c:forEach var="v" items="${listVoyage}" varStatus="vs">

			<div class="grid-item">


				<div class="panel-group">

					<div class="panel panel-default"
						style="background-image: url('http://localhost:8080/BoVoyage/destination/photoD/${v.destination.id}');">

						<div class="panel-body">


							<div
								style="color: darkblue; font-size: 200%; position: absolute;">
								<b> ${v.destination.pays}</b> - ${v.destination.villeArrive}
							</div>
							<br /> <br /> <br /> <br /> <br /> <br />
							<div
								style="color: darkblue; font-size: 200%; text-decoration: line-through; text-align: right">
								<b>${v.prix}¤</b>
							</div>
							<div style="color: red; font-size: 200%; text-align: right">${v.prix *(1- v.remise) }¤</div>

						</div>


						<div>
							<button>
								<a href="#modal-dialog${vs.index}"
									class="btn btn-default-modal-toggle" data-toggle="modal"
									data-modal-type="confirm" data-modal-title="Details Property"
									data-modal-text="see details">Voir les détails</a>
							</button>
						</div>
					</div>
					<div id="modal-dialog${vs.index}" class="modal">
						<div class="modal-dialog" id="mapB" onloadstart="map()">
							<div class="modal-content">
								<div class="modal-header">
									<a href="#" data-dismiss="modal" aria-hidden="true"
										class="close">×</a>
								</div>
								<div class="modal-body">
									<div class="panel-group">
										<div class="panel panel-default">
											<div class="panel-heading"
												style="border:solid 3px darkblue;font-size: 150%;background-image: url('http://localhost:8080/BoVoyage/destination/photoD/${v.destination.id}')">
												<div
													style="color: darkblue; font-size: 150%; position: absolute;">
													<b>${v.destination.pays}</b> - ${v.destination.villeArrive}
												</div>
												<div
													style="color: darkblue; font-size: 100%; text-decoration: line-through; text-align: right">${v.prix}¤</div>
												<div style="color: red; font-size: 150%; text-align: right">${v.prix *(1- v.remise) }¤</div>

											</div>
											<div class="panel-body"
												style="background-color: #CEF6F5; border: solid 3px darkblue">
												<h3>Partez pour ${v.destination.pays} à
													${v.destination.villeArrive} !</h3>

												<br />
												<h4>A partir de ${v.prix *(1- v.remise)} ¤.</h4>

												<br /> A partir de ${v.villeDepart }, vous partirez le
												${v.dateDepart} et revenez le ${v.dateRetour}.


												<h3 style="text-align: center">Plus que
													${v.stockPassager} places disponibles</h3>

												<button>
													<a
														href="localhost:8080/BoVoyage/bovoyage/getvoyage?id=${v.id}"
														target="_blank">Afficher la carte et la météo</a>
												</button>



												<button>
													<a
														href="${pageContext.request.contextPath}/formule/selectformule?id=${v.id}">Sélectioner
														ce voyage</a>
												</button>
											</div>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>


			</div>
		</c:forEach>
	</div>
</body>
<footer>
	<%@include file='template/footer.html'%>
</footer>

</html>