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
				style="font-size: 150%;background-image: ${vehicule.photo}">
				<div style="color: darkblue; font-size: 150%; position: absolute;">
					<b>${vehicule.destination.pays}</b> -
					${vehicule.destination.villeArrive}
				</div>
				<div style="color: darkblue; font-size: 100%; text-align: right">${vehicule.prix}¤</div>


			</div>
			<div class="panel-body">
				<table class="table table-bordered">

					<tr>
						<th>Prix</th>
						<th>Type</th>
						<th>Photo</th>
					</tr>
					<tr>
						<td>${vehicule.prix}</td>
						<td>${vehicule.type}</td>
						<td><img src="${vehicule.destination.photo}"></td>

					</tr>

				</table>
				<br />
				<div id="map" style="width: 1000px; height: 400px;"></div>
				<br /> <br />
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
      latLng: {lat: ${vehicule.destination.latitude}, lng:${vehicule.destination.longitude} },  	// center of map in latitude/longitude
      mtype: 'map',                              // map type (map, sat, hyb); defaults to map
      bestFitMargin: 0,                          // margin offset from map viewport when applying a bestfit on shapes
      zoomOnDoubleClick: true                    // enable map to be zoomed in when double-clicking
    };
    
    

    // construct an instance of MQA.TileMap with the options object
    window.map = new MQA.TileMap(options);
  });

</script>

</body>
</html>