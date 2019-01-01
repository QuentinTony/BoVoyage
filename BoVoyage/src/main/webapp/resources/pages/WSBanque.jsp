<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- AJouter la tagLib core de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- ajout de la taglIb form de spring MVC -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- ajouter la taglib fmt de jstl -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

<div style="display: block; position: relative; top: 300px; width: 400px;" > <img alt="paypal" src="${pageContext.request.contextPath}/resources/image/paypal-tunisie.png" style="width: 400px; height: 200px;"> <img alt="card" src="${pageContext.request.contextPath}/resources/image/mastercard.png" style="width: 400px; height: 200px;"></div>

	<br />
	<br />
	<form:form method="POST" action="submitVirement" commandName="compte"
		cssClass="form-horizontal" modelAttribute="compte">




		<div class="panel panel-info"
			style="width: 30%; position: relative; left: 35%; text-align: center; color: darkblue">
			<div class="panel-heading"
				style="background-color: lightblue; color: darkblue">
				<b>Paiment de votre commande <span
					class="glyphicon glyphicon-euro"></span></b>
			</div>


			<div class="panel-body">
				<label for="numCarte">Numero de carte :</label> <br />
				<form:input type="number" class="form-control " id="numCarte"
					cssStyle="width: 80%; position: relative; left: 10%"
					placeholder="Entrez votre numero de carte" required="required"
					path="numeroCarte" />

				<br /> <label for="DateExp">Date expiration</label> <br />
				<form:input type="date" class="form-control" id="DateExp"
					cssStyle="width: 80%; position: relative; left: 10%"
					placeholder="Entrez votre date d'expiration" path="dateExperiation"
					required="required" />
				<fmt:formatDate pattern="yyyy-MM" value="${dSomme }" />
				<br /> <label for="CleSecurite">cryptogramme (au dos de la
					carte)</label> <br />
				<form:input type="number" class="form-control" id="CleSecurite"
					cssStyle="width: 80%; position: relative; left: 10%"
					placeholder="Entrez votre cle de securité" required="required"
					path="cleSecurite" />
				<br /> <label for="Somme">Somme</label> <br /> <input
					type="number" class="form-control" id="Somme"
					style="width: 80%; position: relative; left: 10%"
					placeholder="Entrez la somme" required="required" name="dSomme" />

				<button type="submit" class="btn btn-default ">payer</button>
			</div>
		</div>
	</form:form>
	<br />
	<br />


</body>
</html>