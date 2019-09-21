<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Instalacion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion de instalaciones - Club</title>

</head>
<body>
    <form action="Instalaciones" method="post">
      <h3>Registrar nueva instalacion:</h3>
      
      <label for="inputNombre">Nombre:</label>
      <input id="inputNombre" name="nom_instalacion" placeholder="Ingrese nombre" required type="text"><br>
      
      <label for="inputDescripcion">Descripcion:</label>
      <input id="inputDescripcion" name="desc_instalacion" placeholder="Ingrese Descripcion" required type="text"><br>
      
      <label for="inputImporte">Importe:</label>
      <input id="inputImporte" name="importe" placeholder="Ingrese importe" required type="text"><br>
      
 
      
      <button type="submit" name="action" value="agregar">Registrar</button>
    </form>
    
    <form action="Instalaciones" method="post">
    	<button type="submit" name="action" value="listar">Cancelar</button>
    </form>

</body>
</html>