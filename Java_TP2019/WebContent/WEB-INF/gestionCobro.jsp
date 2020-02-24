<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Persona"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Realizar cobro</title>

</head>
<body>
<form method="post" action="Cuotas">
<p>
<label for="inputTipoDNI">Ingrese tipo de DNI del socio</label>
      <select id="inputTipoDNI" name="tipoDNI">
        <option disabled selected value>Seleccione</option>
      	<option value="DNI">DNI</option>
      	<option value="LE">LE</option>
      	<option value="DUI">DUI</option>
  	 </select>
 <label for="inputDNI">Ingrese DNI del socio</label>
 <input id="inputDNI" name="dni" placeholder="ingrese dni" required type="number">
</p>
 <p>
 <br>	
 <tr>      
    <label for="inputMes">Ingrese mes a cobrar:</label>
    <input id="inputMes" name="mes" placeholder="ingrese nro de mes" required type="number">
</tr>      
<br>
</p>
<button type="submit" name="action" value="nuevoCobro">Cobrar</button>

 </form>
<form method="post" action="Cuotas">
	<input type="hidden" name="action" value="homeUser">
	<button>Cancelar</button>
</form>

</body>
</html>