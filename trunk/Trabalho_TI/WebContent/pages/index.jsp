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
	<c:if test="${sessionScope.login == null || sessionScope.login == ''}">
				<c:if test="${metodo=='deslogar'}">
						Você saiu de sua conta.
				</c:if>
		<table align="right" cellpadding="2">
			<tr>
				<td align="right">Usuário:</td>
				<td align="right"><html:text property="login" />
			</tr>
			<tr>
				<td  align="right">Senha:</td>
				<td  align="right"><html:password property="senha" />
			</tr>
			<tr >
				<td colspan="2" align="right">
				<div align="right"><a onclick="" href="CadastroVendedor.do">Registar</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<html:submit value="Entrar" /></div>
				</td>
			</tr>
		</table>
	</c:if>
	<c:if test="${sessionScope.login != null}">
		<table align="right" cellpadding="2">
			<tr>
				<td>Você está logado como</td>
				<td>${login}</td>
			</tr>
			<tr>
				<td colspan="2">
					<div align="left">
						<a onclick="" href="http://localhost:8080/Trabalho_TI/Produto.do">Produtos</a>
						<a onclick="" href="VendedorLogin.do?method=deslogar">Sair</a>
					</div>
					
				</td>
			</tr>
		</table>
	</c:if>
</html:form>

<center>
<c:if test="${sessionScope.login == null || sessionScope.login == ''}">
<html:form action="Produtos.do?method=buscaCliente">
	<div style="padding-top: 200px;">
	<html:text property="nome" />
	<html:select property="cod_area">
		<html:option value="0" disabled="false"> Selecione uma área</html:option>
		<html:options collection="listaArea" property="id_area"
			labelProperty="descricao" />
	</html:select>
	<html:submit styleId="botao" value="Buscar" />
</div>
</html:form>
</c:if>
</center>
</body>
</html>