<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Actividad"%>
<%@page import="java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mis Actividades</title>
<%
	System.out.println("Index -> Home Socio -> Mis Actividades");
	ArrayList<Actividad> la = (ArrayList<Actividad>) session.getAttribute("listaActividades");
	
%>
</head>
<body>
<form method="post" action="Actividades">
	<input type="hidden" name="action" value="homeUser">
	<button>Volver</button>
</form>

<div align="center">
<table border="1" cellpadding="5">
	<caption><h2>Mis Actividades</h2></caption>
	<thead>
		<tr>
			<th>Id</th>
			<th>Actividad</th>
			<th>Descripción</th>
		</tr>		
	</thead>
	
	<tbody>
	<% for (Actividad act :la) {%>
		<tr>
			<td><%=act.getId_actividad()%></td>
			<td><%=act.getNom_actividad()%></td>
			<td><%=act.getDesc_actividad()%></td>
			
		</tr>
	<%} %>
	</tbody>
	
</table>
</div>
</body>
</html>