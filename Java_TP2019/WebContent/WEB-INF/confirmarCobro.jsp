<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="entities.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Realizar cobro</title>
<%
	System.out.println("Index -> Home Empleado -> Realizar cobro -> Confirmar cobro");
	Persona soc = (Persona)session.getAttribute("socio");
	Cuota cuota = (Cuota)session.getAttribute("cuota");
	Double importe = (Double)session.getAttribute("importe");
	ArrayList<Actividad> actividades = (ArrayList<Actividad>) session.getAttribute("actividades");
%>
</head>
<body>
	<h3>Confirmar cobro:</h3>
	<ul>
		<li><b>Socio: </b><%=soc.getNombre() + " " + soc.getApellido()%></li>
		<li><b>Mes: </b><%=cuota.getMes() + "/" + cuota.getAnio()%></li>
		<li><b>Importe de cuota: </b>$<%=cuota.getImporte()%></li>
		<li><b>Importe de actividades: </b>$<%=importe - cuota.getImporte()%>
			<ul>
				<%for (Actividad act : actividades) {%>
					<li><%=act.getNom_actividad() + " - $" +act.getImporte_adicional()%></li>
				<%};%>
			</ul>
		</li>
		<li><b>Importe total a cobrar: </b>$<%=importe%></li>
	</ul>

<form action="Cuotas" method="post">								
	<button type="submit" name="action" value="registrarCobro">Confirmar</button>
</form>
<form action="Cuotas" method="post">								
	<button type="submit" name="action" value="gestionCobro">Cancelar</button>
</form>
</body>
</html>