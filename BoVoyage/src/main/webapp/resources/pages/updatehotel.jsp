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
<title>Update hotel</title>
</head>
<body>
	<%@include file='template/headerAgence.html'%>

	<!-- PARTIE modif -->

	<div class="panel panel-info"
		style="width: 30%; position: relative; left: 35%; text-align: center; color: darkblue">
		<div class="panel-heading"
			style="background-color: lightblue; color: darkblue">
			<b>Ajouter un hôtel</b>
		</div>
		<div class="panel-body">
			<form:form method="POST" action="updatehotelp" commandName="hotel"
				cssClass="form-horizontal" enctype="multipart/form-data"
				modelAttribute="hotel">
				<div class="form-group">
					<label for="idID" class="col-sm-2 control-label">ID</label>
					<div class="col-sm-10">
						<form:input type="number" cssClass="form-control" id="idID"
							placeholder="ID" path="id" required="required"/>
					</div>
				</div>
				<label for="nom">Nom:</label>
				<br />
				<form:input type="text" placeholder="Entrez un nom" id="nom"
					path="type" required="required"/>
				<br />
				<br />
				<label for="categorie">Catégorie :</label>
				<br />
				<form:select class="form-control" path="categorie" id="categorie">
					<option>Sélectionnez une catégorie</option>
					<form:option value="1" label="1 *" />
					<form:option value="2" label="2**" />
					<form:option value="3" label="3***" />
					<form:option value="4" label="4****" />
					<form:option value="5" label="5*****" />
				</form:select>
				<br />
				<label for="hebergement">Hébergement :</label>
				<br />
				<form:select class="form-control" path="hebergement"
					id="hebergement">
					<option>Sélectionnez une catégorie</option>
					<form:option value="complet" label="Pension complète" />
					<form:option value="demi" label="Demi pension" />
					<form:option value="petit" label="Petit-Déjeuner" />
					<form:option value="seul" label="Hébergement seul" />
				</form:select>
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
					<label id="labelimage">Insérer une image :</label>
					<div class="input-group" id="img">
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
<%@include file="template/footer.html"%>
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