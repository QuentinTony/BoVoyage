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
<body>
	<%@include file='template/headerAgence.html'%>

	<div class="panel-group">
		<div class="panel panel-default">
		<div class="panel-heading"
				style="font-size: 150%;background-image:url('http://localhost:8080/BoVoyage/destination/photoD/${destination.id}')">
				<div style="color: darkblue; font-size: 150%; position: absolute;">
					<b>${destination.pays}</b> -
					${destination.villeArrive}
				</div>
				<div style="color: darkblue; font-size: 100%; text-align: right; visibility:hidden"> fgsdfgsdrtydfhdfvcbfghfghghf</div>


			</div>
			<div class="panel-body">
				<table class="table table-bordered">

					<tr>
						<th>Continent</th>
						<th>Pays</th>
						<th>Ville d'Arrivée</th>
						<th>Longitude</th>
						<th>Latitude</th>

						<th>Photo</th>
					</tr>
					<tr>
						<td>${destination.continent}</td>
						<td>${destination.pays}</td>
						<td>${destination.villeArrive}</td>
						<td>${destination.longitude}</td>
						<td>${destination.latitude}</td>
							<td> <img
							src="${pageContext.request.contextPath}/destination/photoD/${destination.id}"
														style="max-width: 100%; height: 40%; border-radius: 5px"
											class="img-fluid" /></td>

					</tr>

				</table>
				<br />
				<div id="map" style="width: 1000px; height: 400px; border-radius: 5px"></div>
				<br />

			</div>
		</div>
	</div>

	<%@include file='template/footer.html'%>
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
      latLng: {lat: ${destination.latitude}, lng:${destination.longitude} },  	// center of map in latitude/longitude
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
			        lat = ${voyage.destination.latitude};
			        lon = ${voyage.destination.longitude};
			        
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
</body>
</html>