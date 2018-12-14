<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Eventos</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<h1>Lista de Eventos</h1>		
	<form action=<c:url value="/eventos/listareventos"/> method="get">
	
	<div>							
		<table>
			<thead>
				<tr>
				    <td>Id</td>
					<td>Descrição</td>
					<td>Data</td>
					<td>Responsável</td>
					<td>Preço</td>
				</tr>						
			</thead>
			<tbody>
				<c:forEach var="ev" items="${lista_eventos}">
					<tr>  
						<td> <a href= <c:url value="/convidados/listar?idEvento=${ev.id}"/>> ${ev.id} </a> </td>																	
						<td>${ev.descricao}</td>
						<td>${ev.data}</td>
						<td>${ev.responsavel}</td>
						<td>${ev.preco}</td>																
					</tr>							
				</c:forEach>
			</tbody>
		</table>
	</div>	
	</form>
</body>
</html>