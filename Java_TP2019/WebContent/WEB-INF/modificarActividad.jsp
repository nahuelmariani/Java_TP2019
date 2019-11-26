<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Actividad"%>
<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Gestion de Actividades - Club</title>
	<% 
		Actividad a = (Actividad)session.getAttribute("actividadModificar");
	%>
</head>

<body>
	<form action="Actividades" method="post">
		<h3>Modificar actividad:</h3>
		
		<input type="hidden" name="idActividad" value="<%= a.getId_actividad() %>">
		
		<label for="inputNombre">Nombre:</label>
		<input id="inputNombre" name="nom_actividad" placeholder="Ingrese nombre" required type="text" value="<%=a.getNom_actividad()%>"><br>
		
		<label for="inputDescripcion">Descripcion:</label>
		<input id="inputDescripcion" name="desc_actividad" placeholder="Ingrese Descripcion" required type="text" value="<%=a.getDesc_actividad()%>"><br>
		
		<label for="inputImporte">Importe:</label>
		<input id="inputImporte" name="importe_adicional" placeholder="Ingrese importe" required type="text" value="<%=a.getImporte_adicional()%>"><br>
		
		<button type="submit" name="action" value="actualizar">Guardar cambios</button>
	</form>
	
	<form action="Actividades" method="post">
		<button type="submit" name="action" value="listar">Cancelar</button>
	</form>
</body>

</html>