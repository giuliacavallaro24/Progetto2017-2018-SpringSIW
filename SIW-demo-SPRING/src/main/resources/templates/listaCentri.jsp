<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import = "it.uniroma3.progetto.model.Centro" %>
<%@ page import = "java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<ul>
			<c:forEach var ="centro" items = "${listaCentri}">
				<li>
					<div>Nome: ${centro.nome}</div>
					<div>Indirizzo: ${centro.indirizzo}</div>
					<div>Email: ${centro.email}</div>
					<div>Telefono: ${centro.telefono}</div>
					<div>Capienza: ${centro.capienzaMax}</div>
				</li>
			</c:forEach>
		</ul>
	</body>
</html>