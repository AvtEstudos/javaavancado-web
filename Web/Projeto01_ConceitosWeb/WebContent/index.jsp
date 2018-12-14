<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Introdução a Java Web</title>
	</head>

	<body>	
		<h1>Introdução a Java Web</h1>	
		<samp>Hora atual: </samp> 
		<p><%out.println(new Date().toString()); %></p>
		<h2>Forneça seu usuário e sua senha</h2>
		
		<form action="login" method="post">
			<label>Nome:</label><br/>
			<input type="text" name="nome" /><br/>
			<label>Senha:</label><br/>
			<input type="password" name="senha" /><br/>
			<input type="submit" value="Validar" />
		</form>
	</body>
	
</html>