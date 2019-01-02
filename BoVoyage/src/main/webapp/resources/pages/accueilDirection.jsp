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
<header><%@include file='template/headerNeutre.html'%></header>
<body>



	<c:forEach var="v" items="${listAgence}">
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading" style="font-size: 150%;">


					<div style="color: darkblue; font-size: 150%; position: absolute;">
						${v.nom} - ${v.prenom}</div>
					
					<div style="color: red; font-size: 150%; text-align: right">${v.statut}</div>

				</div>
				<div class="panel-body">
					<table class="table table-bordered">

						<tr>
							<th>ID</th>
							<th>Nom</th>
							<th>Prenom</th>
							<th>Statut</th>
							<th>Mail</th>
							<th>Actions</th>
						</tr>
						<tr>
							<td>${v.id}</td>
							<td>${v.nom}</td>
							<td>${v.prenom}</td>
							<td>${v.statut}</td>
							<td>${v.mail }</td>
							<td><button>
						<a	href="${pageContext.request.contextPath}/direction/recherche/${v.id}">Voir
							les détails</a>
					</button><button>
						<a	href="${pageContext.request.contextPath}/direction/delete/${v.id}">Supprimer</a>
					</button></td>
						</tr>

					</table>
				</div>

			</div>
		</div>
	</c:forEach>
	<br/>
	<br/>
		<div class="panel panel-info"
		style="width: 30%; position: relative; left: 35%; text-align: center; color: darkblue">
		<div class="panel-heading"
			style="background-color: lightblue; color: darkblue">
			<b>Ajouter un Agent</b>
		</div>
	<div class="panel-body">
			<form:form method="POST" action="/BoVoyage/direction/agence/addagentp" commandName="agent"
				cssClass="form-horizontal" >
				<label for="nom">Nom:</label>
				<br />
				<form:input type="text" placeholder="Entrez un nom"
					id="nom" path="nom" />
				<br />
				<label for="prenom">Prénom:</label>
				<br />
				<form:input type="text" placeholder="Entrez un prénom"
					id="prenom" path="prenom" />
				<br />
				<label for="mail">Mail:</label>
				<br />
				<form:input type="email" placeholder="Entrez un mail"
					id="mail" path="mail" />
				<br />
				<label for="mdp">Mot de passe:</label>
				<br />
				<form:password placeholder="Entrez un mot de passe"
					id="mdp" path="mdp" />
				<br />
				<label for="statut">Statut:</label>
				<br />
				<form:select path="statut">
				<form:option value="direction" >Direction</form:option>
				<form:option value="marketing" >Marketing</form:option>
				<form:option value="gestion" >Gestion</form:option>
				</form:select>
				<button type="submit" class="btn btn-default ">Ajouter</button>

			</form:form>
		</div>
		<div class="panel-body">
			<form>
			<a href="${pageContext.request.contextPath}/j_spring_security_logout">Se deconnecter</a>
				</form></div>
	</div>
</body>
<footer>
	<%@include file='template/footer.html'%>
</footer>

</html>