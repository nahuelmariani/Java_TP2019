<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Instalacion"%>
<!DOCTYPE html>

<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Gestion de instalaciones - Club</title>
	<%
		System.out.println("Index -> Home Admin -> Gestión de instalaciones -> Modificar instalación");
		Instalacion i = (Instalacion)session.getAttribute("instalacion");
	%>
</head>

<body>
	<form enctype="multipart/form-data" action="Instalaciones" method="post">
		<h3>Modificar instalacion:</h3>
		
		<input type="hidden" name="idInstalacion" value="<%= i.getId_instalacion() %>">
		
		<label for="inputNombre">Nombre:</label>
		<input id="inputNombre" name="nom_instalacion" placeholder="Ingrese nombre" required type="text" value="<%=i.getNom_instalacion()%>"><br>
		
		<label for="inputDescripcion">Descripcion:</label>
		<input id="inputDescripcion" name="desc_instalacion" placeholder="Ingrese Descripcion" required type="text" value="<%=i.getDesc_instalacion()%>"><br>
		
		<label for="inputImporte">Importe:</label>
		<input id="inputImporte" name="importe" placeholder="Ingrese importe" required type="text" value="<%=i.getImporte()%>"><br>
		
		<label for="inputImagen">Selecciona la imagen: </label>
        <input id="inputImagen" type="file" name="imagen"/>
		
		<input type="submit" name="action" value="actualizar"/>
	</form>
	
	<form action="Instalaciones" method="post">
		<button type="submit" name="action" value="gestionInstalacion">Cancelar</button>
	</form>
</body>

</html>