<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Persona"%>
<%@page import="java.text.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscriptos</title>
<%
	System.out.println("Index -> Home Administrador -> Gestion Actividades -> Ver inscriptos");
	ArrayList<Persona> li = (ArrayList<Persona>) session.getAttribute("listaInscriptos");
	//DateFormat df = new SimpleDateFormat("HH:mm dd/MM/yyyy");
%>
</head>
<body>
<br>
<br>
<form method="post" action="Actividades">
	<input type="hidden" name="action" value="gestionActividad">
	<button>Volver</button>
</form>

<div align="center">

	<% if (li.size() > 0 ){%>	
	<table border="1" cellpadding="2">
	<caption><h2>Inscriptos</h2></caption>
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Apellido</th>					
		</tr>
	</thead>	
	<tbody >
	<% for (Persona per : li) {%>
		<tr>
		
		<td><%=per.getId()%></td>
		<td><%=per.getNombre()%></td>
		<td><%=per.getApellido()%></td>
									
		</tr>
	<%} %>
	</tbody>	
	<%} else{%>
	
	<font size="5" color="red">Actividad sin inscriptos.</font>
	
	<%} %>
		
	
	
	
	
</table>
</div>

</body>
</html>





