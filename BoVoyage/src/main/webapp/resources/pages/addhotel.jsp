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
			<b>Ajouter un h�tel</b>
		</div>
		<div class="panel-body">
			<form:form method="POST" action="addhotelnp" commandName="addHotel"
				cssClass="form-horizontal">
				<label for="nom">Nom:</label>
				<br />
				<form:input type="text" placeholder="Entrez un nom" id="nom"  path="type"/>
				<br />
				<br />
				<label for="categorie">Cat�gorie :</label>
				<br />
				<form:select class="form-control" path="categorie" id="categorie">
					<option>S�lectionnez une cat�gorie</option>
					<option value="1">1 *</option>
					<option value="2">2**</option>
					<option value="3">3***</option>
					<option value="3">4****</option>
					<option value="3">5*****</option>
				</form:select>
				<br />
				<label for="hebergement">H�bergement :</label>
				<br />
				<form:select class="form-control" path="hebergement" id="hebergement">
					<option>S�lectionnez une cat�gorie</option>
					<option value="complet">Pension compl�te</option>
					<option value="demi">Demi pension</option>
					<option value="petit">Petit-D�jeuner</option>
					<option value="seul">H�bergement seul</option>
				</form:select>
				<br />
				<label for="prix">Prix /Jour /personne:</label>
				<br />
				<form:input type="number" path="prix" placeholder="Entrez un prix" id="prix" />
				<br />
				<br />
				<label for="prix">Description:</label>
				<br />
				<form:textarea path="description" rows="5" cols="50"></form:textarea>
				<br />
				<br />
				<div
					style="width: 30%; position: relative; left: 35%; text-align: center; color: darkblue">
					<label id="labelimage">Ins�rer une image :</label>
					<div class="input-group" id="img">
						<span class="input-group-btn"><br /> <span
							class="btn btn-default btn-file"> Charger une photo <form:input path="photo"
								type="file" id="imgInp"/>
						</span> </span> <img id='img-upload' style="width: 30%" />
					</div>
				</div>
				<br />
				<br />
				<button type="submit" class="btn btn-default ">Ajouter</button>

			</form:form>
		</div>
	</div>

	<script>
		$(document).ready(
				function() {
					$(document).on(
							'change',
							'.btn-file :file',
							function() {
								var input = $(this), label = input.val()
										.replace(/\\/g, '/')
										.replace(/.*\//, '');
								input.trigger('fileselect', [ label ]);
							});

					$('.btn-file :file').on(
							'fileselect',
							function(event, label) {

								var input = $(this).parents('.input-group')
										.find(':text'), log = label;

								if (input.length) {
									input.val(log);
								} else {
									if (log)
										alert(log);
								}

							});
					function readURL(input) {
						if (input.files && input.files[0]) {
							var reader = new FileReader();

							reader.onload = function(e) {
								$('#img-upload').attr('src', e.target.result);
							}

							reader.readAsDataURL(input.files[0]);
						}
					}

					$("#imgInp").change(function() {
						readURL(this);
					});
				});
	</script>
</body>
</html>