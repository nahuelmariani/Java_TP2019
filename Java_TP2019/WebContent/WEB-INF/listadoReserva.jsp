<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Reserva"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mis reservas</title>
<% 
	ArrayList<Reserva> lr = (ArrayList<Reserva>)session.getAttribute("listaReservas");
%>
</head>
<body>
<form method="post" action="Instalaciones">
	<input type="hidden" name="action" value="homeUser">
	<button>Volver</button>
</form>

<div align="center">
<table border="1" cellpadding="5">
	<caption><h2>Mis reservas</h2></caption>
	<thead>
		<tr>
			<th>Id</th>
			<th>Instalacion</th>
			<th>Fecha Reserva</th>
			<th>Fecha-Hora Desde</th>
			<th>Fecha-Hora Hasta</th>
			<th>Fecha Cancelación</th>
		
			<th colspan="2">Acciones</th>
		</tr>
	</thead>
	
	<tbody>
	<% for (Reserva res : lr) {%>
		<tr>
			<td><%=res.getId_reserva() %></td>
			
			<td><%=res.getFecha_reserva()%></td>
			<td><%=res.getInst().getNom_instalacion()%></td>
			<td><%=res.getFecha_hora_desde()%></td>
			<td><%=res.getFecha_hora_hasta()%></td>
			<td><%=res.getFecha_cancelacion()%></td>
	
			
			
			<td colspan="2">
				<form method="post" action="Instalaciones">
					<input type="hidden" name="idReserva" value="<%= res.getId_reserva() %>">
					<button type="submit" name="action" value="cancelarReserva">Cancelar Reserva</button>
				</form>
			</td>
		</tr>
	<%} %>
	</tbody>
	
</table>
</div>

</body>
</html>