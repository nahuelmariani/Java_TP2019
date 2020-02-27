<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="entities.Actividad"%>
<%@page import="entities.Persona"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Inscripcion a Actividades</title>
	<%
		System.out.println("Index -> Home Socio -> Lista de actividades -> Inscripcion");
		Persona p = (Persona)session.getAttribute("usuario");
		Actividad a = (Actividad)session.getAttribute("actividadModificar");
	%>
</head>

<body>
	<form action="Actividades" method="post">
		<h3>Inscribirse a una actividad:</h3>
		
		<input type="hidden" name="idActividad" value="<%= a.getId_actividad() %>">
		<input type="hidden" name="idPersona" value="<%= p.getId() %>">
		
		<h4><%=a.getNom_actividad()%></h4>
		<p>Descripcion: <%=a.getDesc_actividad()%></p>
		<p>Importe adicional: <%=a.getImporte_adicional()%></p>
		<p>A nombre de: <%=p.getNombre()%> <%=p.getApellido()%> (ID=<%=p.getId()%>) </p>
		
		
		<button type="submit" name="action" value="inscribirse">Inscribirse</button>
	</form>
	
	<form action="Actividades" method="post">
		<button type="submit" name="action" value="inscripcionActividad">Cancelar</button>
	</form>


</body>
</html>