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
	<%@include file='template/header.html'%>

	<div class="panel-group">
		<div class="panel panel-default">
			<div class="panel-heading"
				style="font-size: 150%;background-image: url('http://localhost:8080/BoVoyage/destination/photoD/${voyage.destination.id}')">
				<div style="color: darkblue; font-size: 150%; position: absolute;">
					<b>${voyage.destination.pays}</b> -
					${voyage.destination.villeArrive}
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
						<td>${voyage.prix}</td>
						<td>${voyage.remise*100}%</td>
						<td>${voyage.prix *(1- voyage.remise) }</td>
						<td>${voyage.villeDepart }</td>
						<td>${voyage.destination.villeArrive }</td>
						<td>${voyage.dateDepart}</td>
						<td>${voyage.dateRetour}</td>
						<td><img src="${voyage.destination.photo}"></td>

					</tr>

				</table>
				<br />
				<div id="map" style="width: 1000px; height: 400px;"></div>
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



				<h3 style="text-align: center">Plus que ${voyage.stockPassager}
					places disponibles</h3>

				<button>
					<a
						href="${pageContext.request.contextPath}/formule/selectformule?id=${voyage.id}">Sélectioner
						ce voyage</a>
				</button>
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
      latLng: {lat: ${voyage.destination.latitude}, lng:${voyage.destination.longitude} },  	// center of map in latitude/longitude
      mtype: 'map',                              // map type (map, sat, hyb); defaults to map
      bestFitMargin: 0,                          // margin offset from map viewport when applying a bestfit on shapes
      zoomOnDoubleClick: true                    // enable map to be zoomed in when double-clicking
    };
    
    
    /*Construct an instance of MQA.TileMap with the options object*/ 
    window.map = new MQA.TileMap(options);
    MQA.withModule('largezoom','traffictoggle','viewoptions','geolocationcontrol','insetmapcontrol','mousewheel', function() {

    map.addControl(
    new MQA.LargeZoom(),
    new MQA.MapCornerPlacement(MQA.MapCorner.TOP_LEFT, new MQA.Size(5,5))
    );

    map.addControl(new MQA.TrafficToggle());

    map.addControl(new MQA.ViewOptions());

    map.addControl(
    new MQA.GeolocationControl(),
    new MQA.MapCornerPlacement(MQA.MapCorner.TOP_RIGHT, new MQA.Size(10,50))
    );

    /*Inset Map Control options*/ 
    var options={
    size:{width:150, height:125},
    zoom:3,
    mapType:'map',
    minimized:true };

    map.addControl(
    new MQA.InsetMapControl(options),
    new MQA.MapCornerPlacement(MQA.MapCorner.BOTTOM_RIGHT)
    );

    map.enableMouseWheelZoom();
    });
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