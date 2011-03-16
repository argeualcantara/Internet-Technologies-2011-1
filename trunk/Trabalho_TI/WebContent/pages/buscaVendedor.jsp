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
		<c:redirect
			url="http://localhost:8080/Trabalho_TI/pages/erroLogin.jsp"></c:redirect>
	</c:if>
	<c:if test="${sessionScope.login != null}">
		<table align="right" cellpadding="2">
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
		</table>
	</c:if>
</html:form>
<div style="padding-top: 200px;">
<center><html:form action="Produtos.do?method=buscar">
	<html:text property="nome" />
	<br />
	<html:select property="cod_area">
		<html:option value="0" disabled="false"> Selecione uma área</html:option>
		<html:options collection="listaArea" property="id_area"
			labelProperty="descricao" />
	</html:select>
	<html:submit styleId="botao" value="Buscar" />

</html:form></center>
</div>

</body>
</html>