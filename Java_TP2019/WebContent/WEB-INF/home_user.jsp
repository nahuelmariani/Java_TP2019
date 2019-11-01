<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Persona"%>
<%@page import="entities.Rol"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Club</title>
<% 
	Persona p = (Persona)session.getAttribute("usuario");
	Rol r = (Rol)session.getAttribute("rol");
%>

</head>
<body>
		<h2>Hola <%=p.getNombre()+" "+p.getApellido()%></h2>
		<h3>Menu:</h3>
		<% 
        if (r.getDescripcion().equals("admin")) {
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
			
		<%
		}
        if (r.getDescripcion().equals("empleado")) {
        	System.out.println("Empleado del club");
        	%>
			<h3> Realizar cobros </h3>
			<%
		}
        if (r.getDescripcion().equals("socio")) {
        	System.out.println("Socio del club");
        	%>
			<form method="post" action="Instalaciones">
				<input type="hidden" name="action" value="reservaInstalacion">
				<button>Instalaciones</button>
			</form>
			<%
		}

 %>
</body>
</html>