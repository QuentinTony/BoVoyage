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

	<div style="z-index: 3; position: absolute; left: 10%;">
		<div
			style="text-decoration: underlined; color: lightblue; text-align: center; font-family: Calibri; text-shadow: 10px 8px darkblue; font-size: 500%">
			BoVoyage - Voyages Nordiques<br /> le spécialiste au-dela du cercle
			polaire
		</div>
		<br /> <br />


		<div class="panel panel-info"
			style="width: 30%; position: relative; left: 35%; text-align: center; color: darkblue">
			<div class="panel-heading"
				style="background-color: lightblue; color: darkblue">
				<b>Accès à votre espace Administrateur de BoVoyage</b>
			</div>
			<div class="radio">
				<label><input id="radmark" type="radio" name="optradio">Service
					Marketing</label>
			</div>
			<div class="radio">
				<label><input id="raddir" type="radio" name="optradio">Direction
					Générale</label>
			</div>
			<div class="radio">
				<label><input id="radgest" type="radio" name="optradio">Gestionnaire
					Site</label>
			</div>
			<div id="mark" style="display: none">
				<form:form method="POST" action="isexistmarkp"
					commandName="agence" cssClass="form-horizontal" modelAttribute="agence">
					<div class="panel-body">
					
						<label for="email">Adresse Electronique</label> <br />
				<form:input path="mail" type="email" class="form-control "
					id="email" style="width: 80%; position:relative; left:10%"
					placeholder="Entrez votre adresse électronique" />
				<br /> <label for="mdp">Mot de passe</label> <br />
				<form:input path="mdp" type="password" class="form-control" id="mdp"
					style="width: 80%; position:relative; left:10%"
					placeholder="Entrez votre mot de passe" />
				<br />
							<form:hidden path="statut"  class="form-control" id="statutIP"
					style="width: 80%; position:relative; left:10%"/>
						<button  type="submit" class="btn btn-default "
							>Entrez dans votre espace Marketing</button>
					</div>
				</form:form>
			</div>
				<div id="dir" style="display: none">
				<form:form method="POST" action="isexistdirp"
					commandName="agence" cssClass="form-horizontal" modelAttribute="agence">
					<div class="panel-body">
					<label for="email">Adresse Electronique</label> <br />
				<form:input path="mail" type="email" class="form-control "
					id="email" style="width: 80%; position:relative; left:10%"
					placeholder="Entrez votre adresse électronique" />
				<br /> <label for="mdp">Mot de passe</label> <br />
				<form:input path="mdp" type="password" class="form-control" id="mdp"
					style="width: 80%; position:relative; left:10%"
					placeholder="Entrez votre mot de passe" />
				<br />
							<form:hidden path="statut"  class="form-control" id="statutIP2"
					style="width: 80%; position:relative; left:10%"/>
						<button  type="submit" class="btn btn-default "
							>Entrez dans votre espace Direction</button>
						</div>
				</form:form>
			</div>
				<div id="gest" style="display: none">
				<form:form method="POST" action="isexistgestionp"
					commandName="agence" cssClass="form-horizontal" modelAttribute="agence">
					<div class="panel-body">
					<label for="email">Adresse Electronique</label> <br />
				<form:input path="mail" type="email" class="form-control "
					id="email" style="width: 80%; position:relative; left:10%"
					placeholder="Entrez votre adresse électronique" />
				<br /> <label for="mdp">Mot de passe</label> <br />
				<form:input path="mdp" type="password" class="form-control" id="mdp"
					style="width: 80%; position:relative; left:10%"
					placeholder="Entrez votre mot de passe" />
				<br />
							<form:hidden path="statut"  class="form-control" id="statutIP3"
					style="width: 80%; position:relative; left:10%"/>
						<button  type="submit" class="btn btn-default "
							>Entrez dans votre espace
							Gestionnaire</button>
					</div>
				</form:form>
			</div>
		</div>

		<br /> <br />
		<div
			style="width: 30%; position: relative; left: 35%; text-align: center;">
			<a href="${pageContext.request.contextPath}"
				class="btn btn-default btn-lg active" role="button">Revenir à la
				page d'accueil</a>
		</div>
		<br /> <br />
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

	<script>
		$('#radmark').click(function() {
			if ($('#radmark').is(':checked')) {
				document.getElementById('mark').style.display = 'block';
				document.getElementById('dir').style.display = 'none';
				document.getElementById('gest').style.display = 'none';
				document.getElementById('statutIP').value = 'marketing';
			}
		});

		$('#raddir').click(function() {
			if ($('#raddir').is(':checked')) {
				document.getElementById('dir').style.display = 'block';
				document.getElementById('mark').style.display = 'none';
				document.getElementById('gest').style.display = 'none';
				document.getElementById('statutIP2').value = 'direction';
			}
		});
		$('#radgest').click(function() {
			if ($('#radgest').is(':checked')) {
				document.getElementById('gest').style.display = 'block';
				document.getElementById('mark').style.display = 'none';
				document.getElementById('dir').style.display = 'none';
				document.getElementById('statutIP3').value = 'gestion';
			}
		});
	</script>
	<%@include file="template/footer.html"%>
</body>
</html>