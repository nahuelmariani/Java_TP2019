<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Persona"%>
<%@page import="entities.Rol"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<% 
	Persona p = (Persona)session.getAttribute("usuario");
	Rol r = (Rol)session.getAttribute("rol");
%>

</head>
<body>
		<% 
        if (r.getDescripcion().equals("admin")) {
        	System.out.println("Administrador");
        	%>
        	<h1>Home - Administrador</h1>
			<h2>Hola <%=p.getNombre()+" "+p.getApellido()%></h2>
			<h3> Gestionar usuarios </h3>
			<jsp:include page="/WEB-INF/abmUsuario.jsp"/>
			<%

		}
        if (r.getDescripcion().equals("empleado")) {
        	System.out.println("Empleado del club");
        	%>
        	<h1>Home - Empleado</h1>
			<h2>Hola <%=p.getNombre()+" "+p.getApellido()%></h2>
			<h3> Realizar cobros </h3>
			<%
		}
        if (r.getDescripcion().equals("socio")) {
        	System.out.println("Socio del club");
        	%>
        	<h1>Home - Socio</h1>
			<h2>Hola <%=p.getNombre()+" "+p.getApellido()%></h2>
			<h3> Alquilar cancha </h3>
			<%
		}

 %>
</body>
</html>