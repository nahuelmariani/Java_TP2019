<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Persona"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Club</title>
	<% 
		Persona p = (Persona)session.getAttribute("usuario");
	%>
</head>

<body>
		<h2>Hola <%=p.getNombre()+" "+p.getApellido()%></h2>
		<h3>Menú</h3>
		<hr>
		<% 
        if (p.getRol().equals("Administrador")) {
        	System.out.println("Index -> Home Administrador");
        	%>
			<form method="post" action="Usuarios">
				<input type="hidden" name="action" value="gestionUsuario">
				<button>Gestión de usuarios</button>
			</form>
			<br>
			<form method="post" action="Instalaciones">
				<input type="hidden" name="action" value="gestionInstalacion">
				<button>Gestión de instalaciones</button>
			</form>
			<br>
			<form method="post" action="Actividades">
				<input type="hidden" name="action" value="gestionActividad">
				<button>Gestión de actividades</button>
			</form>
			<br>
			<form method="post" action="Cuotas">
				<input type="hidden" name="action" value="gestionCuota">
				<button>Gestion de cuotas</button>
			</form>
			<br>
			<form method="post" action="Instalaciones">
				<input type="hidden" name="action" value="obtenerReservas">
				<button>Reservas</button>
			</form>
			<br>
			<br>
		<%
		}
		if (p.getRol().equals("Empleado")) {
			System.out.println("Index -> Home Empleado");
        	%>
			<form method="post" action="Cuotas">
				<input type="hidden" name="action" value="gestionCobro">
				<button>Realizar cobros</button>
			</form>
			<br>
			<br>
			
			<%
		}
        if (p.getRol().equals("Socio")) {
        	System.out.println("Index -> Home Socio");
        	%>
        	<h4>Opciones:</h4>
			<form method="post" action="Instalaciones">
				<input type="hidden" name="action" value="reservaInstalacion">
				<button>Instalaciones</button>
			</form>
			
			<form method="post" action="Actividades">
				<input type="hidden" name="action" value="inscripcionActividad">
				<button>Actividades</button>
			</form>
			
			<h4>Seleccionados:</h4>					
			<form method="post" action="Instalaciones">
				<input type="hidden" name="action" value="misReservas">
				<button>Mis Reservas</button>
			</form>
			
			<form method="post" action="Actividades">
				<input type="hidden" name="action" value="misActividades">
				<button>Mis Actividades</button>
			</form>
			
			<br>
			<br>
			<%
		}

%>

<p>
<form action="Signin" method="get">
<button type="submit">Cerrar sesion</button>
</form>	
</body>
</html>