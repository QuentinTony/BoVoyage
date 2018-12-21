<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vous entrez dans l'espace Administrateur de BoVoyage</title>
</head>
<body>

<%@include file="template/header.html"%>
<br/><br/>
<form>
  <div class="form-group">
    <label for="email">Adresse Electronique</label>
    <input type="email" class="form-control" id="email" placeholder="Entrez votre adresse électronique">
  </div>
  <div class="form-group">
    <label for="mdp">Mot de passe</label>
    <input type="password" class="form-control" id="mdp" placeholder="Entrez votre mot de passe">
  </div>
   <button type="submit" class="btn btn-default">Entrez dans votre espace Administrateur</button>
</form>
<br/><br/>
<a href="accueil.jsp" class="btn btn-default btn-lg active" role="button">Revenir à la page d'accueil</a>
<br/><br/>
<%@include file="template/footer.html"%>

</body>
</html>