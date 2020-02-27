<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion de cuotas</title>
</head>
<body>
<form action="Cuotas" method="post">
      <h3>Registrar cuotas de socios:</h3>
      
        	
      <label for="inputImporte">Ingrese importe de las cuotas:</label>
     
      <input id="inputImporte" name="importe" placeholder="Ingrese importe" required type="text"><br>
      
      <tr>      
      <button type="submit" name="action" value="agregar">Generar</button>
   	</tr>
</form>
    
    <form action="Cuotas" method="post">
    	<button type="submit" name="action" value="gestionCuota">Cancelar</button>
    </form>
   
</body>
</html>