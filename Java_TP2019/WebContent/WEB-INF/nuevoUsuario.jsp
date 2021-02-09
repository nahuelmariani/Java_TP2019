<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Instalacion"%>
<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Gestion de usuarios - Club</title>
	<%
		System.out.println("Index -> Home Admin -> Gestión de usuarios -> Nuevo usuario");
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
		
		<label for="inputHabilitado">Habilitado:</label>
		<select id="inputHabilitado" name="habilitado">
			<option value="1">Habilitado</option>
			<option value="0">Inhabilitado</option>
		</select>
		
		<label for="inputRol">Rol:</label>
		<select id="inputRol" name="rol">
			<option value="Socio">Socio</option>
			<option value="Empleado">Empleado</option>
			<option value="Administrador">Administrador</option>
		</select>
		
		<button type="submit" name="action" value="agregar">Registrar</button>
	</form>
	
	<form action="Usuarios" method="post">
		<button type="submit" name="action" value="listar">Cancelar</button>
	</form>
</body>

</html>