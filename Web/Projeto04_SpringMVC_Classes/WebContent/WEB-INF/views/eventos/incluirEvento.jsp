<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Eventos</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<h1>Cadastro de Eventos</h1>
	<div>
		${mensagem}
	</div>
	<form action=<c:url value="/eventos/cadevento" /> method="post">
		<label>Descrição</label><br/>
		<input type="text" name="descricao"><br/>
		<form:errors path="evento.descricao"/> <br/>
		
		<label>Resposável</label><br/>
		<input type="text" name="responsavel"><br/>
		<form:errors path="evento.responsavel"/> <br/> 
		
		<label>Data:</label><br/>
		<input type="date" name="DataString"><br/>
		<form:errors path="evento.data"/> <br/>
		
		<label>Preço:</label><br/>
		<input type="text" name="preco"><br/>
		<form:errors path="evento.preco"/> <br/>				
				
		<input type="submit" name="Incluir Evento" />		
		
	</form>
</body>
</html>