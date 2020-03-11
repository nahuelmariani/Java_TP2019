
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion Cuotas</title>
</head>
<body>
<form method="post" action="Cuotas">
	<input type="hidden" name="action" value="nuevaCuota">
	<button>Generar cuotas</button>
</form>
<form method="post" action="Cuotas">
	<input type="hidden" name="action" value="nuevoValorCuota">
	<button>Actualizar precio cuota</button>
</form>
</body>
</html>