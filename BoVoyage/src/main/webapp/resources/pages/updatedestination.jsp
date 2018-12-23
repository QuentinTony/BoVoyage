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

	<form:form method="POST" action="updatedestinationp"
		commandName="updateDestination" cssClass="form-horizontal">
		<div class="form-group">
			<label for="idID" class="col-sm-2 control-label">ID</label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control" id="idID"
					placeholder="ID" path="id" />
			</div>
		</div>
		<label for="continent">Continent :</label>
		<br />
		<select class="form-control" id="continent" onclick="liste()">
			<option>Sélectionnez un continent</option>
			<option value="europe">Europe</option>
			<option value="asie">Asie</option>
			<option value="amerique">Amérique</option>

		</select>
		<br />
		<label id="label" for="paysE;paysAs;paysAm" style="display: none">Pays
			: </label>
		<select class="form-control" id="paysE" style="display: none"
			onclick="liste2()">
			<option>Sélectionnez un pays</option>
			<option value="Norvège">Norvège</option>
			<option value="Finlande">Finlande</option>
			<option value="Suède">Suède</option>
		</select>
		<select class="form-control" id="paysAs" style="display: none;"
			onclick="liste3()">
			<option>Sélectionnez un pays</option>
			<option value="Sibérie">Sibérie</option>
			<option value="Chine">Chine</option>
		</select>
		<select class="form-control" id="paysAm" style="display: none;"
			onclick="liste4()">
			<option>Sélectionnez un pays</option>
			<option value="Canada">Canada</option>
			<option value="Alaska">Alaska</option>
		</select>
		<br />
		<label id="labelville" for="ville" style="display: none">Ville
			: </label>
		<select class="form-control" id="villeNorvege" style="display: none;"
			onclick="liste5()">
			<option>Sélectionnez une ville</option>
			<option value="Oslo">Olso</option>
			<option value="Bergen">Bergen</option>
		</select>
		<select class="form-control" id="villeFinlande" style="display: none;"
			onclick="liste6()">
			<option>Sélectionnez une ville</option>
			<option value="Helsinki">Helsinki</option>
			<option value="village">Village du Père Noël</option>
		</select>
		<select class="form-control" id="villeSuede" style="display: none;"
			onclick="liste7()">
			<option>Sélectionnez une ville</option>
			<option value=Stockholm>Stockholm</option>
			<option value="Uppsala">Uppsala</option>
		</select>
		<select class="form-control" id="villeSibérie" style="display: none;"
			onclick="liste8()">
			<option>Sélectionnez une ville</option>
			<option value="Omsk">Omsk</option>
			<option value="Irkoutsk">Irkoutsk</option>
		</select>
		<select class="form-control" id="villeChine" style="display: none;"
			onclick="liste9()">
			<option>Sélectionnez une ville</option>
			<option value="Xuexiang">Xuexiang</option>
		</select>
		<select class="form-control" id="villeCanada" style="display: none;"
			onclick="liste10()">
			<option>Sélectionnez une ville</option>
			<option value="Quebec">Québec</option>
			<option value="Montreal">Montréal</option>
		</select>
		<select class="form-control" id="villeAlaska" style="display: none;"
			onclick="liste11()">
			<option>Sélectionnez une ville</option>
			<option value="Homer">Homer</option>
			<option value="Sitka">Sitka</option>
		</select>
		<br />
		<div
			style="width: 30%; position: relative; left: 35%; text-align: center; color: darkblue">
			<label id="labellat" for="lat" style="display: none">Latitude
				: </label> <input type="number" id="lat" name="latitude" placeholder="0"
				style="display: none" style="width: 30%;"> <br /> <br /> <label
				id="labellong" for="long" style="display: none">Longitude :
			</label> <input type="number" id="long" name="longitude" placeholder="0"
				style="display: none">
		</div>
		<br />
		<br />
		<label id="labelimage" style="display: none">Insérer une image
			:</label>
		<div class="input-group" id="img" style="display: none">
			<span class="input-group-btn"><br /> <span
				class="btn btn-default btn-file"> Charger une photo <input
					type="file" id="imgInp">
			</span> </span> <img id='img-upload' style="width: 30%" />
		</div>


		<br />
		<br />
		<button type="submit" class="btn btn-default ">Ajouter</button>

	</form:form>


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
				document.getElementById('lat').placeholder = '59.9138688';
				document.getElementById('long').placeholder = '10.752245';
				break;
			case 'Bergen':
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellong').style.display = 'block';
				document.getElementById('lat').style.display = 'block';
				document.getElementById('long').style.display = 'block';
				document.getElementById('img').style.display = 'block';
				document.getElementById('labelimage').style.display = 'block';
				document.getElementById('lat').placeholder = '60.391262';
				document.getElementById('long').placeholder = '5.32205440';
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
				document.getElementById('lat').placeholder = '60.16985';
				document.getElementById('long').placeholder = '24.93837';
				break;
			case 'village':
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellong').style.display = 'block';
				document.getElementById('lat').style.display = 'block';
				document.getElementById('long').style.display = 'block';
				document.getElementById('img').style.display = 'block';
				document.getElementById('labelimage').style.display = 'block';
				document.getElementById('lat').placeholder = '66.5436144';
				document.getElementById('long').placeholder = '25.8471973';
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
				document.getElementById('lat').placeholder = '59.3293234';
				document.getElementById('long').placeholder = '18.06858080';
				break;
			case 'Uppsala':
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellong').style.display = 'block';
				document.getElementById('lat').style.display = 'block';
				document.getElementById('long').style.display = 'block';
				document.getElementById('img').style.display = 'block';
				document.getElementById('labelimage').style.display = 'block';
				document.getElementById('lat').placeholder = '59.85856';
				document.getElementById('long').placeholder = '17.6389266';
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
				document.getElementById('lat').placeholder = '54.98848';
				document.getElementById('long').placeholder = '73.324236';
				break;
			case 'Irkoutsk':
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellong').style.display = 'block';
				document.getElementById('lat').style.display = 'block';
				document.getElementById('long').style.display = 'block';
				document.getElementById('img').style.display = 'block';
				document.getElementById('labelimage').style.display = 'block';
				document.getElementById('lat').placeholder = '52.28697';
				document.getElementById('long').placeholder = '104.3050';
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
				document.getElementById('lat').placeholder = '29.8237369';
				document.getElementById('long').placeholder = '91.488037';
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
				document.getElementById('lat').placeholder = '52.939915';
				document.getElementById('long').placeholder = '-73.5491361';
				break;
			case 'Montreal':
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellong').style.display = 'block';
				document.getElementById('lat').style.display = 'block';
				document.getElementById('long').style.display = 'block';
				document.getElementById('img').style.display = 'block';
				document.getElementById('labelimage').style.display = 'block';
				document.getElementById('lat').placeholder = '45.5016889';
				document.getElementById('long').placeholder = '-73.5672559';
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
				document.getElementById('lat').placeholder = '59.642500';
				document.getElementById('long').placeholder = '-151.5483';
				break;
			case 'Sitka':
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellat').style.display = 'block';
				document.getElementById('labellong').style.display = 'block';
				document.getElementById('lat').style.display = 'block';
				document.getElementById('long').style.display = 'block';
				document.getElementById('img').style.display = 'block';
				document.getElementById('labelimage').style.display = 'block';
				document.getElementById('lat').placeholder = '57.0530556';
				document.getElementById('long').placeholder = '-135.33000';
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