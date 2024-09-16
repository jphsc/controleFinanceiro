<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page	import="controlefinanceiro.model.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Página Listar Despesa</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Página Listar Despesa</h1>
	<a class="btn btn-primary" href="home">Home</a>
	<a class="btn btn-primary" href="cadastrarEditarDespesas">Cadastrar despesas</a>
	
	<table style="border: 1px solid black">
		<thead>
			<tr>
				<th>Descrição</th>
				<th>Data despesa</th>
				<th>Valor</th>
				<th>Débito próprio</th>
				<th>Despesa Parcelada</th>
				<th>Tipo de despesa</th>
				<th>Forma de aquisição</th>
				<th>Recorrência</th>
				<th>Classificação</th>
				<th>Despesa Parcelada</th>
				<th>Parcela</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="despesa" items="${despesas}">
				<tr>
					<td>${despesa.descricao}</td>
					<td>${despesa.dataEfetivacao}</td>
					<td>${despesa.valor}</td>
					<td>${despesa.debitoProprio}</td>
					<td>${despesa.parcelado}</td>
					<td>${despesa.numParcela}</td>
					<td>${despesa.tipoDespesa}</td>
					<td>${despesa.formaAquisicao}</td>
					<td>${despesa.tipoRecorrencia}</td>
					<td>${despesa.classificacaoDespesa}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>