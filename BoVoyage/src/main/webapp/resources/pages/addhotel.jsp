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
	<%@include file='template/header.html'%>

	<!-- PARTIE AJOUT -->

	<div class="panel panel-info"
		style="width: 30%; position: relative; left: 35%; text-align: center; color: darkblue">
		<div class="panel-heading"
			style="background-color: lightblue; color: darkblue">
			<b>Ajouter un hôtel</b>
		</div>
		<div class="panel-body">
			<form>

				<label for="nom">Nom:</label> <br /> <input type="text"
					placeholder="Entrez un nom" id="nom" /> <br /> <br /> <label
					for="categorie">Catégorie :</label> <br /> <select
					class="form-control" id="categorie">
					<option>Sélectionnez une catégorie</option>
					<option value="1">1 *</option>
					<option value="2">2**</option>
					<option value="3">3***</option>
					<option value="3">4****</option>
					<option value="3">5*****</option>
				</select> <br /> <label for="hebergement">Hébergement :</label> <br /> <select
					class="form-control" id="hebergement">
					<option>Sélectionnez une catégorie</option>
					<option value="complet">Pension complète</option>
					<option value="demi">Demi pension</option>
					<option value="petit">Petit-Déjeuner</option>
					<option value="seul">Hébergement seul</option>
				</select> <br /> <label for="prix">Prix /Jour /personne:</label> <br /> <input
					type="number" placeholder="Entrez un prix" id="prix" /> <br /> <br />
				<label for="prix">Description:</label> <br />
				<textarea rows="5" cols="50"></textarea>
				<br /> <br />
				<div
					style="width: 30%; position: relative; left: 35%; text-align: center; color: darkblue">
					<label id="labelimage">Insérer une image :</label>
					<div class="input-group" id="img">
						<span class="input-group-btn"><br /> <span
							class="btn btn-default btn-file"> Charger une photo <input
								type="file" id="imgInp">
						</span> </span> <img id='img-upload' style="width: 30%" />
					</div>
				</div>
				<br /> <br />
				<button type="submit" class="btn btn-default ">Ajouter</button>

			</form>
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