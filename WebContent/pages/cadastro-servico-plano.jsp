<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Planos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
</head>
<body>
	<<div class="container">
		<form action="/rd-services-crud-grupo1/planos" method="post">
			<div class="row">

				Id do Serviço do Plano: <input type="text" name="idServico" /> 
				Nome do Serviço do Plano: <input type="text" name="dsServico" /> 
				
				<input type="hidden" name="idServico"	value="id" /> <input type="hidden" name="acao" value="inserir">
			</div>
			<div class="row">
				<input type="submit" value="Cadastrar" class="btn btn-success mt-2"/>
			</div>
		</form>
				<div class="row mt-3">
			<a href="/rd-services-crud-grupo1/planos" class="mx-0 p-0"><button
					class="btn  btn-success">Voltar</button></a>
		</div>
	</div>
</body>
</html>