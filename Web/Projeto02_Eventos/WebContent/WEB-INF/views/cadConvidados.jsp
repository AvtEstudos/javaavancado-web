<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title>Cadastro de Convidados</title>
</head>
<body>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ include file="cabecalho.jsp" %>
	<div class="container" style="margin-top:50px;">
		<div class="row">
			<div class="col-sm-6">
				<h3>Dados do Convidado</h3>
				<div class="form-horizontal">
					<form method="post" action="admin/convidados">
						<!--  Seleção do Evento -->
						<div class="form-group">
							<label class="control-label col-sm-3"> Evento:</label>
							<div class = "col-sm-9" >
								<select name="evento" class="form-control" >
									<option value="0" >-- Selecione --</option>
									<c:forEach var="ev" items="${lista_eventos}">
										<option value="${ev.id}" >${ev.descricao}</option>																	
									</c:forEach>
								</select>																
							</div>
						</div>
						
						<!--  CPF do Convidado -->
						<div class="form-group">
							<label class="control-label col-sm-3">CPF:</label>
							<div class = "col-sm-9">
								<input type="text" name="cpf" class="form-control" />								
							</div>
						</div>
						
						<!--  Nome do Convidado -->
						<div class="form-group">
							<label class="control-label col-sm-3">Nome:</label>
							<div class = "col-sm-9">
								<input type="text" name="nome" class="form-control" />								
							</div>
						</div>														
						
						<!--  Email do Convidado -->
						<div class="form-group">
							<label class="control-label col-sm-3">Email:</label>
							<div class = "col-sm-9">
								<input type="email" name="email" class="form-control" />								
							</div>
						</div>		
						
						<!--  Telefone do Convidado -->
						<div class="form-group">
							<label class="control-label col-sm-3">Telefone:</label>
							<div class = "col-sm-9">
								<input type="text" name="telefone" class="form-control" />								
							</div>
						</div>								
						
						<!-- Botão enviar -->
						<div class="form-group">
							<input type="submit" value="Incluir convidado" class="btn btn-info" />
						</div>						
						
					</form>
				</div>
			</div>
			<div class="col-sm-6">
				<h3>Lista de Convidados</h3>
				<table class="table table-striped">
					<thead>
						<tr>
						    <td>Evento</td>
							<td>CPF</td>
							<td>Nome</td>
							<td>Email</td>
							<td>Telefone</td>
						</tr>						
					</thead>
					<tbody>
						<c:forEach var="cv" items="${lista_convidados}">
							<tr>
								<td>${cv.evento.descricao}</td>
								<td>${cv.cpf}</td>
								<td>${cv.nome}</td>
								<td>${cv.email}</td>
								<td>${cv.telefone}</td>																
							</tr>							
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>	
	</div>	
	
	<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
	
</body>
</html>