<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- AJouter la tagLib core de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- ajout de la taglIb form de spring MVC -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>BoVoyage-Voyages Nordiques</title>
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

	<!-- PARTIE AJOUT -->

	<div class="panel panel-info"
		style="width: 30%; position: relative; left: 35%; text-align: center; color: darkblue">
		<div class="panel-heading"
			style="background-color: lightblue; color: darkblue">
			<b>Ajouter un véhicule</b>
		</div>
		<div class="panel-body">
			<form:form method="POST" action="addvehiculep" commandName="vehicule"
				cssClass="form-horizontal" enctype="multipart/form-data" modelAttribute="vehicule">
				<label for="type">Type de véhicule:</label>
				<br />
				<form:input type="text" placeholder="Entrez un type de véhicule"
					id="type" path="type" required="required" />
				<br />
				<br />
				<br />
				<label for="prix">Prix /Jour /personne:</label>
				<br />
				<form:input type="number" path="prix" placeholder="Entrez un prix"
					id="prix" required="required"/>
				<br />
				<br />
				<div
					style="width: 30%; position: relative; left: 35%; text-align: center; color: darkblue">
					<br /> <br />
					<label id="labelimage" >Insérer
					une image :</label>
				<div class="input-group" id="img" >
					<span class="input-group-btn"><br /> <span
						class="btn btn-default btn-file"> Charger une photo <input
							type="file" id="imgInp" name="file"/>
					</span> </span> <img id='img-upload' style="width: 30%" />
					</div>
				</div>
				<br />
				<br />
				<form:select class="form-control" id="dest" path="destination.id">
					<c:forEach items="${listdest}" var="list">
						<form:option value="${list.id}"
							label="${list.pays} - ${list.villeArrive}" />
					</c:forEach>
				</form:select>
				<br />
				<br />
				<button type="submit" class="btn btn-default ">Ajouter</button>

			</form:form>
		</div>
	</div>
	<%@include file="template/footer.html"%>
</body>
</html>