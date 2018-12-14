<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usuarios</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<h1>Cadastro de Usuarios</h1>
	<div>
		${mensagem}
	</div>
	<form action=<c:url value="/usuarios/cadusuario" /> method="post">
		<label>Nome:</label><br/>
		<input type="text" name="nome" />
		<form:errors path="usuario.nome"/> <br/>
		
		<label>Senha:</label><br/>
		<input type="password" name="senha" />	<br/> 
		
		<label>Nível:</label><br/>
		<select name="nivel" class="form-control">
			<option value="1">Administrador</option>
			<option value="2">Convidado</option>									
		</select> <br/>
		
		<input type="submit" name="Incluir Usuario" />			
		
	</form>
</body>
</html>