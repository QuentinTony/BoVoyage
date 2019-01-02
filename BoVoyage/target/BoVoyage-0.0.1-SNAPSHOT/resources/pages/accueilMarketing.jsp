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



	<c:forEach var="v" items="${listclient}">
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading" style="font-size: 150%;">


					<div style="color: darkblue; font-size: 150%; position: absolute;">
						${v.nom} - ${v.prenom}</div>
					
					<div style="color: red; font-size: 150%; text-align: right">${v.telephone}</div>

				</div>
				<div class="panel-body">
					<table class="table table-bordered">

						<tr>
							<th>ID</th>
							<th>Nom</th>
							<th>Prenom</th>
							<th>Date de naissance</th>
							<th>Mail</th>
							<th>Telephone</th>
						</tr>
						<tr>
							<td>${v.id}</td>
							<td>${v.nom}</td>
							<td>${v.prenom}</td>
							<td>${v.dn}</td>
							<td>${v.mail}</td>
							<td>${v.telephone}</td>
						</tr>

					</table>
				</div>

			</div>
		</div>
	</c:forEach>
	<br/>
	<br/>
	
</body>
<footer>
	<%@include file='template/footer.html'%>
</footer>

</html>