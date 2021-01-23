<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Estado de Cuotas</title>
</head>
<body>
<%--<script type="text/javascript">
	function EnableDisableTextBox(chkPassport) {
		var txtPassportNumber = document.getElementById("txtPassportNumber");
		txtPassportNumber.disabled = chkPassport.checked ? false : true;
		if (!txtPassportNumber.disabled) {
			txtPassportNumber.focus();
		}
	}
</script>--%>

<script type="text/javascript">
	function EnableDisableTextBox(todos) {
		var inputDNI = document.getElementById("inputDNI");
		var inputTipoDNI = document.getElementById("inputTipoDNI");
		inputDNI.disabled = todos.checked ? true : false;
		inputTipoDNI.disabled = todos.checked ? true : false;
		if (!inputDNI.disabled) {
			inputDNI.focus();
		}
	}
</script>

<%--<label for="chkPassport">
<input type="checkbox" id="chkPassport" onclick="EnableDisableTextBox(this)" />
Do you have Passport?
</label>
<br />
Passport Number:
<input type="text" id="txtPassportNumber" disabled="disabled" />--%>





	<form action="Cuotas" method="post">
		<h3>Datos de la consulta:</h3>
		<label for="todos">
		<input type="checkbox" id="todos" onclick="EnableDisableTextBox(this)" />
		Mostrar todos
		</label>
		<br>
		<label for="inputTipoDNI">Tipo de documento:</label>
		<select id="inputTipoDNI" name="tipoDNI">
		<option disabled selected value>Seleccione</option>
		<option value="DNI">DNI</option>
		<option value="LE">LE</option>
		<option value="DUI">DUI</option>
		</select>
		
		<label for="inputDNI">Documento:</label>
		<input id="inputDNI" name="dni" placeholder="Ingresar n° doc" required type="number">
		
		<label for="inputAnio">Año:</label>
		<input id="inputAnio" name="anio" placeholder="Ingresar año" required type="number">
		
		<button type="submit" name="action" value="estadoCuotasSocio">Aceptar</button>
	</form>
	
	<form action="Cuotas" method="post">
		<button type="submit" name="action" value="homeUser">Cancelar</button>
	</form>

</body>
</html>