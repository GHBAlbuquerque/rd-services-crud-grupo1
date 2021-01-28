<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Planos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Serviços - Planos</h1>

		<a href="/rd-services-crud-grupo1/servicos-plano?acao=novo"><button
				type="button" class="btn btn-success my-3">Novo Serviço de Plano</button></a>
		<table>
			<tr>
				<th>ID do Serviço de Plano:</th>
				<th>Nome do Serviço de Plano:</th>
				<th>Editar Serviço de Plano</th>
				<th>Excluir Serviço de Plano</th>

			</tr>
			<c:forEach items="${servPlano}" var="servico">
				<tr>
					<td>${servico.idServicoPlano}</td>
					<td>${servico.dsServico}</td>
					<td><a
						href="/rd-services-crud-grupo1/planos?acao=editar&id=${servico.idServicoPlano}"><button
								type="button" class="btn btn-sm btn-success">editar</button></a></td>
					<td><a
						href="/rd-services-crud-grupo1/planos?acao=excluir&id=${servico.idServicoPlano}"><button
								type="button" class="btn btn-sm btn-secondary">excluir</button></a></td>
				</tr>
			</c:forEach>
		</table>
		
						<div class="row mt-3">
			<a href="/rd-services-crud-grupo1/planos" class="mx-0 p-0"><button
					class="btn  btn-success">Voltar para Planos</button></a>
	</div>
</body>
</html>