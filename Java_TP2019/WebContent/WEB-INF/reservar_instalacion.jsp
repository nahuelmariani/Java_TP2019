<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Instalacion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reserva de Instalaciones</title>
<% 
	Instalacion i = (Instalacion)session.getAttribute("reservarInstalacion");
%>
</head>
<body>
    <form action="Instalaciones" method="post">
      <h3>Reservar instalacion:</h3>
      
      <label for="inputNombre">Nombre:</label>
      <input id="inputNombre" name="nombre" placeholder="Ingrese nombre" required type="text" value="<%=i.getNom_instalacion()%>"><br>
      
      <label for="inputNombre">Descripcion:</label>
      <input id="inputNombre" name="descripcion" placeholder="Ingrese descripcion" required type="text" value="<%=i.getDesc_instalacion()%>"><br>
  
  	  <label for="inputNombre">Importe:</label>
      <input id="inputNombre" name="importe" placeholder="Ingrese importe" required type="text" value="<%=i.getImporte()%>"><br>
      
      
      <label for="inputFechaHoraDesde">Fecha y Hora Desde:</label>
      <input id="inputFechaHoraDesde" name="fecha_hora_desde" placeholder="Ingrese fecha y hora desde" required type="datetime"><br>
      
      <label for="inputFechaHoraHasta">Fecha y Hora Hasta:</label>
      <input id="inputFechaHoraHasta" name="fecha_hora_hasta" placeholder="Ingrese fecha y hora hasta" required type="datetime"><br>
      
 
      
      <button type="submit" name="action" value="agregar">Reservar</button>
    </form>
    <form action="Instalaciones" method="post">
    	<button type="submit" name="action" value="listar">Cancelar</button>
    </form>
    
    
</body>
</html>