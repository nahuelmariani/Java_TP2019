<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Persona"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion de usuarios - Club</title>
<% 
	Persona p = (Persona)session.getAttribute("usuario");
	ArrayList<Persona> lp = (ArrayList<Persona>)session.getAttribute("listaPersonas");
%>
</head>
<body>
<h2>Usuarios:</h2>
<table class="table">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Email</th>
			<th>Teléfono</th>
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
			<td colspan="2">
				<form method="post" action="Usuarios">
					<input type="hidden" name="idUsuario" value="<%= per.getId() %>">
					<button type="submit" name="action" value="editar">Editar</button>
					<button type="submit" name="action" value="eliminar">Eliminar</button>
				</form>
			</td>
		</tr>
	<%} %>
	</tbody>
	
</table>
<form method="post" action="Usuarios">
	<input type="hidden" name="action" value="nuevoUsuario">
	<button>Agregar usuario</button>
</form>
</body>
</html>