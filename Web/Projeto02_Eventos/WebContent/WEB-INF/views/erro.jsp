<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title>Erro</title>
</head>
<body>

	<%@ include file="cabecalho.jsp" %>
	
	<div class="container" style="margin-top:60px;">
		<div class="alert alert-danger">
			${erro}
		</div>
		<a href="${link_retorno}">Voltar</a>
	</div>

	<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>