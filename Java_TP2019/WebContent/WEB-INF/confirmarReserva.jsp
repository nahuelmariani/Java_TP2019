<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="entities.Instalacion"%>
<%@page import="entities.Persona"%>
<%@page import="entities.Reserva"%>
<%@page import="java.text.*"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Confirmar Reserva</title>
	<%
		System.out.println("Index -> Home Socio -> Lista de instalaciones -> Pre Reserva -> Confirmar Reserva");
		Reserva r = (Reserva)session.getAttribute("reserva");
		DateFormat df = new SimpleDateFormat("HH:mm dd/MM/yyyy");
		DecimalFormat def = new DecimalFormat("#0.00");
	%>
</head>

<body>
	<form action="Instalaciones" method="post">
		<h3>Reservar instalacion:</h3>
		<h4><%=r.getInst().getNom_instalacion()%></h4>
		<p>Desde: <%=df.format(r.getFecha_hora_desde())%></p>
		<p>Hasta: <%=df.format(r.getFecha_hora_hasta())%></p>
		<p>Duracion: <%=def.format(r.getDuracion())%> horas</p>
		<p>Importe por hora: $<%=r.getInst().getImporte()%></p>
		<h3>Importe total: $<%=def.format(r.getInst().getImporte()*r.getDuracion())%></h3>
		<h3>Socio: <%=r.getPer().getNombre()%> <%=r.getPer().getApellido()%> (ID=<%=r.getPer().getId()%>) </h3>

		<button type="submit" name="action" value="reservar">Confirmar</button>
	</form>
	
	<form action="Instalaciones" method="post">
		<button type="submit" name="action" value="reservaInstalacion">Cancelar</button>
	</form>
</body>
</html>