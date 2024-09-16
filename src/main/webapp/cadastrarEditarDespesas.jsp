<%@ page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page	import="controlefinanceiro.enumeradores.Enum" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Página Cadastrar Editar Despesa</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Página Cadastrar Editar Despesa</h1>
	<a class="btn btn-primary" href="listarDespesas">Listar despesas</a>
	<a class="btn btn-primary" href="home">Home</a> <br> <br>
	
	<div class="container container-xxl ms-0">
 		<div class="row">
    		<div class="col">
    			<form id="cadastrarEditarDespesa" name="cadastrarEditarDespesa" class="mb-3" method="get" action="cadastrarDespesa">
					<div class="input-group mb-3">
						<label for="des_descricao" class="input-group-text">Descricao </label>
						<input class="form-control" type="text" name="des_descricao" id="des_descricao" placeholder="Descrição da despesa" value="teste">
					</div>
					
					<div class="input-group mb-3">
						<label for="des_valor" class="input-group-text">Valor despesa </label>
						<input class="form-control" type="number" name="des_valor" id="des_valor" min="1" placeholder="" value="100">
					</div>
					
					<div class="input-group mb-3">
						<label for="des_dataEfetivacao" class="input-group-text">Data efetivação </label>
						<input class="form-control" type="date" name="des_dataEfetivacao" id="des_dataEfetivacao" placeholder="" value="2024-07-12">
					</div>
					
					<div class="mb-3">
						<label for="des_DebitoProprio">Débito próprio</label>&nbsp;&nbsp;&nbsp;&nbsp;
						<c:forEach var="bool" items="${booleano}">
							<c:choose>
								<c:when test="${bool.getCodigo() == 0}">
									<label class="form-check-label" for="des_DebitoProprio${bool.getCodigo()}">${bool.getDescricao()}</label>
									<input class="form-check-input" type="radio" name="des_DebitoProprio" id="des_debitoProprio_${bool.getCodigo()}" value="${bool}" checked="checked">&nbsp;&nbsp;
								</c:when>
								<c:otherwise>
									<label class="form-check-label" for="des_DebitoProprio_${bool.getCodigo()}">${bool.getDescricao()}</label>
									<input class="form-check-input" type="radio" name="des_DebitoProprio" id="des_debitoProprio_${bool.getCodigo()}" value="${bool}">&nbsp;&nbsp;
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</div>
					
					<div class="input-group mb-3">
						<label for="des_FormaAquisicao" class="input-group-text">Forma aquisição </label>
						<select id="des_FormaAquisicao" name="des_FormaAquisicao" class="form-select">
							<c:forEach var="fa" items="${formaAquisicao}">
								<option value="${fa}">${fa.getDescricao()}</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="input-group mb-3">
						<label for="des_TipoDespesa" class="input-group-text">Tipo despesa </label>
						<select id="des_TipoDespesa" name="des_TipoDespesa" class="form-select">
							<c:forEach var="tpDes" items="${tipoDespesa}">
								<option value="${tpDes}">${tpDes.getDescricao()}</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="input-group mb-3">
						<label for="des_ClassificacaoDespesa" class="input-group-text">Classificação despesa </label>
						<select id="des_ClassificacaoDespesa" name="des_ClassificacaoDespesa" class="form-select">
							<c:forEach var="cdes" items="${classificacaoDespesa}">
								<option value="${cdes}">${cdes.getDescricao()}</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="input-group mb-3">
						<label for="des_TipoRecorrencia" class="input-group-text">Tipo de recorrência </label>
						<select id="des_TipoRecorrencia" name="des_TipoRecorrencia" class="form-select">
							<c:forEach var="tpRec" items="${tipoRecorrencia}">
								<option value="${tpRec}">${tpRec.getDescricao()}</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="mb-3">
						<label for="des_parcelado">Débito parcelado</label>&nbsp;&nbsp;&nbsp;&nbsp;
						<c:forEach var="bool" items="${booleano}">
							<c:choose>
								<c:when test="${bool.getCodigo() == 0}">
									<label class="form-check-label" for="des_parcelado_${bool.getCodigo()}">${bool.getDescricao()}</label>
									<input class="form-check-input" type="radio" name="des_parcelado" id="des_parcelado_${bool.getCodigo()}" value="${bool}" onclick="viewNumParc()" checked="checked">&nbsp;&nbsp;
								</c:when>
								<c:otherwise>
									<label class="form-check-label" for="des_parcelado_${bool.getCodigo()}">${bool.getDescricao()}</label>
									<input class="form-check-input" type="radio" name="des_parcelado" id="des_parcelado_${bool.getCodigo()}" value="${bool}" onclick="viewNumParc()">&nbsp;&nbsp;
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</div>
					
					<div class="input-group mb-3" id="des_numParcela_div" hidden="hidden" >
						<label for="des_numParcela" class="input-group-text">Número da parcela </label>
						<input class="form-control" type="number" name="des_numParcela" id="des_numParcela" min="0" value="0">
					</div>
					
					<button form="cadastrarEditarDespesa" type="submit" class="btn btn-success">Cadastrar</button>
					<a onclick="limparCampos(cadastrarEditarDespesa)" class="btn btn-warning">Limpar campos</a>
					<a href="home" class="btn btn-danger">Cancelar</a>
				</form>
			</div>
		</div>
	</div>
	
	<script>
		let parcelado = document.getElementById("des_parcelado_1");
	
		function limparCampos(form){
			let elementos = form.elements;
			
			for(let i=0; i < elementos.length; i++){
				
				console.log(`tipo: ${elementos[i].nodeName.toLowerCase()} - valor: ${elementos[i].value}`)
				if(elementos[i].nodeName.toLowerCase() === "input"){ 
					elementos[i].value = ''
				}
			}
		}

		function viewNumParc() {
			let divNumParcela = document.getElementById("des_numParcela_div");
			let numParc = document.getElementById("des_numParcela")
			
			if(divNumParcela.hasAttribute("hidden") && parcelado.checked == true){
				divNumParcela.removeAttribute("hidden");
				numParc.value = 1;
			} else {
				divNumParcela.setAttribute("hidden", "hidden");
				numParc.value = 0;
			}
		}

	</script>
</body>
</html>