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
<h1>Gestion de usuarios - Administrador</h1>

    <form action="Usuarios" method="post">
      <h3>Registrar nuevo usuario:</h3>
      
      <label for="inputId">Id:</label>
      <input id="inputId" name="id" placeholder="Ingrese ID" required autofocus type="text">
      
      <label for="inputNombre">Nombre:</label>
      <input id="inputNombre" name="nombre" placeholder="Ingrese nombre" required type="text">
      
      <label for="inputApellido">Apellido:</label>
      <input id="inputApellido" name="apellido" placeholder="Ingrese Apellido" required type="text">
      
      <label for="inputTipoDoc">Tipo documento:</label>
      <input id="inputTipoDoc" name="tipo_doc" placeholder="Ingrese tipo de documento" required type="text">
      
      <label for="inputNroDoc">Numero de documento:</label>
      <input id="inputNroDoc" name="nro_doc" placeholder="Ingrese numero de documento" required type="text">
      
      <label for="inputEmail">Email:</label>
      <input id="inputEmail" name="email" placeholder="Ingrese Email" required type="email">     
      
      <label for="inputPassword">Contraseña:</label>
      <input id="inputPassword" name="password" placeholder="Ingrese contraseña" required type="password">
      
      <label for="inputTelefono">Telefono:</label>
      <input id="inputTelefono" name="tel" placeholder="Ingrese Telefono" required type="text">
      
      <button type="submit" name="action" value="agregar">Registrar</button>
    </form>

</body>
</html>