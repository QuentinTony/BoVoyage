<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- AJouter la tagLib core de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- ajout de la taglIb form de spring MVC -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vous entrez dans l'espace Client de BoVoyage</title>
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
<canvas id="canvas" style="z-index: 3;position: absolute;"></canvas>
<div style="z-index: 3;position: absolute;left:10%;">
	
	<div
		style="text-decoration: underlined; color: lightblue;text-align:center; font-family: Calibri; text-shadow: 10px 8px darkblue; font-size: 500%">BoVoyage
		- Voyages Nordiques<br /> le spécialiste
		au-dela du cercle polaire</div>
	<br />
	<br />

	<form method="POST" action="isExist"
		cssClass="form-horizontal">
		<div class="panel panel-info"
			style="width: 40%; position: relative;top: 50%; left: 30%; text-align: center;  color: darkblue">
			<div class="panel-heading"
				style="background-color: lightblue; color: darkblue">
				<h3><b>Déjà membre de BoVoyage ?</b></h3> 
			</div>
			<div class="panel-body">
				<label for="email">Adresse Electronique</label> <br />
				<input type="email" class="form-control "
					id="email" style="width: 80%; position:relative; left:10%"
					placeholder="Entrez votre adresse électronique" />
				<br /> <label for="mdp">Mot de passe</label> <br />
				<input type="password" class="form-control" id="mdp"
					style="width: 80%; position:relative; left:10%"
					placeholder="Entrez votre mot de passe" />
				<br />
				<button type="submit" class="btn btn-default ">Entrez dans
					votre espace Client</button>
				
			</div>
		</div><div class="panel panel-info"
			style="width: 40%; position: relative;top: 50%; left: 30%; text-align: center;  color: darkblue">
			<div class="panel-heading"
				style="background-color: lightblue; color: darkblue">
				<h3><b>Devenir membre de BoVoyage ?</b></h3> 
			</div>
			<div class="panel-body">
				Vous voulez avoir accès à nos offres BoVoyage -
				Voyages Nordiques, vous pouvez créer un compte client : <br/>
				<br/>
				<button type="button" class="btn btn-default ">
				<a href="${pageContext.request.contextPath}/client/addclient">Créer
						un compte Client</a>
				</button>
			</div>
		</div>
	</form>
	
	<br />
	<br />
	
	<br />
	<br />

</div>
	<div id="myCarousel" class="carousel slide" data-ride="carousel"
		style="z-index: 1; height: 10%">

		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active">
				<img
					src="${pageContext.request.contextPath}/resources/image/log1.jpg"
					alt="Finlande" style="width: 100%;">
				<div class="carousel-caption"></div>
			</div>
			<div class="item">
				<img
					src="${pageContext.request.contextPath}/resources/image/log2.jpg"
					alt="Norvege" style="width: 100%;">
				<div class="carousel-caption"></div>
			</div>
			<div class="item">
				<img
					src="${pageContext.request.contextPath}/resources/image/log3.jpg"
					alt="Suede" style="width: 100%;">
				<div class="carousel-caption"></div>
			</div>

		</div>
	</div>




	<%@include file="template/footer.html"%>
</body>
</html>