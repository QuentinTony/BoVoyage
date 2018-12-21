<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>Bienvenue dans BoVoyage-Voyages Nordiques</title>

</head>
<body>
	<%@include file="template/header.html"%>

	<div class="row">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Accueil</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Prix <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Inf�rieur � 100 </a></li>
								<li><a href="#">De 100 � 300 </a></li>
								<li><a href="#">De 300 � 500 </a></li>
								<li><a href="#">Sup�rieur � 500</a></li>
							</ul></li>
					</ul>
					<form class="navbar-form navbar-left">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		
<table class="table table-condensed">
<tr>
<td>
<img src="..." alt="image" class="img-thumbnail">
<br/>
Destination : .......
<br/>
Prix Initial : .......
<br/>
Prix Sold� : .......

<button type="button" class="btn btn-default">Voir l'offre</button>
</td>
</tr>
</table>
<nav aria-label="..."><ul class="pagination pagination-lg">...</ul></nav>
	</div>

	<%@include file="template/footer.html"%>
</body>
</html>