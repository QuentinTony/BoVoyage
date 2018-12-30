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
	<form:form method="POST" action="/BoVoyage/direction/recherchep" commandName="agent"
		cssClass="form-horizontal">


		
			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel-heading" style="font-size: 150%;">


						<div style="color: darkblue; font-size: 150%; position: absolute;">
							${agent.nom} - ${agent.prenom}</div>

						<div style="color: red; font-size: 150%; text-align: right">${agent.statut}</div>

					</div>
					<div class="panel-body">
						<table class="table table-bordered">

							<tr>
								<th>Nom</th>
								<th>Prenom</th>
								<th>Statut</th>
								<th>Mail</th>
								<th>Modifier</th>
							</tr>
							<tr>

								<td><form:input type="text" path="nom" id="nom"
										value="${agent.nom}" /></td>

								<td><form:input type="text" path="prenom" id="prenom"
										value="${agent.prenom}" /></td>
								<td><form:input type="text" path="statut" id="statut"
										value="${agent.statut}" /></td>
								<td><form:input type="text" path="mail" id="mail"
										value="${agent.mail}" /></td>

								<td><button type="submit">Modifier</button></td>
							</tr>
						</table>
					</div>
					<form:hidden path="id" id="id" value="${agent.id}" />
					<form:hidden  path="mdp" id="mdp" value="${agent.mdp}" />
				</div>
			</div>
	
	</form:form>
</body>
<footer>
	<%@include file='template/footer.html'%>
</footer>

</html>