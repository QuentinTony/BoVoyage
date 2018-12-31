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
			<b>Ajouter une destination</b>
		</div>
		<div class="panel-body">
			<form:form method="POST" action="adddestinationp"
		commandName="destination" cssClass="form-horizontal" modelAttribute="destination"  enctype="multipart/form-data">
				<label for="continent">Continent :</label> <br /> 
				<form:select class="form-control" id="continent" path="continent" onclick="liste()">
					<form:option value="" label="Sélectionnez un continent"/>
					<form:option value="europe" label="Europe"/>
					<form:option value="asie" label="Asie"/>
					<form:option value="amerique" label="Amérique"/>

				</form:select> <br /> <label id="label" for="paysE;paysAs;paysAm"
					style="display: none;">Pays : </label> <form:select class="form-control"
					id="paysE" style="display: none" path="pays" onclick="liste2()">
					<form:option value="" label="Sélectionnez un pays"/>
					<form:option value="Norvège" label="Norvège"/>
					<form:option value="Finlande" label="Finlande"/>
					<form:option value="Suède" label="Suède"/>
				</form:select> <form:select class="form-control"  path="pays" id="paysAs" style="display: none;"
					onclick="liste3()">
					<form:option value="" label="Sélectionnez un pays"/>
					<form:option value="Sibérie" label="Sibérie"/>
					<form:option value="Chine" label="Chine"/>
				</form:select> <form:select class="form-control" path="pays" id="paysAm" style="display: none;"
					onclick="liste4()">
					<form:option value="" label="Sélectionnez un pays"/>
					<form:option value="Canada" label="Canada"/>
					<form:option value="Alaska" label="Alaska"/>
				</form:select> <br /> <label id="labelville" for="ville" style="display: none">Ville
					: </label> <form:select class="form-control" path="villeArrive" id="villeNorvege"
					style="display: none;" onclick="liste5()">
					<form:option value="" label="Sélectionnez une ville"/>
					<form:option value="Oslo" label="Olso"/>
					<form:option value="Bergen" label="Bergen"/>
				</form:select> <form:select class="form-control"  path="villeArrive" id="villeFinlande"
					style="display: none;" onclick="liste6()">
					<form:option value="" label="Sélectionnez une ville"/>
					<form:option value="Helsinki" label="Helsinki"/>
					<form:option value="village" label="Village du Père Noël"/>
				</form:select> <form:select class="form-control" path="villeArrive" id="villeSuede" style="display: none;"
					onclick="liste7()">
					<form:option value="" label="Sélectionnez une ville"/>
					<form:option value="Stockholm" label="Stockholm"/>
					<form:option value="Uppsala" label="Uppsala"/>
				</form:select> <form:select class="form-control" path="villeArrive" id="villeSibérie"
					style="display: none;" onclick="liste8()">
					<form:option value="" label="Sélectionnez une ville"/>
					<form:option value="Omsk" label="Omsk"/>
					<form:option value="Irkoutsk" label="Irkoutsk"/>
				</form:select> <form:select class="form-control" path="villeArrive" id="villeChine" style="display: none;"
					onclick="liste9()">
					<form:option value="" label="Sélectionnez une ville"/>
					<form:option value="Xuexiang" label="Xuexiang"/>
				</form:select> <form:select class="form-control" path="villeArrive" id="villeCanada"
					style="display: none;" onclick="liste10()">
					<form:option value="" label="Sélectionnez une ville"/>
					<form:option value="Quebec" label="Québec"/>
					<form:option value="Montreal" label="Montréal"/>
				</form:select> <form:select class="form-control" path="villeArrive" id="villeAlaska"
					style="display: none;" onclick="liste11()">
					<form:option value="" label="Sélectionnez une ville"/>
					<form:option value="Homer" label="Homer"/>
					<form:option value="Sitka" label="Sitka"/>
				</form:select> <br />
				<div style="width: 30%; position: relative; left: 35%; text-align: center; color: darkblue">
					<label id="labellat" for="lat" style="display: none">Latitude
						: </label> <form:input type="text" path="latitude" id="lat" name="latitude" 
						style="display: none;" /> 
						<br /> <br />
					<label id="labellong" for="long" style="display: none">Longitude
						: </label> <form:input type="text" path="longitude" id="long" name="longitude"  
						style="display: none" />
				</div>
				<br /> <br /> <label id="labelimage" style="display: none">Insérer
					une image :</label>
				<div class="input-group" id="img" style="display: none">
					<span class="input-group-btn"><br /> <span
						class="btn btn-default btn-file"> Charger une photo <input
							type="file" id="imgInp" name="file"/>
					</span> </span> <img id='img-upload' style="width: 30%" />
				</div>


