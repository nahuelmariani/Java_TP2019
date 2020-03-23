<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Reserva"%>
<%@page import="java.text.*"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservas</title>
<%
	System.out.println("Index -> Home Socio -> Total Reservas");
	ArrayList<Reserva> lr = (ArrayList<Reserva>) session.getAttribute("totalReservas");
	System.out.println(lr);
	DateFormat df = new SimpleDateFormat("HH:mm dd/MM/yyyy");
%>
</head>
<body>
<form method="post" action="Instalaciones">
	<input type="hidden" name="action" value="homeUser">
	<button>Volver</button>
</form>

<div align="center">
<table border="1" cellpadding="5">
	<caption><h2>Reservas</h2></caption>
	<thead>
		<tr>
			<th>Id</th>
			<th>Instalacion</th>
			<th>Fecha Reserva</th>
			<th>Fecha-Hora Desde</th>
			<th>Fecha-Hora Hasta</th>
			<th>Fecha Cancelación</th>
		
			<th colspan="2">Accion</th>
		</tr>
	</thead>
	<%if (lr!=null) { %>
	<tbody>
	 <%for (Reserva res : lr) {%>
		<tr>
			<td><%=res.getId_reserva()%></td>
			<td><%=res.getInst().getNom_instalacion()%></td>
			<td><%=df.format(res.getFecha_reserva())%></td>
			<td><%=df.format(res.getFecha_hora_desde())%></td>
			<td><%=df.format(res.getFecha_hora_hasta())%></td>
			<%--<td><%=res.getFecha_cancelacion()%></td>--%>
			<%if(res.getFecha_cancelacion()==null){%><td>Vigente</td><%}else{%><td><%=df.format(res.getFecha_cancelacion())%></td><%} %>
			<td colspan="2">
				<form method="post" action="Instalaciones">
					<input type="hidden" name="idReserva" value="<%= res.getId_reserva() %>">
					<button type="submit" name="action" value="cancelarReserva">Cancelar Reserva</button>
				</form>
			</td>
		</tr>
	<%} %>
	</tbody>
	<%} %>
</table>
<br>
<font size="5" color="red">${message}</font>
<c:remove var="message" scope="session" />

</div>

</body>
</html>