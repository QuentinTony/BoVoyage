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
	<div class="panel panel-info"
		style="width: 30%; position: relative; left: 35%; text-align: center; color: darkblue">
		<div class="panel-heading"
			style="background-color: lightblue; color: darkblue">
			<b>Supprimer une destination</b>
		</div>
		<div class="panel-body">
			<form:form  method="POST" action="deletehotelp"
		commandName="hotel" cssClass="form-horizontal">
				<label for="destination">H�tel :</label> <br /> <form:select
					class="form-control" id="hotel" path="id">
					<c:forEach items="${listhotel}"  var="list">
					<form:option value="${list.id}" label="${list.type}* - ${list.type}"/>
						
					</c:forEach>
				</form:select> <br /> <br />
				<button type="submit" class="btn btn-default ">Supprimer</button>

			</form:form>
		</div>
	</div>

</body>
</html>