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
			<b>Ajouter une prestation</b>
		</div>
		<div class="panel-body">
			<form:form method="POST" action="addprestationp"
				commandName="prestation" cssClass="form-horizontal"
				enctype="multipart/form-data">
				<label for="type">Type de prestation:</label>
				<br />
				<form:input type="text" placeholder="Entrez un type de prestation"
					id="type" path="type" />
				<br />
				<br />
				<br />
				<label for="prix">Prix /Jour /personne:</label>
				<br />
				<form:input type="number" path="prix" placeholder="Entrez un prix"
					id="prix" />
				<br />
				<br />
				<label for="prix">Description:</label>
				<br />
				<form:textarea path="description" rows="5" cols="50"></form:textarea>
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
				<div
					style="width: 30%; position: relative; left: 35%; text-align: center; color: darkblue">
					<br /> <br />
					<form:label id="labelimage" style="display: block" path="photo"
						enctype="multipart/form-data">Insérer
					une image :</form:label>
					<div class="input-group" id="img" style="display: block">
						<span class="input-group-btn"><br /> <span
							class="btn btn-default btn-file"> Charger une photo <input
								type="file" id="imgInp" name="file" />
						</span> </span> <img id='img-upload' style="width: 30%" />
					</div>
				</div>
				<br />
				<br />
				<button type="submit" class="btn btn-default ">Ajouter</button>

			</form:form>
		</div>
	</div>
</body>
</html>