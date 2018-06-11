<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Iscrizione Allievo</title>
</head>
<body>
	<form action="iscrizione" method="post">
		<div>Email: <input type="text" name="email" value="${email}"></div>
		<h1>${errore}</h1> <!-- se la mail non esiste -->
		<div><a href="confermaIscrizione">Iscrivi all'attività</a></div>
		<h2>Nuovo allievo? <a href="nuovoAllievo.jsp">Inserisci nuovo allievo</a></h2>
	</form>
</body>
</html>