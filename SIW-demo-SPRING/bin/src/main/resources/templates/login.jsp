<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Esegui login</title>
		<!-- stylesheets css -->
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/animate.min.css">
		
		<link rel="stylesheet" href="css/et-line-font.css">
		<link rel="stylesheet" href="css/font-awesome.min.css">
		
		<!-- <link rel="stylesheet" href="css/vegas.min.css"> -->
		<!-- <link rel="stylesheet" href="css/style.css"> -->
		
		<link rel="stylesheet" type="text/css"
			href="css/styleFormLogin.css">
		
		<link
			href='https://fonts.googleapis.com/css?family=Rajdhani:400,500,700'
			rel='stylesheet' type='text/css'>
		
		<style>
		@import
			url('https://fonts.googleapis.com/css?family=Lato:400i|Exo+2:900i|Roboto:100')
			;
		</style>
	</head>
	<body>
		<form action="login" method="post">
			<div class="loginbox">
				<img src="images/download.png" class="avatar">
				<h1>Login</h1>
				<p>Username:</p>
				<h6>${erruser }</h6>
				<h6>${errore }</h6>
				<input type="text" name="username" value="${username}" placeholder="Enter Username">
				<p>Password:</p>
				<h6>${errpass }</h6>
				<input type="password" name="password" placeholder="Enter Password">
				<div></div>
				<div>
					<a href="verificaLogin">Entra</a>
				</div>
			</div>
		</form>
	
		<!-- javscript js -->
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
	
		<script src="js/vegas.min.js"></script>
	
		<script src="js/wow.min.js"></script>
		<script src="js/smoothscroll.js"></script>
		<script src="js/custom.js"></script>
	</body>
</html>