<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title>Cadastro de Eventos</title>
</head>
<body>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ include file="cabecalho.jsp" %>
	<div class="container" style="margin-top:50px;">
		<div class="row">
			<div class="col-sm-6">
				<h3>Dados do Evento</h3>
				<div class="form-horizontal">
					<form method="post" action="admin/eventos">
						<!--  Descrição do Evento -->
						<div class="form-group">
							<label class="control-label col-sm-3"> Descrição do evento:</label>
							<div class = "col-sm-9" >
								<input type="text" name="descricao" class="form-control" />								
							</div>
						</div>
						
						<!--  Data do Evento -->
						<div class="form-group">
							<label class="control-label col-sm-3"> Data do evento:</label>
							<div class = "col-sm-4" >
								<input type="date" name="data" class="form-control" />								
							</div>
						</div>

						<!--  Responsável pelo Evento -->
						<div class="form-group">
							<label class="control-label col-sm-3"> Responsável pelo evento:</label>
							<div class = "col-sm-9">
								<input type="text" name="responsavel" class="form-control" />								
							</div>
						</div>
																		
						<!--  Preço do Evento -->
						<div class="form-group">
							<label class="control-label col-sm-3"> Preço do evento:</label>
							<div class = "col-sm-4">
								<input type="text" name="preco" class="form-control" />								
							</div>
						</div>
						
						<!-- Botão enviar -->
						<div class="form-group">
							<input type="submit" value="Incluir evento" class="btn btn-info" />
						</div>						
						
					</form>
				</div>
			</div>
			<div class="col-sm-6">
				<h3>Lista de Eventos</h3>
				<table class="table table-striped">
					<thead>
						<tr>
							<td>Data</td>
							<td>Descrição</td>
							<td>Preço</td>
							<td>Documento</td>
						</tr>						
					</thead>
					<tbody>
						<c:forEach var="ev" items="${lista_eventos}">
							<tr>
								<td><fmt:formatDate value="${ev.data}" pattern="dd/MM/YYYY"/></td>								
								<td>${ev.descricao}</td>
								<td><fmt:formatNumber value="${ev.preco}" type="currency" /></td>
								<td><a class="btn btn-info" href="admin/documento?id=${ev.id}">Ver PDf</a></td>								
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