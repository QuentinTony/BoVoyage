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
<title>Paiement</title>
</head>
<body>

<%@include file='template/header.html'%>

	<br />
	<br />
	<form:form method="POST" action="submitVirement"
		commandName="compte" cssClass="form-horizontal">




		<div class="panel panel-info"
			style="width: 30%; position: relative; left: 35%; text-align: center; color: darkblue">
			<div class="panel-heading"
				style="background-color: lightblue; color: darkblue" >
				<b>Paiment de votre commande <span class="glyphicon glyphicon-euro"></span></b>
			</div>
			

			<div class="panel-body">
				<label for="numCarte">Numero de carte :</label> <br /> <input
					type="number" class="form-control " id="numCarte"
					style="width: 80%; position: relative; left: 10%"
					placeholder="Entrez votre numero de carte" /> <br /> <label
					for="DateExp">Date expiration</label> <br /> <input type="date"
					class="form-control" id="DateExp"
					style="width: 80%; position: relative; left: 10%"
					placeholder="Entrez votre date d'expiration" /> <br /> <label
					for="CleSecurite">cryptogramme (au dos de la carte)</label> <br /> <input type="number"
					class="form-control" id="CleSecurite"
					style="width: 80%; position: relative; left: 10%"
					placeholder="Entrez votre cle de securité" />
				
				<button  type="submit" class="btn btn-default " >payer</button>
			</div>
		</div>
	</form:form>
	<br />
	<br />
	

</body>
</html>