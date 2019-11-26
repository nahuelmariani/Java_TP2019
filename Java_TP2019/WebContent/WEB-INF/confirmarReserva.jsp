<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<%@page import="entities.Instalacion"%>
<%@page import="entities.Persona"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Confirmar Reserva</title>
	<%
		Persona p = (Persona)session.getAttribute("usuario");
		Instalacion i = (Instalacion)session.getAttribute("reservarInstalacion");
	%>
</head>
<body>
	<form action="Instalaciones" method="post">
		<h3>Reservar instalacion:</h3>
		
		<input type="hidden" name="idInstalacion" value="<%= i.getId_instalacion() %>">
		<input type="hidden" name="idPersona" value="<%= p.getId() %>">
		
		<h4><%=i.getNom_instalacion()%></h4>
		<p>Descripcion: <%=i.getDesc_instalacion()%></p>
		<p>Importe por hora: <%=i.getImporte()%></p>
		<p>A nombre de: <%=p.getNombre()%> <%=p.getApellido()%> (ID:<%=p.getId()%>)</p>
		
		<label for="inputFechaHoraDesde">Fecha y Hora Desde:</label>
		<input id="inputFechaHoraDesde" name="fecha_hora_desde" placeholder="Ingrese fecha y hora desde" required type="datetime"><br>
		
		<label for="inputFechaHoraHasta">Fecha y Hora Hasta:</label>
		<input id="inputFechaHoraHasta" name="fecha_hora_hasta" placeholder="Ingrese fecha y hora hasta" required type="datetime"><br>
		
		<button type="submit" name="action" value="reservar">Confirmar</button>
	</form>
	
	<form action="Instalaciones" method="post">
		<button type="submit" name="action" value="reservaInstalacion">Cancelar</button>
	</form>
</body>
</html>