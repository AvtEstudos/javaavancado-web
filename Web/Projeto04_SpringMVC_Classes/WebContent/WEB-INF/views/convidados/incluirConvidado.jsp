<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Convidados</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<h1>Cadastro de Convidados</h1>	
	<div>
		${mensagem}
	</div>	
	<form action=<c:url value="/convidados/cadconvidado"/> method="post">
	<label>Evento:</label><br/> 
	<select name="idEvento">
		<c:forEach var="e" items="${eventos}">
			<option value="${e.id}">${e.descricao}</option>
		</c:forEach>	
	</select><br/>
	<form:errors path="convidado.idEvento"/> <br/>
	
	<label>Cpf:</label><br/>
	<input type="text" name="cpf" /><br/>
	<form:errors path="convidado.cpf"/> <br/>
	
	<label>Nome:</label><br/>
	<input type="text" name="nome" /><br/>
	<form:errors path="convidado.nome"/> <br/>
	
	<label>Email:</label><br/>
	<input type="text" name="email" /><br/>
	<form:errors path="convidado.email"/> <br/>
	
	<label>Telefone:</label><br/>
	<input type="text" name="telefone" /><br/>
	<form:errors path="convidado.telefone"/> <br/>
	
	<input type="submit" value="Incluir Convidado" />	
	</form>
</body>
</html>