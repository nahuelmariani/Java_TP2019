<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Actividad"%>
<%@page import="entities.Persona"%>
<%@page import="java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mis Actividades</title>
<%
	System.out.println("Index -> Home Socio -> Mis Actividades");
	ArrayList<Actividad> la = (ArrayList<Actividad>) session.getAttribute("listaActividades");
	Persona p = (Persona)session.getAttribute("usuario");
	Actividad a = (Actividad)session.getAttribute("actividad");
	
%>
</head>
<body>
<form method="post" action="Actividades">
	<input type="hidden" name="action" value="homeUser">
	<button>Volver</button>
</form>

<div align="center">

<% if (la.size() > 0 ){%>	
<table border="1" cellpadding="5">
	<caption><h2>Mis Actividades</h2></caption>
	<thead>
		<tr>
			<th>Id</th>
			<th>Actividad</th>
			<th>Descripción</th>
			<th>Acciones</th>
		</tr>		
	</thead>	
	<tbody>
	<% for (Actividad act :la) {%>
		<tr>
			<td><%=act.getId_actividad()%></td>
			<td><%=act.getNom_actividad()%></td>
			<td><%=act.getDesc_actividad()%></td>
			<td>
				<form method="Post" action="Actividades" >
				<input type="hidden" name="idActividad" value="<%= act.getId_actividad() %>">				
					<button type="submit" name="action" value="bajaInscripcion">Dar de baja</button>
				</form>							
			</td>			
		</tr>
	<%} %>
	</tbody>
	<%} else{%>	
	<font size="5" color="red">No tenes inscripciones en actividades.</font>
	
	<%} %>
	
</table>
</div>
</body>
</html>