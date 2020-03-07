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
      <h3>Ingrese datos del socio a generar cuotas:</h3>
      
        	
    	 <label for="inputTipoDNI">Ingrese tipo de documento:</label>
    	 <select id="inputTipoDNI" name="tipoDNI">
    	    <option disabled selected value>Seleccione</option>
    	  	<option value="DNI">DNI</option>
    	  	<option value="LE">LE</option>
    	  	<option value="DUI">DUI</option>
  	     </select>
 
 	 <label for="inputDNI">Ingrese número de documento:</label>
	 <input id="inputDNI" name="dni" placeholder="Ingresar n° doc" required type="number">
	</p>
 <p>
 <br>	 
      <button type="submit" name="action" value="genCuotaSoc">Aceptar</button>

   	</tr>
   	
</form>
    
    <form action="Cuotas" method="post">
    	<button type="submit" name="action" value="gestionCuota">Cancelar</button>
    </form>
   
</body>
</html>