<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista Attivit�</title>
	</head>
	<body>
		<ul>
			<c:forEach var ="attivit�" items = "${listaAttivit�}">
				<li>
					<div>Nome: ${attivit�.nome}</div>
					<div>Data/Ora: ${attivit�.dataOra}</div>
					<div>Posti liberi: ${attivit�.posti}</div>
					
					<a href="iscrizioneAllievo">Iscrivi un allievo</a>
				</li>
			</c:forEach>
		</ul>
	</body>
</html>





