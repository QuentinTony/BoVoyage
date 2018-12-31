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
			<form:form method="POST" action="deletedestinationp"
				commandName="destination" cssClass="form-horizontal">

				<label for="dest">Destination :</label>
				<br />
				<form:select class="form-control" id="dest" path="id">
					<c:forEach items="${listdestination}" var="list">
						<form:option value="${list.id}"
							label="${list.pays} - ${list.villeArrive}" />
					</c:forEach>
				</form:select>
				<br />
				<br />
				<a href="#modal-dialog" class="btn btn-default-modal-toggle"
					data-toggle="modal" data-modal-type="confirm"
					data-modal-title="Delete Property"
					data-modal-text="Are you sure you want to delete">Supprimer</a>

				<div id="modal-dialog" class="modal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<a href="#" data-dismiss="modal" aria-hidden="true"
									class="close">×</a>
								<h3>êtes vous sur ???</h3>
							</div>
							<div class="modal-body">
								<p>êtes vous sur de vouloir supprimer cette destination?</p>
							</div>
							<div class="modal-footer">
								<button type="submit" id="btnYes" class="btn confirm">Yes</button>
								<button type="button" data-dismiss="modal" aria-hidden="true"
									class="btn secondary">No</button>
							</div>
						</div>
					</div>
				</div>

			</form:form>
		</div>
	</div>

</body>
</html>