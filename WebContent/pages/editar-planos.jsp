<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

</head>
<body>
	<div class="container">
		<form action="/pi-grupo-1/planos" method="post">
			<div class="row">
				Descrição do Plano:<input type="text" name="dsPlano" value="${plano.dsPlano}" />
				ID Serviço do Plano: <input type="text" name="idServicoPlano"value="${plano.servicoPlano.idServicoPlano}" />
					Valor do Plano: <input type="number"name="vlPlano" value="${plano.vlPlano}" /> 
					Nome do Plano: <input type="text"name="nmPlano" value="${plano.nmPlano}" /> 
					<input type="hidden" name="id" value="${plano.idPlano}"> 
					<input	type="hidden" name="acao" value="alterar">
			</div>
			<div class="row mt-3">
				<input type="submit" value="Alterar" class="btn btn-primary"/>
			</div>
		</form>
		<div class="row mt-3">
			<a href="/pi-grupo-1/planos" class="mx-0 p-0"><button
					class="btn btn-primary">Voltar</button></a>
		</div>
	</div>
</body>
</html>