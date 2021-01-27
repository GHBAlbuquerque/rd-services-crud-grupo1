<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Plano</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form action="/rd-services-crud-grupo1/planos" method="post">
			<div class="row">
			
			
				Nome do Plano:<input type="text" name="nmPlano" value="${plano.nmPlano}" />
				Descrição do Plano:<input type="text" name="dsPlano" value="${plano.dsPlano}">
				Valor do Plano:<input type="text" name="vlPlano" value="${plano.vlPlano}">
				Id do Serviço do Plano:<input type="text" name="idServicoPlano" value="${plano.servicoPlano.idServicoPlano}">
			
					<input type="hidden" name="id" value="${plano.idPlano}"> <input
					type="hidden" name="acao" value="alterar">
			</div>
			<div class="row mt-3">
				<input type="submit" value="Alterar" class="btn btn-primary"/>
			</div>
		</form>
		<div class="row mt-3">
			<a href="/acesso-banco-jpa/cidades" class="mx-0 p-0"><button
					class="btn btn-primary">Voltar</button></a>
		</div>
	</div>

</body>
</html>