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
						<a href="#modal-dialog" class="btn btn-default-modal-toggle"
							data-toggle="modal" data-modal-type="confirm"
							data-modal-title="Details Property" data-modal-text="see details">Voir
							les détails</a>
					</button>
				</div>
				<div id="modal-dialog" class="modal">
					<div class="modal-dialog">
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
											style="font-size: 150%;background-image: url('http://localhost:8080/BoVoyage/destination/photoD/${voyage.destination.id}')">
											<div
												style="color: darkblue; font-size: 150%; position: absolute;">
												<b>${v.destination.pays}</b> - ${v.destination.villeArrive}
											</div>
											<div
												style="color: darkblue; font-size: 100%; text-decoration: line-through; text-align: right">${voyage.prix}¤</div>
											<div style="color: red; font-size: 150%; text-align: right">${voyage.prix *(1- voyage.remise) }¤</div>

										</div>
										<div class="panel-body">
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
													<td>${v.prix}</td>
													<td>${v.remise*100}%</td>
													<td>${v.prix *(1- voyage.remise) }</td>
													<td>${v.villeDepart }</td>
													<td>${v.destination.villeArrive }</td>
													<td>${v.dateDepart}</td>
													<td>${v.dateRetour}</td>
													<td><img src="${v.destination.photo}"></td>

												</tr>

											</table>
											<br />
											<div id="map" style="width: 530px; height: 400px;"></div>
											<br />

											<div class="wrapper">
												<!-- A wrapper for CSS-design -->
												<h2>Weather Application in jQuery</h2>
												<p>
													What temperature is it at your <span class='italic'>exact</span>
													location?
												</p>
												<!-- Some fancy text -->

												<!-- Here we will show the final result -->
												<p id="result">? °</p>


											</div>



											<br />



											<h3 style="text-align: center">Plus que
												${v.stockPassager} places disponibles</h3>

											<button>
												<a
													href="${pageContext.request.contextPath}/formule/selectformule?id=${v.id}">Sélectioner
													ce voyage</a>
											</button>
										</div>
									</div>

									<script
										src="http://www.mapquestapi.com/sdk/js/v7.2.s/mqa.toolkit.js?key=KhXhyTLNG9H9fw4AZFoIzxnakIy4XEUj"></script>
									<script type="text/javascript"></script>
									<script type="text/javascript">

  // An example of using the MQA.EventUtil to hook into the window load event and execute the defined
  // function passed in as the last parameter. You could alternatively create a plain function here and
  // have it executed whenever you like (e.g. <body onload="yourfunction">).

  MQA.EventUtil.observe(window, 'load', function() {

    // create an object for options
    var options = {
      elt: document.getElementById('map'),       // ID of map element on page
      zoom:8,                                  // initial zoom level of the map
      latLng: {lat: ${v.destination.latitude}, lng:${v.destination.longitude} },  	// center of map in latitude/longitude
      mtype: 'map',                              // map type (map, sat, hyb); defaults to map
      bestFitMargin: 0,                          // margin offset from map viewport when applying a bestfit on shapes
      zoomOnDoubleClick: true                    // enable map to be zoomed in when double-clicking
    };
    
    

    // construct an instance of MQA.TileMap with the options object
    window.map = new MQA.TileMap(options);
  });

</script>
									<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
									<script>
		$(document).ready(function () {
			  var lat, lon, api_url;
			  
			  if ("geolocation" in navigator) {
			    
			    $('#showTemp').on('load', function () {
			       navigator.geolocation.getCurrentPosition(gotLocation);

			      function gotLocation(position) {
			        lat = ${v.destination.latitude};
			        lon = ${v.destination.longitude};
			        
			        api_url = 'http://api.openweathermap.org/data/2.5/forecast?lat=' +
			                  lat + '&lon=' + 
			                  lon + '&units=metric&appid=8feb5c49c43a8842da6a278e8bedc5cd';
			       // http://api.openweathermap.org/data/2.5/weather?q=London,uk&callback=test&appid=b1b15e88fa79722
			        
			        $.ajax({
			          url : api_url,
			          method : 'GET',
			          success : function (data) {
			            


			            var tempr = data.main.temp;
			            var location = data.name;
			            var desc = data.weather.description;
			            

			            $('#result').text(tempr + '°' + location);

			          }
			        });
			     }
			    });
			    
			  } else {
			    alert('Your browser doesnt support geolocation. Sorry.');
			  }
			  
			});

</script>
								</div>
								<div class="modal-footer"></div>
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