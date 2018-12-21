<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- AJouter la tagLib core de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- ajout de la taglIb form de spring MVC -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>

<title>Bienvenue dans BoVoyage-Voyages Nordiques</title>

<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/monCSS.css">

<script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.js"></script>

</head>
<body>
<%@include file="header.html"%>

	<div class="row">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Accueil</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Prix <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Inférieur à 100 </a></li>
								<li><a href="#">De 100 à 300 </a></li>
								<li><a href="#">De 300 à 500 </a></li>
								<li><a href="#">Supérieur à 500</a></li>
							</ul></li>
					</ul>
					<form class="navbar-form navbar-left">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>

		<table class="table table-condensed">
			<c:forEach var="voyagelist" items="${voyagelist}">
				<tr>
					<td><img src="${voyagelist.photo}" alt="image"
						class="img-thumbnail">
						 <br />
						  Destination :	${voyagelist.destination} 
						<br /> Prix Initial : ${voyagelist.prix} 
						<br /> Prix Soldé : ${voyagelist.prix}*${voyagelist.remise}

					<button type="button" class="btn btn-default"><a href="href="${pageContext.request.contextPath}/bovoyage/getvoyage?id=${voyagelist.id}">	Voir
							l'offre</a></button></td>
			</c:forEach>
			</tr>
		</table>
		<nav aria-label="...">
			<ul class="pagination pagination-lg">...
			</ul>
		</nav>
	</div>

	<%@include file="footer.html"%>
</body>
</html>