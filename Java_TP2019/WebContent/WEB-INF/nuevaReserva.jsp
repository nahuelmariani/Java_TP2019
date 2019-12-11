<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="entities.Instalacion"%>
<%@page import="entities.Persona"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Reserva de Instalaciones</title>
	<%
		System.out.println("Index -> Home Socio -> Lista de instalaciones -> Pre Reserva");
		Persona p = (Persona)session.getAttribute("usuario");
		Instalacion i = (Instalacion)session.getAttribute("instalacion");
	%>
</head>

<body>
	<form action="Instalaciones" method="post">
		<h3>Reservar instalacion:</h3>
		
		<h4><%=i.getNom_instalacion()%></h4>
		<p>Descripcion: <%=i.getDesc_instalacion()%></p>
		<p>Importe por hora: <%=i.getImporte()%></p>
		
		<label for="inputFechaHoraDesde">Fecha y Hora Desde:</label>
		<input id="inputFechaHoraDesde" name="fecha_hora_desde" placeholder="HH:MM DD/MM/AAAA" required type="datetime"><br>
		
		<label for="inputFechaHoraHasta">Fecha y Hora Hasta:</label>
		<input id="inputFechaHoraHasta" name="fecha_hora_hasta" placeholder="HH:MM DD/MM/AAAA" required type="datetime"><br>
		
		<%-- <button type="submit" name="action" value="reservar">Reservar</button> --%>
		<button type="submit" name="action" value="preReservar">Reservar</button>
	</form>
	
	<form action="Instalaciones" method="post">
		<button type="submit" name="action" value="reservaInstalacion">Cancelar</button>
	</form>
</body>
</html>