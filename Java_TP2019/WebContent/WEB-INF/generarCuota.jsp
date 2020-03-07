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
      <br>     
      <button type="submit" name="action" value="agregar">Generar a todos</button>
      <button type="submit" name="action" value="agregarASoc">Generar a socio</button>
   	</tr>
   	
</form>
    <br>
    <form action="Cuotas" method="post">
    	<button type="submit" name="action" value="gestionCuota">Cancelar</button>
    </form>
   
</body>
</html>