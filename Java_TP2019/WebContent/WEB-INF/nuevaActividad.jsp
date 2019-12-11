<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Actividad"%>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion de Actividades</title>
<%
	System.out.println("Index -> Home Admin -> Gestión de actividades -> Nueva actividad");
%>
</head>
<body>
<form action="Actividades" method="post">
      <h3>Registrar nueva Actividad:</h3>
      
      <label for="inputNombre">Nombre:</label>
      <input id="inputNombre" name="nom_actividad" placeholder="Ingrese nombre" required type="text"><br>
      
      <label for="inputDescripcion">Descripcion:</label>
      <input id="inputDescripcion" name="desc_actividad" placeholder="Ingrese Descripcion" required type="text"><br>
      
      <label for="inputImporte">Importe:</label>
      <input id="inputImporte" name="importe_adicional" placeholder="Ingrese importe adicional" required type="text"><br>
      
 
      
      <button type="submit" name="action" value="agregar">Registrar</button>
    </form>
    
    <form action="Actividades" method="post">
    	<button type="submit" name="action" value="listar">Cancelar</button>
    </form>


</body>
</html>