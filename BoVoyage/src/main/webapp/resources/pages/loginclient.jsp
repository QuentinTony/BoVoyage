<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- AJouter la tagLib core de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- ajout de la taglIb form de spring MVC -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vous entrez dans l'espace Client de BoVoyage</title>
<link rel="stylesheet" href="ressources/css/bootstrap.css">
<link rel="stylesheet" href="ressources/css/monCSS.css">

<script type="text/javascript" src="ressources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="ressources/js/bootstrap.js"></script>
</head>
<body>

<form>
  <div class="form-group">
    <label for="email">Adresse Electronique</label>
    <input type="email" class="form-control" id="email" placeholder="Entrez votre adresse électronique">
  </div>
  <div class="form-group">
    <label for="mdp">Mot de passe</label>
    <input type="password" class="form-control" id="mdp" placeholder="Entrez votre mot de passe">
  </div>
   <button type="submit" class="btn btn-default">Entrez dans votre espace Client</button>
</form>
<br/><br/>
<a href="accueil.jsp" class="btn btn-default btn-lg active" role="button">Revenir à la page d'accueil</a>
<br/><br/>

</body>
</html>