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
		<form action="/rd-services-crud-grupo1/servicos-plano" method="post">
			<div class="row">
				Descri��o do Servi�o-Plano: <input type="text" name="dsServPlano"
					value="${servPlano.dsServico}" /> <input type="hidden"
					name="idServicoPlano" value="idServicoPlano" /> <input
					type="hidden" name="acao" value="editar">
			</div>
			<div class="row">
				<input type="submit" value="Atualizar" class="btn btn-success mt-2" />
			</div>
		</form>
		<div class="row mt-3">
			<a href="/rd-services-crud-grupo1/servicos-plano" class="mx-0 p-0"><button
					class="btn  btn-success">Voltar</button></a>
		</div>
	</div>
</body>
</html>