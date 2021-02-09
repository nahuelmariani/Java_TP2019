<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Instalacion"%>
<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Registrar usuario - Club</title>
	<%
		System.out.println("Index -> Registrar usuario");
	%>
</head>

<body>
	<form action="Usuarios" method="post">
		<h3>Registrar nuevo usuario:</h3>
		
		<label for="inputNombre">Nombre:</label>
		<input id="inputNombre" name="nombre" placeholder="Ingrese nombre" required type="text"><br>
		
		<label for="inputApellido">Apellido:</label>
		<input id="inputApellido" name="apellido" placeholder="Ingrese Apellido" required type="text"><br>
		
		<label for="inputTipoDoc">Tipo documento:</label>		
		<select name="tipo_doc">
					<option disabled selected>Seleccione</option>
					<option value="DNI">DNI</option>
					<option value="LE">LE</option>
					<option value="DUI">DUI</option>
		</select><br>
		
		<label for="inputNroDoc">Numero de documento:</label>
		<input id="inputNroDoc" name="nro_doc" placeholder="Ingrese numero de documento" required type="text"><br>
		
		<label for="inputEmail">Email:</label>
		<input id="inputEmail" name="email" placeholder="Ingrese Email" required type="email"> <br>    
		
		<label for="inputPassword">Contraseña:</label>
		<input id="inputPassword" name="password" placeholder="Ingrese contraseña" required type="password"><br>
		
		<label for="inputTelefono">Telefono:</label>
		<input id="inputTelefono" name="tel" placeholder="Ingrese Telefono" required type="text"><br>
		
		<input type="hidden" name="habilitado" value="1">
		
		<input type="hidden" name="rol" value="Socio">
		
		<button type="submit" name="action" value="registrar">Registrar</button>
	</form>
	<form action="Signin" method="get">
		<button type="submit">Cancelar</button>
	</form>
</body>

</html>