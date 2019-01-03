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
<body onload="map">



	<c:forEach var="v" items="${listVoyage}" varStatus="vs" >
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading"
					style="font-size: 150%; background-image:url('http://localhost:8080/BoVoyage/destination/photoD/${v.destination.id}')">


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
							<td>${v.destination.id}<img
								src="${pageContext.request.contextPath}/photo/destination?id=${v.destination.id}"
								style="max-width: 100%; height: 260px; border-radius: 5px"
								class="img-fluid" />
							</td>
						</tr>

					</table>
					<h3 style="text-align: center">Plus que ${v.stockPassager}
						places disponibles</h3>
					<button>
						<a href="#modal-dialog${vs.index}"
							class="btn btn-default-modal-toggle" data-toggle="modal"
							data-modal-type="confirm" data-modal-title="Details Property"
							data-modal-text="see details">Voir les détails</a>
					</button>
				</div>
				<div id="modal-dialog${vs.index}" class="modal">
					<div class="modal-dialog" id="mapB" onloadstart="map()">
						<div class="modal-content">
							<div class="modal-header">
								<a href="#" data-dismiss="modal" aria-hidden="true"
									class="close">×</a>
								<h3>${v.destination.pays}-${v.destination.villeArrive}</h3>
							</div>
							<div class="modal-body">
								<div class="panel-group">
									<div class="panel panel-default">
										<div class="panel-heading"
											style="font-size: 150%;background-image: url('http://localhost:8080/BoVoyage/destination/photoD/${v.destination.id}')">
											<div
												style="color: darkblue; font-size: 150%; position: absolute;">
												<b>${v.destination.pays}</b> -
												${v.destination.villeArrive}
											</div>
											<div
												style="color: darkblue; font-size: 100%; text-decoration: line-through; text-align: right">${v.prix}¤</div>
											<div style="color: red; font-size: 150%; text-align: right">${v.prix *(1- v.remise) }¤</div>

										</div>
										<div class="panel-body" >
											<table class="table table-bordered">

												<tr>
													<th>Prix</th>
													<th>Remise</th>
													<th>Prix Soldé</th>
													<th>Ville de Départ</th>
													<th>Ville de Retour</th>
													<th>Date de Départ</th>
													<th>Date de Retour</th>
												
												</tr>
												<tr>
													<td>${v.prix}</td>
													<td>${v.remise*100}%</td>
													<td>${v.prix *(1- v.remise) }</td>
													<td>${v.villeDepart }</td>
													<td>${v.destination.villeArrive }</td>
													<td>${v.dateDepart}</td>
													<td>${v.dateRetour}</td>
												

												</tr>

											</table>
											<br/>
											<button><a href="localhost:8080/BoVoyage/bovoyage/getvoyage?id=${v.id}" target="_new" >Afficher la carte et la météo</a></button>
													
											<h3 style="text-align: center">Plus que
												${v.stockPassager} places disponibles</h3>

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
</body>
<footer>
	<%@include file='template/footer.html'%>
</footer>

</html>