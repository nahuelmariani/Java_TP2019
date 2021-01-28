<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio - Club</title>
</head>
<body>
	<div align="center">
		<form action="Signin" method="post">
			<h1>Iniciar sesi�n</h1>
			<label for="inputEmail">Mail</label><br>
			<input id="inputEmail" name="email" placeholder="Ingrese mail" required autofocus type="email"><br>
			<br>
			<label for="inputPassword">Contrase�a</label><br>
			<input id="inputPassword" name="password" placeholder="Ingrese contrase�a" required type="password"><br>
			<p>
				<button type="submit" name="action" value="ingresar">Ingresar</button>
			</p>
			<p class="text-center" style="color: red">${message}</p>
			<c:remove var="message" scope="session"/>
			<br>
		</form>
		<form action="Signin" method="post">
			<h5>Si todav�a no tienes usuario, puedes registrarte.</h5>
			<button type="submit" name="action" value="registrar">Registrarse</button>
		</form>
	</div>
</body>
</html>