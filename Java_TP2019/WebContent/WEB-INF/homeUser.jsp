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
		<h3>Menu:</h3>
		<% 
        if (p.getRol().equals("Administrador")) {
        	System.out.println("Administrador");
        	%>
			<form method="post" action="Usuarios">
				<input type="hidden" name="action" value="gestionUsuario">
				<button>Gestión de usuarios</button>
			</form>
			<form method="post" action="Instalaciones">
				<input type="hidden" name="action" value="gestionInstalacion">
				<button>Gestión de instalaciones</button>
			</form>
			<form method="post" action="Actividades">
				<input type="hidden" name="action" value="gestionActividad">
				<button>Gestión de actividades</button>
			</form>
			
		<%
		}
		if (p.getRol().equals("Empleado")) {
			System.out.println("Empleado del club");
        	%>
			<h3> Realizar cobros </h3>
			<%
		}
        if (p.getRol().equals("Socio")) {
        	System.out.println("Socio del club");
        	%>
			<form method="post" action="Instalaciones">
				<input type="hidden" name="action" value="reservaInstalacion">
				<button>Instalaciones</button>
			</form>
			<%
		}

%>
<p>
<form action="Signin" method="get">
<button type="submit">Cerrar sesion</button>
</form>	
</body>
</html>