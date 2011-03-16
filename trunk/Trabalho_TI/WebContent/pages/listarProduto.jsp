<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page isELIgnored="false"%>
<html>
<head>
<link rel="shortcut icon" href="images/favicon.png" type="image/png" />
<LINK rel="stylesheet" href="css/estilo.css" type="text/css">
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
	<a href="http://localhost:8080/Trabalho_TI/Index.do">Início</a>
	<table align="right" cellpadding="2">
		<c:if test="${sessionScope.login == null || sessionScope.login == ''}">
			<c:if test="${metodo=='deslogar'}">
						Você saiu de sua conta.
				</c:if>
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
				<div align="right"><a onclick="" href="CadastroVendedor.do">Registar</a>
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
				<div align="left"><a onclick=""
					href="http://localhost:8080/Trabalho_TI/pages/produtos.jsp">Produtos</a>
				<a onclick="" href="VendedorLogin.do?method=deslogar">Sair</a></div>
				</td>
			</tr>
		</c:if>
	</table>
</html:form>
<div style="padding-top: 200px;">
<center>

<table border ="2" cellpadding="2" align="center" style="padding-top: 200px;">
	<tr>
		<td><b>Nome</b></td>
		<td><b>Descricao</b></td>
		<td><b>Area</b></td>
		<td><b>Valor Unitário</b></td>
		<td><b>Quantidade Restante</b></td>
		<td><b>Quantidade Vendida</b></td>
		<!--
		<td colspan="2"><b>Opções<b></td> 
		 -->
	</tr>
	<c:forEach var="produto" items="${listaProduto}">
		<tr>
			<td><br>
			${produto.nome}</td>
			<td><br>
			${produto.descricao}</td>
			<td><br>
			<c:forEach var="area" items="${listaArea}">
				<c:if test="${produto.cod_area == area.id_area}">
					<c:out value="${area.descricao}" />
				</c:if>
			</c:forEach></td>
			<td><br>
			${produto.valor_unitario}</td>
			<td><br>
			${produto.quantidade}</td>
			<td><br>
			${produto.quantidade_vendida}</td>		
		</tr>
	</c:forEach>
</table>

</center>
</div>

</body>
</html>