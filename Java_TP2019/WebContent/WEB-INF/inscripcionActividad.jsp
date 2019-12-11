<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Actividad"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Inscripcion Actividades - Club</title>
	<%
		System.out.println("Index -> Home Socio -> Lista de actividades");
		ArrayList<Actividad> la = (ArrayList< Actividad>)session.getAttribute("listaActividades");
	%>
</head>

<body>

<h2>Inscripcion Actividades:</h2>

<form method="post" action="Actividades">
	<input type="hidden" name="action" value="homeUser">
	<button>Volver</button>
</form>

<div align="center">
<table border="1" cellpadding="5">
	<caption><h2>Listado de Actividades</h2></caption>
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Descripcion</th>
			<th>Importe Adicional</th>
			<th colspan="2">Acciones</th>
		</tr>
	</thead>
	
	<tbody>
	<% for (Actividad act : la) {%>
		<tr>
			<td><%=act.getId_actividad()%></td>
			<td><%=act.getNom_actividad()%></td>
			<td><%=act.getDesc_actividad()%></td>
			<td><%=act.getImporte_adicional()%></td>
			<td colspan="2">
				<form method="post" action="Actividades">
					<input type="hidden" name="idActividad" value="<%= act.getId_actividad() %>">
					<button type="submit" name="action" value="nuevaInscripcion">Inscribirse</button>
				</form>
			</td>
		</tr>
	<%} %>
	</tbody>
	
</table>
</div>


</body>
</html>