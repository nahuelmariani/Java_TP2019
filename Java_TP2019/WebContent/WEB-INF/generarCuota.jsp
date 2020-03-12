<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Gestion de cuotas</title>
	</head>
	
	<body>
		<h3>Registrar cuotas de socios:</h3>
		<br>
		<form action="Cuotas" method="post">
			<button type="submit" name="action" value="agregarATodos">Generar a todos</button>
			<button type="submit" name="action" value="agregarASocio">Generar a socio</button>
		</form>
		
		<br>
		<form action="Cuotas" method="post">
			<button type="submit" name="action" value="gestionCuota">Cancelar</button>
		</form>
	</body>
</html>