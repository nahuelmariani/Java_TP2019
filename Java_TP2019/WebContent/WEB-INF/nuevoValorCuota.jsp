<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuevo Valor Cuota</title>
<%
	ArrayList<Valores_Cuota> vcs = (ArrayList<Valores_Cuota>) session.getAttribute("listaValoresCuotas");
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
%>
</head>
<body>
	<form action="Cuotas" method="post">
		<h3>Agregar nuevo valor de Cuota:</h3>
		
		<label for="inputValor">Valor:</label>
		<input id="inputValor" name="valor" placeholder="Ingrese valor" required type="text" ><br>
		
		<label for="inputFechaDesde">Fecha Desde:</label>
		<input id="inputFechaDesde" name="fecha_desde" placeholder="DD/MM/AAAA" required type="date"><br>
		
		<button type="submit" name="action" value="agregarNuevoValorCuota">Agregar</button>
	</form>
	
	<form action="Cuotas" method="post">
		<button type="submit" name="action" value="gestionCuota">Cancelar</button>
	</form>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption><h2>Lista de valores</h2></caption>
			<thead>
				<tr>
					<th>Fecha</th>
					<th>Valor</th>
				</tr>
			</thead>
			
			<tbody>
			<% for (Valores_Cuota vc : vcs) {%>
				<tr>
					<td><%=vc.getFecha()%></td>
					<td><%=vc.getValor()%></td>
				</tr>
			<%} %>
			</tbody>
			
		</table>
	</div>
</body>
</html>