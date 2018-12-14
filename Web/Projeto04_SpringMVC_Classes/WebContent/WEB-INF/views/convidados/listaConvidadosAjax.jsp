<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Convidados</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<h1>Lista de convidados por evento (Ajax)</h1>	
	
	<label>Evento:</label><br/>
	<select name="idEvento" id="idEvento">
		<option value="0">Escolha uma op��o</option>			
		<c:forEach var="e" items="${eventos}">
			<option value="${e.id}">${e.descricao}</option>	
		</c:forEach>
	</select> <br/>	
	<hr/>		
	<table class="table table-striped" id="tblLista">
		<thead>
			<tr>
				<th>CPF</th>
				<th>NOME</th>
				<th>EMAIL</th>
				<th>TELEFONE</th>
			</tr>
		</thead>				
		<tbody></tbody>			
	</table>	
	
	<script src="http://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
		
	<script type="text/javascript">
		$(document).ready(function(){			
			$("#idEvento").change(function(){				
				$.ajax({
					method: 'GET',
					url: '/Projeto04_SpringMVC_Classes/convidados/listaAjaxResult/' + $("#idEvento").val(),
					success: function(data){ 
						$("#tblLista tbody > tr").remove();
						$.each(data, function(k, v){
							$("#tblLista tbody").append(
								'<tr>' + 
								' 	<td>' + v.cpf + '</td>' +
								' 	<td>' + v.nome + '</td>' +
								' 	<td>' + v.email + '</td>' +
								' 	<td>' + v.telefone + '</td>' +
								'</tr>'
							);
						});
					},
					error: function(erro){ 
						console.log('Erro ao chamar servi�o: ' + erro.responseText);
					} 
				});				
			});			
		});
	</script>
		
</body>
</html>