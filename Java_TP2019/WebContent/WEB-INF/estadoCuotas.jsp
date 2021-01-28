<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.*"%>
<%@page import="java.text.*"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Estado de Cuotas</title>
<%
	System.out.println("Index -> Home Empleado -> Estado de Cuotas");
	ArrayList<ArrayList<String>> lc = (ArrayList<ArrayList<String>>) session.getAttribute("cuotasPorAnio");
	String anio2 = (String) session.getAttribute("anio2");
%>
</head>
<body>

<script type="text/javascript">
	function EnableDisableTextBox(todos) {
		var inputDNI = document.getElementById("inputDNI");
		var inputTipoDNI = document.getElementById("inputTipoDNI");
		inputDNI.disabled = todos.checked ? true : false;
		inputTipoDNI.disabled = todos.checked ? true : false;
		if (!inputDNI.disabled) {
			inputDNI.focus();
		}
	}
</script>

<form action="Cuotas" method="post">
	<h3>Datos de la consulta:</h3>
	<label for="todos">
	<input type="checkbox" id="todos" name="todos" onclick="EnableDisableTextBox(this)" />
	Mostrar todos
	</label>
	<br>
	<label for="inputTipoDNI">Tipo de documento:</label>
	<select id="inputTipoDNI" name="tipoDNI">
		<option disabled selected value>Seleccione</option>
		<option value="DNI">DNI</option>
		<option value="LE">LE</option>
		<option value="DUI">DUI</option>
	</select>
	
	<label for="inputDNI">Documento:</label>
	<input id="inputDNI" name="dni" placeholder="Ingresar n° doc" required type="number">
	
	<label for="inputAnio">Año:</label>
	<input id="inputAnio" name="anio" placeholder="Ingresar año" required type="number">
	
	<button type="submit" name="action" value="estadoCuotas">Filtrar</button>
</form>

<form action="Cuotas" method="post">
	<button type="submit" name="action" value="homeUser">Volver</button>
</form>

<div align="center">
<font size="5" color="red">${message}</font>
<c:remove var="message" scope="session"/>

<%if (lc!=null) { %>
<p>
<span style='color:gray;'>&#9679; No generada</span><br>
<span style='color:red;'>&#9679; Impaga</span><br>
<span style='color:green;'>&#9679; Paga</span><br>
</p>
<table border="1" cellpadding="5">
	<caption><h2>Cuotas - Año: <%=anio2%> </h2></caption>
	<thead>
		<tr>
			<th>Tipo</th>
			<th>Numero</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>01</th>
			<th>02</th>
			<th>03</th>
			<th>04</th>
			<th>05</th>
			<th>06</th>
			<th>07</th>
			<th>08</th>
			<th>09</th>
			<th>10</th>
			<th>11</th>
			<th>12</th>
		</tr>
	</thead>
	<tbody>
		<%for (int j = 0; j < lc.size(); j++) {%>
		<tr>
			<td><%=lc.get(j).get(0)%></td>
			<td><%=lc.get(j).get(1)%></td>
			<td><%=lc.get(j).get(2)%></td>
			<td><%=lc.get(j).get(3)%></td>
			<%for (int i = 4; i < 16; i++) {%>
			<td>
				<% if(lc.get(j).get(i)=="0") %> <span style='font-size:30px;color:gray;'>&#9679;</span>
				<% if(lc.get(j).get(i)=="1") %> <span style='font-size:30px;color:red;'>&#9679;</span>
				<% if(lc.get(j).get(i)=="2") %> <span style='font-size:30px;color:green;'>&#9679;</span>
			</td>
			<%}%>
		</tr>
		<%}%>
	</tbody>
	<%} %>
</table>

</div>
</body>
</html>