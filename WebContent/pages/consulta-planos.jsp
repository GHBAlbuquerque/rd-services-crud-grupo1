<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
			<tr>
				<th> ID do Plano: </th>
				<th> Nome do Plano: </th>
				<th> Descrição do Plano:</th>
				<th> Valor do Plano:</th>
				<th> Id do Serviço do Plano: </th>
				
				<th> Editar </th>
				<th> Excluir </th>
    		
			</tr>
			<c:forEach items="${planos}" var="plano">
				<tr>
					<td>${plano.idPlano}</td>
					<td>${plano.nmPlano}</td>
					<td>${plano.dsPlano}</td>
					<td>${plano.vlPlano}</td>
					<td>${plano.servicoPlano.idServicoPlano}</td>
					<td><a
						href="/pi-grupo-1/planos?acao=editar&id=${plano.idPlano}"><button
								type="button" class="btn btn-sm btn-primary">editar</button></a></td>
					<td><a
						href="pi-grupo-1/planos?acao=excluir&id=${plano.idPlano}"><button
								type="button" class="btn btn-sm btn-warning">excluir</button></a></td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>