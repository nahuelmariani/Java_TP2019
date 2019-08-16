<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Persona"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administrador - Club</title>

<% 
	Persona p= (Persona)session.getAttribute("usuario");
%>

</head>
<body>
<h1>Home - Administrador</h1>
<h2>Hola <%=p.getNombre()+" "+p.getApellido()%></h2>
</body>
</html>