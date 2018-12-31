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
<title>Update prestation</title>
</head>
<body>

	<%@include file='template/headerAgence.html'%>
	<!-- PARTIE modifier -->

	<div class="panel panel-info"
		style="width: 30%; position: relative; left: 35%; text-align: center; color: darkblue">
		<div class="panel-heading"
			style="background-color: lightblue; color: darkblue">
			<b>Modifier une prestation</b>
		</div>
		<div class="panel-body">
			<form:form method="POST" action="updateprestationp"
				commandName="prestation" cssClass="form-horizontal"
				modelAttribute="prestation" enctype="multipart/form-data">
				<div class="form-group">
					<label for="idID" class="col-sm-2 control-label">ID</label>
					<div class="col-sm-10">
						<form:input type="text" cssClass="form-control" id="idID"
							placeholder="ID" path="id" />
					</div>
				</div>
				<label for="type">Type de prestation:</label>
				<br />
				<form:input type="text" placeholder="Entrez un type de prestation"
					id="type" path="type" required="required" />
				<br />
				<br />
				<br />
				<label for="prix">Prix /Jour /personne:</label>
				<br />
				<form:input type="number" path="prix" placeholder="Entrez un prix"
					id="prix" required="required" />
				<br />
				<br />
				<label for="prix">Description:</label>
				<br />
				<form:textarea path="description" rows="5" cols="50"
					required="required"></form:textarea>
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
					<br /> <br /> <label id="labelimage">Insérer une image :</label>
					<div class="input-group" id="img">
						<span class="input-group-btn"><br /> <span
							class="btn btn-default btn-file"> Charger une photo <input
								type="file" id="imgInp" name="file" />
						</span> </span> <img id='img-upload' style="width: 30%" />
					</div>
				</div>
				<br />
				<br />
				<button type="submit" class="btn btn-default ">Modifier</button>

			</form:form>
		</div>
	</div>
	<%@include file="template/footer.html"%>
</body>
</html>