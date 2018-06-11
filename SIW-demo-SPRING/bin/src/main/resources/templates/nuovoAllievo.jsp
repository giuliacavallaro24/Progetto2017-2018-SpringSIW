<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Nuovo Allievo</title>
</head>
<body>
	<form action="inserisci" method="get">
		<div>
			Nome:<input type="text" name="nome" value="${nome}" />
		</div>
		<h1>${errnome }</h1>
		<div>
			Cognome:<input type="text" name="cognome" value="${cognome}" />
		</div>
		<h1>${errcognome }</h1>
		<div>
			Email:<input type="text" name="email" value="${email}" />
		</div>
		<h1>${erremail }</h1>
		<div>
			Telefono:<input type="text" name="telefono" value="${telefono}" />
		</div>
		<h1>${errtelefono }</h1>
		<div>
			Data Nascita:<input type="text" name="dataNascita" value="${dataNascita}" />
		</div>
		<h1>${errdataNascita }</h1>
		<div>
			Luogo Nascita:<input type="text" name="luogoNascita" value="${luogoNascita}" />
		</div>
		<h1>${errluogoNascita }</h1>
		<div>
			<input type="submit" value="invia" name="submit" />
		</div>
	</form>
</body>
</html>