<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Actividad"%>
<%@page import="java.util.HashMap"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion de Actividades</title>
<%
	System.out.println("Index -> Home Admin -> Gestión de actividades");
	ArrayList<Actividad> la = (ArrayList<Actividad>) session.getAttribute("listaActividades");
	HashMap<Integer,Integer> insc = (HashMap<Integer,Integer>)session.getAttribute("inscriptos");
%>
</head>

<body>
<h2>ABM de Actividades:</h2>

<form method="post" action="Actividades">
	<input type="hidden" name="action" value="nuevaActividad">
	<button>Agregar nueva actividad</button>
</form>

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
			<th>Inscriptos/Cupo Total</th>
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
			<td><%=insc.get(act.getId_actividad())%>/<%=act.getCupo()%></td>
			<td><%=act.getImporte_adicional()%></td>
		
			<td colspan="2">
				<form method="post" action="Actividades">
					<input type="hidden" name="idActividad" value="<%= act.getId_actividad() %>">
					<button type="submit" name="action" value="modificarActividad">Editar</button>
					<button type="submit" name="action" value="eliminar">Eliminar</button>
				</form>
			</td>
		</tr>
	<%} %>
	</tbody>
	
</table>
</div>


</body>
</html>