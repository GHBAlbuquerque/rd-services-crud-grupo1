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
		<h1>Planos</h1>

		<a href="/rd-services-crud-grupo1/planos?acao=novo"><button
				type="button" class="btn btn-success my-3">Novo Plano</button></a>
		<table>
			<tr>
				<th>ID do Plano:</th>
				<th>Nome do Plano:</th>
				<th>Descrição do Plano:</th>
				<th>Valor do Plano:</th>
				<th>Id do Serviço do Plano:</th>
				<th>Editar Plano</th>
				<th>Excluir Plano</th>

			</tr>
			<c:forEach items="${planos}" var="plano">
				<tr>
					<td>${plano.idPlano}</td>
					<td>${plano.nmPlano}</td>
					<td>${plano.dsPlano}</td>
					<td>${plano.vlPlano}</td>
					<td>${plano.servicoPlano.idServicoPlano}</td>
					<td><a
						href="/rd-services-crud-grupo1/planos?acao=editar&id=${plano.idPlano}"><button
								type="button" class="btn btn-sm btn-success">editar</button></a></td>
					<td><a
						href="/rd-services-crud-grupo1/planos?acao=excluir&id=${plano.idPlano}"><button
								type="button" class="btn btn-sm btn-secondary">excluir</button></a></td>
				</tr>
			</c:forEach>
		</table>
		
								<div class="row mt-3">
			<a href="/rd-services-crud-grupo1/servicos-plano" class="mx-0 p-0"><button
					class="btn  btn-success">Ver lista de Serviços de Plano</button></a>
	</div>
</body>
</html>