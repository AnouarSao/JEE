<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification auteur</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/style.css" />" />
</head>
<body>
	<c:import url="/WEB-INF/menu.jsp" />

	<div class="view">
		<form method="post" action="<c:url value="/modifierAuteur"><c:param name="id" value="${ auteur.id }" /></c:url>">
		
			<fieldset>
				<legend>Modifier un auteur</legend>
				
				<label for="prenomAuteur">Prénom</label>
				<input type="text" id="prenomAuteur" name="prenomAuteur" value="<c:out value="${ auteur.prenom }" />" size="20" />
				<br/>
				
				<label for="nomAuteur">Nom</label>
				<input type="text" id="nomAuteur" name="nomAuteur" value="<c:out value="${ auteur.nom }" />" size="20" />
				<br/>
				
				<label for="telephoneAuteur">Téléphone</label>
				<input type="text" id="telephoneAuteur" name="telephoneAuteur" value="<c:out value="${ auteur.telephone }" />" size="10" />
				<br/>
				
				<label for="emailAuteur">Email</label>
				<input type="email" id="emailAuteur" name="emailAuteur" value="<c:out value="${ auteur.email }" />" size="60" />
				<br/>
			
			</fieldset>
		
			<input type="submit" value="Valider" />
			<input type="reset" value="Remettre à zéro" />
		</form>
	</div>
</body>
</html>