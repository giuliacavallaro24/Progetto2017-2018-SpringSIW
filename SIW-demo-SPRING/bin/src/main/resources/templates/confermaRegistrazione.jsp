<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<div>Hai inserito i seguenti parametri:</div>
		<br></br>
		
		<div>Nome: ${allievo.nome}</div>
		<div>Cognome: ${allievo.cognome}</div>
		<div>Email: ${allievo.email}</div>
		<div>Telefono: ${allievo.telefono}</div>
		<div>Data Nascita: ${allievo.dataNascita}</div>
		<div>Luogo Nascita: ${allievo.luogoNascita}</div>
		
		<br></br> Vuoi confermare i dati inseriti?
		<a href="conferma">Conferma</a>
		<a href="nuovoAllievo.jsp">Annulla</a>
	</body>
</html>