<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="entities.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Realizar cobro</title>
<%
	Persona soc = (Persona)session.getAttribute("Soc");
	Cuota cuota = (Cuota)session.getAttribute("Cuota");
	ArrayList<Actividad> actividades = (ArrayList<Actividad>) session.getAttribute("actividades");
	Double sum = 0.0;
%>
</head>
<body>

<form action="Cuotas" method="post">
		<h3>Confirmar cobro:</h3>
		
		<p>Socio:
		 <%=soc.getNombre()%>
		 <%=soc.getApellido()%></p>
			
		<p>Mes a cobrar:

		 <%=cuota.getMes() %>
		 Año a cobrar: <%=cuota.getAnio() %> </p>

        <p>Importe de cuota: <%=cuota.getImporte() %> </p>
        <p>Importe de actividades: </p>
        <% for (Actividad act : actividades) {
        sum = sum + act.getImporte_adicional();%>        
		
		<p><%=act.getNom_actividad()%>
		$ <%=act.getImporte_adicional()%></p>
		
									<%};  %>
		<p>Importe total a cobrar: 
		<%=sum + cuota.getImporte()%> </p>							
									
									
<button type="submit" name="action" value="registrarCobro">Confirmar</button>
</form>
<form method="post" action="Cuotas">
	<input type="hidden" name="action" value="gestionCobro">
	<button>Cancelar</button>
</form>
</body>
</html>