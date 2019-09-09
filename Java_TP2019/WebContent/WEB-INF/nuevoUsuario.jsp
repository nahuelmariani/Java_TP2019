<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Persona"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion de usuarios - Club</title>

</head>
<body>
    <form action="Usuarios" method="post">
      <h3>Registrar nuevo usuario:</h3>
      
      <label for="inputNombre">Nombre:</label>
      <input id="inputNombre" name="nombre" placeholder="Ingrese nombre" required type="text"><br>
      
      <label for="inputApellido">Apellido:</label>
      <input id="inputApellido" name="apellido" placeholder="Ingrese Apellido" required type="text"><br>
      
      <label for="inputTipoDoc">Tipo documento:</label>
      <input id="inputTipoDoc" name="tipo_doc" placeholder="Ingrese tipo de documento" required type="text"><br>
      
      <label for="inputNroDoc">Numero de documento:</label>
      <input id="inputNroDoc" name="nro_doc" placeholder="Ingrese numero de documento" required type="text"><br>
      
      <label for="inputEmail">Email:</label>
      <input id="inputEmail" name="email" placeholder="Ingrese Email" required type="email"> <br>    
      
      <label for="inputPassword">Contraseña:</label>
      <input id="inputPassword" name="password" placeholder="Ingrese contraseña" required type="password"><br>
      
      <label for="inputTelefono">Telefono:</label>
      <input id="inputTelefono" name="tel" placeholder="Ingrese Telefono" required type="text"><br>
      
      <button type="submit" name="action" value="agregar">Registrar</button>
    </form>
    
    <form action="Usuarios" method="post">
    	<button type="submit" name="action" value="listar">Cancelar</button>
    </form>

</body>
</html>