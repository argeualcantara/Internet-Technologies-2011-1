<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page isELIgnored="false"%>
<html>
<head>
<link rel="shortcut icon" href="images/favicon.png" type="image/png" />
<LINK rel="stylesheet" href="css/estilo.css" type="text/css">

<script type="text/javascript" src="js/funcoes.js">
	
</script>

<style type="text/css">
.tableAlign {
	vertical-align: middle;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mercado Livre 2.0</title>
</head>
<body class="bgStyle">

<html:form action="VendedorLogin.do?method=logar">
	<a href="http://localhost:8080/Trabalho_TI/">Início</a>
	<table align="right" cellpadding="2">
		<c:if test="${sessionScope.login == null || sessionScope.login == ''}">
			<c:redirect url="http://localhost:8080/Trabalho_TI/ErroLogin.do"></c:redirect>
			<tr>
				<td align="right">Usuário:</td>
				<td align="right"><html:text property="login" />
			</tr>
			<tr>
				<td align="right">Senha:</td>
				<td align="right"><html:password property="senha" />
			</tr>
			<tr>
				<td colspan="2" align="right">
				<div align="right"><a onclick=
	;;
href="CadastroVendedor.do">Registar</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <html:submit
					value="Entrar" /></div>
				</td>
			</tr>
		</c:if>
		<c:if test="${sessionScope.login != null}">

			<tr>
				<td>Você está logado como</td>
				<td>${login}</td>
			</tr>
			<tr>
				<td colspan="2">
				<div align="left"><a onclick=
	;;
href="http://localhost:8080/Trabalho_TI/Produto.do">Produtos</a> <a
					onclick=
	;;
href="VendedorLogin.do?method=deslogar">Sair</a></div>
				</td>
			</tr>
		</c:if>
	</table>
</html:form>

<div style="padding-top: 200px;">
<center><html:form action="Produtos.do?method=buscar">
	<html:text property="nome" />

	<html:select property="cod_area">
		<html:option value="0" disabled="false"> Selecione uma área</html:option>
		<html:options collection="listaArea" property="id_area"
			labelProperty="descricao" />
	</html:select>
	<html:submit styleId="botao" value="Buscar" />

</html:form></center>


<center><c:if test="${tamanho==0}">
	<font color="red">Sua busca não gerou resultados.</font>
</c:if> <c:if test="${tamanho==1}">
	<html:form styleId="selecionador" action="Produtos.do?method=remover">
		<table border="2" cellpadding="2" align="center">
			<tr>
				<td><b>Todos<html:checkbox property="marcados" value="0"
					onchange="marcarTodos()">
				</html:checkbox> </b></td>
				<td><b>Nome</b></td>
				<td><b>Descricao</b></td>
				<td><b>Area</b></td>
				<td><b>Valor Unitário</b></td>
				<td><b>Quantidade Restante</b></td>
				<td><b>Quantidade Vendida</b></td>
				<td ><b>Opções</b></td> 
			</tr>
			<c:forEach var="produto" items="${listaProduto}">
				<tr>
					<td>
					<div align="right"><html:checkbox property="marcados"
						value="${produto.cod_produto}"></html:checkbox></div>
					</td>
					<td>
					${produto.nome}</td>
					<td>
					${produto.descricao}</td>
					<td>
					<c:forEach var="area" items="${listaArea}">
						<c:if test="${produto.cod_area == area.id_area}">
							<c:out value="${area.descricao}" />
						</c:if>
					</c:forEach></td>
					<td>
					${produto.valor_unitario}</td>
					<td>
					${produto.quantidade}</td>
					<td>
					${produto.quantidade_vendida}</td>
					<td>
					<center><a href="Produtos.do?method=carregar&indice=${produto.cod_produto}">
					<img alt="Editar" name="Editar" src="images/EditIcon.gif"/> </a></center></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="8">
				<div align="left"><html:submit value="Remover" /></div>
				</td>
			</tr>
		</table>
	</html:form>
</c:if></center>
</div>


</body>
</html>