<br/>
<br/>
				<button type="submit" class="btn btn-default ">Ajouter</button>

			</form:form>
		</div>
	</div>



	<%@include file="template/footer.html"%>

	<script>
		function liste() {
			if (document.getElementById('continent').value == 'europe') {
				document.getElementById('paysE').style.display = 'block';
				document.getElementById('label').style.display = 'block';
			} else {
				document.getElementById('paysE').style.display = 'none';
			}
			if (document.getElementById('continent').value == 'asie') {
				document.getElementById('paysAs').style.display = 'block';
				document.getElementById('label').style.display = 'block';
			} else {
				document.getElementById('paysAs').style.display = 'none';
			}
			if (document.getElementById('continent').value == 'amerique') {
				document.getElementById('paysAm').style.display = 'block';
				document.getElementById('label').style.display = 'block';
			} else {
				document.getElementById('paysAm').style.display = 'none';
			}
		}

		function liste2() {
			if (document.getElementById('paysE').value == 'Norvège') {
				document.getElementById('villeNorvege').style.display = 'block';
				document.getElementById('labelville').style.display = 'block';
			} else {
				document.getElementById('villeNorvege').style.display = 'none';
			}
			if (document.getElementById('paysE').value == 'Finlande') {
				document.getElementById('villeFinlande').style.display = 'block';
				document.getElementById('labelville').style.display = 'block';
			} else {
				document.getElementById('villeFinlande').style.display = 'none';
			}
			if (document.getElementById('paysE').value == 'Suède') {
				document.getElementById('villeSuede').style.display = 'block';
				document.getElementById('labelville').style.display = 'block';
			} else {
				document.getElementById('villeSuede').style.display = 'none';
			}
		}
		function liste3() {
			if (document.getElementById('paysAs').value == 'Sibérie') {
				document.getElementById('villeSibérie').style.display = 'block';
				document.getElementById('labelville').style.display = 'block';
			} else {
				document.getElementById('villeSibérie').style.display = 'none';
			}
			if (document.getElementById('paysAs').value == 'Chine') {
				document.getElementById('villeChine').style.display = 'block';
				document.getElementById('labelville').style.display = 'block';
			} else {
				document.getElementById('villeChine').style.display = 'none';
			}

		}

		function liste4() {
			if (document.getElementById('paysAm').value == 'Canada') {
				document.getElementById('villeCanada').style.display = 'block';
				document.getElementById('labelville').style.display = 'block';
			} else {
				document.getElementById('villeCanada').style.display = 'none';
			}
			if (document.getElementById('paysAm').value == 'Alaska') {
				document.getElementById('villeAlaska').style.display = 'block';
				document.getElementById('labelville').style.display = 'block';
			} else {
				document.getElementById('villeAlaska').style.display = 'none';
			}

		}

		function liste5() {
			switch (document.getElementById('villeNorvege').value) {
			case 'Oslo':
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellong').style.display = 'block';
				document.getElementById('lat').style.display = 'block';
				document.getElementById('long').style.display = 'block';
				document.getElementById('img').style.display = 'block';
				document.getElementById('labelimage').style.display = 'block';
				document.getElementById('lat').value = '59.9138688';
				document.getElementById('long').value = '10.752245';
				break;
			case 'Bergen':
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellong').style.display = 'block';
				document.getElementById('lat').style.display = 'block';
				document.getElementById('long').style.display = 'block';
				document.getElementById('img').style.display = 'block';
				document.getElementById('labelimage').style.display = 'block';
				document.getElementById('lat').value = '60.391262';
				document.getElementById('long').value = '5.32205440';
				break;
			default:
				document.getElementById('labellat').style.display = 'none';
				document.getElementById('labellong').style.display = 'none';
				document.getElementById('lat').style.display = 'none';
				document.getElementById('long').style.display = 'none';
				document.getElementById('img').style.display = 'none';
				document.getElementById('labelimage').style.display = 'none';
				break;
			}

		}

		function liste6() {
			switch (document.getElementById('villeFinlande').value) {
			case 'Helsinki':
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellong').style.display = 'block';
				document.getElementById('lat').style.display = 'block';
				document.getElementById('long').style.display = 'block';
				document.getElementById('img').style.display = 'block';
				document.getElementById('labelimage').style.display = 'block';
				document.getElementById('lat').value = '60.16985';
				document.getElementById('long').value = '24.93837';
				break;
			case 'village':
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellong').style.display = 'block';
				document.getElementById('lat').style.display = 'block';
				document.getElementById('long').style.display = 'block';
				document.getElementById('img').style.display = 'block';
				document.getElementById('labelimage').style.display = 'block';
				document.getElementById('lat').value = '66.5436144';
				document.getElementById('long').value = '25.8471973';
				break;
			default:
				document.getElementById('labellat').style.display = 'none';
				document.getElementById('labellong').style.display = 'none';
				document.getElementById('lat').style.display = 'none';
				document.getElementById('long').style.display = 'none';
				break;
			}
		}
		function liste7() {
			switch (document.getElementById('villeSuede').value) {
			case 'Stockholm':
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellong').style.display = 'block';
				document.getElementById('lat').style.display = 'block';
				document.getElementById('long').style.display = 'block';
				document.getElementById('img').style.display = 'block';
				document.getElementById('labelimage').style.display = 'block';
				document.getElementById('lat').value = '59.3293234';
				document.getElementById('long').value = '18.06858080';
				break;
			case 'Uppsala':
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellong').style.display = 'block';
				document.getElementById('lat').style.display = 'block';
				document.getElementById('long').style.display = 'block';
				document.getElementById('img').style.display = 'block';
				document.getElementById('labelimage').style.display = 'block';
				document.getElementById('lat').value = '59.85856';
				document.getElementById('long').value = '17.6389266';
				break;
			default:
				document.getElementById('labellat').style.display = 'none';
				document.getElementById('labellong').style.display = 'none';
				document.getElementById('lat').style.display = 'none';
				document.getElementById('long').style.display = 'none';
				break;
			}
		}

		function liste8() {
			switch (document.getElementById('villeSibérie').value) {
			case 'Omsk':
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellong').style.display = 'block';
				document.getElementById('lat').style.display = 'block';
				document.getElementById('long').style.display = 'block';
				document.getElementById('img').style.display = 'block';
				document.getElementById('labelimage').style.display = 'block';
				document.getElementById('lat').value = '54.98848';
				document.getElementById('long').value = '73.324236';
				break;
			case 'Irkoutsk':
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellong').style.display = 'block';
				document.getElementById('lat').style.display = 'block';
				document.getElementById('long').style.display = 'block';
				document.getElementById('img').style.display = 'block';
				document.getElementById('labelimage').style.display = 'block';
				document.getElementById('lat').value = '52.28697';
				document.getElementById('long').value = '104.3050';
				break;
			default:
				document.getElementById('labellat').style.display = 'none';
				document.getElementById('labellong').style.display = 'none';
				document.getElementById('lat').style.display = 'none';
				document.getElementById('long').style.display = 'none';
				break;
			}
		}

		function liste9() {
			switch (document.getElementById('villeChine').value) {
			case 'Xuexiang':
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellong').style.display = 'block';
				document.getElementById('lat').style.display = 'block';
				document.getElementById('long').style.display = 'block';
				document.getElementById('img').style.display = 'block';
				document.getElementById('labelimage').style.display = 'block';
				document.getElementById('lat').value = '29.8237369';
				document.getElementById('long').value = '91.488037';
				break;

			default:
				document.getElementById('labellat').style.display = 'none';
				document.getElementById('labellong').style.display = 'none';
				document.getElementById('lat').style.display = 'none';
				document.getElementById('long').style.display = 'none';
				break;
			}

		}
		function liste10() {
			switch (document.getElementById('villeCanada').value) {
			case 'Quebec':
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellong').style.display = 'block';
				document.getElementById('lat').style.display = 'block';
				document.getElementById('long').style.display = 'block';
				document.getElementById('img').style.display = 'block';
				document.getElementById('labelimage').style.display = 'block';
				document.getElementById('lat').value = '52.939915';
				document.getElementById('long').value = '-73.5491361';
				break;
			case 'Montreal':
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellong').style.display = 'block';
				document.getElementById('lat').style.display = 'block';
				document.getElementById('long').style.display = 'block';
				document.getElementById('img').style.display = 'block';
				document.getElementById('labelimage').style.display = 'block';
				document.getElementById('lat').value = '45.5016889';
				document.getElementById('long').value = '-73.5672559';
				break;
			default:
				document.getElementById('labellat').style.display = 'none';
				document.getElementById('labellong').style.display = 'none';
				document.getElementById('lat').style.display = 'none';
				document.getElementById('long').style.display = 'none';
				break;
			}
		}
		function liste11() {
			switch (document.getElementById('villeAlaska').value) {
			case 'Homer':
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellong').style.display = 'block';
				document.getElementById('lat').style.display = 'block';
				document.getElementById('long').style.display = 'block';
				document.getElementById('img').style.display = 'block';
				document.getElementById('labelimage').style.display = 'block';
				document.getElementById('lat').value = '59.642500';
				document.getElementById('long').value = '-151.5483';
				break;
			case 'Sitka':
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellong').style.display = 'block';
				document.getElementById('lat').style.display = 'block';
				document.getElementById('long').style.display = 'block';
				document.getElementById('img').style.display = 'block';
				document.getElementById('labelimage').style.display = 'block';
				document.getElementById('lat').value = '57.0530556';
				document.getElementById('long').value = '-135.33000';
				break;
			default:
				document.getElementById('labellat').style.display = 'none';
				document.getElementById('labellong').style.display = 'none';
				document.getElementById('lat').style.display = 'none';
				document.getElementById('long').style.display = 'none';
				break;
			}
		}

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