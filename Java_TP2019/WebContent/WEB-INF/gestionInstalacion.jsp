<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Instalacion"%>
<%@page import="logic.Constants"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion de Instalaciones - Club</title>
<%
	System.out.println("Index -> Home Admin -> Gestión de instalaciones");
	ArrayList<Instalacion> li = (ArrayList<Instalacion>) session.getAttribute("listaInstalaciones");
%>
</head>

<body>
<h2>ABM de Instalaciones:</h2>

<form method="post" action="Instalaciones">
	<input type="hidden" name="action" value="nuevaInstalacion">
	<button>Agregar nueva instalacion</button>
</form>

<form method="post" action="Instalaciones">
	<input type="hidden" name="action" value="homeUser">
	<button>Volver</button>
</form>

<div align="center">
<table border="1" cellpadding="5">
	<caption><h2>Listado de instalaciones</h2></caption>
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Descripcion</th>
			<th>Importe</th>
			<th>Imagen</th>
			<th colspan="2">Acciones</th>
		</tr>
	</thead>
	
	<tbody>
	<% for (Instalacion inst : li) {%>
		<tr>
			<td><%=inst.getId_instalacion()%></td>
			<td><%=inst.getNom_instalacion()%></td>
			<td><%=inst.getDesc_instalacion()%></td>
			<td><%=inst.getImporte()%></td>
			<td>
				<img src="upload/<%=inst.getImagen()%>" height="50" width="50">
			</td>
			<td colspan="2">
				<form method="post" action="Instalaciones">
					<input type="hidden" name="idInstalacion" value="<%= inst.getId_instalacion() %>">
					<button type="submit" name="action" value="modificarInstalacion">Editar</button>
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