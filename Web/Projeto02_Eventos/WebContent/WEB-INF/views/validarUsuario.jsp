<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

	<%@ include file="cabecalho.jsp" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<div class="container" style="margin-top:50px;">		
		<div class="row">
			<div class="col-sm-6">
				<h3>Login</h3>
				<div class="form-horizontal">
					<form method="post" action="login">
					
						<c:if test="${not empty mensagem}">				
							<div class="alert alert-danger"> 
								${mensagem}
							</div>								
						</c:if>
				
						<!--  Nome do Usuário -->
						<div class="form-group">
							<label class="control-label col-sm-3">Usuário:</label>
							<div class = "col-sm-9" >
								<input type="text" name="nome" class="form-control" />								
							</div>
						</div>
						
						<!--  Senha -->
						<div class="form-group">
							<label class="control-label col-sm-3">Senha:</label>
							<div class = "col-sm-9" >
								<input type="password" name="senha" class="form-control" />								
							</div>
						</div>
						
						<!-- Botão enviar -->
						<div class="form-group">
							<input type="submit" value="Login" class="btn btn-info" />
						</div>						
						
					</form>				
				</div>
			</div>
		</div>	
	</div>
	
	<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>