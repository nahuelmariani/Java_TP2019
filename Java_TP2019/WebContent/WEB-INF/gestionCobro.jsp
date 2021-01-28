<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="entities.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.*"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Realizar cobro</title>
<%
	System.out.println("Index -> Home Empleado -> Realizar cobro");
%>
</head>

<body>
<div align="center">
	<h3>Ingrese los datos para realizar el cobro</h3>
	<table>
		<tr>
			<th>Tipo</th>
			<th>Número de documento</th>
			<th>Mes</th>
			<th>Año</th>
			<th>Acción</th>
		</tr>
		<tr>
			<td>
				<select name="tipoDNI" form="cobro">
					<option disabled selected>Seleccione</option>
					<option value="DNI">DNI</option>
					<option value="LE">LE</option>
					<option value="DUI">DUI</option>
				</select>
			</td>
			<td>
				<input name="dni" placeholder="Ingresar n° doc" required type="number" form="cobro">
			</td>
			<td>
				<input name="mes" placeholder="Ingresar n° de mes" required type="number" form="cobro">
			</td>
			<td>
				<input name="anio" placeholder="Ingresar año" required type="number" form="cobro">
			</td>
			<td>
				<button type="submit" name="action" value="nuevoCobro" form="cobro">Cobrar</button>
				<button type="submit" name="action" value="homeUser" form="volver">Volver</button>
			</td>
		</tr>
	</table>
<font size="5" color="red">${message}</font>
<c:remove var="message" scope="session"/>
<%-- 
<form method="post" action="Cuotas">	
	<label for="inputTipoDNI">Ingrese tipo de documento del socio</label>
	<select id="inputTipoDNI" name="tipoDNI">
		<option disabled selected>Seleccione</option>
		<option value="DNI">DNI</option>
		<option value="LE">LE</option>
		<option value="DUI">DUI</option>
	</select>
	
	<label for="inputDNI">Ingrese número de documento del socio</label>
	<input id="inputDNI" name="dni" placeholder="Ingresar n° doc" required type="number">
	
	<label for="inputMes">Ingrese el número del mes a cobrar:</label>
	<input id="inputMes" name="mes" placeholder="Ingresar n° de mes" required type="number">
	
	<label for="inputAnio">Ingrese año a cobrar:</label>
	<input id="inputAnio" name="anio" placeholder="Ingresar año" required type="number">
	
	<button type="submit" name="action" value="nuevoCobro">Cobrar</button>
	
</form>
--%>
<form method="post" action="Cuotas" id="cobro"></form>
<form method="post" action="Cuotas" id="volver"></form>
</div>
</body>
</html>