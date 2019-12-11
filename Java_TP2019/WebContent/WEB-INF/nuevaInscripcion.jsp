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
		Persona p = (Persona)session.getAttribute("usuario");
		Actividad a = (Actividad)session.getAttribute("actividad");
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
		
		
		<button type="submit" name="action" value="inscribir">Inscribirse</button>
	</form>
	
	<form action="Actvidades" method="post">
		<button type="submit" name="action" value="inscribirActividad">Cancelar</button>
	</form>


</body>
</html>