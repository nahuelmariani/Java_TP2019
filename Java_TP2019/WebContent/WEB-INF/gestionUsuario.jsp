<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Persona"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion de usuarios - Club</title>
<%
	System.out.println("Index -> Home Admin -> Gestión de usuarios");
	ArrayList<Persona> lp = (ArrayList<Persona>) session.getAttribute("listaPersonas");
%>
</head>

<body>
<h2>ABM de Usuarios:</h2>

<form method="post" action="Usuarios">
	<input type="hidden" name="action" value="nuevoUsuario">
	<button>Agregar nuevo usuario</button>
</form>

<form method="post" action="Usuarios">
	<input type="hidden" name="action" value="homeUser">
	<button>Volver</button>
</form>

<div align="center">
<table border="1" cellpadding="5">
	<caption><h2>Listado de usuarios</h2></caption>
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Email</th>
			<th>Teléfono</th>
			<th>Habilitado</th>
			<th>Rol</th>
			<th colspan="2">Acciones</th>
		</tr>
	</thead>
	
	<tbody>
	<% for (Persona per : lp) {%>
		<tr>
			<td><%=per.getId()%></td>
			<td><%=per.getNombre()%></td>
			<td><%=per.getApellido()%></td>
			<td><%=per.getEmail()%></td>
			<td><%=per.getTel()%></td>
			<td><%=per.isHabilitado()%></td>
			<td><%=per.getRol()%></td>
			<td colspan="2">
				<form method="post" action="Usuarios">
					<input type="hidden" name="idUsuario" value="<%= per.getId() %>">
					<button type="submit" name="action" value="modificarUsuario">Editar</button>
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