<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- AJouter la tagLib core de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- ajout de la taglIb form de spring MVC -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
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
<title>BoVoyage-Voyages Nordiques</title>

</head>
<body>
	<%@include file='template/headerAgence.html'%>
	<div class="panel panel-info"
		style="width: 30%; position: relative; left: 35%; text-align: center; color: darkblue">
		<div class="panel-heading"
			style="background-color: lightblue; color: darkblue">
			<b>Ajouter un voyage</b>
		</div>
		<div class="panel-body">
			<form:form method="POST" action="addvoyagep" commandName="voyage" 
				cssClass="form-horizontal">

				<label for="date">Ville de départ :</label>
				<br />
				<form:select class="form-control" id="dest" path="villeDepart">
					<form:option value="Nantes" label="Nantes" />
					<form:option value="Paris" label="Paris" />
					<form:option value="Marseille" label="Marseille" />
					<form:option value="Strasbourg" label="Strasbourg" />
					<form:option value="Lille" label="Lille" />
				</form:select>

				<label for="date">Dates :</label>
				<br />
				<form:input id="date" type="date" path="dateDepart" />
				<br />
				<form:input type="date" path="dateRetour" />
				<br />
				<br />
				<label for="stock">Nombre de places disponible :</label>
				<br />
				<form:input id="stock" type="number" path="stockPassager" />
				<br />
				<br />
				<br />
				<label for="prix">Prix Initial :</label>
				<br />
				<form:input id="prix" type="number" path="prix" />
				<br />
				<br />
				<br />
				<p>
					<label for="range_weight">Remise :  </label>
					 <form:input type="range" path="remise"
						name="num2" class="slider" min="0" max="1" value="0.5"
						step="0.05"/> <span class="slider_label"> </span>
				</p>
				<br />
				<form:select class="form-control" id="dest" path="destination.id">
					<c:forEach items="${listdestination}" var="list">
						<form:option value="${list.id}"
							label="${list.pays} - ${list.villeArrive}" />
					</c:forEach>
				</form:select>
				<br />

							<button type="submit" class="btn btn-default ">Ajouter</button>

			</form:form>
		</div>
	</div>




	<%@include file="template/footer.html"%>

	<script>
		$(function() {
			$('.slider').on('input change', function() {
				$(this).next($('.slider_label')).html(this.value*100  + "%");
			});
			$('.slider_label').each(function() {
				var value = $(this).prev().attr('value');
				$(this).html(value*100 + "%") ;
			});

		})
	</script>
</body>
</html>